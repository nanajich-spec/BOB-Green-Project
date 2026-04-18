package com.bob.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Immutable
@Entity
@Table(name="ALL_SOL_MASTER")
public class ALL_SOL_MASTER {

	@Id
	@Column(name = "BR_ALPHA")
	private String brAlpha;
	
	@Column(name = "BRANCH_NAME")
	private String branchName;
	
	
	
	@Column(name = "BR_SOLID")
	private String brSolid;
	
	@Column(name = "ZO_NAME")
	private String zoName;
	
	@Column(name = "RO_NAME")
	private String roName;
	
	@Column(name = "ZO_ALPHA")
	private String zoAlpha;
	
	@Column(name = "ZO_SOLID")
	private String zoSolid;
	
	@Column(name = "RO_ALPHA")
	private String roAlpha;
	
	@Column(name = "RO_SOLID")
	private String roSolid;
	
	@Column(name = "IFSC")
	private String ifsc;
	

	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBrAlpha() {
		return brAlpha;
	}
	public void setBrAlpha(String brAlpha) {
		this.brAlpha = brAlpha;
	}
	public String getBrSolid() {
		return brSolid;
	}
	public void setBrSolid(String brSolid) {
		this.brSolid = brSolid;
	}
	public String getZoName() {
		return zoName;
	}
	public void setZoName(String zoName) {
		this.zoName = zoName;
	}
	public String getRoName() {
		return roName;
	}
	public void setRoName(String roName) {
		this.roName = roName;
	}
	public String getZoAlpha() {
		return zoAlpha;
	}
	public void setZoAlpha(String zoAlpha) {
		this.zoAlpha = zoAlpha;
	}
	public String getZoSolid() {
		return zoSolid;
	}
	public void setZoSolid(String zoSolid) {
		this.zoSolid = zoSolid;
	}
	public String getRoAlpha() {
		return roAlpha;
	}
	public void setRoAlpha(String roAlpha) {
		this.roAlpha = roAlpha;
	}
	public String getRoSolid() {
		return roSolid;
	}
	public void setRoSolid(String roSolid) {
		this.roSolid = roSolid;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public ALL_SOL_MASTER() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ALL_SOL_MASTER(String brAlpha, String branchName, String brSolid, String zoName, String roName,
			String zoAlpha, String zoSolid, String roAlpha, String roSolid, String ifsc) {
		super();
		this.brAlpha = brAlpha;
		this.branchName = branchName;
		this.brSolid = brSolid;
		this.zoName = zoName;
		this.roName = roName;
		this.zoAlpha = zoAlpha;
		this.zoSolid = zoSolid;
		this.roAlpha = roAlpha;
		this.roSolid = roSolid;
		this.ifsc = ifsc;
	}
	@Override
	public String toString() {
		return "ALL_SOL_MASTER [brAlpha=" + brAlpha + ", branchName=" + branchName + ", brSolid=" + brSolid
				+ ", zoName=" + zoName + ", roName=" + roName + ", zoAlpha=" + zoAlpha + ", zoSolid=" + zoSolid
				+ ", roAlpha=" + roAlpha + ", roSolid=" + roSolid + ", ifsc=" + ifsc + "]";
	}
	
	
	
}
