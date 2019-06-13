package com.example.FJU_Store;

import java.io.Serializable;

public class Order_info implements Serializable {
    private String o_id;
    private String f_id;

    public Order_info(String o_id, String f_id) {
        this.o_id = o_id;
        this.f_id = f_id;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }
}
