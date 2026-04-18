package com.bob.app.bean;

import javax.persistence.*;

@Entity
@Table(name = "GP_GREEN_LOAN_DTLS")
public class Disbursement {

    @Id
    @Column(name = "ID")
    private Long id; // must match a unique/id column in the table

    @Column(name = "FORACID")
    private String accountNumber;

    @Column(name = "DISB_DATE")
    private String disbursementDate;

    @Column(name = "DISB_AMT")
    private Double disbursementAmount;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getDisbursementDate() { return disbursementDate; }
    public void setDisbursementDate(String disbursementDate) { this.disbursementDate = disbursementDate; }

    public Double getDisbursementAmount() { return disbursementAmount; }
    public void setDisbursementAmount(Double disbursementAmount) { this.disbursementAmount = disbursementAmount; }
}
