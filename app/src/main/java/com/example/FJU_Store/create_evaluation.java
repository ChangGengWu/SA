package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class create_evaluation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_evaluation);

        Button goto_index = findViewById(R.id.goto_index);
        goto_index.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                Intent goto_index = new Intent(create_evaluation.this,IndexActivity.class);
                startActivity(goto_index);
            }
        });
    }
}
