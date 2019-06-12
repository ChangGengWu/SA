package com.example.FJU_Store;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        final List<accept_order_item> list = new ArrayList<>();

        list.add(new accept_order_item(android.R.drawable.star_big_on, "aaa"));

        myAdapter = new MyAdapter(this, list);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(myAdapter);
    }
}

