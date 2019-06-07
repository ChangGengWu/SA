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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class OrderActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<PageView> pageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

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
                    // 呼叫新的 Activity Class
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


