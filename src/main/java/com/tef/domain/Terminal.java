package com.tef.domain;

public class Terminal {
   
    // Attributes

    private Boolean contactlessSupported = null;
    private String manufacturer = null;
    private String manufacturerVersion = null;
    private String model = null;
    private String osVersion = null;
    private String serialNumber = null;
    private String specVersion = null;
    
    //Getters & Setters

    public Boolean getContactlessSupported() {
        return this.contactlessSupported;
    }

    public void setContactlessSupported(Boolean contactlessSupported) {
        this.contactlessSupported = contactlessSupported;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerVersion() {
        return this.manufacturerVersion;
    }

    public void setManufacturerVersion(String manufacturerVersion) {
        this.manufacturerVersion = manufacturerVersion;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSpecVersion() {
        return this.specVersion;
    }

    public void setSpecVersion(String specVersion) {
        this.specVersion = specVersion;
    }


    @Override
    public String toString() {
        return "{" +
            " contactlessSupported='" + getContactlessSupported() + "'" +
            ", manufacturer='" + getManufacturer() + "'" +
            ", manufacturerVersion='" + getManufacturerVersion() + "'" +
            ", model='" + getModel() + "'" +
            ", osVersion='" + getOsVersion() + "'" +
            ", serialNumber='" + getSerialNumber() + "'" +
            ", specVersion='" + getSpecVersion() + "'" +
            "}";
    }

}
