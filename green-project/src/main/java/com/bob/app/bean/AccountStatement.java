package com.bob.app.bean;

import javax.persistence.*;

@Entity
@Table(name = "TB_ACCOUNT_STATEMENT")
public class AccountStatement {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
	
	@Column(name="ACCOUNT_NUMBER", nullable = false)
    private String AccountNumber;
	
	@Column(name="TRANSACTION_ID", nullable = false)
    private String transID;
	
	@Column(name="TRANSACTION_AMOUNT", nullable = false)
    private Double transAmt;
	
	@Column(name="TRANSACTION_TYPE", nullable = false)
    private String transType;
	
	@Column(name="REMARKS", nullable = false)
    private String remarks;
	
	@Column(name="TRANSACTION_DATE", nullable = false)
    private String transDate;
	
	@Column(name="CLOSING_BALANCE", nullable = false)
    private Double closingBal;

	public Long getId() {
		return id;
	}

	public String getTransID() {
		return transID;
	}

	public Double getTransAmt() {
		return transAmt;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getTransDate() {
		return transDate;
	}

	public Double getClosingBal() {
		return closingBal;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTransID(String transID) {
		this.transID = transID;
	}

	public void setTransAmt(Double transAmt) {
		this.transAmt = transAmt;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public void setClosingBal(Double closingBal) {
		this.closingBal = closingBal;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	
	
	
	
	
	
}