package com.example.FJU_Store;

public class Order {
    private Integer order_id = null;
    private String[] ordered_product_id;
    private String order_status;
    private String[] order_buyer;
    private String wish_date;
    private String[] buyer_name;
    private String[] ordered_p_id;

    public Order(String order_status,String wish_date) {
        this.order_status = order_status;
        this.wish_date = wish_date;
    }


    public Order(String[] ordered_product_id,String order_status,String[] order_buyer) {
        this.ordered_product_id = ordered_product_id;
        this.order_status = order_status;
        this.order_buyer = order_buyer;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String[] getOrdered_product_id() {
        return ordered_product_id;
    }

    public void setOrdered_product_id(String[] ordered_product_id) {
        this.ordered_product_id = ordered_product_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String[] getOrder_buyer() {
        return order_buyer;
    }

    public void setOrder_buyer(String[] order_buyer) {
        this.order_buyer = order_buyer;
    }

    public String getWish_date() {
        return wish_date;
    }

    public void setWish_date(String wish_date) {
        this.wish_date = wish_date;
    }

    public String[] getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String[] buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String[] getOrdered_p_id() {
        return ordered_p_id;
    }

    public void setOrdered_p_id(String[] ordered_p_id) {
        this.ordered_p_id = ordered_p_id;
    }
}
