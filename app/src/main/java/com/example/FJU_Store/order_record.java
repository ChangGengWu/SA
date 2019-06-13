package com.example.FJU_Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class order_record extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_record);

        Button bt1_btn = findViewById(R.id.bt1);
        Button home = findViewById(R.id.home);

        Toolbar toolbar2 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("賣家(上/下架)紀錄");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        bt1_btn.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                // 指定要呼叫的 Activity Class
                Intent newAct = new Intent();
                newAct.setClass(order_record.this, OrderActivity.class );
                // 呼叫新的 Activity Class
                startActivity( newAct );
                // 結束原先的 Activity Class
                order_record.this.finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent();
                home.setClass(order_record.this, IndexActivity.class );
                // 呼叫新的 Activity Class
                startActivity(home);
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==android.R.id.home)
        {
            Intent newAct = new Intent();
            newAct.setClass(order_record.this, OrderActivity.class );
            // 呼叫新的 Activity Class
            startActivity( newAct );
            // 結束原先的 Activity Class
            order_record.this.finish();
        }
        return  super.onOptionsItemSelected(item);
    }


}
