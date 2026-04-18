package com.bob.app.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import org.springframework.data.annotation.CreatedDate;

public class HistoryCmntDTO {
	
	private String accountNumber;  
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime currentDate;
	private String cmntBy;
	 //private String borrowerComment;
	private String borrowerFlag;
	//private String branchcomment;
	private String branchFlag;
	//private String panComment;
	private String panFlag;
//	private String cinComment;
	private String cinFlag;
	//private String schemecomment;
	private String schemeFlag;
//	private String activitycomment;
	private String activityFlag;
	private String projComment;
	private String projFlag;
	private String sectorcomment;
	private String sectorFlag;
	
	private String segment;
	private String segmentcomment;
	private String segmentFlag;
	
	private String plantLocations;
	private String plantLocationsFlag;
	private String plantLocationsComment;
	private String locationComment;
	private String locationFlag;
	private String descpComment;
	private String descpFlag;	
	private String susobjComment;
	private String susobjFlag;
	private String stakeEngComment;
	private String stakeEngFlag;
	private String reportReqComment;
	private String reportReqFlag;
	private String timelineComment;
	private String timelineFlag;
	private String budgetComment;
	private String budgetFlag;
	private String EIAcommComment;
	private String EIAcommFlag;
	private String legalverComment; 
	private String legalverFlag; 
	private String financialHealthCmnt;
	private String financialHealthFlag;
	private String esgCompComment;
	private String esgCompFlag;
	private String vulnerabilityComment;
	private String vulnerabilityFlag;
	private String carbonintComment;
	private String carbonintFlag;
	private String sealevelComment;
	private String sealevelFlag;
	private String assestriskComment;
	private String assestriskFlag;
	private String supplychainComment;
	private String supplychainFlag;
	private String shiftingComment;
	private String shiftingFlag;
	private String businessComment;
	private String businessFlag;
	private String climateComment;
	private String climateFlag;
	private String borrowermissionComment;
	private String borrowermissionFlag;
	private String EIAFileFlag;
	private String legalFileFlag;
	private String financialFileFlag;
	private String ESGFileFlag;
	private String returnReason;
	private String PincodeFlag;
	private String PincodeComment;
	private String LatitudeFlag;
	private String LatitudeComment;
	private String LongitudeFlag;
	private String LongitudeComment;
	private String OthersAddFlag;
	private String OthersAddComment;
	

	
	public String getPincodeFlag() {
		return PincodeFlag;
	}
	public void setPincodeFlag(String pincodeFlag) {
		PincodeFlag = pincodeFlag;
	}
	public String getPincodeComment() {
		return PincodeComment;
	}
	public void setPincodeComment(String pincodeComment) {
		PincodeComment = pincodeComment;
	}
	public String getLatitudeFlag() {
		return LatitudeFlag;
	}
	public void setLatitudeFlag(String latitudeFlag) {
		LatitudeFlag = latitudeFlag;
	}
	public String getLatitudeComment() {
		return LatitudeComment;
	}
	public void setLatitudeComment(String latitudeComment) {
		LatitudeComment = latitudeComment;
	}
	public String getLongitudeFlag() {
		return LongitudeFlag;
	}
	public void setLongitudeFlag(String longitudeFlag) {
		LongitudeFlag = longitudeFlag;
	}
	public String getLongitudeComment() {
		return LongitudeComment;
	}
	public void setLongitudeComment(String longitudeComment) {
		LongitudeComment = longitudeComment;
	}
	public String getOthersAddFlag() {
		return OthersAddFlag;
	}
	public void setOthersAddFlag(String othersAddFlag) {
		OthersAddFlag = othersAddFlag;
	}
	public String getOthersAddComment() {
		return OthersAddComment;
	}
	public void setOthersAddComment(String othersAddComment) {
		OthersAddComment = othersAddComment;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
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
	public String getSegmentcomment() {
		return segmentcomment;
	}
	public void setSegmentcomment(String segmentcomment) {
		this.segmentcomment = segmentcomment;
	}
	public String getSegment() {
		return segment; 
		}
	public void setSegment(String segment) {
		this.segment = segment; 
		}
	public String getSegmentFlag() { 
		return segmentFlag; } public void setSegmentFlag(String segmentFlag) { this.segmentFlag = segmentFlag; 
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
	public String getBorrowerFlag() {
		return borrowerFlag;
	}
	public void setBorrowerFlag(String borrowerFlag) {
		this.borrowerFlag = borrowerFlag;
	}
	public String getBranchFlag() {
		return branchFlag;
	}
	public void setBranchFlag(String branchFlag) {
		this.branchFlag = branchFlag;
	}
	public String getPanFlag() {
		return panFlag;
	}
	public void setPanFlag(String panFlag) {
		this.panFlag = panFlag;
	}
	public String getCinFlag() {
		return cinFlag;
	}
	public void setCinFlag(String cinFlag) {
		this.cinFlag = cinFlag;
	}
	public String getSchemeFlag() {
		return schemeFlag;
	}
	public void setSchemeFlag(String schemeFlag) {
		this.schemeFlag = schemeFlag;
	}
	public String getActivityFlag() {
		return activityFlag;
	}
	public void setActivityFlag(String activityFlag) {
		this.activityFlag = activityFlag;
	}
	public String getProjFlag() {
		return projFlag;
	}
	public void setProjFlag(String projFlag) {
		this.projFlag = projFlag;
	}
	public String getSectorFlag() {
		return sectorFlag;
	}
	public void setSectorFlag(String sectorFlag) {
		this.sectorFlag = sectorFlag;
	}
	public String getLocationFlag() {
		return locationFlag;
	}
	public void setLocationFlag(String locationFlag) {
		this.locationFlag = locationFlag;
	}
	public String getDescpFlag() {
		return descpFlag;
	}
	public void setDescpFlag(String descpFlag) {
		this.descpFlag = descpFlag;
	}
	public String getSusobjFlag() {
		return susobjFlag;
	}
	public void setSusobjFlag(String susobjFlag) {
		this.susobjFlag = susobjFlag;
	}
	public String getStakeEngFlag() {
		return stakeEngFlag;
	}
	public void setStakeEngFlag(String stakeEngFlag) {
		this.stakeEngFlag = stakeEngFlag;
	}
	public String getReportReqFlag() {
		return reportReqFlag;
	}
	public void setReportReqFlag(String reportReqFlag) {
		this.reportReqFlag = reportReqFlag;
	}
	public String getTimelineFlag() {
		return timelineFlag;
	}
	public void setTimelineFlag(String timelineFlag) {
		this.timelineFlag = timelineFlag;
	}
	public String getBudgetFlag() {
		return budgetFlag;
	}
	public void setBudgetFlag(String budgetFlag) {
		this.budgetFlag = budgetFlag;
	}
	public String getEIAcommFlag() {
		return EIAcommFlag;
	}
	public void setEIAcommFlag(String eIAcommFlag) {
		EIAcommFlag = eIAcommFlag;
	}
	public String getLegalverFlag() {
		return legalverFlag;
	}
	public void setLegalverFlag(String legalverFlag) {
		this.legalverFlag = legalverFlag;
	}
	public String getFinancialHealthFlag() {
		return financialHealthFlag;
	}
	public void setFinancialHealthFlag(String financialHealthFlag) {
		this.financialHealthFlag = financialHealthFlag;
	}
	public String getEsgCompFlag() {
		return esgCompFlag;
	}
	public void setEsgCompFlag(String esgCompFlag) {
		this.esgCompFlag = esgCompFlag;
	}
	public String getVulnerabilityFlag() {
		return vulnerabilityFlag;
	}
	public void setVulnerabilityFlag(String vulnerabilityFlag) {
		this.vulnerabilityFlag = vulnerabilityFlag;
	}
	public String getCarbonintFlag() {
		return carbonintFlag;
	}
	public void setCarbonintFlag(String carbonintFlag) {
		this.carbonintFlag = carbonintFlag;
	}
	public String getSealevelFlag() {
		return sealevelFlag;
	}
	public void setSealevelFlag(String sealevelFlag) {
		this.sealevelFlag = sealevelFlag;
	}
	public String getAssestriskFlag() {
		return assestriskFlag;
	}
	public void setAssestriskFlag(String assestriskFlag) {
		this.assestriskFlag = assestriskFlag;
	}
	public String getSupplychainFlag() {
		return supplychainFlag;
	}
	public void setSupplychainFlag(String supplychainFlag) {
		this.supplychainFlag = supplychainFlag;
	}
	public String getShiftingFlag() {
		return shiftingFlag;
	}
	public void setShiftingFlag(String shiftingFlag) {
		this.shiftingFlag = shiftingFlag;
	}
	public String getBusinessFlag() {
		return businessFlag;
	}
	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}
	public String getClimateFlag() {
		return climateFlag;
	}
	public void setClimateFlag(String climateFlag) {
		this.climateFlag = climateFlag;
	}
	public String getBorrowermissionFlag() {
		return borrowermissionFlag;
	}
	public void setBorrowermissionFlag(String borrowermissionFlag) {
		this.borrowermissionFlag = borrowermissionFlag;
	}
	public String getEIAFileFlag() {
		return EIAFileFlag;
	}
	public void setEIAFileFlag(String eIAFileFlag) {
		EIAFileFlag = eIAFileFlag;
	}
	public String getLegalFileFlag() {
		return legalFileFlag;
	}
	public void setLegalFileFlag(String legalFileFlag) {
		this.legalFileFlag = legalFileFlag;
	}
	public String getFinancialFileFlag() {
		return financialFileFlag;
	}
	public void setFinancialFileFlag(String financialFileFlag) {
		this.financialFileFlag = financialFileFlag;
	}
	public String getESGFileFlag() {
		return ESGFileFlag;
	}
	public void setESGFileFlag(String eSGFileFlag) {
		ESGFileFlag = eSGFileFlag;
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
	public String getPlantLocationsComment() {
		return plantLocationsComment;
		}
	public void setPlantLocationsComment(String plantLocationsComment) {
		this.plantLocationsComment = plantLocationsComment; }

}
