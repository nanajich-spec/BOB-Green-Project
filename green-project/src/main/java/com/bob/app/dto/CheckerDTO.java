package com.bob.app.dto;

public class CheckerDTO {
	private String accountNumber;
	private String decision;
	private String returnReason;
	private String CheckerId;
	private String status;
	//private String CurrentStatus;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public String getCheckerId() {
		return CheckerId;
	}
	public void setCheckerId(String checkerId) {
		CheckerId = checkerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public String getCurrentStatus() {
//		return CurrentStatus;
//	}
//	public void setCurrentStatus(String currentStatus) {
//		CurrentStatus = currentStatus;
//	}

}
