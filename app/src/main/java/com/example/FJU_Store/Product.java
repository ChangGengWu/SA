package com.example.FJU_Store;

public class Product {
    private int product_id;
    //private String seller_email;
    private int product_price;
    private String product_name;
    private String[] product_sub_1;
    private String product_site;
    private String product_level;
    private int product_amount;

    public Product(int product_id, int product_price, String product_name, String product_site, String product_level, int product_amount) {
        this.product_id = product_id;
        //this.seller_email = seller_email;
        this.product_price = product_price;
        this.product_name = product_name;
        //this.product_sub_1 = product_sub_1;
        this.product_site = product_site;
        this.product_level = product_level;
        this.product_amount = product_amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

//    public String getSeller_email() {
//        return seller_email;
//    }
//
//    public void setSeller_email(String seller_email) {
//        this.seller_email = seller_email;
//    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String[] getProduct_sub_1() {
        return product_sub_1;
    }

    public void setProduct_sub_1(String[] product_sub_1) {
        this.product_sub_1 = product_sub_1;
    }

    public String getProduct_site() {
        return product_site;
    }

    public void setProduct_site(String product_site) {
        this.product_site = product_site;
    }

    public String getProduct_level() {
        return product_level;
    }

    public void setProduct_level(String product_level) {
        this.product_level = product_level;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }
}
