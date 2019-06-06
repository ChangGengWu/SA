package com.example.FJU_Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class after_order extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_order);

        Toolbar toolbar2 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("關於產品-聊天室");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==android.R.id.home)
        {
            Intent newAct = new Intent();
            newAct.setClass(after_order.this, OrderActivity.class );
            // 呼叫新的 Activity Class
            startActivity( newAct );
            // 結束原先的 Activity Class
            after_order.this.finish();
        }
        return  super.onOptionsItemSelected(item);
    }


}

