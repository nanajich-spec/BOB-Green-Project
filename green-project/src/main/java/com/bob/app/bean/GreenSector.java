package com.bob.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="GP_Green_Sector")
public class GreenSector {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
//	private String accountNumber;
	private String sector;
	private String MandatoryIndicator;
	private String Description;
	private String commentKey;
	private String Type;
	private String Methodology;
	
	
	public Long getId() {  
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	
//	public String getAccountNumber() {
//		return accountNumber;
//	}
//	public void setAccountNumber(String accountNumber) {
//		this.accountNumber = accountNumber;
//	}

	
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getMandatoryIndicator() {
		return MandatoryIndicator;
	}
	public void setMandatoryIndicator(String mandatoryIndicator) {
		MandatoryIndicator = mandatoryIndicator;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	public String getCommentKey() {
		return commentKey;
	}
	public void setCommentKey(String commentKey) {
		this.commentKey = commentKey;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getMethodology() {
		return Methodology;
	}
	public void setMethodology(String methodology) {
		Methodology = methodology;
	}
	
	
	
}
