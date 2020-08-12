package com.parvanpajooh.bill.model;

import java.util.Iterator;
import java.util.List;

public class Bill {
    private String chargeId;
    private String personName;
    private List billItems;

    public Bill(){
    }

    public Bill(String chargeId, String personName, List billItems){
        this.chargeId = chargeId;
        this.personName=personName;
        this.billItems=billItems;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public List getBillItems() {
        return billItems;
    }

    public void setBillItems(List billItems) {
        this.billItems = billItems;
    }

    public String toString(){


        return ("name : [" + personName +"] \n  chargeId: [" + chargeId + "] bill : ["+ billItems +"]");

    }
}
