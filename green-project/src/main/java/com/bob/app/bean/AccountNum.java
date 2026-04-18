package com.bob.app.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="GP_GREEN_INFO")

public class AccountNum {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;  
	
//	private String accountNumber;   
//	private String borrowerName;
//	private String branchName;
//	private String panNumber; 
//	private String cinNumber;	
//	private String schemeCode;
//	private String activityCode;

	
	
	
	    @Column(name="ACCOUNT_NUMBER")
	    private String accountNumber;

	    @Column(name="BORROWER_NAME")
	    private String borrowerName;

	    @Column(name="BRANCH_NAME")
	    private String branchName;

	    @Column(name="PAN_NUMBER")
	    private String panNumber;

	    @Column(name="CIN_NUMBER")
	    private String cinNumber;

	    @Column(name="SCHEME_CODE")
	    private String schemeCode;

	    @Column(name="ACTIVITY_CODE")
	    private String activityCode;
	    
	    @Column(name="CUST_ID")
	    private String customerId;
	    
	    @Column(name="BUSINESS_DATE")
	    private String businessDate;
	    
	    @Column(name="SOL_ID")
	    private String solId;
	    
	   

		@Column(name="ACCOUNT_OPENED_DATE")
	    private String accountOpenedDate;
	    
	    @Column(name="BRIEF_DTLS")
	    private String briefDtls;

	    @Column(name="PROJ_NAME")
	    private String projName;
	    

	    @Column(name="SECTOR")
	    private String sector;

	    @Column(name="SECTOR_FLAG")
	    private String sectorFlag;

	    @Column(name="SECTORCOMMENT")
	    private String sectorcomment;

	    @Column(name="PLANT_LOCATIONS")
	    private String plantLocations;

	    @Column(name="PLANT_LOCATIONS_FLAG")
	    private String plantLocationsFlag;

	    @Column(name="LOCATION_COMMENT")
	    private String locationComment;

	    @Column(name="SEGMENT")
	    private String segment;

	    @Column(name="PINCODE")
	    private String Pincode;

	    @Column(name="PINCODE_FLAG")
	    private String PincodeFlag;

	    @Column(name="PINCODE_COMMENT")
	    private String PincodeComment;

	    @Column(name="LATITUDE")
	    private String Latitude;

	    @Column(name="LATITUDE_FLAG")
	    private String LatitudeFlag;

	    @Column(name="LATITUDE_COMMENT")
	    private String LatitudeComment;

	

		@Column(name="LONGITUDE")
	    private String Longitude;

	    @Column(name="LONGITUDE_FLAG")
	    private String LongitudeFlag;

	    @Column(name="LONGITUDE_COMMENT")
	    private String LongitudeComment;

	    @Column(name="OTHERS_ADD")
	    private String OthersAdd;

	    @Column(name="OTHERS_ADD_FLAG")
	    private String OthersAddFlag;

	    @Column(name="OTHERS_ADD_COMMENT")
	    private String OthersAddComment;

	    @Column(name="DESCRIPTION")
	    private String description;

	    @Column(name="DESCP_FLAG")
	    private String descpFlag;

	    @Column(name="DESCP_COMMENT")
	    private String descpComment;

	    @Column(name="SUSOBJ")
	    private String susobj;

	    @Column(name="SUSOBJ_FLAG")
	    private String susobjFlag;

	    @Column(name="SUSOBJ_COMMENT")
	    private String susobjComment;

	    @Column(name="STAKE_ENG")
	    private String stakeEng;

	    @Column(name="STAKE_ENG_FLAG")
	    private String stakeEngFlag;

	    @Column(name="STAKE_ENG_COMMENT")
	    private String stakeEngComment;

	    @Column(name="REPORT_REQ")
	    private String reportReq;

	    @Column(name="REPORT_REQ_FLAG")
	    private String reportReqFlag;

	    @Column(name="REPORT_REQ_COMMENT")
	    private String reportReqComment;

	    @Column(name="TIMELINE")
	    private String timeline;

	    @Column(name="TIMELINE_FLAG")
	    private String timelineFlag;

	    @Column(name="TIMELINE_COMMENT")
	    private String timelineComment;

	    @Column(name="BUDGET")
	    private String budget;

	    @Column(name="BUDGET_FLAG")
	    private String budgetFlag;

	    @Column(name="BUDGET_COMMENT")
	    private String budgetComment;

	    @Column(name="EIACOMMENTS")
	    private String EIAcomments;

	    @Column(name="EIACOMM_FLAG")
	    private String EIAcommFlag;

	    @Column(name="EIACOMM_COMMENT")
	    private String EIAcommComment;

	    @Column(name="LEGAL_VERIFICATION_COMMENTS")
	    private String legalVerificationComments;

	    @Column(name="LEGALVER_FLAG")
	    private String legalverFlag;

	    @Column(name="LEGALVER_COMMENT")
	    private String legalverComment;

	    @Column(name="FINANCIAL_HEALTH_COMMENTS")
	    private String financialHealthComments;

	    @Column(name="FINANCIAL_HEALTH_FLAG")
	    private String financialHealthFlag;

	    @Column(name="FINANCIAL_HEALTH_CMNT")
	    private String financialHealthCmnt;

	    @Column(name="ESG_COMPLIANCE")
	    private String esgCompliance;

	    @Column(name="ESG_COMP_FLAG")
	    private String esgCompFlag;

	    @Column(name="ESG_COMP_COMMENT")
	    private String esgCompComment;

	    @Column(name="VULNERABILITY")
	    private String vulnerability;

	    @Column(name="VULNERABILITY_FLAG")
	    private String vulnerabilityFlag;

	    @Column(name="VULNERABILITY_COMMENT")
	    private String vulnerabilityComment;

	    @Column(name="CARBONINTENSIVE")
	    private String carbonintensive;

	    @Column(name="CARBONINT_FLAG")
	    private String carbonintFlag;

	    @Column(name="CARBONINT_COMMENT")
	    private String carbonintComment;

	    @Column(name="SEALEVEL")
	    private String sealevel;

	    @Column(name="SEALEVEL_FLAG")
	    private String sealevelFlag;

	    @Column(name="SEALEVEL_COMMENT")
	    private String sealevelComment;

	    @Column(name="ASSETRISK")
	    private String assetrisk;

	    @Column(name="ASSESTRISK_FLAG")
	    private String assestriskFlag;

	    @Column(name="ASSESTRISK_COMMENT")
	    private String assestriskComment;

	    @Column(name="SUPPLYCHAIN")
	    private String supplychain;

	    @Column(name="SUPPLYCHAIN_FLAG")
	    private String supplychainFlag;

	    @Column(name="SUPPLYCHAIN_COMMENT")
	    private String supplychainComment;

	    @Column(name="SHIFTING")
	    private String shifting;

	    @Column(name="SHIFTING_FLAG")
	    private String shiftingFlag;

	    @Column(name="SHIFTING_COMMENT")
	    private String shiftingComment;

	    @Column(name="BUSINESS")
	    private String business;

	    @Column(name="BUSINESS_FLAG")
	    private String businessFlag;

	    @Column(name="BUSINESS_COMMENT")
	    private String businessComment;

	    @Column(name="CLIMATE")
	    private String climate;

	    @Column(name="CLIMATE_FLAG")
	    private String climateFlag;

	    @Column(name="CLIMATE_COMMENT")
	    private String climateComment;

	    @Column(name="BORROWEREMISSION")
	    private String borroweremission;

	    @Column(name="BORROWERMISSION_FLAG")
	    private String borrowermissionFlag;

	    @Column(name="BORROWERMISSION_COMMENT")
	    private String borrowermissionComment;

	    @Column(name="STATUS")
	    private String status;

	    @Column(name="DECISION")
	    private String decision;

	    @Column(name="RETURN_REASON")
	    private String returnReason;

	    @Lob
	    @Column(name="EIAFILE")
	    private byte[] EIAfile;

	    @Lob
	    @Column(name="LEGAL_VERIFICATION_FILE")
	    private byte[] legalVerificationFile;

	    @Lob
	    @Column(name="FINANCIAL_HEALTH_FILE")
	    private byte[] financialHealthFile;

	    @Lob
	    @Column(name="ESGFILE")
	    private byte[] ESGfile;

	    @Column(name="EIAFILE_NAME")
	    private String EIAFileName;

	    @Column(name="LEGAL_VERIFICATION_FILE_NAME")
	    private String legalVerificationFileName;

	    @Column(name="FINANCIAL_FILE_NAME")
	    private String FinancialFileName;

	    @Column(name="ESGFILE_NAME")
	    private String ESGFileName;

	    @Column(name="MAKER_USER_ID")
	    private String MakerUserId;

	    @Column(name="CHECKER_ID")
	    private String CheckerId;

	    @Column(name="CURRENT_DATE")
	    private Date currentDate;

	    @Column(name="CMNT_BY")
	    private String cmntBy;

	    @Column(name="ANNGHGCOMMENT")
	    private String AnnGHGComment;

	    @Column(name="CO2COMMENT")
	    private String Co2Comment;

	    @Column(name="CAP_PLANT_COMMENT")
	    private String CapPlantComment;

	    @Column(name="INFO_STAKE_COMNT")
	    private String InfoStakeComnt;

	    @Column(name="ANN_ENERGY_CMNT")
	    private String AnnEnergyCmnt;

	    @Column(name="ENERGY_PRE_POSTCMNT")
	    private String EnergyPrePostcmnt;

	    @Column(name="CLEAN_VEHICLE_CMNT")
	    private String CleanVehicleCmnt;

	    @Column(name="EST_REDUCTION_CMNT")
	    private String EstReductionCmnt;

	    @Column(name="POLL_CONT_CMNT")
	    private String pollContCmnt;

	    @Column(name="WATER_USE_CMNT")
	    private String WaterUseCmnt;

	    @Column(name="ANN_LEVEL_CMNT")
	    private String AnnLevelCmnt;

	    @Column(name="WATER_POLLU_CMNT")
	    private String waterPolluCmnt;

	    @Column(name="REDUCTION_WATERCMNT")
	    private String ReductionWatercmnt;

	    @Column(name="ANNUAL_WATER_CMNT")
	    private String AnnualWaterCmnt;

	 
	    @Column(name="ANNUAL_AMOUNT_CMNT")
	    private String AnnualAmountCmnt;

	    @Column(name="AREA_LAND_CMNT")
	    private String AreaLandCmnt;

	    @Column(name="AREA_SUSTAIN_CMNT")
	    private String AreaSustainCmnt;

	    @Column(name="SUSTAINABLE_COMNT")
	    private String SustainableComnt;

	    @Column(name="RESTORELAND_CMNT")
	    private String RestorelandCmnt;

	    @Column(name="RESTOREHABIT_CMNT")
	    private String RestorehabitCmnt;

	    @Column(name="PROTECT_AREA_COMNT")
	    private String protectAreaComnt;

	    @Column(name="NATURAL_LAND_CMNT")
	    private String NaturalLandCmnt;

	    @Column(name="NUMBER_TRGT_CMNT")
	    private String NumberTrgtCmnt;
	    
	    @Column(name="ACC_STATUS_COMMENT")
	    private String accStatusComment;
	    
	    @Column(name="CURRENT_STATUS")
	    private String currentStatus;

	    @Column(name="PROJ_COMMENT")
	    private String projComment;

	    @Column(name="PROJ_FLAG")
	    private String projFlag;

	    @Column(name="RECORD_TYPE")
	    private String recordType;
	    
	    

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
		
	    public String getCustomerId() {
				return customerId;
			}

			public void setCustomerId(String customerId) {
				this.customerId = customerId;
			}
			
			
			
			 public String getBusinessDate() {
					return businessDate;
				}

				public void setBusinessDate(String businessDate) {
					this.businessDate = businessDate;
				}

				public String getSolId() {
					return solId;
				}

				public void setSolId(String solId) {
					this.solId = solId;
				}

				public String getAccountOpenedDate() {
					return accountOpenedDate;
				}

				public void setAccountOpenedDate(String accountOpenedDate) {
					this.accountOpenedDate = accountOpenedDate;
				}
		public String getActivityCode() {
			return activityCode;
		}

		public void setActivityCode(String activityCode) {
			this.activityCode = activityCode;
		}

		public String getBriefDtls() {
			return briefDtls;
		}

		public void setBriefDtls(String briefDtls) {
			this.briefDtls = briefDtls;
		}

		public String getProjName() {
			return projName;
		}

		public void setProjName(String projName) {
			this.projName = projName;
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

		public String getSectorcomment() {
			return sectorcomment;
		}

		public void setSectorcomment(String sectorcomment) {
			this.sectorcomment = sectorcomment;
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

		public String getLocationComment() {
			return locationComment;
		}

		public void setLocationComment(String locationComment) {
			this.locationComment = locationComment;
		}

		public String getSegment() {
			return segment;
		}

		public void setSegment(String segment) {
			this.segment = segment;
		}

		public String getPincode() {
			return Pincode;
		}

		public void setPincode(String pincode) {
			Pincode = pincode;
		}

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

		public String getLatitude() {
			return Latitude;
		}

		public void setLatitude(String latitude) {
			Latitude = latitude;
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

		public String getLongitude() {
			return Longitude;
		}

		public void setLongitude(String longitude) {
			Longitude = longitude;
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

		public String getOthersAdd() {
			return OthersAdd;
		}

		public void setOthersAdd(String othersAdd) {
			OthersAdd = othersAdd;
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

		public String getDescpComment() {
			return descpComment;
		}

		public void setDescpComment(String descpComment) {
			this.descpComment = descpComment;
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

		public String getSusobjComment() {
			return susobjComment;
		}

		public void setSusobjComment(String susobjComment) {
			this.susobjComment = susobjComment;
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

		public String getStakeEngComment() {
			return stakeEngComment;
		}

		public void setStakeEngComment(String stakeEngComment) {
			this.stakeEngComment = stakeEngComment;
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

		public String getReportReqComment() {
			return reportReqComment;
		}

		public void setReportReqComment(String reportReqComment) {
			this.reportReqComment = reportReqComment;
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

		public String getTimelineComment() {
			return timelineComment;
		}

		public void setTimelineComment(String timelineComment) {
			this.timelineComment = timelineComment;
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

		public String getBudgetComment() {
			return budgetComment;
		}

		public void setBudgetComment(String budgetComment) {
			this.budgetComment = budgetComment;
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

		public String getEIAcommComment() {
			return EIAcommComment;
		}

		public void setEIAcommComment(String eIAcommComment) {
			EIAcommComment = eIAcommComment;
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

		public String getLegalverComment() {
			return legalverComment;
		}

		public void setLegalverComment(String legalverComment) {
			this.legalverComment = legalverComment;
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

		public String getFinancialHealthCmnt() {
			return financialHealthCmnt;
		}

		public void setFinancialHealthCmnt(String financialHealthCmnt) {
			this.financialHealthCmnt = financialHealthCmnt;
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

		public String getEsgCompComment() {
			return esgCompComment;
		}

		public void setEsgCompComment(String esgCompComment) {
			this.esgCompComment = esgCompComment;
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

		public String getVulnerabilityComment() {
			return vulnerabilityComment;
		}

		public void setVulnerabilityComment(String vulnerabilityComment) {
			this.vulnerabilityComment = vulnerabilityComment;
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

		public String getCarbonintComment() {
			return carbonintComment;
		}

		public void setCarbonintComment(String carbonintComment) {
			this.carbonintComment = carbonintComment;
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

		public String getSealevelComment() {
			return sealevelComment;
		}

		public void setSealevelComment(String sealevelComment) {
			this.sealevelComment = sealevelComment;
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

		public String getAssestriskComment() {
			return assestriskComment;
		}

		public void setAssestriskComment(String assestriskComment) {
			this.assestriskComment = assestriskComment;
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

		public String getSupplychainComment() {
			return supplychainComment;
		}

		public void setSupplychainComment(String supplychainComment) {
			this.supplychainComment = supplychainComment;
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

		public String getShiftingComment() {
			return shiftingComment;
		}

		public void setShiftingComment(String shiftingComment) {
			this.shiftingComment = shiftingComment;
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

		public String getBusinessComment() {
			return businessComment;
		}

		public void setBusinessComment(String businessComment) {
			this.businessComment = businessComment;
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

		public String getClimateComment() {
			return climateComment;
		}

		public void setClimateComment(String climateComment) {
			this.climateComment = climateComment;
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

		public String getBorrowermissionComment() {
			return borrowermissionComment;
		}

		public void setBorrowermissionComment(String borrowermissionComment) {
			this.borrowermissionComment = borrowermissionComment;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
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

		public String getMakerUserId() {
			return MakerUserId;
		}

		public void setMakerUserId(String makerUserId) {
			MakerUserId = makerUserId;
		}

		public String getCheckerId() {
			return CheckerId;
		}

		public void setCheckerId(String checkerId) {
			CheckerId = checkerId;
		}

		public Date getCurrentDate() {
			return currentDate;
		}

		public void setCurrentDate(Date currentDate) {
			this.currentDate = currentDate;
		}

		public String getCmntBy() {
			return cmntBy;
		}

		public void setCmntBy(String cmntBy) {
			this.cmntBy = cmntBy;
		}

		public String getAnnGHGComment() {
			return AnnGHGComment;
		}

		public void setAnnGHGComment(String annGHGComment) {
			AnnGHGComment = annGHGComment;
		}

		public String getCo2Comment() {
			return Co2Comment;
		}

		public void setCo2Comment(String co2Comment) {
			Co2Comment = co2Comment;
		}

		public String getCapPlantComment() {
			return CapPlantComment;
		}

		public void setCapPlantComment(String capPlantComment) {
			CapPlantComment = capPlantComment;
		}

		public String getInfoStakeComnt() {
			return InfoStakeComnt;
		}

		public void setInfoStakeComnt(String infoStakeComnt) {
			InfoStakeComnt = infoStakeComnt;
		}

		public String getAnnEnergyCmnt() {
			return AnnEnergyCmnt;
		}

		public void setAnnEnergyCmnt(String annEnergyCmnt) {
			AnnEnergyCmnt = annEnergyCmnt;
		}

		public String getEnergyPrePostcmnt() {
			return EnergyPrePostcmnt;
		}

		public void setEnergyPrePostcmnt(String energyPrePostcmnt) {
			EnergyPrePostcmnt = energyPrePostcmnt;
		}

		public String getCleanVehicleCmnt() {
			return CleanVehicleCmnt;
		}

		public void setCleanVehicleCmnt(String cleanVehicleCmnt) {
			CleanVehicleCmnt = cleanVehicleCmnt;
		}

		public String getEstReductionCmnt() {
			return EstReductionCmnt;
		}

		public void setEstReductionCmnt(String estReductionCmnt) {
			EstReductionCmnt = estReductionCmnt;
		}

		public String getPollContCmnt() {
			return pollContCmnt;
		}

		public void setPollContCmnt(String pollContCmnt) {
			this.pollContCmnt = pollContCmnt;
		}

		public String getWaterUseCmnt() {
			return WaterUseCmnt;
		}

		public void setWaterUseCmnt(String waterUseCmnt) {
			WaterUseCmnt = waterUseCmnt;
		}

		public String getAnnLevelCmnt() {
			return AnnLevelCmnt;
		}

		public void setAnnLevelCmnt(String annLevelCmnt) {
			AnnLevelCmnt = annLevelCmnt;
		}

		public String getWaterPolluCmnt() {
			return waterPolluCmnt;
		}

		public void setWaterPolluCmnt(String waterPolluCmnt) {
			this.waterPolluCmnt = waterPolluCmnt;
		}

		public String getReductionWatercmnt() {
			return ReductionWatercmnt;
		}

		public void setReductionWatercmnt(String reductionWatercmnt) {
			ReductionWatercmnt = reductionWatercmnt;
		}

		public String getAnnualWaterCmnt() {
			return AnnualWaterCmnt;
		}

		public void setAnnualWaterCmnt(String annualWaterCmnt) {
			AnnualWaterCmnt = annualWaterCmnt;
		}

		public String getAnnualAmountCmnt() {
			return AnnualAmountCmnt;
		}

		public void setAnnualAmountCmnt(String annualAmountCmnt) {
			AnnualAmountCmnt = annualAmountCmnt;
		}

		public String getAreaLandCmnt() {
			return AreaLandCmnt;
		}

		public void setAreaLandCmnt(String areaLandCmnt) {
			AreaLandCmnt = areaLandCmnt;
		}

		public String getAreaSustainCmnt() {
			return AreaSustainCmnt;
		}

		public void setAreaSustainCmnt(String areaSustainCmnt) {
			AreaSustainCmnt = areaSustainCmnt;
		}

		public String getSustainableComnt() {
			return SustainableComnt;
		}

		public void setSustainableComnt(String sustainableComnt) {
			SustainableComnt = sustainableComnt;
		}

		public String getRestorelandCmnt() {
			return RestorelandCmnt;
		}

		public void setRestorelandCmnt(String restorelandCmnt) {
			RestorelandCmnt = restorelandCmnt;
		}

		public String getRestorehabitCmnt() {
			return RestorehabitCmnt;
		}

		public void setRestorehabitCmnt(String restorehabitCmnt) {
			RestorehabitCmnt = restorehabitCmnt;
		}

		public String getProtectAreaComnt() {
			return protectAreaComnt;
		}

		public void setProtectAreaComnt(String protectAreaComnt) {
			this.protectAreaComnt = protectAreaComnt;
		}

		public String getNaturalLandCmnt() {
			return NaturalLandCmnt;
		}

		public void setNaturalLandCmnt(String naturalLandCmnt) {
			NaturalLandCmnt = naturalLandCmnt;
		}

		public String getNumberTrgtCmnt() {
			return NumberTrgtCmnt;
		}

		public void setNumberTrgtCmnt(String numberTrgtCmnt) {
			NumberTrgtCmnt = numberTrgtCmnt;
		}

		public String getAccStatusComment() {
			return accStatusComment;
		}

		public void setAccStatusComment(String accStatusComment) {
			this.accStatusComment = accStatusComment;
		}

		public String getCurrentStatus() {
			return currentStatus;
		}

		public void setCurrentStatus(String currentStatus) {
			this.currentStatus = currentStatus;
		}

		public String getProjComment() {
			return projComment;
		}

		public void setProjComment(String projComment) {
			this.projComment = projComment;
		}

		public String getProjFlag() {
			return projFlag;
		}

		public void setProjFlag(String projFlag) {
			this.projFlag = projFlag;
		}

		public String getRecordType() {
			return recordType;
		}

		public void setRecordType(String recordType) {
			this.recordType = recordType;
		}


		

	
	
	 
}