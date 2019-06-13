package com.example.FJU_Store;

public class accept_order_item {
    private int imageResId;
    private String account;

    public accept_order_item(String account) {
        this.account = account;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
