package com.bob.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NCGTCDATA_MASTER")
public class NcgtcMaster {

    @Id
    
    @Column(name = "REF_NO")
    private String refNo;
    
    @Column(name = "ZO_SOLID")
	private String zoSolid;
    
    @Column(name = "RO_SOLID")
	private String roSolid;
    
    @Column(name = "REGION_NAME")
    private String regionName;
    
    @Column(name = "REGION_ALPHA")
    private String regionAlpha;

    @Column(name = "ZONE_NAME")
    private String zoneName;
    
    
    @Column(name = "ZONE_ALPHA")
    private String zoneAlpha;
    
    public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionAlpha() {
		return regionAlpha;
	}

	public void setRegionAlpha(String regionAlpha) {
		this.regionAlpha = regionAlpha;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneAlpha() {
		return zoneAlpha;
	}

	public void setZoneAlpha(String zoneAlpha) {
		this.zoneAlpha = zoneAlpha;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getSolId() {
		return solId;
	}

	public void setSolId(String solId) {
		this.solId = solId;
	}

	public String getBrAlpha() {
		return brAlpha;
	}

	public void setBrAlpha(String brAlpha) {
		this.brAlpha = brAlpha;
	}

	public String getLoanAcctnum() {
		return loanAcctnum;
	}

	public void setLoanAcctnum(String loanAcctnum) {
		this.loanAcctnum = loanAcctnum;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getSchmcode() {
		return schmcode;
	}

	public void setSchmcode(String schmcode) {
		this.schmcode = schmcode;
	}

	public String getCoborrowerName() {
		return coborrowerName;
	}

	public void setCoborrowerName(String coborrowerName) {
		this.coborrowerName = coborrowerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmailBorrower() {
		return emailBorrower;
	}

	public void setEmailBorrower(String emailBorrower) {
		this.emailBorrower = emailBorrower;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getAdhaarNum() {
		return adhaarNum;
	}

	public void setAdhaarNum(String adhaarNum) {
		this.adhaarNum = adhaarNum;
	}

	public String getPanNum() {
		return panNum;
	}

	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	public String getDrivingLicenseNum() {
		return drivingLicenseNum;
	}

	public void setDrivingLicenseNum(String drivingLicenseNum) {
		this.drivingLicenseNum = drivingLicenseNum;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCasteCatg() {
		return casteCatg;
	}

	public void setCasteCatg(String casteCatg) {
		this.casteCatg = casteCatg;
	}

	public String getPresentAdd1() {
		return presentAdd1;
	}

	public void setPresentAdd1(String presentAdd1) {
		this.presentAdd1 = presentAdd1;
	}

	public String getPresentCity() {
		return presentCity;
	}

	public void setPresentCity(String presentCity) {
		this.presentCity = presentCity;
	}

	public String getPresentDistrict() {
		return presentDistrict;
	}

	public void setPresentDistrict(String presentDistrict) {
		this.presentDistrict = presentDistrict;
	}

	public String getPresentState() {
		return presentState;
	}

	public void setPresentState(String presentState) {
		this.presentState = presentState;
	}

	public String getPresentPin() {
		return presentPin;
	}

	public void setPresentPin(String presentPin) {
		this.presentPin = presentPin;
	}

	public String getPermanentAddr2() {
		return permanentAddr2;
	}

	public void setPermanentAddr2(String permanentAddr2) {
		this.permanentAddr2 = permanentAddr2;
	}

	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	public String getPermanentDistrict() {
		return permanentDistrict;
	}

	public void setPermanentDistrict(String permanentDistrict) {
		this.permanentDistrict = permanentDistrict;
	}

	public String getPermanentState() {
		return permanentState;
	}

	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}

	public String getPermanentPin() {
		return permanentPin;
	}

	public void setPermanentPin(String permanentPin) {
		this.permanentPin = permanentPin;
	}

	public String getSanctAmt() {
		return sanctAmt;
	}

	public void setSanctAmt(String sanctAmt) {
		this.sanctAmt = sanctAmt;
	}

	public String getSanctDate() {
		return sanctDate;
	}

	public void setSanctDate(String sanctDate) {
		this.sanctDate = sanctDate;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public String getFgName() {
		return fgName;
	}

	public void setFgName(String fgName) {
		this.fgName = fgName;
	}

	public String getAgefgName() {
		return agefgName;
	}

	public void setAgefgName(String agefgName) {
		this.agefgName = agefgName;
	}

	public String getBorrowerReltnfg() {
		return borrowerReltnfg;
	}

	public void setBorrowerReltnfg(String borrowerReltnfg) {
		this.borrowerReltnfg = borrowerReltnfg;
	}

	public String getFgOccupation() {
		return fgOccupation;
	}

	public void setFgOccupation(String fgOccupation) {
		this.fgOccupation = fgOccupation;
	}

	public String getFgAddr() {
		return fgAddr;
	}

	public void setFgAddr(String fgAddr) {
		this.fgAddr = fgAddr;
	}

	public String getFgCity() {
		return fgCity;
	}

	public void setFgCity(String fgCity) {
		this.fgCity = fgCity;
	}

	public String getFgDistrict() {
		return fgDistrict;
	}

	public void setFgDistrict(String fgDistrict) {
		this.fgDistrict = fgDistrict;
	}

	public String getFgState() {
		return fgState;
	}

	public void setFgState(String fgState) {
		this.fgState = fgState;
	}

	public String getFgPin() {
		return fgPin;
	}

	public void setFgPin(String fgPin) {
		this.fgPin = fgPin;
	}

	public String getFgAnnualincome() {
		return fgAnnualincome;
	}

	public void setFgAnnualincome(String fgAnnualincome) {
		this.fgAnnualincome = fgAnnualincome;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getAbroadStudycourse() {
		return abroadStudycourse;
	}

	public void setAbroadStudycourse(String abroadStudycourse) {
		this.abroadStudycourse = abroadStudycourse;
	}

	public String getCourseCatg() {
		return courseCatg;
	}

	public void setCourseCatg(String courseCatg) {
		this.courseCatg = courseCatg;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAcctExpdate() {
		return acctExpdate;
	}

	public void setAcctExpdate(String acctExpdate) {
		this.acctExpdate = acctExpdate;
	}

	public String getLoanAmtFirstDisb() {
		return loanAmtFirstDisb;
	}

	public void setLoanAmtFirstDisb(String loanAmtFirstDisb) {
		this.loanAmtFirstDisb = loanAmtFirstDisb;
	}

	public String getFirstDisbdate() {
		return firstDisbdate;
	}

	public void setFirstDisbdate(String firstDisbdate) {
		this.firstDisbdate = firstDisbdate;
	}

	public String getOutstandingBal() {
		return outstandingBal;
	}

	public void setOutstandingBal(String outstandingBal) {
		this.outstandingBal = outstandingBal;
	}

	public String getLoanMoratEnddate() {
		return loanMoratEnddate;
	}

	public void setLoanMoratEnddate(String loanMoratEnddate) {
		this.loanMoratEnddate = loanMoratEnddate;
	}

	public String getNpaStatus() {
		return npaStatus;
	}

	public void setNpaStatus(String npaStatus) {
		this.npaStatus = npaStatus;
	}

	public String getNpaDate() {
		return npaDate;
	}

	public void setNpaDate(String npaDate) {
		this.npaDate = npaDate;
	}

	public String getAcctClsflg() {
		return acctClsflg;
	}

	public void setAcctClsflg(String acctClsflg) {
		this.acctClsflg = acctClsflg;
	}

	public String getAcctClsdate() {
		return acctClsdate;
	}

	public void setAcctClsdate(String acctClsdate) {
		this.acctClsdate = acctClsdate;
	}

	public String getBalasonNpadate() {
		return balasonNpadate;
	}

	public void setBalasonNpadate(String balasonNpadate) {
		this.balasonNpadate = balasonNpadate;
	}

	public String getRecovertAmt() {
		return recovertAmt;
	}

	public void setRecovertAmt(String recovertAmt) {
		this.recovertAmt = recovertAmt;
	}

	public String getRecoveryDate() {
		return recoveryDate;
	}

	public void setRecoveryDate(String recoveryDate) {
		this.recoveryDate = recoveryDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getFreq() {
		return freq;
	}

	public void setFreq(String freq) {
		this.freq = freq;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(String uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getEnteredOn() {
		return enteredOn;
	}

	public void setEnteredOn(String enteredOn) {
		this.enteredOn = enteredOn;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public String getVerifiedOn() {
		return verifiedOn;
	}

	public void setVerifiedOn(String verifiedOn) {
		this.verifiedOn = verifiedOn;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	@Column(name = "SOLID")
    private String solId;

    @Column(name = "BR_ALPHA")
    private String brAlpha;
    
    @Column(name = "LOAN_ACCT_NUMBER")
    private String loanAcctnum;
    
    @Column(name = "BORROWER_NAME")
    private String borrowerName;
    
    @Column(name = "SCHM_CODE")
    private String schmcode;
    
    
    @Column(name = "COBORROWERS_NAME")
    private String coborrowerName;
    
    @Column(name = "GENDER")
    private String gender;
    
    @Column(name = "DATEOF_BIRTH")
    private String dob;
    
    @Column(name = "EMAIL_BORROWER")
    private String emailBorrower;
    
    @Column(name = "MOBILE")
    private String mobileNum;
    
    @Column(name = "ADHAAR_NUM")
    private String adhaarNum;

    @Column(name = "PAN_NUM")
    private String panNum;
    
    @Column(name = "VOTER_ID")
    private String voterId;
    
    @Column(name = "PASSPORT_NUM")
    private String passportNum;
    
    @Column(name = "DRIVING_LICENSE_NO")
    private String drivingLicenseNum;
    
    @Column(name = "RELIGION")
    private String religion;
    
    @Column(name = "CASTE_CATG")
    private String casteCatg;
  
   
    @Column(name = "PRESENT_ADDR1")
    private String presentAdd1;
    
    @Column(name = "PRESENT_CITY")
    private String presentCity;
    
    @Column(name = "PRESENT_DISTRICT")
    private String presentDistrict;
    
    @Column(name = "PRESENT_STATE")
    private String presentState;
    
    @Column(name = "PRESENT_PIN")
    private String presentPin;
    
    @Column(name = "PERMANENT_ADDR2")
    private String permanentAddr2;
    
    @Column(name = "PERMANENT_CITY")
    private String permanentCity;
    
    @Column(name = "PERMANENT_DISTRICT")
    private String permanentDistrict;
    
    @Column(name = "PERMANENT_STATE")
    private String permanentState;
    
    @Column(name = "PERMANENT_PIN")
    private String permanentPin;
    
    @Column(name = "SANCT_AMT")
    private String sanctAmt;
        
    @Column(name = "SANCT_DATE")
    private String sanctDate;
    
    @Column(name = "TENURE")
    private String tenure;
    
    @Column(name = "FATHER_GUARDIAN_NAME")
    private String fgName;
    
    @Column(name = "AGE_FATHER_GUARDIAN")
    private String agefgName;
    
    @Column(name = "BORROWER_RELTN_FATHER_GUARDIAN")
    private String borrowerReltnfg;
    
    @Column(name = "FATHER_GUARDIAN_OCCUPATION")
    private String fgOccupation;
    
    @Column(name = "FATHER_GUARDIAN_ADDR")
    private String fgAddr;
    
    
    @Column(name = "FATHER_GUARDIAN_CITY")
    private String fgCity;
    
    @Column(name = "FATHER_GUARDIAN_DISTRICT")
    private String fgDistrict;
    
    @Column(name = "FATHER_GUARDIAN_STATE")
    private String fgState;
    
    @Column(name = "FATHER_GUARDIAN_PIN")
    private String fgPin;
    
    @Column(name = "FATHER_GUARDIAN_ANNUAL_INCOME")
    private String fgAnnualincome;
    
    @Column(name = "NAME_COURSE")
    private String courseName;
    
    @Column(name = "TYPE_COURSE")
    private String courseType;
    
    @Column(name = "ABROAD_STUDY_COURSE")
    private String abroadStudycourse;
    
    @Column(name = "COURSE_CATG")
    private String courseCatg;
    
    @Column(name = "IFSC_CODE")
    private String ifscCode;
    
    @Column(name = "CUST_ID")
    private String custId;
    
    @Column(name = "ACCT_EXPIRY_DATE")
    private String acctExpdate;
    
    @Column(name = "LOAN_AMT_FIRST_DISB")
    private String loanAmtFirstDisb;
    
    @Column(name = "FIRST_DISB_DATE")
    private String firstDisbdate;
    
    @Column(name = "OUTSTANDING_BAL")
    private String outstandingBal;
    
    @Column(name = "LOAN_MORATORIUM_END_DATE")
    private String loanMoratEnddate;
    
    @Column(name = "NPA_STATUS")
    private String npaStatus;
    
    @Column(name = "NPA_DATE")
    private String npaDate;
    
    @Column(name = "ACCT_CLS_FLG")
    private String acctClsflg;
    
    @Column(name = "ACCT_CLS_DATE")
    private String acctClsdate;
    
    @Column(name = "BAL_ASON_DATEOFNPA")
    private String balasonNpadate;
    
    @Column(name = "RECOVERY_AMT")
    private String recovertAmt;
    
    @Column(name = "DATE_OF_RECOVERY")
    private String recoveryDate;
    
    @Column(name = "YEAR")
    private String year;
    
    @Column(name = "Month")
    private String month;
    
    @Column(name = "QUARTER")
    private String quarter;
    
    @Column(name = "FREQ")
    private String freq;
    
    @Column(name = "REPORT_DATE")
    private String reportDate;
    
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "UPLOADED_ON")
    private String uploadedOn;
    
    @Column(name = "UPLOADED_BY")
    private String uploadedBy;
    
    @Column(name = "ENTERED_ON")
    private String enteredOn;
    
    @Column(name = "ENTERED_BY")
    private String enteredBy;
    
    @Column(name = "VERIFIED_ON")
    private String verifiedOn;
    
    @Column(name = "VERIFIED_BY")
    private String verifiedBy;
    
    @Column(name = "REMARKS")
    private String remarks;
    
    @Column(name = "DEL_FLG", nullable = false)
    private String delFlg = "N";
    
    
    
}