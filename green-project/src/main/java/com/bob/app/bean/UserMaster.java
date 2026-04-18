package com.bob.app.bean;

import javax.persistence.*;

@Entity
@Table(name = "SA_USERMASTER")
public class UserMaster {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
	
	@Column(name="ECNUMBER", nullable = false)
    private String ecNumber;
	
	@Column(name="EMP_NAME", nullable = false)
    private String empName;
	
	
	@Column(name="REGION", nullable = false)
    private String region; 
	
	
	@Column(name="REGION_ALPHA", nullable = false)
    private String regionAlpha; 
	
	@Column(name="ZONE", nullable = false)
    private String zone;
	
	@Column(name="ZONE_ALPHA", nullable = false)
    private String zoneAlpha;
	
	
	@Column(name="BRANCH_SOLID", nullable = false)
    private String branchsolId;

	
	@Column(name="ROLE", nullable = false)
    private String role;
	
	
	@Column(name="CURRENT_ORG", nullable = false)
	private String  cur_org;
	
	
	@Column(name="CURRENT_ORG_TYPE", nullable = false)
	private String curr_org_type; 
	

	
	 @Column(nullable = false)
     private boolean deleted = false;
 	

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEcNumber() {
		return ecNumber;
	}
	

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}






	public String getBranchsolId() {
		return branchsolId;
	}

	public void setBranchsolId(String branchsolId) {
		this.branchsolId = branchsolId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setEcNumber(String ecNumber) {
		this.ecNumber = ecNumber;
	}

	public String getRegionAlpha() {
		return regionAlpha;
	}

	public void setRegionAlpha(String regionAlpha) {
		this.regionAlpha = regionAlpha;
	}

	public String getZoneAlpha() {
		return zoneAlpha;
	}

	public void setZoneAlpha(String zoneAlpha) {
		this.zoneAlpha = zoneAlpha;
	}


	
	 public String getCur_org() {
		return cur_org;
	}

	public void setCur_org(String cur_org) {
		this.cur_org = cur_org;
	}

	public String getCurr_org_type() {
		return curr_org_type;
	}

	public void setCurr_org_type(String curr_org_type) {
		this.curr_org_type = curr_org_type;
	}

//	@Override
//	    public String toString() {
//	        return "UserMaster{" +
//	                "id=" + id +
//	                ", ecNumber='" + ecNumber + '\'' +
//	                ", empName='" + empName + '\'' +
//	                ", region='" + region + '\'' +
//	                ", regionAlpha='" + regionAlpha + '\'' +
//	                 ", zone='" + zone + '\'' +
//	                  ", zoneAlpha='" + zoneAlpha + '\'' +
//	                   ", branch='" + branch + '\'' +
//	                    ", branchAlpha='" + branchAlpha + '\'' +
//	                     ", loginType='" + loginType + '\'' +
//	                     ", branchsolId='" + branchsolId + '\'' +
//	                       ", role='" + role + '\'' +
//	                      
//	               
//	                '}';
//	    }
}

