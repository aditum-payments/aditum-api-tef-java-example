package com.tef.domain;
import java.util.Objects;

public class InitRequest {

    // Attributes

    private String applicationName = null;
    private String applicationVersion = null;
    private String activationCode = null;
    private Boolean contacless = null;
    private PinpadMessages pinpadMessages = null;


    public InitRequest() {}

    public InitRequest(String applicationName, String applicationVersion, String activationCode, Boolean contacless, PinpadMessages pinpadMessages) {
        this.applicationName = applicationName;
        this.applicationVersion = applicationVersion;
        this.activationCode = activationCode;
        this.contacless = contacless;
        this.pinpadMessages = pinpadMessages;
    }


    //Getters & Setters

    public String getApplicationName() {
        return this.applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return this.applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getActivationCode() {
        return this.activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Boolean isContacless() {
        return this.contacless;
    }

    public Boolean getContacless() {
        return this.contacless;
    }

    public void setContacless(Boolean contacless) {
        this.contacless = contacless;
    }

    public PinpadMessages getPinpadMessages() {
        return this.pinpadMessages;
    }

    public void setPinpadMessages(PinpadMessages pinpadMessages) {
        this.pinpadMessages = pinpadMessages;
    }

    @Override
    public String toString() {
        return "{" +
            " applicationName='" + getApplicationName() + "'" +
            ", applicationVersion='" + getApplicationVersion() + "'" +
            ", activationCode='" + getActivationCode() + "'" +
            ", contacless='" + isContacless() + "'" +
            ", pinpadMessages='" + getPinpadMessages() + "'" +
            "}";
    }


}
