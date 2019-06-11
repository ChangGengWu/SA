package com.example.FJU_Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.FJU_Store.Catagory_Book_Activity.Extra_CREATER;
import static com.example.FJU_Store.Catagory_Book_Activity.Extra_LIKES;
import static com.example.FJU_Store.Catagory_Book_Activity.Extra_URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = ((Intent) intent).getStringExtra(Extra_URL);
        String creatorName = intent.getStringExtra(Extra_CREATER);
        int likeCount = intent.getIntExtra(Extra_LIKES, 0);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewLikes = findViewById(R.id.text_view_like_detail);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText(creatorName);
        textViewCreator.setText("Likes: " + likeCount);

    }
}
