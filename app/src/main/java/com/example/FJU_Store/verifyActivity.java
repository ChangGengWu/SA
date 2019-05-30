package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class verifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        Button btn_enroll = findViewById(R.id.next);
        btn_enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.enroll_email);
                String getmail = email.getText().toString();
                Intent intent = new Intent(verifyActivity.this,enrollActivity.class);
                intent.putExtra("sentMail",getmail);
                startActivity(intent);

            }
        });
        //長耕借我一個button連到我的主畫面測試一下~~~~~~~~~~^^
        Button btn_Index = findViewById(R.id.send);
        btn_Index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toIndex = new Intent(verifyActivity.this,IndexActivity.class);
                startActivity(toIndex);
            }
        });
    }
}
