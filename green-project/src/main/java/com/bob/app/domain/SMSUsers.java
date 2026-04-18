package com.bob.app.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SMS_USER")
public class SMSUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Column(name = "DOMAIN_ID",  nullable = false)
	private String domainId;
	
	
	
	@Column(name = "USER_ROLE")
	private String userRole;
	
	@Column(name = "BRANCH_NAME")
	private String branchName;
	
	@Column(name = "DESIGNATION")
	private String designation;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "NODAL_BRANCH_ALPHA")
	private String nodalBranchAlpha;
	
	
	@Column(name = "MOBILE_NO")
	private Long mobileNo;
	
	
	@Column(name = "USER_ADDED_BY")
	private String userAddedBy;
	
	@Column(name = "USER_ADDED_BY_ROLE")
	private String userAddedByRole;
	
	@Column(name = "USER_ADDED_BY_BRANCH_NAME")
	private String userAddedByBranchName;
	
	@Column(name = "USER_ADDED_ON_DATE")
	private Timestamp userAddedOnDate;
	
	@Column(name = "SOLID")
	private String solid;
	
	@Column(name = "CURRENT_ORG")
	private String currentOrg;
	
	@Column(name = "RO_ALPHA")
	private String roAlpha;
	
	@Column(name = "ZO_ALPHA")
	private String zoAlpha;
	
	@Column(name = "RO_NAME")
	private String roName;
	
	@Column(name = "ZO_NAME")
	private String zoName;
	
	
	@Column(name = "VERIFY")
	private String verify;
	
	@Column(name = "DEL_FLAG")
	private String delFlag;
	
	@Column(name = "STATUS_FLAG")
	private String statusFlag;
	
	@Column(name = "DESIG")
	private String desig;
	
	
	@Column(name = "UPDATED_ON")
	private Timestamp updatedOn;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getNodalBranchAlpha() {
		return nodalBranchAlpha;
	}
	public void setNodalBranchAlpha(String nodalBranchAlpha) {
		this.nodalBranchAlpha = nodalBranchAlpha;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserAddedBy() {
		return userAddedBy;
	}
	public void setUserAddedBy(String userAddedBy) {
		this.userAddedBy = userAddedBy;
	}
	public String getUserAddedByRole() {
		return userAddedByRole;
	}
	public void setUserAddedByRole(String userAddedByRole) {
		this.userAddedByRole = userAddedByRole;
	}
	public String getUserAddedByBranchName() {
		return userAddedByBranchName;
	}
	public void setUserAddedByBranchName(String userAddedByBranchName) {
		this.userAddedByBranchName = userAddedByBranchName;
	}
	public Timestamp getUserAddedOnDate() {
		return userAddedOnDate;
	}
	public void setUserAddedOnDate(Timestamp userAddedOnDate) {
		this.userAddedOnDate = userAddedOnDate;
	}
	public String getSolid() {
		return solid;
	}
	public void setSolid(String solid) {
		this.solid = solid;
	}
	public String getCurrentOrg() {
		return currentOrg;
	}
	public void setCurrentOrg(String currentOrg) {
		this.currentOrg = currentOrg;
	}
	public String getRoAlpha() {
		return roAlpha;
	}
	public void setRoAlpha(String roAlpha) {
		this.roAlpha = roAlpha;
	}
	public String getZoAlpha() {
		return zoAlpha;
	}
	public void setZoAlpha(String zoAlpha) {
		this.zoAlpha = zoAlpha;
	}
	public String getRoName() {
		return roName;
	}
	public void setRoName(String roName) {
		this.roName = roName;
	}
	public String getZoName() {
		return zoName;
	}
	public void setZoName(String zoName) {
		this.zoName = zoName;
	}
	public String getVerify() {
		return verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}
	public SMSUsers() {
		super();
		
	}
	public SMSUsers(long id, String domainId, String userRole, String branchName, String designation, String userName,
			String department, String nodalBranchAlpha, Long mobileNo, String userAddedBy, String userAddedByRole,
			String userAddedByBranchName, Timestamp userAddedOnDate, String solid, String currentOrg, String roAlpha,
			String zoAlpha, String roName, String zoName, String verify, String delFlag, String statusFlag,
			String desig, Timestamp updatedOn) {
		super();
		this.id = id;
		this.domainId = domainId;
		this.userRole = userRole;
		this.branchName = branchName;
		this.designation = designation;
		this.userName = userName;
		this.department = department;
		this.nodalBranchAlpha = nodalBranchAlpha;
		this.mobileNo = mobileNo;
		this.userAddedBy = userAddedBy;
		this.userAddedByRole = userAddedByRole;
		this.userAddedByBranchName = userAddedByBranchName;
		this.userAddedOnDate = userAddedOnDate;
		this.solid = solid;
		this.currentOrg = currentOrg;
		this.roAlpha = roAlpha;
		this.zoAlpha = zoAlpha;
		this.roName = roName;
		this.zoName = zoName;
		this.verify = verify;
		this.delFlag = delFlag;
		this.statusFlag = statusFlag;
		this.desig = desig;
		this.updatedOn = updatedOn;
	}
	@Override
	public String toString() {
		return "SMSUsers [id=" + id + ", domainId=" + domainId + ", userRole=" + userRole + ", branchName=" + branchName
				+ ", designation=" + designation + ", userName=" + userName + ", department=" + department
				+ ", nodalBranchAlpha=" + nodalBranchAlpha + ", mobileNo=" + mobileNo + ", userAddedBy=" + userAddedBy
				+ ", userAddedByRole=" + userAddedByRole + ", userAddedByBranchName=" + userAddedByBranchName
				+ ", userAddedOnDate=" + userAddedOnDate + ", solid=" + solid + ", currentOrg=" + currentOrg
				+ ", roAlpha=" + roAlpha + ", zoAlpha=" + zoAlpha + ", roName=" + roName + ", zoName=" + zoName
				+ ", verify=" + verify + ", delFlag=" + delFlag + ", statusFlag=" + statusFlag + ", desig=" + desig
				+ ", updatedOn=" + updatedOn + "]";
	}
	
	
	
}
