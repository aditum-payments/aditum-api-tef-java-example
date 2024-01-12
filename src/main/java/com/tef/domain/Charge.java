package com.tef.domain;

import java.util.List;

public class Charge {

    private String acquirerName;
    private String aid;
    private int amount;
    private String authorizationCode;
    private String authorizationResponseCode;
    private Double balance;
    private String brand;
    private String cancelationDateTime;
    private String captureDateTime;
    private String cardHolderName;
    private String cardNumber;
    private List<String> cardholderReceipt;
    private String creationDateTime;
    private int installmentNumber;
    private String installmentType;
    private boolean isApproved;
    private boolean isCanceled;
    private String merchantChargeId;
    private List<String> merchantReceipt;
    private String merchantTransactionId;
    private String nsu;
    private String origin;
    private String paymentType;
    private String transactionId;
    private String transactionIdOnAcquirer;

    public String getAcquirerName() {
        return acquirerName;
    }

    public void setAcquirerName(String acquirerName) {
        this.acquirerName = acquirerName;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getAuthorizationResponseCode() {
        return authorizationResponseCode;
    }

    public void setAuthorizationResponseCode(String authorizationResponseCode) {
        this.authorizationResponseCode = authorizationResponseCode;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCancelationDateTime() {
        return cancelationDateTime;
    }

    public void setCancelationDateTime(String cancelationDateTime) {
        this.cancelationDateTime = cancelationDateTime;
    }

    public String getCaptureDateTime() {
        return captureDateTime;
    }

    public void setCaptureDateTime(String captureDateTime) {
        this.captureDateTime = captureDateTime;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<String> getCardholderReceipt() {
        return cardholderReceipt;
    }

    public void setCardholderReceipt(List<String> cardholderReceipt) {
        this.cardholderReceipt = cardholderReceipt;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public String getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(String installmentType) {
        this.installmentType = installmentType;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public String getMerchantChargeId() {
        return merchantChargeId;
    }

    public void setMerchantChargeId(String merchantChargeId) {
        this.merchantChargeId = merchantChargeId;
    }

    public List<String> getMerchantReceipt() {
        return merchantReceipt;
    }

    public void setMerchantReceipt(List<String> merchantReceipt) {
        this.merchantReceipt = merchantReceipt;
    }

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionIdOnAcquirer() {
        return transactionIdOnAcquirer;
    }

    public void setTransactionIdOnAcquirer(String transactionIdOnAcquirer) {
        this.transactionIdOnAcquirer = transactionIdOnAcquirer;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "aid='" + aid + '\'' +
                ", amount=" + amount +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", authorizationResponseCode='" + authorizationResponseCode + '\'' +
                ", balance=" + balance +
                ", brand='" + brand + '\'' +
                ", cancelationDateTime='" + cancelationDateTime + '\'' +
                ", captureDateTime='" + captureDateTime + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardholderReceipt=" + cardholderReceipt +
                ", creationDateTime='" + creationDateTime + '\'' +
                ", installmentNumber=" + installmentNumber +
                ", installmentType='" + installmentType + '\'' +
                ", isApproved=" + isApproved +
                ", isCanceled=" + isCanceled +
                ", merchantChargeId='" + merchantChargeId + '\'' +
                ", merchantReceipt=" + merchantReceipt +
                ", merchantTransactionId='" + merchantTransactionId + '\'' +
                ", nsu='" + nsu + '\'' +
                ", origin='" + origin + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", transactionIdOnAcquirer='" + transactionIdOnAcquirer + '\'' +
                '}';
    }

}
