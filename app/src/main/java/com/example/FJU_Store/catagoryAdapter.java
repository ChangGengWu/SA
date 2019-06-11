package com.example.FJU_Store;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class catagoryAdapter extends RecyclerView.Adapter<catagoryAdapter.catagoryHolder> {
    private Context mContext;
    private ArrayList<catagory_book_item> mExampleList;
    private OnItemClickListener mListener;
    //ON ITEM CLICK LISTENER INTERFACE
    public interface OnItemClickListener {
        void onItemClick(int position);//onItermClick介面
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    public catagoryAdapter(Context context ,ArrayList<catagory_book_item> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }


    @Override
    public catagoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.catagory_book_item, parent, false);
        return new catagoryHolder(v);
    }

    @Override
    public void onBindViewHolder(catagoryHolder holder, int position) {
        catagory_book_item currentItem = mExampleList.get(position);

        String imageUrl = currentItem.getmImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikeCount();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Likes: "+ likeCount);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public class catagoryHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;
        //
        public catagoryHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);//抓取CLICK=>pass to 介面=>activity
                        }
                    }
                }
            });
        }
    }
}

