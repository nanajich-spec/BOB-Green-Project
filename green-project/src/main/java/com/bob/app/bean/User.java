package com.bob.app.bean;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="GP_GREEN_FIN")

public class User {

    
//    @GeneratedValue(strategy = GenerationType.AUTO)
   // private String id;
	
	@Id
    //@Column(name = "USER_ID")
    private String userid;
	private String Region;
	private String RegionAlpha;
	private String Zone;
	private String ZoneAlpha;
	private String CurrentOrg;
	private String CurrentOrgType;
	private String designation;
	private String removeVerifiedBy;
	private LocalDateTime RemovedOn;
	private String RemovedBy;
	private String RemoveReason;
    private String UserLevel;
	private String Removed;
	private LocalDateTime removeVerifiedOn;  
	private String verifyRemark;
	private String role;
    private String empname;       
    private String branchAlpha;
    private String branchSol;
    private String addedBy;
    private LocalDateTime addedOn;
    private String verifiedBy;
    private LocalDateTime verifiedOn;
    private String verified;
    private String enableUser;
    private String enableOn;
    private String enableBy;
    private String enableReason;
    private String enableVerifyBy;
    private LocalDateTime enableVerifyOn;
   


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getVerifyRemark() {
		return verifyRemark;
		
	}

	public void setVerifyRemark(String verifyRemark) {
			this.verifyRemark = verifyRemark;
		}
	

	public String getEmpname() {
		return empname;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getRegionAlpha() {
		return RegionAlpha;
	}

	public void setRegionAlpha(String regionAlpha) {
		RegionAlpha = regionAlpha;
	}

	public String getZone() {
		return Zone;
	}

	public void setZone(String zone) {
		Zone = zone;
	}

	public String getZoneAlpha() {
		return ZoneAlpha;
	}

	public void setZoneAlpha(String zoneAlpha) {
		ZoneAlpha = zoneAlpha;
	}

	public String getCurrentOrg() {
		return CurrentOrg;
	}

	public void setCurrentOrg(String currentOrg) {
		CurrentOrg = currentOrg;
	}

	public String getCurrentOrgType() {
		return CurrentOrgType;
	}

	public void setCurrentOrgType(String currentOrgType) {
		CurrentOrgType = currentOrgType;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBranchAlpha() {
		return branchAlpha;
	}

	public void setBranchAlpha(String branchAlpha) {
		this.branchAlpha = branchAlpha;
	}

	public String getBranchSol() {
		return branchSol;
	}

	public void setBranchSol(String branchSol) {
		this.branchSol = branchSol;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public LocalDateTime getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(LocalDateTime addedOn) {
		this.addedOn = addedOn;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public LocalDateTime getVerifiedOn() {
		return verifiedOn;
	}

	public void setVerifiedOn(LocalDateTime verifiedOn) {
		this.verifiedOn = verifiedOn;
	}

	
	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getEnableUser() {
		return enableUser;
	}

	public void setEnableUser(String enableUser) {
		this.enableUser = enableUser;
	}

	public String getRemoved() {
		return Removed;
	}

	public LocalDateTime getEnableVerifyOn() {
		return enableVerifyOn;
	}

	public void setEnableVerifyOn(LocalDateTime enableVerifyOn) {
		this.enableVerifyOn = enableVerifyOn;
	}

	public void setRemoved(String removed) {
		Removed = removed;
	}

	
	public LocalDateTime getRemovedOn() {
		return RemovedOn;
	}

	public void setRemovedOn(LocalDateTime removedOn) {
		RemovedOn = removedOn;
	}

	public String getRemovedBy() {
		return RemovedBy;
	}

	public void setRemovedBy(String removedBy) {
		RemovedBy = removedBy;
	}

	public String getRemoveReason() {
		return RemoveReason;
	}

	public void setRemoveReason(String removeReason) {
		RemoveReason = removeReason;
	}
	
	public String getRemoveVerifiedBy() {
		return removeVerifiedBy;
	}

	public void setRemoveVerifiedBy(String removeVerifiedBy) {
		this.removeVerifiedBy = removeVerifiedBy;
	}

	public LocalDateTime getRemoveVerifiedOn() {
		return removeVerifiedOn;
	}

	public void setRemoveVerifiedOn(LocalDateTime removeVerifiedOn) {
		this.removeVerifiedOn = removeVerifiedOn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEnableOn() {
		return enableOn;
	}

	public void setEnableOn(String enableOn) {
		this.enableOn = enableOn;
	}

	public String getEnableBy() {
		return enableBy;
	}

	public void setEnableBy(String enableBy) {
		this.enableBy = enableBy;
	}

	public String getEnableReason() {
		return enableReason;
	}

	public void setEnableReason(String enableReason) {
		this.enableReason = enableReason;
	}

	public String getEnableVerifyBy() {
		return enableVerifyBy;
	}

	public void setEnableVerifyBy(String enableVerifyBy) {
		this.enableVerifyBy = enableVerifyBy;
	}

	public String getUserLevel() {
		return UserLevel;
	}

	public void setUserLevel(String userLevel) {
		UserLevel = userLevel;
	}   
    
	
	
}

    

