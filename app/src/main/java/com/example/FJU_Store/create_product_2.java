package com.example.FJU_Store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

public class create_product_2 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product_2);

        final int[] chk_id={R.id.c1,R.id.c2,R.id.c3,R.id.c4,R.id.c5,R.id.c6,R.id.c7
                ,R.id.c8,R.id.c9,R.id.c10,R.id.c11,R.id.c12,R.id.c13,R.id.c14,R.id.c15
                ,R.id.c16,R.id.c17,R.id.c18,R.id.c19};
        for(int id:chk_id){
            CheckBox chk=findViewById(id);
            chk.setOnCheckedChangeListener(this);
        }

        Intent intent = getIntent();
        //String book_category = intent.getStringExtra("book_category");
        final Product_w product_data = (Product_w) getIntent().getSerializableExtra("product_data");
        Button next_book=findViewById(R.id.next_book);
        next_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg="";
                for(CompoundButton chk:selected){
                    msg+=chk.getText();
                }
                Intent intent =new Intent(create_product_2.this,create_product_3.class);
//                Product_w product = new Product_w();
//                product_data.getProduct_main();
//                product.setProduct_main("書籍類");
                product_data.setProduct_sub_1(msg);
                intent.putExtra("product_data",product_data);
                Log.v("MAIL",product_data.getSeller_email());


                startActivity(intent);
            }
        });

    }





    ArrayList<CompoundButton> selected=new ArrayList<>();
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            selected.add(buttonView);
            //Log.d("HKT", "product_data: " + selected);
        }
        else{
            selected.remove(buttonView);
        }
    }
}
