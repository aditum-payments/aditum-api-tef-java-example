package com.tef.domain;

public class PaymentResponse extends BaseResponse {

    // Attributes

    private PaymentStatus status;
    private Charge charge;
    private Boolean isApproved;
    private String operatorMessage;
    private Integer httpStatusResponse;

    // Getters & Setters

    public String getOperatorMessage() {
        return this.operatorMessage;
    }

    public void setOperatorMessage(String operatorMessage) {
        this.operatorMessage = operatorMessage;
    }

    public Charge getCharge() {
        return this.charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public PaymentStatus getStatus() {
        return this.status;
    }

    public void setAmount(PaymentStatus status) {
        this.status = status;
    }

    public Boolean getIsApproved() {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Integer getHttpStatusResponse() {
        return httpStatusResponse;
    }

    public void setHttpStatusResponse(Integer httpStatusResponse) {
        this.httpStatusResponse = httpStatusResponse;
    }

    @Override
    public String toString() {
        return "{" +
            " status='" + getStatus() + "'" +
            ", charge='" + getCharge() + "'" +
            ", isApproved='" + getIsApproved() + "'" +
            ", operatorMessage='" + getOperatorMessage() + "'" +
            "}";
    }

}
