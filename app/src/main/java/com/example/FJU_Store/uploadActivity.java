package com.example.FJU_Store;

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

public class uploadActivity extends AppCompatActivity {
    private Adapter3 myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        RecyclerView recyclerView;


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

        //String subview = "Grid%202";

        map.put("api_key", Config.API_KEY);
        map.put("view", "Grid%20view");
        map.put("pageSize", "100");

        Call<product_ListRes> call = api.getProduct(map);

        call.enqueue(new Callback<product_ListRes>() {
            @Override
            public void onResponse(Call<product_ListRes> call, Response<product_ListRes> response) {
                final ArrayList<String> Dataset = new ArrayList<String>();
                final ArrayList<String> idData = new ArrayList<String>();;
                String[] name = new String[1];
                product_ListRes listRes = response.body();
                List<product_Res> resList =  listRes.records;
                Buyer_info info2 = new Buyer_info();
                for (product_Res h: resList){
                    //Log.v("NAME",h.fields.getProduct_name());
                    name = h.fields.getUser_rmail();
                    //Log.v("NAME",name[0]+" "+info2.mail);
                    if(name[0].equals(info2.mail)) {
                        String p_name = h.fields.getProduct_name();
                        String id_data = Integer.toString(h.fields.getProduct_id());
                        Dataset.add(p_name);
                        idData.add(id_data);
                    }
                }
                myAdapter.updateData(Dataset,idData);


//
//                Log.v("MainRe", Dataset.size() + "");
                //myAdapter.updateData(MainRe.this,Dataset, Dataset2);
                //myAdapter = new MyAdapter(Dataset,Dataset2);
            }

            @Override
            public void onFailure(Call<product_ListRes> call, Throwable t) {
                Log.e("error",t.getMessage());
            }
        });


        //System.out.println(Dataset.get(0));
        myAdapter = new Adapter3(uploadActivity.this,new ArrayList<String>(),new ArrayList<String>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
        recyclerView.setLayoutManager(layoutManager); //設定 LayoutManager
        recyclerView.setAdapter(myAdapter);
    }
}
