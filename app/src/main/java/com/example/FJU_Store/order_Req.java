package com.example.FJU_Store;

public class order_Req {
    private Order fields;
    private boolean typecast = true;

    public order_Req(Order fields) {
        this.fields = fields;
    }

    public Order getFields() {
        return fields;
    }
    public void setFields(Order fields) {
        this.fields = fields;
    }

    public boolean isTypecast() {
        return typecast;
    }

    public void setTypecast(boolean typecast) {
        this.typecast = typecast;
    }
}
