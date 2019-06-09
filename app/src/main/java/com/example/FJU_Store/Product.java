package com.example.FJU_Store;

import java.io.Serializable;

public class Product implements Serializable {
    private int product_id;
    private String product_price;
    private String product_name;
    private String product_site;
    private String product_level;
    private String product_number;
    private String product_date;
    private String seller_email;
    private String order_product;
    private String product_sub_1;
    private String product_main ;

    public String getProduct_restrict() {
        return product_restric;
    }

    public void setProduct_restric(String product_restric) {
        this.product_restric = product_restric;
    }

    private String product_restric;

    public String getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(String product_detail) {
        this.product_detail = product_detail;
    }

    private String product_detail;

    public String getProduct_main() {
        return product_main;
    }

    public void setProduct_main(String product_main) {
        this.product_main = product_main;
    }


    //沒有接圖片
    //FK欄位不確定

  /* public Product(int product_id,int product_price,String product_name,String product_site,
                  String product_level,int product_number,String product_date,String seller_email,
                  String order_product,String product_sub_1,String product_main ){

   }*/

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_sub_1() {
        return product_sub_1;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
    }

    public String getProduct_date() {
        return product_date;
    }

    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getOrder_product() {
        return order_product;
    }

    public void setOrder_product(String order_product) {
        this.order_product = order_product;
    }



    public void setProduct_sub_1(String product_sub_1) {
        this.product_sub_1 = product_sub_1;
    }
}

