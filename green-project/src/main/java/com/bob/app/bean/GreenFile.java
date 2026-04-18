package com.bob.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Immutable
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="GP_Green_File")

public class GreenFile {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;  
	private String accountNumber;
	
	@Lob
	@Column(name="EIAfile")
	private byte[] EIAfile;
	
	@Lob
	@Column(name="legalVerificationFile")
	private byte[] legalVerificationFile;
	
	@Lob
	@Column(name="financialHealthFile")
	private byte[] financialHealthFile;
	
	@Lob    
	@Column(name="ESGfile")
	private byte[] ESGfile;
	
	private String EIAFileName;
	private String legalVerificationFileName;
	private String FinancialFileName;
	private String ESGFileName;
	
	
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public byte[] getEIAfile() {
		return EIAfile;
	}
	public void setEIAfile(byte[] eIAfile) {
		EIAfile = eIAfile;
	}
	
	public byte[] getLegalVerificationFile() {
		return legalVerificationFile;
	}
	public void setLegalVerificationFile(byte[] legalVerificationFile) {
		this.legalVerificationFile = legalVerificationFile;
	}
	
	public byte[] getFinancialHealthFile() {
		return financialHealthFile;
	}
	public void setFinancialHealthFile(byte[] financialHealthFile) {
		this.financialHealthFile = financialHealthFile;
	}
	public byte[] getESGfile() {
		return ESGfile;
	}
	public void setESGfile(byte[] eSGfile) {
		ESGfile = eSGfile;
	}
	public String getEIAFileName() {
		return EIAFileName;
	}
	public void setEIAFileName(String eIAFileName) {
		EIAFileName = eIAFileName;
	}

	public String getLegalVerificationFileName() {
		return legalVerificationFileName;
	}
	public void setLegalVerificationFileName(String legalVerificationFileName) {
		this.legalVerificationFileName = legalVerificationFileName;
	}
	public String getFinancialFileName() {
		return FinancialFileName;
	}
	public void setFinancialFileName(String financialFileName) {
		FinancialFileName = financialFileName;
	}
	public String getESGFileName() {
		return ESGFileName;
	}
	public void setESGFileName(String eSGFileName) {
		ESGFileName = eSGFileName;
	}
	
	
}
