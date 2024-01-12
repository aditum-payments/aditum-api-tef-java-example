package com.tef.domain;

public class PinPad {
    String applicationName;
    String bairro;
    String localidade;

    public String getAplicationName() {
        return applicationName;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    @Override
    public String toString() {
        return "{" + 
            "applicationName='" + getAplicationName() + "'" +
            ", bairro='" + getBairro() + "'" +
            ", localidade='" + getLocalidade() + "'" + 
            "}";
    }
}