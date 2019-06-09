package com.example.FJU_Store;

import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public  class create_product_3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

TextView main_category;
TextView sub_category;
EditText p_name;
EditText p_site;
EditText p_price;
EditText p_amount;
EditText p_detail;
Spinner new_old;
Spinner evaluation_star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_3);
        main_category=findViewById(R.id.main_category);
         sub_category=findViewById(R.id.sub_category);

        new_old=(Spinner) findViewById(R.id.new_old);
        new_old.setOnItemSelectedListener(this);
        evaluation_star=(Spinner)findViewById(R.id.evaluation_star);
        evaluation_star.setOnItemSelectedListener(this);

        Button make_sure = findViewById(R.id.make_sure);
        make_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(create_product_3.this, create_product_makesure.class);
                Product_w product = new Product_w();
                p_name=findViewById(R.id.p_name);
                p_site=findViewById(R.id.p_site);
                p_price=findViewById(R.id.p_price);
                p_amount=findViewById(R.id.p_amount);
                p_detail=findViewById(R.id.p_detail);

                //p_name.getText();
                Intent intent1 = getIntent();
                Product_w product_data = (Product_w) getIntent().getSerializableExtra("product_data");

                product.setProduct_name(p_name.getText().toString());
                product.setProduct_site(p_site.getText().toString());
                product.setProduct_price(p_price.getText().toString());
                product.setProduct_number(p_amount.getText().toString());
                product.setProduct_detail(p_detail.getText().toString());
                product.setProduct_level(new_old.getSelectedItem().toString());
                product.setProduct_restric(evaluation_star.getSelectedItem().toString());
                product.setProduct_sub_1(product_data.getProduct_sub_1());
                product.setProduct_main(product_data.getProduct_main());
                //product.setProduct_sub_1(sub_to3);
                intent.putExtra("product_data", product);

                startActivity(intent);
            }
        });

        Intent intent1 = getIntent();//接1的值
        Product_w product_data = (Product_w) getIntent().getSerializableExtra("product_data");

        // Log.d("HKG","product_data "+product_data.getProduct_main());
        sub_category.setText(product_data.getProduct_sub_1());
        main_category.setText(product_data.getProduct_main());



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
