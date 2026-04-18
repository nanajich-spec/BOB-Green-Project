package com.bob.app.bean;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
@Entity
@Table(name="GP_Green_Cmnt")

public class CmntHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;  
	private String accountNumber;  
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime currentDate;
	private String cmntBy;
//	private String borrowerComment;
	//private String branchcomment;
	//private String panComment;
	//private String cinComment;
//	private String schemecomment;
//	private String activitycomment;
	private String projComment;
	private String sectorcomment;
	private String locationComment;
	private String descpComment;
	private String susobjComment;
	private String stakeEngComment;
	private String reportReqComment;
	private String timelineComment;
	private String budgetComment;
	private String EIAcommComment;
	private String legalverComment; 
	private String financialHealthCmnt;
	private String esgCompComment;
	private String vulnerabilityComment;
	private String carbonintComment;
	private String sealevelComment;
	private String assestriskComment;
	private String supplychainComment;
	private String shiftingComment;
	private String businessComment;
	private String climateComment;
	private String borrowermissionComment;
	private String PincodeComment;
	private String LatitudeComment;
	private String LongitudeComment;
	private String OthersAddComment;
	private String returnReason;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public LocalDateTime getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(LocalDateTime currentDate) {
		this.currentDate = currentDate;
	}
	public String getCmntBy() {
		return cmntBy;
	}
	public void setCmntBy(String cmntBy) {
		this.cmntBy = cmntBy;
	}
//	public String getBorrowerComment() {
//		return borrowerComment;
//	}
//	public void setBorrowerComment(String borrowerComment) {
//		this.borrowerComment = borrowerComment;
//	}
//	public String getBranchcomment() {
//		return branchcomment;
//	}
//	public void setBranchcomment(String branchcomment) {
//		this.branchcomment = branchcomment;
//	}
//	public String getPanComment() {
//		return panComment;
//	}
//	public void setPanComment(String panComment) {
//		this.panComment = panComment;
//	}
//	public String getCinComment() {
//		return cinComment;
//	}
//	public void setCinComment(String cinComment) {
//		this.cinComment = cinComment;
//	}
//	public String getSchemecomment() {
//		return schemecomment;
//	}
//	public void setSchemecomment(String schemecomment) {
//		this.schemecomment = schemecomment;
//	}
//	public String getActivitycomment() {
//		return activitycomment;
//	}
//	public void setActivitycomment(String activitycomment) {
//		this.activitycomment = activitycomment;
//	}
	public String getProjComment() {
		return projComment;
	}
	public void setProjComment(String projComment) {
		this.projComment = projComment;
	}
	public String getSectorcomment() {
		return sectorcomment;
	}
	public void setSectorcomment(String sectorcomment) {
		this.sectorcomment = sectorcomment;
	}
	public String getLocationComment() {
		return locationComment;
	}
	public void setLocationComment(String locationComment) {
		this.locationComment = locationComment;
	}
	public String getDescpComment() {
		return descpComment;
	}
	public void setDescpComment(String descpComment) {
		this.descpComment = descpComment;
	}
	public String getSusobjComment() {
		return susobjComment;
	}
	public void setSusobjComment(String susobjComment) {
		this.susobjComment = susobjComment;
	}
	public String getStakeEngComment() {
		return stakeEngComment;
	}
	public void setStakeEngComment(String stakeEngComment) {
		this.stakeEngComment = stakeEngComment;
	}
	public String getReportReqComment() {
		return reportReqComment;
	}
	public void setReportReqComment(String reportReqComment) {
		this.reportReqComment = reportReqComment;
	}
	public String getTimelineComment() {
		return timelineComment;
	}
	public void setTimelineComment(String timelineComment) {
		this.timelineComment = timelineComment;
	}
	public String getBudgetComment() {
		return budgetComment;
	}
	public void setBudgetComment(String budgetComment) {
		this.budgetComment = budgetComment;
	}
	public String getEIAcommComment() {
		return EIAcommComment;
	}
	public void setEIAcommComment(String eIAcommComment) {
		EIAcommComment = eIAcommComment;
	}
	public String getLegalverComment() {
		return legalverComment;
	}
	public void setLegalverComment(String legalverComment) {
		this.legalverComment = legalverComment;
	}
	public String getFinancialHealthCmnt() {
		return financialHealthCmnt;
	}
	public void setFinancialHealthCmnt(String financialHealthCmnt) {
		this.financialHealthCmnt = financialHealthCmnt;
	}
	public String getEsgCompComment() {
		return esgCompComment;
	}
	public void setEsgCompComment(String esgCompComment) {
		this.esgCompComment = esgCompComment;
	}
	public String getVulnerabilityComment() {
		return vulnerabilityComment;
	}
	public void setVulnerabilityComment(String vulnerabilityComment) {
		this.vulnerabilityComment = vulnerabilityComment;
	}
	public String getCarbonintComment() {
		return carbonintComment;
	}
	public void setCarbonintComment(String carbonintComment) {
		this.carbonintComment = carbonintComment;
	}
	public String getSealevelComment() {
		return sealevelComment;
	}
	public void setSealevelComment(String sealevelComment) {
		this.sealevelComment = sealevelComment;
	}
	public String getAssestriskComment() {
		return assestriskComment;
	}
	public void setAssestriskComment(String assestriskComment) {
		this.assestriskComment = assestriskComment;
	}
	public String getSupplychainComment() {
		return supplychainComment;
	}
	public void setSupplychainComment(String supplychainComment) {
		this.supplychainComment = supplychainComment;
	}
	public String getShiftingComment() {
		return shiftingComment;
	}
	public void setShiftingComment(String shiftingComment) {
		this.shiftingComment = shiftingComment;
	}
	public String getBusinessComment() {
		return businessComment;
	}
	public void setBusinessComment(String businessComment) {
		this.businessComment = businessComment;
	}
	public String getClimateComment() {
		return climateComment;
	}
	public void setClimateComment(String climateComment) {
		this.climateComment = climateComment;
	}
	public String getBorrowermissionComment() {
		return borrowermissionComment;
	}
	public void setBorrowermissionComment(String borrowermissionComment) {
		this.borrowermissionComment = borrowermissionComment;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public String getPincodeComment() {
		return PincodeComment;
	}
	public void setPincodeComment(String pincodeComment) {
		PincodeComment = pincodeComment;
	}
	public String getLatitudeComment() {
		return LatitudeComment;
	}
	public void setLatitudeComment(String latitudeComment) {
		LatitudeComment = latitudeComment;
	}
	public String getLongitudeComment() {
		return LongitudeComment;
	}
	public void setLongitudeComment(String longitudeComment) {
		LongitudeComment = longitudeComment;
	}
	public String getOthersAddComment() {
		return OthersAddComment;
	}
	public void setOthersAddComment(String othersAddComment) {
		OthersAddComment = othersAddComment;
	}
	
	
}
