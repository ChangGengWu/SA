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
        map.put("pageSize", "100");
        final Call<ListRes> call = api.getUser(map);

        Button btn_login = findViewById(R.id.login);
        Button btn_enroll = findViewById(R.id.signup);
        btn_enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toVerify = new Intent(loginActivity.this, verifyActivity.class);
                startActivity(toVerify);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取得輸入欄資料
                EditText email = findViewById(R.id.mail);
                EditText password = findViewById(R.id.password);
                final String mail = email.getText().toString().trim();
                final String passw = password.getText().toString().trim();
                Log.v("test",mail+" "+passw);
                //判斷是否填入值
                try {
                    if(checkAsset(mail, passw)) {
                        call.clone().enqueue(new Callback<ListRes>() {
                            @Override
                            public void onResponse(Call<ListRes> call, Response<ListRes> response) {
                                if (response.isSuccessful()) {
                                    ListRes listRes = response.body();
                                    List<user_Res> resList = listRes.records;
                                    //設置判斷器 1代表正確 , 0代表錯誤
                                    int flag = 0;
                                    for (user_Res h : resList) {
                                        String acc = h.fields.getEmail();
                                        String pass = h.fields.getUser_password();
                                        //String userName = h.fields.getUser_name();
                                        //Log.v("MainActivity", acc+" "+pass);
                                        //Log.v("MainActivity", "[EMail成功找到] " + acc);
                                        //Log.v("MainActivity", "[EMail成功找到] " + pass);
                                        //若比對帳號密碼正確更改判斷器數值
                                        if (acc.equals(mail) && pass.equals(passw)) flag = 1;
                                    }
                                    if (flag == 1) {
                                        //Intent login = new Intent(loginActivity.this,indexActivity.class);
                                        //startActivity(login);

                                        Toast.makeText(loginActivity.this, "正確", Toast.LENGTH_LONG).show();
                                        Intent toIndex = new Intent(loginActivity.this, IndexActivity.class);
                                        toIndex.putExtra("userMail",mail);
                                        startActivity(toIndex);

                                    } else
                                        Toast.makeText(loginActivity.this, "錯誤", Toast.LENGTH_LONG).show();
                                    //Log.v("MainActivity", mail+" "+passw);
                                } else {
                                    Log.e("MainActivity", "連接失敗!");
                                }
                            }

                            @Override
                            public void onFailure(Call<ListRes> call, Throwable t) {
                                Log.d("emails", "not connected");

                            }
                        });
                    } else {
                        Toast.makeText(loginActivity.this, "必填欄位未填!!", Toast.LENGTH_LONG).show();
                    }
                }
                catch (Exception e){}
            }
        });
    }

    public static boolean checkAsset(String acc, String pw) {
        boolean pass = true;
        if (acc.matches("") || pw.matches("")) {
            pass = false;
        }
        return pass;
    }
}