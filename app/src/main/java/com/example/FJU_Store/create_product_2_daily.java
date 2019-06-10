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

public class create_product_2_daily extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {

    RadioGroup daily_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_2_daily);

        daily_category=findViewById(R.id.daily_category);
        daily_category.setOnCheckedChangeListener(this);

        Intent intent = getIntent();//接1的值
        final Product_w product_data = (Product_w) getIntent().getSerializableExtra("product_data");
        Log.d("HKG","product_data "+product_data.getProduct_main());

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        choose();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        choose();
    }

    protected void choose() {
         if (daily_category.getCheckedRadioButtonId() == R.id.daily_shower) {

            Button next_daily = findViewById(R.id.next_daily);
             next_daily.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(create_product_2_daily.this, create_product_3.class);
                    Product_w product = new Product_w();
                    product.setProduct_main("日常用品類");
                    product.setProduct_sub_1("盆洗用品類");
                    intent.putExtra("product_data", product);

                    startActivity(intent);
                }
            });
        } else if (daily_category.getCheckedRadioButtonId() == R.id.daily_stationary) {
            Button next_daily = findViewById(R.id.next_daily);
             next_daily.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(create_product_2_daily.this, create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product_w product = new Product_w();
                    product.setProduct_sub_1("文具類");
                    intent.putExtra("product_data", product);
                    product.setProduct_main("日常用品類");
                    startActivity(intent);
                }
            });
        } else if (daily_category.getCheckedRadioButtonId() == R.id.daily_makeup) {
            Button next_daily = findViewById(R.id.next_daily);
             next_daily.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(create_product_2_daily.this, create_product_3.class);


                    Product_w product = new Product_w();
                    product.setProduct_sub_1("化妝品類");
                    product.setProduct_main("日常用品類");
                    intent.putExtra("product_data", product);

                    startActivity(intent);
                }
            });
        } else if (daily_category.getCheckedRadioButtonId() == R.id.daily_decoration) {
            Button next_daily = findViewById(R.id.next_daily);
             next_daily.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(create_product_2_daily.this, create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product_w product = new Product_w();
                    product.setProduct_sub_1("裝飾用品類");
                    product.setProduct_main("日常用品類");
                    intent.putExtra("product_data", product);

                    startActivity(intent);
                }
            });
        } else if (daily_category.getCheckedRadioButtonId() == R.id.daily_clothes) {
            Button next_daily = findViewById(R.id.next_daily);
             next_daily.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(create_product_2_daily.this, create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product_w product = new Product_w();
                    product.setProduct_sub_1("衣著類");
                    product.setProduct_main("日常用品類");
                    intent.putExtra("product_data", product);

                    startActivity(intent);
                }
            });
        } else if (daily_category.getCheckedRadioButtonId() == R.id.daily_else) {
            Button next_daily = findViewById(R.id.next_daily);
             next_daily.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(create_product_2_daily.this, create_product_3.class);
                    //intent.putExtra("book","書籍類");

                    Product_w product = new Product_w();
                    product.setProduct_sub_1("其他日常用品類");
                    product.setProduct_main("日常用品類");
                    intent.putExtra("product_data", product);

                    startActivity(intent);
                }
            });
        }

    }

}
