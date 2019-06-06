package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class create_product_2_daily extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_2_daily);
    }
        //待修改
    public void goto_create_product_2(View v){
        Intent it =new Intent(this,create_product_2_daily.class);
        startActivity(it);
    }
}
