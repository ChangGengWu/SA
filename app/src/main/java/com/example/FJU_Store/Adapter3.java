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

import java.util.List;


public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewHolder>
{
    //    List<product_Res> mResList;
    Context mContext;
    private List<String> mDataSet;
    private List<String> idData;
    private List<String> statusData;
    public Adapter3(Context context,List<String> DataSet,List<String> IdData) {

        this.mDataSet = DataSet;
        this.mContext = context;
        this.idData = IdData;
        //this.statusData = StatusData;
    }


//    public MyAdapter(List<String> data,List<String> data2) {
//        mDataSet = data;
//        pData = data2;
//    }

    @Override
    public Adapter3.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view2, parent, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String productRes = mDataSet.get(position);
        String p_id = idData.get(position);
        final int itemid = Integer.parseInt(p_id);
        holder.txtItem.setText(productRes);
        holder.orderID.setText(p_id);
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(mContext,accept_orderActivity.class);
                intent3.putExtra("id",Integer.toString(itemid));
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
        public TextView txtItem;
        public TextView orderID;
        public Button accept;
        public Button edit;
        public Button getdown;
        public Button finish;
        public ViewHolder(View v)
        {
            super(v);
            txtItem = (TextView) v.findViewById(R.id.txtItem);
            orderID = (TextView) v.findViewById(R.id.orderID);
            accept = v.findViewById(R.id.accept);
            edit = v.findViewById(R.id.edit);
            getdown = v.findViewById(R.id.getdown);
            finish = v.findViewById(R.id.finsh);
        }
    }

    public void updateData(List<String> DataSet,List<String> DataSet2){
//        mDataSet.clear();
//        mDataSet.addAll(data);
//        pData.clear();
//        pData.addAll(data2);
        mDataSet.clear();
        mDataSet.addAll(DataSet);
        idData.clear();;
        idData.addAll(DataSet2);
        Log.v("NAME", "更新資料!");
        notifyDataSetChanged();
    }
}
