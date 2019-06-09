package com.example.FJU_Store;

public class Order {
    private int order_id;
    //private int order_product_id;
    private String order_status;
    //private String order_buyer;

    public Order(int order_id, String order_status) {
        this.order_id = order_id;
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

//    public int getOrder_prouct_id() {
//        return order_product_id;
//    }
//
//    public void setOrder_prouct_id(int order_prouct_id) {
//        this.order_product_id = order_prouct_id;
//    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

//    public String getOrder_buyer() {
//        return order_buyer;
//    }
//
//    public void setOrder_buyer(String order_buyer) {
//        this.order_buyer = order_buyer;
//    }
}
