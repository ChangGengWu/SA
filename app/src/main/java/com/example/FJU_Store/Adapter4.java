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

import java.util.ArrayList;
import java.util.List;


public class Adapter4 extends RecyclerView.Adapter<Adapter4.ViewHolder>
{
    //    List<product_Res> mResList;
    Context mContext;
    private List<String> mDataSet;
    private List<String> mID;
    private List<String> mFID;

    public Adapter4(Context context,List<String> DataSet,List<String> mID,List<String> mFID) {

        this.mDataSet = DataSet;
        this.mID = mID;
        this.mFID = mFID;

        this.mContext = context;
    }


    @Override
    public Adapter4.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view3, parent, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String p_name = mDataSet.get(position);
        final String o_id = mID.get(position);
        final String f_id = mFID.get(position);
        holder.buyer.setText(p_name);
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order_info o_info = new Order_info(o_id,f_id);
                Intent intent3 = new Intent(mContext,Wish_dateActivity.class);
                intent3.putExtra("id",o_info);
                mContext.startActivity(intent3);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView buyer;
        public Button accept;
        public ViewHolder(View v)
        {
            super(v);
            buyer = (TextView) v.findViewById(R.id.buyer);
            accept = v.findViewById(R.id.accept);

        }
    }

    public void updateData(List<String> DataSet, ArrayList<String> mIDset,ArrayList<String> fIDset){

        mDataSet.clear();
        mDataSet.addAll(DataSet);
        mID.clear();
        mID.addAll(mIDset);
        mFID.clear();
        mFID.addAll(fIDset);
        Log.v("NAME", "更新資料!");
        notifyDataSetChanged();
    }
}
