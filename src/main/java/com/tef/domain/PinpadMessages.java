package com.tef.domain;

public class PinpadMessages {
    private String approvedMessage = null;
    private String declinedMessage = null;
    private String initializationMessage = null;
    private String processingMessage = null;


    public PinpadMessages() {}

    public PinpadMessages(String approvedMessage, String declinedMessage, String initializationMessage, String processingMessage) {
        this.approvedMessage = approvedMessage;
        this.declinedMessage = declinedMessage;
        this.initializationMessage = initializationMessage;
        this.processingMessage = processingMessage;
    }

    //Getters & Setters


    public String getApprovedMessage() {
        return this.approvedMessage;
    }

    public void setApprovedMessage(String approvedMessage) {
        this.approvedMessage = approvedMessage;
    }

    public String getDeclinedMessage() {
        return this.declinedMessage;
    }

    public void setDeclinedMessage(String declinedMessage) {
        this.declinedMessage = declinedMessage;
    }

    public String getInitializationMessage() {
        return this.initializationMessage;
    }

    public void setInitializationMessage(String initializationMessage) {
        this.initializationMessage = initializationMessage;
    }

    public String getProcessingMessage() {
        return this.processingMessage;
    }

    public void setProcessingMessage(String processingMessage) {
        this.processingMessage = processingMessage;
    }

}
