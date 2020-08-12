package com.parvanpajooh.bill.model;

import java.util.UUID;
public class Captcha {
    private char[] captcha;
    private  UUID uuid;
    private char[] userInputCaptcha;

    public Captcha(UUID uuid ,char[] captcha ){
        this.captcha=captcha;
        this.uuid=uuid;
    }
    public Captcha(){
    }

    public Captcha(UUID uuid ,char[] captcha ,char[] userInputCaptcha){
        this.captcha=captcha;
        this.uuid=uuid;
        this.userInputCaptcha=userInputCaptcha;
    }


    public char[] getCaptcha() {
        return captcha;
    }

    public void setCaptcha(char[] captcha) {
        this.captcha = captcha;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public char[] getUserInputCaptcha() {
        return userInputCaptcha;
    }

    public void setUserInputCaptcha(char[] userInputCaptcha) {
        this.userInputCaptcha = userInputCaptcha;
    }
}


