package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class loginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Map<String, String> map = new HashMap<>();
        map.put("api_key", Config.API_KEY);
        map.put("view", "Grid%20view");
        map.put("pageSize", "10");
        final Call<ListRes> call = api.getUser(map);

        Button btn_login = findViewById(R.id.login);
        Button btn_enroll = findViewById(R.id.signup);
        btn_enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toVerify = new Intent(loginActivity.this,verifyActivity.class);
                startActivity(toVerify);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.mail);
                EditText password = findViewById(R.id.password);
                final String mail = email.getText().toString();
                final String passw = password.getText().toString();
                call.clone().enqueue(new Callback<ListRes>() {
                    @Override
                    public void onResponse(Call<ListRes> call, Response<ListRes> response) {
                        if (response.isSuccessful()) {
                            ListRes listRes = response.body();
                            List<Res> resList = listRes.records;
                            int flag = 0;
                            for (Res h : resList) {
                                String acc = h.fields.getEmail();
                                String pass = h.fields.getUser_password();
                                //Log.v("MainActivity", "[EMail成功找到] " + acc);
                                //Log.v("MainActivity", "[EMail成功找到] " + pass);
                                if(acc.equals(mail) && pass.equals(passw)) flag = 1;
                            }
                            if (flag == 1) Toast.makeText(loginActivity.this,"正確",Toast.LENGTH_LONG).show();
                            else Toast.makeText(loginActivity.this,"錯誤",Toast.LENGTH_LONG).show();
                        } else {
                            Log.e("MainActivity", "連接失敗!");
                        }
                    }
                    @Override
                    public void onFailure(Call<ListRes> call, Throwable t) {
                        Log.d("emails", "not connected");

                    }
                });
            }
        });


        }
    }