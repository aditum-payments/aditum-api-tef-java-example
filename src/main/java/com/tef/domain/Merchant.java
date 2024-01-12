package com.tef.domain;

import java.util.List;

public class Merchant {

    // Attributes

   private List<String> acquirers = null;
   private String fantasyName = null;
   private String id = null;
   private Boolean isActive = null;
   private String merchantDocument = null;
   
   // Getters & Setters


    public List<String> getAcquirers() {
        return this.acquirers;
    }

    public void setAcquirers(List<String> acquirers) {
        this.acquirers = acquirers;
    }

    public String getFantasyName() {
        return this.fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isIsActive() {
        return this.isActive;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getMerchantDocument() {
        return this.merchantDocument;
    }

    public void setMerchantDocument(String merchantDocument) {
        this.merchantDocument = merchantDocument;
    }


    @Override
    public String toString() {
        return "{" +
            " acquirers='" + getAcquirers() + "'" +
            ", fantasyName='" + getFantasyName() + "'" +
            ", id='" + getId() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", merchantDocument='" + getMerchantDocument() + "'" +
            "}";
    }


}
