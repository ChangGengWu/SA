package com.example.FJU_Store;

public class Order {
    private Integer order_id = null;
    private String[] order_product_id;
    private String order_status;
    private String[] order_buyer;
    private String wish_date;

    public Order(String[] order_product_id, String order_status, String[] order_buyer) {
        this.order_product_id = order_product_id;
        this.order_status = order_status;
        this.order_buyer = order_buyer;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String[] getOrder_product_id() {
        return order_product_id;
    }

    public void setOrder_product_id(String[] order_product_id) {
        this.order_product_id = order_product_id;
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
}
