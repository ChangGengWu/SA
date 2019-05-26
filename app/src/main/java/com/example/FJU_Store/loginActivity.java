package com.example.FJU_Store;

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

        Button btn_login = findViewById(R.id.login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.mail);
                String mail = email.getText().toString();
                Toast.makeText(loginActivity.this,"email: " + mail,Toast.LENGTH_LONG).show();
            }
        });

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Config.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                API api = retrofit.create(API.class);

                Map<String, String> map = new HashMap<>();

                map.put("api_key", Config.API_KEY);
                map.put("view", "Grid%20view");
                map.put("pageSize", "10");

                Call<ListRes> call = api.getUser(map);

                call.enqueue(new Callback<ListRes>() {
                    @Override
                    public void onResponse(Call<ListRes> call, Response<ListRes> response) {
                        if (response.isSuccessful()) {
                            ListRes listRes = response.body();
                            List<Res> resList = listRes.records;
                            for (Res h : resList) {
                                String each = h.fields.getEmail();
                                if (each.equals("406401513@mail.fju.edu.tw")) {
                                    Log.v("MainActivity", "[EMail成功找到] " + each);
                                }
                            }
                            Log.e("MainActivity", response.raw() + "");
                        } else {
                            Log.e("MainActivity", response.code() + "");
                            Log.e("MainActivity", "連接失敗!");
                            Log.e("MainActivity", response.raw() + "");
                        }
                    }

                    @Override
                    public void onFailure(Call<ListRes> call, Throwable t) {
                        Log.d("emails", "not connected");

                    }
                });
        }
    }