package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.FJU_Store.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Catagory_Book_Activity extends AppCompatActivity implements catagoryAdapter.OnItemClickListener{
    //final變數
    public static final String Extra_URL ="imageUrl";
    public static final String Extra_CREATER ="creatorName";
    public static final String Extra_LIKES ="likeCount";

    private RecyclerView mRecyclerView;
    private catagoryAdapter mcatagoryAdapter;
    private ArrayList<catagory_book_item> mcatagoryList;//存放多個card_item的串列
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory__book_);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mcatagoryList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();

    }

    private void parseJSON(){
        String url = "https://pixabay.com/api/?key=12745206-236e25a4010b958a93f2a9421&q=yellow+flowers&image_type=photo&pretty=true";

        //與hit有關
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            //hit裡的所有東西
                            for (int i = 0; i< jsonArray.length();i++)  {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String creatorName = hit.getString("user");//
                                String imageUrl = hit.getString("webformatURL");//
                                int likeCount = hit.getInt("likes");//

                                mcatagoryList.add(new catagory_book_item(imageUrl,creatorName,likeCount));
                            }

                            mcatagoryAdapter = new catagoryAdapter(Catagory_Book_Activity.this, mcatagoryList);
                            mRecyclerView.setAdapter(mcatagoryAdapter);
                            //抓取click
                            mcatagoryAdapter.setOnItemClickListener(Catagory_Book_Activity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
    //get the enter
    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this,DetailActivity.class);
        catagory_book_item clickedItem = mcatagoryList.get(position);

        detailIntent.putExtra(Extra_URL, clickedItem.getmImageUrl());
        detailIntent.putExtra(Extra_CREATER, clickedItem.getCreator());
        detailIntent.putExtra(Extra_LIKES, clickedItem.getLikeCount());

        startActivity(detailIntent);
    }
}
