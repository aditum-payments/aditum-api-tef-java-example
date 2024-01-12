package com.tef.domain;

import java.util.List;

public class InitResponse extends BaseResponse {

    // Attributes

    private List<String> availableBrands = null;
    private Host hostInfo = null;
    private Merchant merchantInfo = null;
    private Terminal terminalInfo = null;

    //Getters & Setters

    public List<String> getAvailableBrands() {
        return this.availableBrands;
    }

    public void setAvailableBrands(List<String> avaibleBrands) {
        this.availableBrands = avaibleBrands;
    }

    public Host getHostInfo() {
        return this.hostInfo;
    }

    public void setHostInfo(Host hostInfo) {
        this.hostInfo = hostInfo;
    }

    public Merchant getMerchantInfo() {
        return this.merchantInfo;
    }

    public void setMerchantInfo(Merchant merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public Terminal getTerminalInfo() {
        return this.terminalInfo;
    }

    public void setTerminalInfo(Terminal terminalInfo) {
        this.terminalInfo = terminalInfo;
    }


    @Override
    public String toString() {
        return "{" +
            " avaibleBrands:'" + getAvailableBrands() + "'" +
            " errors:'" + getErrors() + "'" +
            ", hostInfo:'" + getHostInfo() + "'" +
            ", merchant:'" + getMerchantInfo() + "'" +
            ", merchant:'" + getSuccess() + "'" +
            ", terminalInfo:'" + getTerminalInfo() + "'" +
            "}";
    }

}

