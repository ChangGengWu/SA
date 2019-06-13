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

public class accept_orderActivity extends AppCompatActivity {

    private Adapter4 myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_order);
        RecyclerView recyclerView;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        order_API api = retrofit.create(order_API.class);
        Map<String, String> map = new HashMap<>();

        map.put("api_key", Config.API_KEY);
        map.put("view", "Grid%20view");
        map.put("pageSize", "50");

        Call<order_ListRes> call = api.getOrder(map);

        call.enqueue(new Callback<order_ListRes>() {
            @Override
            public void onResponse(Call<order_ListRes> call, Response<order_ListRes> response) {
                final ArrayList<String> Dataset = new ArrayList<String>();
                final ArrayList<String> Dataset2 = new ArrayList<String>();
                final ArrayList<String> Dataset3 = new ArrayList<String>();
                String[] name = new String[1];
                String[] idid = new String[1];
                int orderId;
                Intent intent = getIntent();
                String id = (String) intent.getStringExtra("id");
                    order_ListRes listRes = response.body();
                    List<order_Res> resList =  listRes.records;
                    for (order_Res h: resList){
                        idid = h.fields.getOrdered_p_id();
                        //Log.v("TEST",idid[0]+" "+id);
                        if(idid[0].equals(id)) {
                            name = h.fields.getBuyer_name();
                            orderId = h.fields.getOrder_id();
                            String f_id = h.id;
                            String orderIdd = Integer.toString(orderId);
                            Log.v("A",orderId+"");
                            Dataset.add(name[0]);
                            Dataset2.add(orderIdd);
                            Dataset3.add(f_id);
                        }
                    }
                    myAdapter.updateData(Dataset,Dataset2,Dataset3);
                }

            @Override
            public void onFailure(Call<order_ListRes> call, Throwable t) {
                Log.d("emails", t.getMessage());
            }
        });


        myAdapter = new Adapter4(accept_orderActivity.this,new ArrayList<String>(),new ArrayList<String>(),new ArrayList<String>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
        recyclerView.setLayoutManager(layoutManager); //設定 LayoutManager
        recyclerView.setAdapter(myAdapter);
    }
}

