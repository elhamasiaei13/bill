package com.parvanpajooh.bill.model;

public class PaymentCommandDto {
    private String chargeId;
    private String captchaPlainValue;
    private String captchaId;

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getCaptchaPlainValue() {
        return captchaPlainValue;
    }

    public void setCaptchaPlainValue(String captchaPlaindValue) {
        this.captchaPlainValue = captchaPlaindValue;
    }

    public String getCaptchaId() {
        return captchaId;
    }

    public void setCaptchId(String captchaId) {
        this.captchaId = captchaId;
    }
}
