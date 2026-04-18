package com.bob.app.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.time.LocalDate;

@Entity
@Table(name="GP_Green_Deposit_Details")
public class DepositDetails {

    @Id
    @Column(name="ACCOUNTNO")
    private String accountno;

    @Column(name="ZONE")
    private String zone;

    @Column(name="REGION")
    private String region;

    @Column(name="SOLID")
    private String solid;

    @Column(name="BRANCHCODE")
    private String branchcode;

    @Column(name="CUSTID")
    private String custid;

    @Column(name="ACCOUNTNAME")
    private String accountname;

    @Column(name="ACCOUNTOPENINGDATE")
    private LocalDate accountopeningdate;

    @Column(name="SCHEMECODE")
    private String schemecode;

    @Column(name="SCHEMEDESCRIPTION")
    private String schemedescription;

    @Column(name="NET_INT_RATE")
    private Double netIntRate;

    @Column(name="TOTALPERIODINMONTHS")
    private Double totalperiodinmonths;

    @Column(name="TOTALPERIODINDAYS")
    private Double totalperiodindays;

    @Column(name="FACEVALUE")
    private Double facevalue;

    @Column(name="CURRENTBALANCE")
    private Double currentbalance;

    @Column(name="MATURITYAMOUNT")
    private Double maturityamount;

    @Column(name="MATURITYDATE")
    private LocalDate maturitydate;
    
    @Column(name="BUSINESS_DATE")
    private LocalDate businessDate;
    
    @Column(name="UPLOAD_DATE")
    private LocalDate uploadDate;

//	public String getAccountno() {
//		return accountno;
//	}
//
//	public void setAccountno(String accountno) {
//		this.accountno = accountno;
//	}
//
//	public String getZone() {
//		return zone;
//	}
//
//	public void setZone(String zone) {
//		this.zone = zone;
//	}
//
//	public String getRegion() {
//		return region;
//	}
//
//	public void setRegion(String region) {
//		this.region = region;
//	}
//
//	public String getSolid() {
//		return solid;
//	}
//
//	public void setSolid(String solid) {
//		this.solid = solid;
//	}
//
//	public String getBranchcode() {
//		return branchcode;
//	}
//
//	public void setBranchcode(String branchcode) {
//		this.branchcode = branchcode;
//	}
//
//	public String getCustid() {
//		return custid;
//	}
//
//	public void setCustid(String custid) {
//		this.custid = custid;
//	}
//
//	public String getAccountname() {
//		return accountname;
//	}
//
//	public void setAccountname(String accountname) {
//		this.accountname = accountname;
//	}
//
//	public LocalDate getAccountopeningdate() {
//		return accountopeningdate;
//	}
//
//	public void setAccountopeningdate(LocalDate accountopeningdate) {
//		this.accountopeningdate = accountopeningdate;
//	}
//
//	public String getSchemecode() {
//		return schemecode;
//	}
//
//	public void setSchemecode(String schemecode) {
//		this.schemecode = schemecode;
//	}
//
//	public String getSchemedescription() {
//		return schemedescription;
//	}
//
//	public void setSchemedescription(String schemedescription) {
//		this.schemedescription = schemedescription;
//	}
//
//	public Double getNetIntRate() {
//		return netIntRate;
//	}
//
//	public void setNetIntRate(Double netIntRate) {
//		this.netIntRate = netIntRate;
//	}
//
//	public Double getTotalperiodinmonths() {
//		return totalperiodinmonths;
//	}
//
//	public void setTotalperiodinmonths(Double totalperiodinmonths) {
//		this.totalperiodinmonths = totalperiodinmonths;
//	}
//
//	public Double getTotalperiodindays() {
//		return totalperiodindays;
//	}
//
//	public void setTotalperiodindays(Double totalperiodindays) {
//		this.totalperiodindays = totalperiodindays;
//	}
//
//	public Double getFacevalue() {
//		return facevalue;
//	}
//
//	public void setFacevalue(Double facevalue) {
//		this.facevalue = facevalue;
//	}
//
//	public Double getCurrentbalance() {
//		return currentbalance;
//	}
//
//	public void setCurrentbalance(Double currentbalance) {
//		this.currentbalance = currentbalance;
//	}
//
//	public Double getMaturityamount() {
//		return maturityamount;
//	}
//
//	public void setMaturityamount(Double maturityamount) {
//		this.maturityamount = maturityamount;
//	}
//
//	public LocalDate getMaturitydate() {
//		return maturitydate;
//	}
//
//	public void setMaturitydate(LocalDate maturitydate) {
//		this.maturitydate = maturitydate;
//	}

//    // --- Getters and Setters ---
    public String getAccountno() { return accountno; }
    public void setAccountno(String accountno) { this.accountno = accountno; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getSolid() { return solid; }
    public void setSolid(String solid) { this.solid = solid; }

    public String getBranchcode() { return branchcode; }
    public void setBranchcode(String branchcode) { this.branchcode = branchcode; }

    public String getCustid() { return custid; }
    public void setCustid(String custid) { this.custid = custid; }

    public String getAccountname() { return accountname; }
    public void setAccountname(String accountname) { this.accountname = accountname; }

    public LocalDate getAccountopeningdate() { return accountopeningdate; }
    public void setAccountopeningdate(LocalDate accountopeningdate) { this.accountopeningdate = accountopeningdate; }

    public String getSchemecode() { return schemecode; }
    public void setSchemecode(String schemecode) { this.schemecode = schemecode; }

    public String getSchemedescription() { return schemedescription; }
    public void setSchemedescription(String schemedescription) { this.schemedescription = schemedescription; }

    public Double getNetIntRate() { return netIntRate; }
    public void setNetIntRate(Double netIntRate) { this.netIntRate = netIntRate; }

    public Double getTotalperiodinmonths() { return totalperiodinmonths; }
    public void setTotalperiodinmonths(Double totalperiodinmonths) { this.totalperiodinmonths = totalperiodinmonths; }

    public Double getTotalperiodindays() { return totalperiodindays; }
    public void setTotalperiodindays(Double totalperiodindays) { this.totalperiodindays = totalperiodindays; }

    public Double getFacevalue() { return facevalue; }
    public void setFacevalue(Double facevalue) { this.facevalue = facevalue; }

    public Double getCurrentbalance() { return currentbalance; }
    public void setCurrentbalance(Double currentbalance) { this.currentbalance = currentbalance; }

    public Double getMaturityamount() { return maturityamount; }
    public void setMaturityamount(Double maturityamount) { this.maturityamount = maturityamount; }

    public LocalDate getMaturitydate() { return maturitydate; }
    public void setMaturitydate(LocalDate maturitydate) { this.maturitydate = maturitydate; }
    
    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

}
