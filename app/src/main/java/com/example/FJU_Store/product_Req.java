package com.example.FJU_Store;

public class product_Req {
    private Product fields;
    private boolean typecast = true;

    public product_Req(Product fields) {
        this.fields = fields;
    }

    public Product getFields() {
        return fields;
    }
    public void setFields(Product fields) {
        this.fields = fields;
    }

    public boolean isTypecast() {
        return typecast;
    }

    public void setTypecast(boolean typecast) {
        this.typecast = typecast;
    }
}
