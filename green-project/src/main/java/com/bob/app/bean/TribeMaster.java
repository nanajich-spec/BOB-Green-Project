package com.bob.app.bean;

import javax.persistence.*;

@Entity
@Table(name = "TB_TRIBE_MASTER")
public class TribeMaster {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
	
	@Column(name="STATE", nullable = false)
    private String state;
	
	@Column(name="SCHOOL", nullable = false)
    private String school;
	
	@Column(name="SCHOOL_ID", nullable = false)
    private String schoolId;
	
	@Column(name="PHASE", nullable = false)
    private String phase;
	
	@Column(name="PHASE_BUDGET", nullable = false)
    private Long phaseBudget;
	
	
	
	@Column(name="PHASE_BUDGET_DISTRIBUTED")
    private Long isPhaseCompleted;
	
	
	@Column(name="PSU", nullable = false)
    private String psu;
	
	@Column(name="ESCROW_ACCOUNT", nullable = false)
    private String escrowAccount;
	
	@Column(name="ESCROW_IFSC", nullable = false)
    private String escrowIFSC;
	
	@Column(name="CONTRACTOR_NAME", nullable = false)
    private String contractor;
	
	@Column(name="CONTRACTOR_ACCOUNT", nullable = false)
    private String contractorAccount;
	
	@Column(name="CONTRACTOR_IFSC", nullable = false)
    private String contractorIFSC;

	@Column(name="CONTRACTOR_BANK", nullable = false)
    private String contractorBANK;
	


	public Long getId() {
		return id;
	}

	public String getState() {
		return state;
	}

	public String getSchool() {
		return school;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public String getPsu() {
		return psu;
	}

	public String getEscrowAccount() {
		return escrowAccount;
	}

	public String getEscrowIFSC() {
		return escrowIFSC;
	}

	public String getContractor() {
		return contractor;
	}

	public String getContractorAccount() {
		return contractorAccount;
	}

	public String getContractorIFSC() {
		return contractorIFSC;
	}

	public String getContractorBANK() {
		return contractorBANK;
	}
	
	

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public void setPsu(String psu) {
		this.psu = psu;
	}

	public void setEscrowAccount(String escrowAccount) {
		this.escrowAccount = escrowAccount;
	}

	public void setEscrowIFSC(String escrowIFSC) {
		this.escrowIFSC = escrowIFSC;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public void setContractorAccount(String contractorAccount) {
		this.contractorAccount = contractorAccount;
	}

	public void setContractorIFSC(String contractorIFSC) {
		this.contractorIFSC = contractorIFSC;
	}

	public void setContractorBANK(String contractorBANK) {
		this.contractorBANK = contractorBANK;
	}

	public Long getPhaseBudget() {
		return phaseBudget;
	}

	public void setPhaseBudget(Long phaseBudget) {
		this.phaseBudget = phaseBudget;
	}

	public Long getIsPhaseCompleted() {
		return isPhaseCompleted;
	}

	public void setIsPhaseCompleted(Long isPhaseCompleted) {
		this.isPhaseCompleted = isPhaseCompleted;
	}


	
	
	
	
}