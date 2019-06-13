package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class orderDoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_done);

        Button next_evaluation = findViewById(R.id.next_evaluation);
        next_evaluation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                Intent next_evaluation = new Intent(orderDoneActivity.this,create_evaluation.class);
                startActivity(next_evaluation);
            }
        });

    }
}
