package com.example.FJU_Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CateActivity extends AppCompatActivity {
    Button c2;
    Button c3;
    Button c4;
    Button c5;
    Button c6;
    Button c7;
    Button c8;
    Button c9;
    Button c10;
    Button c11;
    Button c12;
    Button c13;
    Button c14;
    Button c15;
    Button c16;
    Button c17;
    Button c18;
    Button c19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate);

        Button c1 = findViewById(R.id.c1);
//        c2.findViewById(R.id.c2);
//        c3.findViewById(R.id.c3);
//        c4.findViewById(R.id.c4);
//        c5.findViewById(R.id.c5);
//        c6.findViewById(R.id.c6);
//        c7.findViewById(R.id.c7);
//        c8.findViewById(R.id.c8);
//        c9.findViewById(R.id.c9);
//        c10.findViewById(R.id.c10);
//        c11.findViewById(R.id.c11);
//        c12.findViewById(R.id.c12);
//        c13.findViewById(R.id.c13);
//        c14.findViewById(R.id.c14);
//        c15.findViewById(R.id.c15);
//        c16.findViewById(R.id.c16);
//        c17.findViewById(R.id.c17);
//        c18.findViewById(R.id.c18);
//        c19.findViewById(R.id.c19);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CateActivity.this,EachSubActivity.class);
                String view = "Grid%201";
                intent1.putExtra("id",view);
                startActivity(intent1);
            }
        });
    }
}
