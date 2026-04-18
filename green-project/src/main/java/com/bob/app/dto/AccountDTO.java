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



public class AccountDTO {
	
	private String phase;
	private String accountNumber;   
	private String borrowerName;
	private String borrowerFlag;
	private String branchName;
	private String branchFlag;
	private String panNumber; 
	private String panFlag;
	private String cinNumber;
	private String cinFlag;
	private String schemeCode;
	private String schemeFlag;
	private String activityCode;
	private String activityFlag;
	private String projName;
	private String projFlag;
	
	private String sector;
	private String sectorFlag;
	
	private String locationType;
	private String locationFlag;
	private String description;
	private String descpFlag;
	private String susobj;
	private String susobjFlag;
	private String stakeEng;
	private String stakeEngFlag;
	private String reportReq;
	private String reportReqFlag;
	private String timeline ;
	private String timelineFlag;
	private String budget;
	private String budgetFlag;
	private String EIAcomments;
	private String EIAcommFlag;
	private String legalVerificationComments;
	private String legalverFlag; 
	private String financialHealthComments;
	private String financialHealthFlag;
	private String esgCompliance;
	private String esgCompFlag;
	private String vulnerability;
	private String vulnerabilityFlag;
	private String carbonintensive;
	private String carbonintFlag;
	private String sealevel;
	private String sealevelFlag;
	private String assetrisk;
	private String assestriskFlag;
	private String supplychain;
	private String supplychainFlag;
	private String shifting;
	private String shiftingFlag;
	private String business;
	private String businessFlag;
	private String climate;
	private String climateFlag;
	private String borroweremission;
	private String borrowermissionFlag;
	private String AccStatus;
	private String AccStatusFlag;
	private String CheckerStatus;
	private String CheckerStatusFlag;
	private String ReturnReason;
	private String RejectReasonFlag;
	private String AdminStatus;
	private String AdminStatusFlag;
	private String AdminReject;
	private String AdminRejectFlag;
	private String Status;
	private String MakerUserId;
	private String Pincode;
	private String Latitude;
	private String Longitude;
	private String OthersAdd;
	private String PincodeFlag;
	private String LatitudeFlag;
	private String LongitudeFlag;
	private String OthersAddFlag;
	private String segment;
	private String segmentFlag;
	
	private String plantLocations;
		private String plantLocationsFlag;
		
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
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
	
	private String EIAFileFlag;
	private String legalFileFlag;
	private String financialFileFlag;
	private String ESGFileFlag;
	
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
	private String EIAFileName;
	private String legalVerificationFileName;
	private String FinancialFileName;
	private String ESGFileName;
	
		
		public String getMakerUserId() {
		return MakerUserId;
	}
	public void setMakerUserId(String makerUserId) {
		MakerUserId = makerUserId;
	}
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
	
	
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	
	
	public String getSegmentFlag() {
		return segmentFlag;
	}
	public void setSegmentFlag(String segmentFlag) {
		this.segmentFlag = segmentFlag;
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
	
	
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getLocationFlag() {
		return locationFlag;
	}
	public void setLocationFlag(String locationFlag) {
		this.locationFlag = locationFlag;
	}
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
	public String getVulnerability() {
		return vulnerability;
	}
	public void setVulnerability(String vulnerability) {
		this.vulnerability = vulnerability;
	}
	
	
	
	public String getVulnerabilityFlag() {
		return vulnerabilityFlag;
	}
	public void setVulnerabilityFlag(String vulnerabilityFlag) {
		this.vulnerabilityFlag = vulnerabilityFlag;
	}
	public String getCarbonintensive() {
		return carbonintensive;
	}
	public void setCarbonintensive(String carbonintensive) {
		this.carbonintensive = carbonintensive;
	}
	
	
	
	public String getCarbonintFlag() {
		return carbonintFlag;
	}
	public void setCarbonintFlag(String carbonintFlag) {
		this.carbonintFlag = carbonintFlag;
	}
	public String getSealevel() {
		return sealevel;
	}
	public void setSealevel(String sealevel) {
		this.sealevel = sealevel;
	}
	
	
	
	public String getSealevelFlag() {
		return sealevelFlag;
	}
	public void setSealevelFlag(String sealevelFlag) {
		this.sealevelFlag = sealevelFlag;
	}
	public String getAssetrisk() {
		return assetrisk;
	}
	public void setAssetrisk(String assetrisk) {
		this.assetrisk = assetrisk;
	}
	
	
	public String getAssestriskFlag() {
		return assestriskFlag;
	}
	public void setAssestriskFlag(String assestriskFlag) {
		this.assestriskFlag = assestriskFlag;
	}
	public String getSupplychain() {
		return supplychain;
	}
	public void setSupplychain(String supplychain) {
		this.supplychain = supplychain;
	}
	
	
	public String getSupplychainFlag() {
		return supplychainFlag;
	}
	public void setSupplychainFlag(String supplychainFlag) {
		this.supplychainFlag = supplychainFlag;
	}
	public String getShifting() {
		return shifting;
	}
	public void setShifting(String shifting) {
		this.shifting = shifting;
	}
	
	
	
	public String getShiftingFlag() {
		return shiftingFlag;
	}
	public void setShiftingFlag(String shiftingFlag) {
		this.shiftingFlag = shiftingFlag;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	
	
	
	public String getBusinessFlag() {
		return businessFlag;
	}
	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	
	
	public String getClimateFlag() {
		return climateFlag;
	}
	public void setClimateFlag(String climateFlag) {
		this.climateFlag = climateFlag;
	}
	public String getBorroweremission() {
		return borroweremission;
	}
	public void setBorroweremission(String borroweremission) {
		this.borroweremission = borroweremission;
	}
	
	
	public String getBorrowermissionFlag() {
		return borrowermissionFlag;
	}
	public void setBorrowermissionFlag(String borrowermissionFlag) {
		this.borrowermissionFlag = borrowermissionFlag;
	}
	public String getAccStatus() {
		return AccStatus;
	}
	public void setAccStatus(String accStatus) {
		AccStatus = accStatus;
	}
	
	
	public String getAccStatusFlag() {
		return AccStatusFlag;
	}
	public void setAccStatusFlag(String accStatusFlag) {
		AccStatusFlag = accStatusFlag;
	}
	public String getCheckerStatus() {
		return CheckerStatus;
	}
	public void setCheckerStatus(String checkerStatus) {
		CheckerStatus = checkerStatus;
	}
	
	
	public String getCheckerStatusFlag() {
		return CheckerStatusFlag;
	}
	public void setCheckerStatusFlag(String checkerStatusFlag) {
		CheckerStatusFlag = checkerStatusFlag;
	}

	
	public String getReturnReason() {
		return ReturnReason;
	}
	public void setReturnReason(String returnReason) {
		ReturnReason = returnReason;
	}
	public String getRejectReasonFlag() {
		return RejectReasonFlag;
	}
	public void setRejectReasonFlag(String rejectReasonFlag) {
		RejectReasonFlag = rejectReasonFlag;
	}
	public String getAdminStatus() {
		return AdminStatus;
	}
	public void setAdminStatus(String adminStatus) {
		AdminStatus = adminStatus;
	}
	
	
	public String getAdminStatusFlag() {
		return AdminStatusFlag;
	}
	public void setAdminStatusFlag(String adminStatusFlag) {
		AdminStatusFlag = adminStatusFlag;
	}
	public String getAdminReject() {
		return AdminReject;
	}
	public void setAdminReject(String adminReject) {
		AdminReject = adminReject;
	}
	
	
	public String getAdminRejectFlag() {
		return AdminRejectFlag;
	}
	public void setAdminRejectFlag(String adminRejectFlag) {
		AdminRejectFlag = adminRejectFlag;
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
	public String getPincode() {
		return Pincode;
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
	public String getOthersAdd() {
		return OthersAdd;
	}
	public void setOthersAdd(String othersAdd) {
		OthersAdd = othersAdd;
	}
	public String getPincodeFlag() {
		return PincodeFlag;
	}
	public void setPincodeFlag(String pincodeFlag) {
		PincodeFlag = pincodeFlag;
	}
	public String getLatitudeFlag() {
		return LatitudeFlag;
	}
	public void setLatitudeFlag(String latitudeFlag) {
		LatitudeFlag = latitudeFlag;
	}
	public String getLongitudeFlag() {
		return LongitudeFlag;
	}
	public void setLongitudeFlag(String longitudeFlag) {
		LongitudeFlag = longitudeFlag;
	}
	public String getOthersAddFlag() {
		return OthersAddFlag;
	}
	public void setOthersAddFlag(String othersAddFlag) {
		OthersAddFlag = othersAddFlag;
	}
	
	
	 
	
}