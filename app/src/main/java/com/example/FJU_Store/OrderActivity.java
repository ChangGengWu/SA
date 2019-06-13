package com.example.FJU_Store;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class OrderActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<PageView> pageList;
    private TextView p_name;
    private TextView p_type;
    private TextView p_level;
    private TextView p_amount;
    private TextView p_site;
    private TextView p_star;
    private TextView p_content;
    private TextView p_price;
    String id;
    int intId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent4 = getIntent();
        Buyer_info id = (Buyer_info) intent4.getSerializableExtra("id");
        intId = Integer.parseInt(id.getItem_id());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        product_API api = retrofit.create(product_API.class);
        Map<String, String> map = new HashMap<>();

        map.put("api_key", Config.API_KEY);
        map.put("view", "Grid%20view");
        map.put("pageSize", "50");
        Call<product_ListRes> call = api.getProduct(map);

        call.enqueue(new Callback<product_ListRes>() {
            @Override
            public void onResponse(Call<product_ListRes> call, Response<product_ListRes> response) {
                if(response.isSuccessful()){
                    product_ListRes listRes = response.body();
                    List<product_Res> resList =  listRes.records;
                    for (product_Res h: resList){
                        int idid = h.fields.getProduct_id();
                        if(idid == intId){
                        String p_name1 = h.fields.getProduct_name();
                        String[] type_1 = h.fields.getProduct_sub_name();
                        String site = h.fields.getProduct_site();
                        String name = h.fields.getProduct_name();
                        String level = h.fields.getProduct_level();
                        int amount = h.fields.getProduct_amount();
                        String limit = h.fields.getProduct_limit();
                        String content = h.fields.getProduct_content();
                        int price = h.fields.getProduct_price();
                        p_name = findViewById(R.id.title0_2);
                        p_name.setText(p_name1);
                        p_price = findViewById(R.id.title0_4);
                        p_price.setText("$"+Integer.toString(price));
                        p_level = findViewById(R.id.title1_4);
                        p_level.setText(level);
                        p_amount = findViewById(R.id.title1_6);
                        p_amount.setText(Integer.toString(amount));
                        p_site = findViewById(R.id.title1_8);
                        p_site.setText(site);
                        p_type = findViewById(R.id.title1_2);
                        p_type.setText(type_1[0]);
                        p_star = findViewById(R.id.title1_10);
                        p_star.setText(limit);
                        p_content = findViewById(R.id.title2_3);
                        p_content.setText(content);
                        Log.v("MainActivity" , "Product： " + p_name+"\t" + type_1[0]);
                        };
                    }
                }
                Log.e("MainActivity", response.raw() + "");//code=200
            }
            @Override
            public void onFailure(Call<product_ListRes> call, Throwable t) {
                Log.e("MainActivity", t.getMessage() + "");
            }
        });

        Log.v("測試", id+"");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("商品");



        pageList = new ArrayList<>();
        pageList.add(new PageList1(OrderActivity.this));
        pageList.add(new PageList2(OrderActivity.this));


        viewPager = (ViewPager) findViewById(R.id.viewPage);
        viewPager.setAdapter(new PageAdapter());

    }

    public class PageView extends RelativeLayout {
        public PageView(Context context) {
            super(context);
        }
    }

    private class PageAdapter extends android.support.v4.view.PagerAdapter {

        @Override
        public int getCount() {
            return pageList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return o == view;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(pageList.get(position));
            return pageList.get(position);
            //return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((View) object);
        }


    }

    public class PageList1 extends PageView {

        public PageList1(Context context) {
            super(context);
            View view = LayoutInflater.from(context).inflate(R.layout.activity_switchpage_order1, null);
            addView(view);

            Button btn_buy = findViewById(R.id.btn_buy);


            ImageButton imagebutton1 = findViewById(R.id.imagebutton1);
            Button btn_add = findViewById(R.id.btn_add);


            Button btn_seeR = findViewById(R.id.seeR);


            btn_buy.setOnClickListener( new View.OnClickListener(){
                public void onClick(View v) {
                    // 指定要呼叫的 Activity Class
                    Intent newAct = new Intent();
                    newAct.setClass(OrderActivity.this, after_order.class );
                    Log.v("1",intId+"");
                    newAct.putExtra("IDID",Integer.toString(intId));
                    startActivity( newAct );
                    // 結束原先的 Activity Class
                    OrderActivity.this.finish();
                }
            });

            imagebutton1.setOnClickListener( new View.OnClickListener(){
                public void onClick(View v) {
                    // 指定要呼叫的 Activity Class
                    Intent newAct = new Intent();
                    newAct.setClass(OrderActivity.this, order_picture.class );
                    // 呼叫新的 Activity Class
                    startActivity( newAct );
                    // 結束原先的 Activity Class
                    OrderActivity.this.finish();
                }
            });


            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //利用Toast的靜態函式makeText來建立Toast物件
                    Toast toast = Toast.makeText(OrderActivity.this,
                            "收藏成功!", Toast.LENGTH_LONG);
                    //顯示Toast
                    toast.show();
                }
            });

            try{
                btn_seeR.setOnClickListener( new View.OnClickListener(){
                    public void onClick(View v) {
                        // 指定要呼叫的 Activity Class
                        Intent newAct = new Intent();
                        newAct.setClass(OrderActivity.this, order_record.class );
                        // 呼叫新的 Activity Class
                        startActivity( newAct );
                        // 結束原先的 Activity Class
                        OrderActivity.this.finish();
                    }
                });
            }catch (Error e){
                Log.e("Error", e.getMessage());
            }

        }
    }

    public class PageList2 extends PageView{
        public PageList2(Context context){
            super(context);

            View view = LayoutInflater.from(context).inflate(R.layout.activity_switchpage_order2, null);
            addView(view);

        }
    }


}

