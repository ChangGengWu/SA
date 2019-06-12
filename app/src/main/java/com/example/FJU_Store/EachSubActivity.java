package com.example.FJU_Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EachSubActivity extends AppCompatActivity {

    private MyAdapter2 myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_sub);
        RecyclerView recyclerView;

        Intent getmail = getIntent();
        Buyer_info info3 = (Buyer_info) getmail.getSerializableExtra("id");
        //Log.v("tesr",info3.getUser_mail()+" "+info3.getView());

        String VIEW = info3.getView();

        final ArrayList<String> Dataset = new ArrayList<String>();
        final ArrayList<String> Dataset2 = new ArrayList<String>();


//        for(int i = 0; i < 10; i++)
//        {
//            Dataset.add(i + "資料");
//            Dataset2.add(i +"");
//        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        product_API api = retrofit.create(product_API.class);
        Map<String, String> map = new HashMap<>();


        //tring subview = "Grid%202";

        map.put("api_key", Config.API_KEY);
        map.put("view", VIEW);
        map.put("pageSize", "20");

        Call<product_ListRes> call = api.getProduct(map);

        call.enqueue(new Callback<product_ListRes>() {
            @Override
            public void onResponse(Call<product_ListRes> call, Response<product_ListRes> response) {
                product_ListRes listRes = response.body();
                List<product_Res> resList =  listRes.records;
                myAdapter.updateData(resList);

            }

            @Override
            public void onFailure(Call<product_ListRes> call, Throwable t) {
                Log.e("error",t.getMessage());
            }
        });


        myAdapter = new MyAdapter2(EachSubActivity.this,new ArrayList<product_Res>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
        recyclerView.setLayoutManager(layoutManager); //設定 LayoutManager
        recyclerView.setAdapter(myAdapter);
    }
    }
