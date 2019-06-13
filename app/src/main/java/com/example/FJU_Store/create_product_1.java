package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class create_product_1 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {


    RadioGroup product_category;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_1);

        product_category=findViewById(R.id.product_category);
        product_category.setOnCheckedChangeListener(this);




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
        if(product_category.getCheckedRadioButtonId()==R.id.book){

            Button score=findViewById(R.id.score);
            score.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(create_product_1.this,create_product_2.class);
                    //intent.putExtra("book","書籍類");
                    Intent intent2 = getIntent();
                    final String mail = intent2.getStringExtra("mail");
                    Product_w product = new Product_w();
                    product.setSeller_email(mail);
                    product.setProduct_main("書籍類");
                    intent.putExtra("product_data",product);

                    startActivity(intent);
                }
            });
        }
        else if(product_category.getCheckedRadioButtonId()==R.id.furniture){
            Button score=findViewById(R.id.score);
            score.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(create_product_1.this,create_product_2_furniture.class);
                    Product_w product = new Product_w();
                    product.setProduct_main("傢具類");
                    intent.putExtra("product_data",product);
                    startActivity(intent);
                }
            });

        }

        else if(product_category.getCheckedRadioButtonId()==R.id.daily_necessities){
            Button score=findViewById(R.id.score);
            score.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(create_product_1.this,create_product_2_daily.class);

                    Product_w product = new Product_w();
                    product.setProduct_main("生活用品類");
                    intent.putExtra("product_data",product);
                    startActivity(intent);
                }
            });
        }
        else if(product_category.getCheckedRadioButtonId()==-1){
            Toast.makeText(create_product_1.this, "請選擇一個類別!", Toast.LENGTH_LONG).show();
        }
    }
}
