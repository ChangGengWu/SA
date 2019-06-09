package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class create_product_2_furniture extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {

    RadioGroup furniture_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_2_furniture);

        furniture_category=findViewById(R.id.furniture_category);
        furniture_category.setOnCheckedChangeListener(this);

        Intent intent = getIntent();//接1的值
        final Product product_data = (Product) getIntent().getSerializableExtra("product_data");
        Log.d("HKG","product_data "+product_data.getProduct_main());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        choose();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        choose();
    }

    @Override
    public void afterTextChanged(Editable s) {
        choose();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        choose();
    }

    protected void choose(){
        if(furniture_category.getCheckedRadioButtonId()==R.id.furni_3c){

            Button furniture_next=findViewById(R.id.furniture_next);
            furniture_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(create_product_2_furniture.this,create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product product = new Product();
                    product.setProduct_main("傢具類");
                    product.setProduct_sub_1("家電類");
                    intent.putExtra("product_data",product);

                    startActivity(intent);
                }
            });
        }
        else if(furniture_category.getCheckedRadioButtonId()==R.id.furni_bed){
            Button furniture_next=findViewById(R.id.furniture_next);
            furniture_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(create_product_2_furniture.this,create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product product = new Product();
                    product.setProduct_main("傢具類");
                    product.setProduct_sub_1("床鋪類");
                    intent.putExtra("product_data",product);

                    startActivity(intent);
                }
            });
        }

        else if(furniture_category.getCheckedRadioButtonId()==R.id.furni_shower){
            Button furniture_next=findViewById(R.id.furniture_next);
            furniture_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(create_product_2_furniture.this,create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product product = new Product();
                    product.setProduct_sub_1("浴室類");
                    product.setProduct_main("傢具類");
                    intent.putExtra("product_data",product);

                    startActivity(intent);
                }
            });
        }

        else if(furniture_category.getCheckedRadioButtonId()==R.id.furni_shelf){
            Button furniture_next=findViewById(R.id.furniture_next);
            furniture_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(create_product_2_furniture.this,create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product product = new Product();
                    product.setProduct_sub_1("櫃子類");
                    product.setProduct_main("傢具類");
                    intent.putExtra("product_data",product);

                    startActivity(intent);
                }
            });
        }

        else if(furniture_category.getCheckedRadioButtonId()==R.id.furni_table){
            Button furniture_next=findViewById(R.id.furniture_next);
            furniture_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(create_product_2_furniture.this,create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product product = new Product();
                    product.setProduct_sub_1("桌椅類");
                    product.setProduct_main("傢具類");
                    intent.putExtra("product_data",product);

                    startActivity(intent);
                }
            });
        }

        else if(furniture_category.getCheckedRadioButtonId()==R.id.furni_else){
            Button furniture_next=findViewById(R.id.furniture_next);
            furniture_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(create_product_2_furniture.this,create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product product = new Product();
                    product.setProduct_sub_1("其他類");
                    product.setProduct_main("傢具類");
                    intent.putExtra("product_data",product);

                    startActivity(intent);
                }
            });
        }
    }



}
