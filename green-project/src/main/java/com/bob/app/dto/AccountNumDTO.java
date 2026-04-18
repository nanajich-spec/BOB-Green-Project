package com.bob.app.dto;

public class AccountNumDTO {
    private String accountNumber;
    private String borrowerName;
    private String branchName;
    private String panNumber;
    private String cinNumber;
    private String schemeCode;
    private String customerId;

    public AccountNumDTO(String accountNumber, String borrowerName, String branchName,
                         String panNumber, String cinNumber, String schemeCode, String customerId) {
        this.accountNumber = accountNumber;
        this.borrowerName = borrowerName;
        this.branchName = branchName;
        this.panNumber = panNumber;
        this.cinNumber = cinNumber;
        this.schemeCode = schemeCode;
        this.customerId = customerId;
    }

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getCinNumber() {
		return cinNumber;
	}

	public void setCinNumber(String cinNumber) {
		this.cinNumber = cinNumber;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}
	public void setCustomerId(String customerId) { 
		this.customerId = customerId; 
		}
    
}
