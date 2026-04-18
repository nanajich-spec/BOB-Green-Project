package com.bob.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="GP_Green_Loan_Dtls")

public class LoanDetails {
	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "ID")
    private Long id;  
	
	@Column(name = "BUSINESS_DATE")
	private String BusinessDate;

	@Column(name = "UPLOAD_DATE")
	private String UploadDate;

	@Column(name = "ACCOUNT_OPENED_DATE")
	private String AccountOpenedDate;

	@Column(name = "ACCOUNT_NUMBER")
	private String AccountNumber;


	@Column(name = "RECORD_TYPE")
	private String RecordType;

	
	
	
	@Column(name = "ACCT_CLS_DATE")
	private String AccountClsDate;

	@Column(name = "ACCT_NAME")
	private String AccountName;
	
    @Column(name = "CUST_ID")
	private String CustId;
    
    @Column(name = "SOL_ID")
	private String SolID;
    
    @Column(name = "ZONE")
	private String zone;
    
    @Column(name = "PAN")
	private String Pan;
    
    @Column(name = "CIN")
	private String cin;
    
    @Column(name = "REGION")
	private String Region;
    
    @Column(name = "SOL_DESC")
	private String SolDesc;
    
    @Column(name = "SCHM_TYPE")
	private String SchemeType;
    
//    @Column(name = "SCHM_DESC")
//	private String SchemeDesc;
    
//    @Column(name = "FORACID")
//    private String foracid;
    
    @Column(name = "SCHM_CODE")
	private String SchemeCode;
    
    @Column(name = "SCHEME_NAME")
	private String SchemeName;
    
    @Column(name = "ACTIVITY_CODE")
	private String ActivityCode;
    
    @Column(name = "ACTIVITY_GROUP")
	private String ActivityGroup;
    

    @Column(name = "ACCOUNT_SEGMENT")
	private String AccountSegment;
    
    @Column(name = "SANCT_LIM")
	private String SantionLimit;
    
    @Column(name = "LIM_SANCT_DATE")
	private String SantionLimitDate;
    
    @Column(name = "OUTSTANDING_AMOUNT")
	private String OutstandingAmount;
    
 
	@Column(name = "DISB_DATE")
	private String DateOfAmountDisbursement;
    
//    @Column(name = "AMOUNT_SANCTIONED")
//	private String AmountSanctioned;
    
    @Column(name = "DISB_AMT")
	private String AmountDisbursed;
	
    @Column(name = "PREPAID_AMOUNT")
	private String prepaidAmount;

    @Column(name = "PREPAID_DATE")
	private String prepaidDate;
	
    @Column(name = "MATURITY")
	private String Maturity;
	
    @Column(name = "REFERENCE_RATE")
	private String ReferenceRate;

//    @Column(name = "DATE_OF_TRANSFER")
//	private String DateOfTransfer;
	
    @Column(name = "INSTALMENT_START_DATE")
	private String InstalmentStartDate;
	
	   @Column(name = "INSTALMENT_FREQUENCY")
	private String InstalmentFrequency;
	
    @Column(name = "INSTALMENT_AMOUNT")
	private String InstalmentAmount;

    @Column(name = "UNDRAWN_LIMIT_AMOUNT")
	private String UndrawnLimitAmount;
	
//    @Column(name = "BENCHMARK")
//	private String Benchmark;
	
	  @Column(name = "PREFERENTIAL_ROI_CUST")
	private String PreferentialROICust; 
	  
	   @Column(name = "CREDIT_SPREAD")
	private String CreditSpread; 
	
	   @Column(name = "PREFERENTIAL_ROI_ID")
	private String PreferentialROIID;
	
    @Column(name = "FINAL_ROI")
	private String FinalROI;
	
	   @Column(name = "EXTERNAL_RATING")
	private String ExternalRating; 
	   
    @Column(name = "INTERNAL_RATING")
	private String InternalRating;
    @Column(name = "AGGREGATE_DISBURSEMENT_AMOUNT")
  	private String AggregateDisbursementAmount;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBusinessDate() {
		return BusinessDate;
	}
	public void setBusinessDate(String businessDate) {
		BusinessDate = businessDate;
	}
	public String getUploadDate() {
		return UploadDate;
	}
	public void setUploadDate(String uploadDate) {
		UploadDate = uploadDate;
	}
	public String getAccountOpenedDate() {
		return AccountOpenedDate;
	}
	public void setAccountOpenedDate(String accountOpenedDate) {
		AccountOpenedDate = accountOpenedDate;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getRecordType() {
		return RecordType;
	}
	public void setRecordType(String recordType) {
		RecordType = recordType;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	
	public String getAccountClsDate() {
		return AccountClsDate;
	}
	public void setAccountClsDate(String accountClsDate) {
		AccountClsDate = accountClsDate;
	}
	public String getCustId() {
		return CustId;
	}
	public void setCustId(String custId) {
		CustId = custId;
	}
	public String getSolID() {
		return SolID;
	}
	public void setSolID(String solID) {
		SolID = solID;
	}
//	public String getZone() {
//		return Zone;
//	}
//	public void setZone(String zone) {
//		Zone = zone;
//	}
	public String getPan() {
		return Pan;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public void setPan(String pan) {
		Pan = pan;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getSolDesc() {
		return SolDesc;
	}
	public void setSolDesc(String solDesc) {
		SolDesc = solDesc;
	}
	public String getSchemeType() {
		return SchemeType;
	}
	public void setSchemeType(String schemeType) {
		SchemeType = schemeType;
	}
//	public String getSchemeDesc() {
//		return SchemeDesc;
//	}
//	public void setSchemeDesc(String schemeDesc) {
//		SchemeDesc = schemeDesc;
//	}


//	public String getForacid() {
//	    return foracid;
//	}
//
//	public void setForacid(String foracid) {
//	    this.foracid = foracid;
//	}

	public String getSchemeCode() {
		return SchemeCode;
	}
	public void setSchemeCode(String schemeCode) {
		SchemeCode = schemeCode;
	}
	public String getSchemeName() {
		return SchemeName;
	}
	public void setSchemeName(String schemeName) {
		SchemeName = schemeName;
	}
	public String getActivityCode() {
		return ActivityCode;
	}
	public void setActivityCode(String activityCode) {
		ActivityCode = activityCode;
	}
	public String getActivityGroup() {
		return ActivityGroup;
	}
	public void setActivityGroup(String activityGroup) {
		ActivityGroup = activityGroup;
	}
	public String getAccountSegment() {
		return AccountSegment;
	}
	public void setAccountSegment(String accountSegment) {
		AccountSegment = accountSegment;
	}
	public String getSantionLimit() {
		return SantionLimit;
	}
	public void setSantionLimit(String santionLimit) {
		SantionLimit = santionLimit;
	}
	public String getSantionLimitDate() {
		return SantionLimitDate;
	}
	public void setSantionLimitDate(String santionLimitDate) {
		SantionLimitDate = santionLimitDate;
	}
//	public String getOutstandingBalance() {
//		return OutstandingBalance;
//	}
//	public void setOutstandingBalance(String outstandingBalance) {
//		OutstandingBalance = outstandingBalance;
//	}
	
	   public String getOutstandingAmount() {
			return OutstandingAmount;
		}
		public void setOutstandingAmount(String outstandingAmount) {
			OutstandingAmount = outstandingAmount;
		}
	public String getDateOfAmountDisbursement() {
		return DateOfAmountDisbursement;
	}
	public void setDateOfAmountDisbursement(String dateOfAmountDisbursement) {
		DateOfAmountDisbursement = dateOfAmountDisbursement;
	}
//	public String getAmountSanctioned() {
//		return AmountSanctioned;
//	}
//	public void setAmountSanctioned(String amountSanctioned) {
//		AmountSanctioned = amountSanctioned;
//	}
	public String getAmountDisbursed() {
		return AmountDisbursed;
	}
	public void setAmountDisbursed(String amountDisbursed) {
		AmountDisbursed = amountDisbursed;
	}
	public String getPrepaidAmount() {
		return prepaidAmount;
	}
	public void setPrepaidAmount(String prepaidAmount) {
		this.prepaidAmount = prepaidAmount;
	}
	public String getPrepaidDate() {
		return prepaidDate;
	}
	public void setPrepaidDate(String prepaidDate) {
		this.prepaidDate = prepaidDate;
	}
	public String getMaturity() {
		return Maturity;
	}
	public void setMaturity(String maturity) {
		Maturity = maturity;
	}
	public String getReferenceRate() {
		return ReferenceRate;
	}
	public void setReferenceRate(String referenceRate) {
		ReferenceRate = referenceRate;
	}
//	public String getDateOfTransfer() {
//		return DateOfTransfer;
//	}
//	public void setDateOfTransfer(String dateOfTransfer) {
//		DateOfTransfer = dateOfTransfer;
//	}
	public String getInstalmentStartDate() {
		return InstalmentStartDate;
	}
	public void setInstalmentStartDate(String instalmentStartDate) {
		InstalmentStartDate = instalmentStartDate;
	}
	public String getInstalmentFrequency() {
		return InstalmentFrequency;
	}
	public void setInstalmentFrequency(String instalmentFrequency) {
		InstalmentFrequency = instalmentFrequency;
	}
	public String getInstalmentAmount() {
		return InstalmentAmount;
	}
	public void setInstalmentAmount(String instalmentAmount) {
		InstalmentAmount = instalmentAmount;
	}
	public String getUndrawnLimitAmount() {
		return UndrawnLimitAmount;
	}
	public void setUndrawnLimitAmount(String undrawnLimitAmount) {
		UndrawnLimitAmount = undrawnLimitAmount;
	}
//	public String getBenchmark() {
//		return Benchmark;
//	}
//	public void setBenchmark(String benchmark) {
//		Benchmark = benchmark;
//	}
	public String getPreferentialROICust() {
		return PreferentialROICust;
	}
	public void setPreferentialROICust(String preferentialROICust) {
		PreferentialROICust = preferentialROICust;
	}
	public String getCreditSpread() {
		return CreditSpread;
	}
	public void setCreditSpread(String creditSpread) {
		CreditSpread = creditSpread;
	}
	public String getPreferentialROIID() {
		return PreferentialROIID;
	}
	public void setPreferentialROIID(String preferentialROIID) {
		PreferentialROIID = preferentialROIID;
	}
	public String getFinalROI() {
		return FinalROI;
	}
	public void setFinalROI(String finalROI) {
		FinalROI = finalROI;
	}
	public String getExternalRating() {
		return ExternalRating;
	}
	public void setExternalRating(String externalRating) {
		ExternalRating = externalRating;
	}
	public String getInternalRating() {
		return InternalRating;
	}
	public void setInternalRating(String internalRating) {
		InternalRating = internalRating;
	} 
	
	public String getAggregateDisbursementAmount() {
		return AggregateDisbursementAmount;
	}
	public void setAggregateDisbursementAmount(String aggregateDisbursementAmount) {
		AggregateDisbursementAmount = aggregateDisbursementAmount;
	}
	@Override
	public String toString() {
		return "LoanDetails [id=" + id + ", AccountName=" + AccountName + ", CustId=" + CustId + ", SolID=" + SolID
				+ ", zone=" + zone + ", Pan=" + Pan + ", cin=" + cin + ", Region=" + Region + ", SolDesc=" + SolDesc
				+ ", SchemeType=" + SchemeType + ",  SchemeCode="
				+ SchemeCode + ", SchemeName=" + SchemeName + ", ActivityCode=" + ActivityCode + ", ActivityGroup="
				+ ActivityGroup + ", AccountSegment=" + AccountSegment + ", SantionLimit=" + SantionLimit
				+ ", SantionLimitDate=" + SantionLimitDate + ", OutstandingBalance=" + OutstandingAmount
				+ ", DateOfAmountDisbursement=" + DateOfAmountDisbursement + ", AmountDisbursed=" + AmountDisbursed
				+ ", prepaidAmount=" + prepaidAmount + ", prepaidDate=" + prepaidDate + ", Maturity=" + Maturity
				+ ", ReferenceRate=" + ReferenceRate + ", InstalmentStartDate=" + InstalmentStartDate
				+ ", InstalmentFrequency=" + InstalmentFrequency + ", InstalmentAmount=" + InstalmentAmount
				+ ", UndrawnLimitAmount=" + UndrawnLimitAmount + ", PreferentialROICust=" + PreferentialROICust
				+ ", CreditSpread=" + CreditSpread + ", PreferentialROIID=" + PreferentialROIID + ", FinalROI="
				+ FinalROI + ", ExternalRating=" + ExternalRating + ", InternalRating=" + InternalRating
				+ ", AggregateDisbursementAmount=" + AggregateDisbursementAmount + ", getId()=" + getId()
				+ ", getAccountName()=" + getAccountName() + ", getCustId()=" + getCustId() + ", getSolID()="
				+ getSolID() + ", getPan()=" + getPan() + ", getZone()=" + getZone() + ", getCin()=" + getCin()
				+ ", getRegion()=" + getRegion() + ", getSolDesc()=" + getSolDesc() + ", getSchemeType()="
				+ getSchemeType()  
				+ ", getSchemeCode()=" + getSchemeCode() + ", getSchemeName()=" + getSchemeName()
				+ ", getActivityCode()=" + getActivityCode() + ", getActivityGroup()=" + getActivityGroup()
				+ ", getAccountSegment()=" + getAccountSegment() + ", getSantionLimit()=" + getSantionLimit()
				+ ", getSantionLimitDate()=" + getSantionLimitDate() + ", getOutstandingBalance()="
				+ getOutstandingAmount() + ", getDateOfAmountDisbursement()=" + getDateOfAmountDisbursement()
				+ ", getAmountDisbursed()=" + getAmountDisbursed() + ", getPrepaidAmount()=" + getPrepaidAmount()
				+ ", getPrepaidDate()=" + getPrepaidDate() + ", getMaturity()=" + getMaturity()
				+ ", getReferenceRate()=" + getReferenceRate() + ", getInstalmentStartDate()="
				+ getInstalmentStartDate() + ", getInstalmentFrequency()=" + getInstalmentFrequency()
				+ ", getInstalmentAmount()=" + getInstalmentAmount() + ", getUndrawnLimitAmount()="
				+ getUndrawnLimitAmount() + ", getPreferentialROICust()=" + getPreferentialROICust()
				+ ", getCreditSpread()=" + getCreditSpread() + ", getPreferentialROIID()=" + getPreferentialROIID()
				+ ", getFinalROI()=" + getFinalROI() + ", getExternalRating()=" + getExternalRating()
				+ ", getInternalRating()=" + getInternalRating() + ", getAggregateDisbursementAmount()="
				+ getAggregateDisbursementAmount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	} 
	
	
}

