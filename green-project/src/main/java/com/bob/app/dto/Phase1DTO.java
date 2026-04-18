package com.bob.app.dto;

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



public class Phase1DTO {
	
	private String phase;
	private String accountNumber;   
	private String borrowerName;
	private String borrowerComment;
	private String borrowerFlag;
	private String briefDtls;
	private String branchName;
	private String branchcomment;
	private String branchFlag;
	private String plantLocations;
	private String panNumber; 
	private String panFlag;
	private String panComment;
	private String plantLocationsFlag;
	private String cinNumber;
	private String cinFlag;
	private String cinComment;
	private String segment;
	private String schemeCode;
	private String schemeFlag;
	private String schemecomment;

	private String activityCode;
	private String activityFlag;
	private String activitycomment;

	private String projName;
	private String projFlag;
	private String projComment;

	private String sector;
	private String sectorFlag;
	private String sectorcomment;

//	private String locationType;
//	private String locationFlag;
//	private String locationComment;

	private String description;
	private String descpFlag;
	private String descpComment;

	private String susobj;
	private String susobjFlag;
	private String susobjComment;

	private String stakeEng;
	private String stakeEngFlag;
	private String stakeEngComment;

	private String reportReq;
	private String reportReqFlag;
	private String reportReqComment;

	private String timeline ;
	private String timelineFlag;
	private String timelineComment;

	private String budget;
	private String budgetFlag;
	private String budgetComment;

	private String EIAcomments;
	private String EIAcommFlag;
	private String EIAcommComment;

	private String legalVerificationComments;
	private String legalverFlag; 
	private String legalverComment; 

	private String financialHealthComments;
	private String financialHealthFlag;
	private String financialHealthCmnt;

	private String esgCompliance;
	private String esgCompFlag;
	private String esgCompComment;
	
	private String Pincode;
	private String Latitude;
	private String Longitude;
//	private String OthersAdd;
	
//	@Lob
//	@Column(name="EIAfile")
//	private byte[] EIAfile;
//
//
//	@Lob
//	@Column(name="legalVerificationFile")
//	private byte[] legalVerificationFile;
//	
//	@Lob
//	@Column(name="financialHealthFile")
//	private byte[] financialHealthFile;
//	
//	@Lob
//	@Column(name="ESGfile")
//	private byte[] ESGfile;

	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
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
	public String getBorrowerFlag() {
		return borrowerFlag;
	}
	public void setBorrowerFlag(String borrowerFlag) {
		this.borrowerFlag = borrowerFlag;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchFlag() {
		return branchFlag;
	}
	public void setBranchFlag(String branchFlag) {
		this.branchFlag = branchFlag;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getPanFlag() {
		return panFlag;
	}
	public void setPanFlag(String panFlag) {
		this.panFlag = panFlag;
	}
	public String getCinNumber() {
		return cinNumber;
	}
	public void setCinNumber(String cinNumber) {
		this.cinNumber = cinNumber;
	}
	public String getCinFlag() {
		return cinFlag;
	}
	public void setCinFlag(String cinFlag) {
		this.cinFlag = cinFlag;
	}
	public String getSchemeCode() {
		return schemeCode;
	}
	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}
	public String getSchemeFlag() {
		return schemeFlag;
	}
	public void setSchemeFlag(String schemeFlag) {
		this.schemeFlag = schemeFlag;
	}
	public String getActivityCode() {
		return activityCode;
	}
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}
	public String getActivityFlag() {
		return activityFlag;
	}
	public void setActivityFlag(String activityFlag) {
		this.activityFlag = activityFlag;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getProjFlag() {
		return projFlag;
	}
	public void setProjFlag(String projFlag) {
		this.projFlag = projFlag;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getSectorFlag() {
		return sectorFlag;
	}
	public void setSectorFlag(String sectorFlag) {
		this.sectorFlag = sectorFlag;
	}
	
//	public String getLocationType() {
//		return locationType;
//	}
//	public void setLocationType(String locationType) {
//		this.locationType = locationType;
//	}
//	public String getLocationFlag() {
//		return locationFlag;
//	}
//	public void setLocationFlag(String locationFlag) {
//		this.locationFlag = locationFlag;
//	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescpFlag() {
		return descpFlag;
	}
	public void setDescpFlag(String descpFlag) {
		this.descpFlag = descpFlag;
	}
	public String getSusobj() {
		return susobj;
	}
	public void setSusobj(String susobj) {
		this.susobj = susobj;
	}
	public String getSusobjFlag() {
		return susobjFlag;
	}
	public void setSusobjFlag(String susobjFlag) {
		this.susobjFlag = susobjFlag;
	}
	public String getStakeEng() {
		return stakeEng;
	}
	public void setStakeEng(String stakeEng) {
		this.stakeEng = stakeEng;
	}
	public String getStakeEngFlag() {
		return stakeEngFlag;
	}
	public void setStakeEngFlag(String stakeEngFlag) {
		this.stakeEngFlag = stakeEngFlag;
	}
	public String getReportReq() {
		return reportReq;
	}
	public void setReportReq(String reportReq) {
		this.reportReq = reportReq;
	}
	public String getReportReqFlag() {
		return reportReqFlag;
	}
	public void setReportReqFlag(String reportReqFlag) {
		this.reportReqFlag = reportReqFlag;
	}
	public String getTimeline() {
		return timeline;
	}
	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}
	public String getTimelineFlag() {
		return timelineFlag;
	}
	public void setTimelineFlag(String timelineFlag) {
		this.timelineFlag = timelineFlag;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getBudgetFlag() {
		return budgetFlag;
	}
	public void setBudgetFlag(String budgetFlag) {
		this.budgetFlag = budgetFlag;
	}
	public String getEIAcomments() {
		return EIAcomments;
	}
	public void setEIAcomments(String eIAcomments) {
		EIAcomments = eIAcomments;
	}
	public String getEIAcommFlag() {
		return EIAcommFlag;
	}
	public void setEIAcommFlag(String eIAcommFlag) {
		EIAcommFlag = eIAcommFlag;
	}
	public String getLegalVerificationComments() {
		return legalVerificationComments;
	}
	public void setLegalVerificationComments(String legalVerificationComments) {
		this.legalVerificationComments = legalVerificationComments;
	}
	public String getLegalverFlag() {
		return legalverFlag;
	}
	public void setLegalverFlag(String legalverFlag) {
		this.legalverFlag = legalverFlag;
	}
	public String getFinancialHealthComments() {
		return financialHealthComments;
	}
	public void setFinancialHealthComments(String financialHealthComments) {
		this.financialHealthComments = financialHealthComments;
	}
	public String getFinancialHealthFlag() {
		return financialHealthFlag;
	}
	public void setFinancialHealthFlag(String financialHealthFlag) {
		this.financialHealthFlag = financialHealthFlag;
	}
	public String getEsgCompliance() {
		return esgCompliance;
	}
	public void setEsgCompliance(String esgCompliance) {
		this.esgCompliance = esgCompliance;
	}
	public String getEsgCompFlag() {
		return esgCompFlag;
	}
	public void setEsgCompFlag(String esgCompFlag) {
		this.esgCompFlag = esgCompFlag;
	}
	public String getBorrowerComment() {
		return borrowerComment;
	}
	public void setBorrowerComment(String borrowerComment) {
		this.borrowerComment = borrowerComment;
	}
	public String getBranchcomment() {
		return branchcomment;
	}
	public void setBranchcomment(String branchcomment) {
		this.branchcomment = branchcomment;
	}
	public String getPanComment() {
		return panComment;
	}
	public void setPanComment(String panComment) {
		this.panComment = panComment;
	}
	public String getCinComment() {
		return cinComment;
	}
	public void setCinComment(String cinComment) {
		this.cinComment = cinComment;
	}
	public String getSchemecomment() {
		return schemecomment;
	}
	public void setSchemecomment(String schemecomment) {
		this.schemecomment = schemecomment;
	}
	public String getActivitycomment() {
		return activitycomment;
	}
	public void setActivitycomment(String activitycomment) {
		this.activitycomment = activitycomment;
	}
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
//	public String getLocationComment() {
//		return locationComment;
//	}
//	public void setLocationComment(String locationComment) {
//		this.locationComment = locationComment;
//	}
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
//	public byte[] getEIAfile() {
//		return EIAfile;
//	}
//	public void setEIAfile(byte[] eIAfile) {
//		EIAfile = eIAfile;
//	}
//	public byte[] getLegalVerificationFile() {
//		return legalVerificationFile;
//	}
//	public void setLegalVerificationFile(byte[] legalVerificationFile) {
//		this.legalVerificationFile = legalVerificationFile;
//	}
//	public byte[] getFinancialHealthFile() {
//		return financialHealthFile;
//	}
//	public void setFinancialHealthFile(byte[] financialHealthFile) {
//		this.financialHealthFile = financialHealthFile;
//	}
//	public byte[] getESGfile() {
//		return ESGfile;
//	}
//	public void setESGfile(byte[] eSGfile) {
//		ESGfile = eSGfile;
//	}
	
	public String getPincode() {
		return Pincode;
	}
	public String getPlantLocations() {
		return plantLocations;
	}
	public void setPlantLocations(String plantLocations) {
		this.plantLocations = plantLocations;
	}
	public String getPlantLocationsFlag() {
		return plantLocationsFlag;
	}
	public void setPlantLocationsFlag(String plantLocationsFlag) {
		this.plantLocationsFlag = plantLocationsFlag;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
//	public String getOthersAdd() {
//		return OthersAdd;
//	}
//	public void setOthersAdd(String othersAdd) {
//		OthersAdd = othersAdd;
//	}
	public String getBriefDtls() {
		return briefDtls;
	}
	public void setBriefDtls(String briefDtls) {
		this.briefDtls = briefDtls;
	}
	
	
	
}