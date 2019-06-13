package com.example.FJU_Store;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Wish_dateActivity extends AppCompatActivity {
    private EditText editDate;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_date);
        editDate = (EditText) findViewById(R.id.editDate);
        update = findViewById(R.id.button4);

        Intent intent = getIntent();
        Order_info info = (Order_info) intent.getSerializableExtra("id");
        final int o_id = Integer.parseInt(info.getO_id());
        final String f_id = info.getF_id();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final order_API api = retrofit.create(order_API.class);
        Map<String, String> map = new HashMap<>();


        map.put("api_key", Config.API_KEY);
        map.put("", f_id);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order("交易中",editDate.getText().toString());

                Call<order_Res> call = api.updateOrder(f_id,new order_Req(order));
                call.enqueue(new Callback<order_Res>() {
                    @Override
                    public void onResponse(Call<order_Res> call, Response<order_Res> response) {
                        Toast.makeText(Wish_dateActivity.this,"確認訂單成功",Toast.LENGTH_LONG);
                        Intent toIndex = new Intent(Wish_dateActivity.this,IndexActivity.class);
                        startActivity(toIndex);
                        Log.v("Order",response.raw()+"");
                    }

                    @Override
                    public void onFailure(Call<order_Res> call, Throwable t) {

                    }
                });

            }
        });

    }
        public void dataPicker(View v){
            Calendar calender = Calendar.getInstance();

            int year = calender.get(Calendar.YEAR);
            int month = calender.get(Calendar.MONTH);
            final int day = calender.get(Calendar.DAY_OF_MONTH);
            new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String dateTime = String.valueOf(month+1) + "/" +String.valueOf(dayOfMonth) + "/" + String.valueOf(year);
                    editDate.setText(dateTime);
                }
            },year, month, day).show();
        }
}
