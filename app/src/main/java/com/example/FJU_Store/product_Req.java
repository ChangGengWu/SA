package com.example.FJU_Store;

public class product_Req {
    private Product fields;

    public product_Req(Product fields) {
        this.fields = fields;
    }

    public Product getFields() {
        return fields;
    }
    public void setFields(Product fields) {
        this.fields = fields;
    }
}
