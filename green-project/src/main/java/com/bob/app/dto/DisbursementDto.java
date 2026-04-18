package com.bob.app.dto;

public class DisbursementDto {
    private String disbursementDate;
    private Double disbursementAmount;

    public DisbursementDto() {}

    public DisbursementDto(String disbursementDate, Double disbursementAmount) {
        this.disbursementDate = disbursementDate;
        this.disbursementAmount = disbursementAmount;
    }

    public String getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(String disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public Double getDisbursementAmount() {
        return disbursementAmount;
    }

    public void setDisbursementAmount(Double disbursementAmount) {
        this.disbursementAmount = disbursementAmount;
    }
}
