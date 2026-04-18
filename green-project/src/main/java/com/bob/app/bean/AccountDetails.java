package com.bob.app.bean;

import javax.persistence.*;

@Entity
@Table(name ="TB_ACCOUNT_DETAILS")
public class AccountDetails {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
	
	@Column(name="ACCOUNT_NUMBER", nullable = false)
    private String accountNo;
	
	@Column(name="IFSC_CODE", nullable = false)
    private String ifscCode;
	
	@Column(name="STATE", nullable = false)
    private String state;

	public Long getId() {
		return id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}