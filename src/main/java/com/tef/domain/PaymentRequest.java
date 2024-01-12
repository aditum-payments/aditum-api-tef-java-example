package com.tef.domain;

public class PaymentRequest {
    private int amount;
    private String paymentType;
    private Integer installmentType;


    public PaymentRequest(){}

    public PaymentRequest(int amount, String paymentType, Integer installmentType) {
        this.amount = amount;
        this.paymentType = paymentType;
        this.installmentType = installmentType;
    }

    //Getters & Setters

    public void setInstallmentType(InstallmentType installmentType) {
        switch(installmentType) {
            case MERCHANT:
            case UNDEFINED:
                this.installmentType = 1;
                break;

            case ISSUER:
                this.installmentType = 2;
                break;

        }
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getInstallmentType() {
        return this.installmentType;
    }

    public void setInstallmentType(Integer installmentType) {
        this.installmentType = installmentType;
    }


    @Override
    public String toString() {
        return "{" +
            " amount='" + getAmount() + "'" +
            ", paymentType='" + getPaymentType() + "'" +
            ", installmentType='" + getInstallmentType() + "'" +
            "}";
    }


}
