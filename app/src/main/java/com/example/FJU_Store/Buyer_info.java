package com.example.FJU_Store;

import java.io.Serializable;

public class Buyer_info implements Serializable{
    private String view;
    private String user_mail;
    private String item_id;

    public static String mail = "";

    public Buyer_info() {
        this.view = view;
        this.user_mail = user_mail;
        this.item_id = item_id;
    }
    public Buyer_info(String user_mail, String item_id) {
        this.user_mail = user_mail;
        this.item_id = item_id;
    }
    public Buyer_info(String view, String user_mail, String item_id) {
        this.view = view;
        this.user_mail = user_mail;
        this.item_id = item_id;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
}
