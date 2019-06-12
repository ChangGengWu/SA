package com.example.FJU_Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class after_order extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_order);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final order_API api = retrofit.create(order_API.class);


        //Log.v("22",Buyer_info.mail);
        Intent int2 = getIntent();
        String n = int2.getStringExtra("IDID");
        final String[] p_id = new String[1];
        final String[] buyer_m = new String[1];
        buyer_m[0] = Buyer_info.mail;
        p_id[0] = n;

        Toolbar toolbar2 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("關於產品-聊天室");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button IwantIt = findViewById(R.id.Buyit);
        IwantIt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                final Order order = new Order(p_id,"未交易",buyer_m);
                Call<order_Res> call = api.postOrder(new order_Req(order));

                call.enqueue(new Callback<order_Res>() {
                    @Override
                    public void onResponse(Call<order_Res> call, Response<order_Res> response) {
                        Toast.makeText(after_order.this,"下單成功",Toast.LENGTH_LONG);
                        Log.v("content","下單成功!");
                        Log.v("Order",response.raw()+"");
                    }

                    @Override
                    public void onFailure(Call<order_Res> call, Throwable t) {
                        Log.e("Order",t.getMessage());
                    }
                });

                Intent IwantIt = new Intent(after_order.this,accept_orderActivity.class);
                startActivity(IwantIt);
            }
        });

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

