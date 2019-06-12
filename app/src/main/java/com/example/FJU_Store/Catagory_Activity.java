package com.example.FJU_Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//import com.example.login.R;


public class Catagory_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_catagory);

        Intent getmail = getIntent();
        final Buyer_info info2 = (Buyer_info) getmail.getSerializableExtra("mail");
        Log.v("m",info2.mail);
//        String M = info2.info.getUser_mail();
//        Log.v("mmm",M);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Button c1 = findViewById(R.id.c1);
        Button c2= findViewById(R.id.c2);
        Button c3 = findViewById(R.id.c3);
        Button c4 = findViewById(R.id.c4);
        Button c5 = findViewById(R.id.c5);
        Button c6 = findViewById(R.id.c6);
        Button c7 = findViewById(R.id.c7);
        Button c8 = findViewById(R.id.c8);
        Button c9 = findViewById(R.id.c9);
        Button c10 = findViewById(R.id.c10);
        Button c11 = findViewById(R.id.c11);
        Button c12 = findViewById(R.id.c12);
        Button c13 = findViewById(R.id.c13);
        Button c14 = findViewById(R.id.c14);
        Button c15 = findViewById(R.id.c15);
        Button c16 = findViewById(R.id.c16);
        Button c17 = findViewById(R.id.c17);
        Button c18 = findViewById(R.id.c18);
        Button c19 = findViewById(R.id.c19);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2010");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%202");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%203");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%205");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%204");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%206");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%207");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%208");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%209");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%201");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2011");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2012");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2013");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2014");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2015");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2016");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2017");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2018");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });

        c19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Catagory_Activity.this,EachSubActivity.class);
                info2.setView("Grid%2019");
                intent1.putExtra("id",info2);
                startActivity(intent1);
            }
        });





    }
}
