package com.tef.domain;

public class AditumApiError {

    private Integer errorCode;
    private String message;
    private String description;

    public AditumApiError() { }

    public AditumApiError(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
