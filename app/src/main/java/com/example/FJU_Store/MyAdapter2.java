package com.example.FJU_Store;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder>
    {
        List<product_Res> mResList;
        Context mContext;
//    private List<String> mDataSet;
//    private List<String> pData;

        public MyAdapter2(Context context,List<product_Res> resList) {
            this.mResList = resList;
            this.mContext = context;
        }


//    public MyAdapter(List<String> data,List<String> data2) {
//        mDataSet = data;
//        pData = data2;
//    }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
            ViewHolder viewholder = new ViewHolder(view);
            return viewholder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            product_Res productRes = mResList.get(position);
            final int itemid = productRes.fields.getProduct_id();
            holder.txtItem.setText(productRes.fields.getProduct_name());
            holder.price.setText(Integer.toString(productRes.fields.getProduct_price()));
            holder.buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent3 = new Intent(mContext,OrderActivity.class);
                    Buyer_info info = new Buyer_info();
                    info.setUser_mail(info.mail);
                    info.setItem_id(Integer.toString(itemid));
                    intent3.putExtra("id",info);
                    mContext.startActivity(intent3);

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(Config.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    order_API api = retrofit.create(order_API.class);
                    Map<String, String> map = new HashMap<>();

                    map.put("api_key", Config.API_KEY);
                    map.put("view", "Grid%20view");
                    map.put("pageSize", "10");

                    Call<order_ListRes> call = api.getOrder(map);

                    call.enqueue(new Callback<order_ListRes>() {
                        @Override
                        public void onResponse(Call<order_ListRes> call, Response<order_ListRes> response) {
                            if(response.isSuccessful()){
                                order_ListRes listRes = response.body();
                                List<order_Res> resList =  listRes.records;
                                for (order_Res h: resList){
                                    String each = h.id.toString();
                                    //String st = h.fields.getOrder_status();
                                    //Log.v("MainActivity" , "Order： "+"\t"+ each+"\t");
                                }
                                Log.e("MainActivity", response.raw() + "");
                            }
                            else {
                                Log.e("MainActivity", response.raw() + "");
                            }
                        }

                        @Override
                        public void onFailure(Call<order_ListRes> call, Throwable t) {
                            Log.d("emails", t.getMessage());
                        }
                    });
//
//                Toast.makeText(v.getContext(),"123",Toast.LENGTH_LONG);
//                Log.v("M","123");
                }
            });
        }

        @Override
        public int getItemCount() {
            return mResList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            public TextView txtItem;
            public TextView price;
            public Button buy;
            public ViewHolder(View v)
            {
                super(v);
                txtItem = (TextView) v.findViewById(R.id.txtItem);
                price = (TextView) v.findViewById(R.id.price);
                buy = v.findViewById(R.id.toItem);
            }
        }

        public void updateData(List<product_Res> resList){
//        mDataSet.clear();
//        mDataSet.addAll(data);
//        pData.clear();
//        pData.addAll(data2);
            mResList.clear();
            mResList.addAll(resList);
            Log.v("NAME", "更新資料!");
            notifyDataSetChanged();
        }
    }

