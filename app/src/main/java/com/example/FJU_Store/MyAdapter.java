package com.example.FJU_Store;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class MyAdapter extends ArrayAdapter<accept_order_item> {
    private Context mContext;
    private List<accept_order_item> mDara;

    public MyAdapter(Context context, List<accept_order_item> data) {
        super(context, 0, data);
        mContext = context;
        mDara = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        accept_order_item item = mDara.get(position);

        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater
                    .from(mContext)
                    .inflate(R.layout.activity_accept_order_item, parent, false);
        }

        ImageView imageView = (ImageView) itemView.findViewById(R.id.account_pic);
        imageView.setImageResource(item.getImageResId());

        TextView account = (TextView) itemView.findViewById(R.id.account);
        account.setText(item.getAccount());

        final Button accept = (Button) itemView.findViewById(R.id.accept);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.accept) {
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    new DatePickerDialog(v.getContext(),new DatePickerDialog.OnDateSetListener(){
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day){
                            String dateTime = String.valueOf(month)+"/"+String.valueOf(day)+"/"+String.valueOf(year);
                            Toast.makeText(mContext, dateTime+"", Toast.LENGTH_SHORT).show();
                            //accept.setText(dateTime);
                        }
                    },year,month,day).show();
                }
                Toast.makeText(mContext, "第" + position + "筆資料", Toast.LENGTH_SHORT).show();

            }
        });

        return itemView;
    }


}
