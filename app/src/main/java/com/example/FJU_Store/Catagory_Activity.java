package com.example.FJU_Store;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//import com.example.login.R;


public class Catagory_Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private catagoryAdapter mcatagoryAdapter;
    private ArrayList<catagory_book_item> mcatagoryList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

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

                            mcatagoryAdapter = new catagoryAdapter(Catagory_Activity.this, mcatagoryList);
                            mRecyclerView.setAdapter(mcatagoryAdapter);

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
}
