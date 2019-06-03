package com.example.FJU_Store;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class enrollActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button getRes;
    TextView textView;
    EditText check_pass;
    EditText pass;
    String getmail;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final API api = retrofit.create(API.class);
        Map<String, String> map = new HashMap<>();

        map.put("api_key", Config.API_KEY);
        map.put("view", "Grid%20view");
        map.put("pageSize", "10");

        Intent intent = getIntent();
        getmail = intent.getStringExtra("sentMail");
        name = findViewById(R.id.user_name);
        pass = findViewById(R.id.password);
        check_pass = findViewById(R.id.passwordcheck);
        radioGroup = findViewById(R.id.RadioGroup);
        getRes = findViewById(R.id.send);
        textView = findViewById(R.id.result);

        final Intent intent2 = new Intent(enrollActivity.this,loginActivity.class);

        getRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = name.getText().toString().trim();
                String newPass = pass.getText().toString().trim();
                String newPassC = check_pass.getText().toString().trim();
                //抓radioButton
                radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                //抓取sex
                String gender = radioButton.getText().toString();
                try {
                    //判斷是否已填值
                    if (checkAsset(newName, newPass, newPassC, gender)) {
                        //判斷密碼確認是否正確
                        if(!newPass.equals(newPassC)){
                            Toast.makeText(enrollActivity.this, "密碼確認有誤!", Toast.LENGTH_LONG).show();
                        }
                        else{
                            USER user =  new USER(getmail,newPass,newName,gender);
                            Call<Res> call = api.postUser(new user_Req(user));
                            call.enqueue(new Callback<Res>() {
                                @Override
                                public void onResponse(Call<Res> call, Response<Res> response) {
                                    startActivity(intent2);
                                    Toast.makeText(enrollActivity.this, "成功!", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onFailure(Call<Res> call, Throwable t) {

                                }
                            });
                        }
                        //Log.v("內容",getmail +"\t"+ newName);
                        //textView.setText(getmail + "\t" + newName + "\t" + newPass + "\t" + gender);
                    } else {
                        //Log.v("內容",getmail +"\t"+ newName);
                        Toast.makeText(enrollActivity.this, "欄位未填!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {

                }


            }
        });
    }

//    public void checkButton(View v) {
//        int radioId = radioGroup.getCheckedRadioButtonId();
//        radioButton = findViewById(radioId);
//    }

    public static boolean checkAsset(String name, String pw, String pwCheck, String gender) {
        boolean pass = true;
        if (name.matches("") || pw.matches("") || pwCheck.matches("") || gender.matches("")) {
            pass = false;
        }
        return pass;
    }

}
