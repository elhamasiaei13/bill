package com.parvanpajooh.bill.model;

public class ResponseEnvelopeDto {
    private Object data;
    private ResponseStatus status;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
