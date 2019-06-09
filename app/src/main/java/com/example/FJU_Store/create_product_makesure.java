package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class create_product_makesure extends AppCompatActivity {
TextView p_name;
TextView p_site;
TextView p_price;
TextView p_amount;
TextView p_detail;
TextView p_level;
TextView p_restrict;
    TextView p_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_makesure);
        p_name=findViewById(R.id.p_name);
        p_site=findViewById(R.id.p_site);
        p_price=findViewById(R.id.p_price);
        p_amount=findViewById(R.id.p_amount);
        p_detail=findViewById(R.id.p_detail);
        p_level=findViewById(R.id.p_level);
        p_restrict=findViewById(R.id.p_restrict);
        p_category=findViewById(R.id.p_category);

        Intent intent = getIntent();//接1的值
        final Product product_data = (Product) getIntent().getSerializableExtra("product_data");

        p_category.setText(product_data.getProduct_main()+">"+product_data.getProduct_sub_1());
        Log.d("HKG","product_data "+product_data.getProduct_main()+product_data.getProduct_sub_1());
        p_name.setText(product_data.getProduct_name());
        p_site.setText(product_data.getProduct_site());
        p_price.setText(product_data.getProduct_price());
        p_amount.setText(product_data.getProduct_number());
        p_detail.setText(product_data.getProduct_detail());
        p_level.setText(product_data.getProduct_level());
        p_restrict.setText(product_data.getProduct_restrict());

    }


}
