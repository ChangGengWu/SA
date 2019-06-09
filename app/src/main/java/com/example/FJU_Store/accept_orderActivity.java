package com.example.FJU_Store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class accept_orderActivity extends AppCompatActivity {

    private ListView listView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_order);

        List<accept_order_item> list = new ArrayList<>();

        list.add(new accept_order_item(android.R.drawable.star_big_on, "12345678"));
        list.add(new accept_order_item(android.R.drawable.alert_dark_frame, "vevwevwe"));
        list.add(new accept_order_item(android.R.drawable.progress_horizontal, "12evev345678"));
        list.add(new accept_order_item(android.R.drawable.star_big_off, "rgrgrgr"));

        listView = (ListView) findViewById(R.id.list_item);
        myAdapter = new MyAdapter(this, list);
        listView.setAdapter(myAdapter);
    }
}

