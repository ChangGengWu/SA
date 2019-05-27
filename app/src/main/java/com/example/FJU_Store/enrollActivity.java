package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class enrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        Intent intent = getIntent();
        String getmail = intent.getStringExtra("sentMail");
        EditText name = findViewById(R.id.user_name);
        Toast.makeText(enrollActivity.this,"上一頁email1："+getmail,Toast.LENGTH_LONG).show();
    }
}
