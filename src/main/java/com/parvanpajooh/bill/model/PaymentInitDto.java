package com.parvanpajooh.bill.model;

public class PaymentInitDto {
    private String captchaId;
    private String captchaIncryptedValue;

    public PaymentInitDto(){

    }
    public PaymentInitDto(String captchaId,String captchaIncryptedValue){
        this.captchaId=captchaId;
        this.captchaIncryptedValue=captchaIncryptedValue;
    }


    public String getCaptchaId() {
        return captchaId;
    }

    public void setCaptchaId(String captchaId) {
        this.captchaId = captchaId;
    }

    public String getCaptchaIncryptedValue() {
        return captchaIncryptedValue;
    }

    public void setCaptchaIncryptedValue(String captchaIncryptedValue) {
        this.captchaIncryptedValue = captchaIncryptedValue;
    }
}
