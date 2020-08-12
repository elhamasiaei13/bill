package com.parvanpajooh.bill.model;

import java.math.BigDecimal;

public class BillItem {
    private String description;
    private BigDecimal amount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String toString(){

        return ("description : [" + description +"] \n  id: [" +amount + "] bill : ["+ amount +"]");
    }

}
