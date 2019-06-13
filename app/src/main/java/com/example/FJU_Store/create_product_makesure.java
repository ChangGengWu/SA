package com.example.FJU_Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
Button upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_makesure);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, String> map = new HashMap<>();
        map.put("api_key", Config.API_KEY);
        map.put("view", "Grid%20view");
        map.put("pageSize", "50");

        final product_API api = retrofit.create(product_API.class);

        p_name=findViewById(R.id.p_name);
        p_site=findViewById(R.id.p_site);
        p_price=findViewById(R.id.p_price);
        p_amount=findViewById(R.id.p_amount);
        p_detail=findViewById(R.id.p_detail);
        p_level=findViewById(R.id.p_level);
        p_restrict=findViewById(R.id.p_restrict);
        p_category=findViewById(R.id.p_category);
        upload_btn = findViewById(R.id.upload);

        Intent intent = getIntent();//接1的值
        final Product_w product_data = (Product_w) getIntent().getSerializableExtra("product_data");

        p_category.setText(product_data.getProduct_main()+">"+product_data.getProduct_sub_1());

        //Log.d("HKG","product_data "+product_data.getProduct_main()+product_data.getProduct_sub_1());
        final String[] sub = new String[1];
        final String[] seller = new String[1];
        final String P_name = product_data.getProduct_name();
        final String P_site = product_data.getProduct_site();
        final String P_price = product_data.getProduct_price();
        final String P_amount = product_data.getProduct_number();
        final String P_detail = product_data.getProduct_detail();
        final String P_level = product_data.getProduct_level();
        final String P_restrict = product_data.getProduct_restrict();

        p_name.setText(P_name);
        p_site.setText(P_site);
        p_price.setText(P_price);
        p_amount.setText(P_amount);
        p_detail.setText(P_detail);
        p_level.setText(P_level);
        p_restrict.setText(P_restrict);
        //product_data.setSeller_email("test_fake@gmail.com");
        sub_text = product_data.getProduct_sub_1();//取得子類別中文
        sub_id = returnSubID(sub_text);
        String mail = Buyer_info.mail;
        seller[0] = mail;
        sub[0] = sub_id;


        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product(seller,Integer.parseInt(P_price),P_name,P_site,P_level,Integer.parseInt(P_amount),sub,P_restrict,P_detail);
                Call<product_Res> call = api.postProduct(new product_Req(product));
                call.enqueue(new Callback<product_Res>() {
                    @Override
                    public void onResponse(Call<product_Res> call, Response<product_Res> response) {
                        product_Res res = response.body();
                        Toast.makeText(create_product_makesure.this,"上架成功",Toast.LENGTH_LONG).show();
                        Intent toupload = new Intent(create_product_makesure.this,uploadActivity.class);
                        startActivity(toupload);
                        Log.e("PostTest",response.raw()+"");
                    }

                    @Override
                    public void onFailure(Call<product_Res> call, Throwable t) {
                        Log.e("erroe",t.getMessage());

                    }
                });
            }
        });

        //設置假的賣家email
//        //sub_id="";
//        if(sub_text.equals("文史哲類")){
//            sub_id="1";//設置子類別編號
//
//        }
//        else if(sub_text.equals("外國語文類")){
//            sub_id="2";
//        }
//        else if(sub_text.equals("財經類")){
//            sub_id="3";
//        }
//        else if(sub_text.equals("法政類")){
//            sub_id="4";
//        }
//        else if(sub_text.equals("管理類")){
//            sub_id="5";
//        }
//        else if(sub_text.equals("社會心理類")){
//            sub_id="6";
//        }
//        else if(sub_text.equals("大眾傳播類")){
//            sub_id="7";
//        }
//        else if(sub_text.equals("教育類")){
//            sub_id="8";
//        }
//        else if(sub_text.equals("藝術類")){
//            sub_id="9";
//        }
//        else if(sub_text.equals("資訊類")){
//            sub_id="10";
//        }
//        else if(sub_text.equals("電機工程類")){
//            sub_id="11";
//        }
//        else if(sub_text.equals("建築與設計類")){
//            sub_id="12";
//        }
//        else if(sub_text.equals("數理化類")){
//            sub_id="13";
//        }
//        else if(sub_text.equals("生命科學類")){
//            sub_id="14";
//        }
//        else if(sub_text.equals("生物資源類")){
//            sub_id="15";
//        }
//        else if(sub_text.equals("地球與環境科學類")){
//            sub_id="16";
//        }
//        else if(sub_text.equals("休閒餐旅類")){
//            sub_id="17";
//        }
//        else if(sub_text.equals("醫藥衛生類")){
//            sub_id="18";
//        }
//        else if(sub_text.equals("家電類")){
//            sub_id="19";
//        }
//        else if(sub_text.equals("床類")){
//            sub_id="20";
//        }
//        else if(sub_text.equals("浴室類")){
//            sub_id="21";
//        }
//        else if(sub_text.equals("櫃子類")){
//            sub_id="22";
//        }
//        else if(sub_text.equals("桌椅類")){
//            sub_id="23";
//        }
//        else if(sub_text.equals("其他傢俱類")){
//            sub_id="24";
//        }
//        else if(sub_text.equals("文具類")){
//            sub_id="25";
//        }
//        else if(sub_text.equals("盥洗用品類")){
//            sub_id="26";
//        }
//        else if(sub_text.equals("化妝品類")){
//            sub_id="27";
//        }
//        else if(sub_text.equals("裝飾用品類")){
//            sub_id="28";
//        }
//        else if(sub_text.equals("衣著類")){
//            sub_id="29";
//        }
//        else if(sub_text.equals("其他日常用品類")){
//            sub_id="30";
//        }
//        else if(sub_text.equals("其他書籍類")){
//            sub_id="31";
//        }
//        //Log.d("HKG","sub_id: "+sub_text+"   "+sub_id);




    }
    
public static String returnSubID(String sub_text){
    String sub_id="";
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
    return sub_id;
}

}
