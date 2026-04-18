package com.bob.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GP_Green_Dynamic_data")


public class DynamicData {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private String accountNumber;
	private String AccountOpeningDate;
	private String DateOfDisbursement;
	private String AmountDisbursed;
	private String AmountOutstanding;
	private String AmountTransferred;
	private String DateOfTransfer;
	
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountOpeningDate() {
		return AccountOpeningDate;
	}
	public void setAccountOpeningDate(String accountOpeningDate) {
		AccountOpeningDate = accountOpeningDate;
	}
	public String getDateOfDisbursement() {
		return DateOfDisbursement;
	}
	public void setDateOfDisbursement(String dateOfDisbursement) {
		DateOfDisbursement = dateOfDisbursement;
	}
	public String getAmountDisbursed() {
		return AmountDisbursed;
	}
	public void setAmountDisbursed(String amountDisbursed) {
		AmountDisbursed = amountDisbursed;
	}
	public String getAmountOutstanding() {
		return AmountOutstanding;
	}
	public void setAmountOutstanding(String amountOutstanding) {
		AmountOutstanding = amountOutstanding;
	}
	public String getAmountTransferred() {
		return AmountTransferred;
	}
	public void setAmountTransferred(String amountTransferred) {
		AmountTransferred = amountTransferred;
	}
	public String getDateOfTransfer() {
		return DateOfTransfer;
	}
	public void setDateOfTransfer(String dateOfTransfer) {
		DateOfTransfer = dateOfTransfer;
	}
	
	
	
	

}
