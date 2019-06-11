package com.example.FJU_Store;

public class catagory_book_item {
    private String mImageUrl;//照片
    private String mCreator;//創作者name
    private int mLikes;//按讚數

    public catagory_book_item(String ImageUrl, String Creator ,int likes){
        mImageUrl = ImageUrl;
        mCreator = Creator;
        mLikes = likes;
    }
    public String getmImageUrl(){
        return  mImageUrl;
    }
    public String getCreator(){ return mCreator; }
    public int getLikeCount(){ return mLikes; }



}
