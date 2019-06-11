package com.example.FJU_Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class create_product_makesure extends AppCompatActivity {
TextView p_name;
TextView p_site;
TextView p_price;
TextView p_amount;
TextView p_detail;
TextView p_level;
TextView p_restrict;
    TextView p_category;
    Button upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_makesure);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, String> map = new HashMap<>();
        map.put("api_key", Config.API_KEY);
        map.put("view", "Grid%20view");
        map.put("pageSize", "50");

        final product_API api = retrofit.create(product_API.class);

        p_name=findViewById(R.id.p_name);
        p_site=findViewById(R.id.p_site);
        p_price=findViewById(R.id.p_price);
        p_amount=findViewById(R.id.p_amount);
        p_detail=findViewById(R.id.p_detail);
        p_level=findViewById(R.id.p_level);
        p_restrict=findViewById(R.id.p_restrict);
        p_category=findViewById(R.id.p_category);
        upload_btn = findViewById(R.id.upload);

        Intent intent = getIntent();//接1的值
        final Product_w product_data = (Product_w) getIntent().getSerializableExtra("product_data");

        p_category.setText(product_data.getProduct_main()+">"+product_data.getProduct_sub_1());
        String[] sub = product_data.getProduct_sub_1().split("/");
        Log.d("HKG","product_data "+product_data.getProduct_main()+product_data.getProduct_sub_1());
        final String P_name = product_data.getProduct_name();
        final String P_site = product_data.getProduct_site();
        final String P_price = product_data.getProduct_price();
        final String P_amount = product_data.getProduct_number();
        String P_detail = product_data.getProduct_detail();
        final String P_level = product_data.getProduct_level();
        String P_restrict = product_data.getProduct_restrict();

        p_name.setText(P_name);
        p_site.setText(P_site);
        p_price.setText(P_price);
        p_amount.setText(P_amount);
        p_detail.setText(P_detail);
        p_level.setText(P_level);
        p_restrict.setText(P_restrict);


        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product(Integer.parseInt(P_price),P_name,P_site,P_level,Integer.parseInt(P_amount));
                Call<product_Res> call = api.postProduct(new product_Req(product));
                call.enqueue(new Callback<product_Res>() {
                    @Override
                    public void onResponse(Call<product_Res> call, Response<product_Res> response) {
                        product_Res res = response.body();
                        Log.e("PostTest",response.raw()+"");
                    }

                    @Override
                    public void onFailure(Call<product_Res> call, Throwable t) {
                        Log.e("erroe",t.getMessage());

                    }
                });
            }
        });

    }


}
