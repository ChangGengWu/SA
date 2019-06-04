package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class inquire_evaluation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire_evaluation);
    }

    public void goto_iquire_evaluation1(View v){
        Intent it =new Intent(this,inquire_evaluation1.class);
        startActivity(it);
    }
}
