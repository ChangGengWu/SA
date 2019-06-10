package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class create_product_makesure extends AppCompatActivity {
TextView p_name;
TextView p_site;
TextView p_price;
TextView p_amount;
TextView p_detail;
TextView p_level;
TextView p_restrict;
TextView p_category;
String sub_id;
String sub_text;
String seller_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_makesure);
        p_name=findViewById(R.id.p_name);
        p_site=findViewById(R.id.p_site);
        p_price=findViewById(R.id.p_price);
        p_amount=findViewById(R.id.p_amount);
        p_detail=findViewById(R.id.p_detail);
        p_level=findViewById(R.id.p_level);
        p_restrict=findViewById(R.id.p_restrict);
        p_category=findViewById(R.id.p_category);

        Intent intent = getIntent();//接1的值
        final Product_w product_data = (Product_w) getIntent().getSerializableExtra("product_data");

        p_category.setText(product_data.getProduct_main()+">"+product_data.getProduct_sub_1());

        p_name.setText(product_data.getProduct_name());
        p_site.setText(product_data.getProduct_site());
        p_price.setText(product_data.getProduct_price());
        p_amount.setText(product_data.getProduct_number());
        p_detail.setText(product_data.getProduct_detail());
        p_level.setText(product_data.getProduct_level());
        p_restrict.setText(product_data.getProduct_restrict());

        //設置假的賣家email
        product_data.setSeller_email("test_fake@gmail.com");

        sub_text = product_data.getProduct_sub_1();//取得子類別中文
        //sub_id="";
        if(sub_text.equals("文史哲類")){
            sub_id="1";//設置子類別編號

        }
        else if(sub_text.equals("外國語文類")){
            sub_id="2";
        }
        else if(sub_text.equals("財經類")){
            sub_id="3";
        }
        else if(sub_text.equals("法政類")){
            sub_id="4";
        }
        else if(sub_text.equals("管理類")){
            sub_id="5";
        }
        else if(sub_text.equals("社會心理類")){
            sub_id="6";
        }
        else if(sub_text.equals("大眾傳播類")){
            sub_id="7";
        }
        else if(sub_text.equals("教育類")){
            sub_id="8";
        }
        else if(sub_text.equals("藝術類")){
            sub_id="9";
        }
        else if(sub_text.equals("資訊類")){
            sub_id="10";
        }
        else if(sub_text.equals("電機工程類")){
            sub_id="11";
        }
        else if(sub_text.equals("建築與設計類")){
            sub_id="12";
        }
        else if(sub_text.equals("數理化類")){
            sub_id="13";
        }
        else if(sub_text.equals("生命科學類")){
            sub_id="14";
        }
        else if(sub_text.equals("生物資源類")){
            sub_id="15";
        }
        else if(sub_text.equals("地球與環境科學類")){
            sub_id="16";
        }
        else if(sub_text.equals("休閒餐旅類")){
            sub_id="17";
        }
        else if(sub_text.equals("醫藥衛生類")){
            sub_id="18";
        }
        else if(sub_text.equals("家電類")){
            sub_id="19";
        }
        else if(sub_text.equals("床類")){
            sub_id="20";
        }
        else if(sub_text.equals("浴室類")){
            sub_id="21";
        }
        else if(sub_text.equals("櫃子類")){
            sub_id="22";
        }
        else if(sub_text.equals("桌椅類")){
            sub_id="23";
        }
        else if(sub_text.equals("其他傢俱類")){
            sub_id="24";
        }
        else if(sub_text.equals("文具類")){
            sub_id="25";
        }
        else if(sub_text.equals("盥洗用品類")){
            sub_id="26";
        }
        else if(sub_text.equals("化妝品類")){
            sub_id="27";
        }
        else if(sub_text.equals("裝飾用品類")){
            sub_id="28";
        }
        else if(sub_text.equals("衣著類")){
            sub_id="29";
        }
        else if(sub_text.equals("其他日常用品類")){
            sub_id="30";
        }
        else if(sub_text.equals("其他書籍類")){
            sub_id="31";
        }
        //Log.d("HKG","sub_id: "+sub_text+"   "+sub_id);




    }


}
