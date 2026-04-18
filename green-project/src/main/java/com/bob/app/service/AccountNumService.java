package com.bob.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.app.bean.AccountNum;
import com.bob.app.bean.CmntHistory;
import com.bob.app.bean.Student;
import com.bob.app.dao.jpa.AccountNumRepository;
import com.bob.app.dao.jpa.HistoryCmntRepository;
import com.bob.app.dao.jpa.StudentRegRepository;
import com.bob.app.dto.AccountDTO;
import com.bob.app.dto.CheckerDTO;
import com.bob.app.dto.CmntDTO;
import com.bob.app.dto.FlagDTO;
import com.bob.app.dto.HistoryCmntDTO;
import com.bob.app.dto.Phase1DTO;


@Service
public class AccountNumService {
	
	  @Autowired
	  private AccountNumRepository accountNumRepository;
	  
	  @Autowired
	  private HistoryCmntRepository historyCmntRepository;
	 

	    public AccountNum getLoanUserByAccountNumber(String accountNumber) {
	    	AccountNum accountNumb= accountNumRepository.findByaccountNumber(accountNumber);
	    	System.out.println("Fetching user with email: " + accountNumber);
	        return accountNumb;
	    }
	    
	    public Optional<AccountNum> getUserByAccountNumber(String accountNumber) {
	    	Optional<AccountNum> accountNumb= accountNumRepository.findByAccountNumber(accountNumber);
	    	System.out.println("Fetching user with email: " + accountNumber);
	        return accountNumb;
	    }
	    
	    public AccountNum getUserByAccountNum(String accountNumber) {
	    	AccountNum accountNumb= accountNumRepository.findByaccountNumber(accountNumber);
	    	System.out.println("Fetching user with email: " + accountNumber);
	        return accountNumb;
	        
	        
	    }
	    //                                 ----
	    
	   
///---------------
	        // ✅ New method: fetch all account numbers (for dropdown)
//	        public List<String> getAllAccountNumbers() {
//	            return accountNumRepository.findAllAccountNumbers();
//	        }
//
//	        // ✅ New method: fetch all accounts (full objects, e.g. accountNumber + borrowerName)
//	        public List<AccountNum> getAllAccounts() {
//	            return accountNumRepository.findAllAccounts();
//	        }

	 // ✅ New method: fetch account numbers filtered by solId and status
//	    public List<String> getAccountNumbersBySolIdAndStatus(String solId, String status) { 
//	        return accountNumRepository.findAccountNumbersBySolIdAndStatus(solId, status); 
//	    }

	    public List<String> getAccountNumbersBySolIdAndStatus(String solId, String status) { 
	    	return accountNumRepository.findAccountNumbersBySolIdAndStatus(solId, status); }
	      //---------------------------------------------------------//
	    
	    public AccountNum getUserByAccount(AccountDTO accountNumber) {
	        // Check if the account already exists
	        AccountNum existingAccount = accountNumRepository.findByaccountNumber(accountNumber.getAccountNumber());
	     
	        // If not found, create a new AccountNum instance
	        if (existingAccount == null) {
	            existingAccount = new AccountNum();
	        }
	     
	        // Set values based on the phase
	        switch (accountNumber.getPhase().toUpperCase()) {
	            case "A":
	                populatePhaseA(existingAccount, accountNumber);
	                break;
	            case "B":
	                populatePhaseB(existingAccount, accountNumber);
	                break;
	            case "C":
	                populatePhaseC(existingAccount, accountNumber);
	                break;
	            default:
	                throw new IllegalArgumentException("Not a valid TYPE!");
	        }
	     
	        // Save and return the updated or new record
	        return accountNumRepository.save(existingAccount);
	    }
	     
	    // Helper method to set Phase A values
	    private void populatePhaseA(AccountNum account, AccountDTO accountNumber) {
	    	account.setAccountNumber(accountNumber.getAccountNumber());
	        account.setBorrowerName(accountNumber.getBorrowerName());
	       // account.setBorrowerFlag(accountNumber.getBorrowerFlag());
	        account.setBranchName(accountNumber.getBranchName());
	     //   account.setBranchFlag(accountNumber.getBranchFlag());
	        account.setCinNumber(accountNumber.getCinNumber());
	     //   account.setCinFlag(accountNumber.getCinFlag());
	        account.setPanNumber(accountNumber.getPanNumber());
	      //  account.setPanFlag(accountNumber.getPanFlag());
	        account.setSchemeCode(accountNumber.getSchemeCode());
	     //   account.setSchemeFlag(accountNumber.getSchemeFlag());
	        account.setActivityCode(accountNumber.getActivityCode());
	      //  account.setActivityFlag(accountNumber.getActivityFlag());
	        account.setProjName(accountNumber.getProjName());
	     //   account.setProjFlag(accountNumber.getProjFlag());
	        account.setSector(accountNumber.getSector());
	        account.setSectorFlag(accountNumber.getSectorFlag());
	       // account.setLocationType(accountNumber.getLocationType());
	       // account.setLocationFlag(accountNumber.getLocationFlag());
	        
	        
	        account.setPlantLocations(accountNumber.getPlantLocations());
	        account.setPlantLocationsFlag(accountNumber.getPlantLocationsFlag());
	        
	        
	        account.setSegment(accountNumber.getSegment());
	        
	        
	        account.setDescription(accountNumber.getDescription());
	        account.setDescpFlag(accountNumber.getDescpFlag());
	        account.setSusobj(accountNumber.getSusobj());
	        account.setSusobjFlag(accountNumber.getSusobjFlag());
	        account.setStakeEng(accountNumber.getStakeEng());
	        account.setStakeEngFlag(accountNumber.getStakeEngFlag());
	        account.setReportReq(accountNumber.getReportReq());
	        account.setReportReqFlag(accountNumber.getReportReqFlag());
	        account.setTimeline(accountNumber.getTimeline());
	        account.setTimelineFlag(accountNumber.getTimelineFlag());
	        account.setBudget(accountNumber.getBudget());
	        account.setBudgetFlag(accountNumber.getBudgetFlag());
	        account.setEIAcomments(accountNumber.getEIAcomments());
	        account.setEIAcommFlag(accountNumber.getEIAcommFlag());
	        account.setLegalVerificationComments(accountNumber.getLegalVerificationComments());
	        account.setLegalverFlag(accountNumber.getLegalverFlag()); 
	        account.setFinancialHealthComments(accountNumber.getFinancialHealthComments());
	        account.setFinancialHealthFlag(accountNumber.getFinancialFileFlag());
	        account.setEsgCompliance(accountNumber.getEsgCompliance());
	        account.setEsgCompFlag(accountNumber.getEsgCompFlag());
	        account.setEIAfile(accountNumber.getEIAfile());
	      //  account.setEIAFileFlag(accountNumber.getEIAFileFlag());
	        account.setLegalVerificationFile(accountNumber.getLegalVerificationFile());
	      //  account.setLegalFileFlag(accountNumber.getLegalFileFlag());
	        account.setFinancialHealthFile(accountNumber.getFinancialHealthFile());
	    //    account.setFinancialFileFlag(accountNumber.getFinancialFileFlag());
	        account.setESGfile(accountNumber.getESGfile());
	    //    account.setESGFileFlag(accountNumber.getESGFileFlag());
	        account.setEIAFileName(accountNumber.getEIAFileName());
	        account.setLegalVerificationFileName(accountNumber.getLegalVerificationFileName());
	        account.setFinancialFileName(accountNumber.getFinancialFileName());
	        account.setESGFileName(accountNumber.getESGFileName());
	      
	        
	        
	    }
	     
	    // Helper method to set Phase B values
	    private void populatePhaseB(AccountNum account, AccountDTO accountNumber) {
	        account.setVulnerability(accountNumber.getVulnerability());
	        account.setVulnerabilityFlag(accountNumber.getVulnerabilityFlag());
	        account.setSealevel(accountNumber.getSealevel());
	        account.setSealevelFlag(accountNumber.getSealevelFlag());
	        account.setCarbonintensive(accountNumber.getCarbonintensive());
	        account.setCarbonintFlag(accountNumber.getCarbonintFlag());
	        account.setAssetrisk(accountNumber.getAssetrisk());
	        account.setAssestriskFlag(accountNumber.getAssestriskFlag());
	        account.setBorroweremission(accountNumber.getBorroweremission());
	        account.setBorrowermissionFlag(accountNumber.getBorrowermissionFlag());
	        account.setShifting(accountNumber.getShifting());
	        account.setShiftingFlag(accountNumber.getShiftingFlag());
	        account.setBusiness(accountNumber.getBusiness());
	        account.setBusinessFlag(accountNumber.getBusinessFlag());
	        account.setSupplychain(accountNumber.getSupplychain());
  	        account.setSupplychainFlag(accountNumber.getSupplychainFlag());
	        account.setClimate(accountNumber.getClimate());
	        account.setClimateFlag(accountNumber.getClimateFlag());
	        account.setActivityCode(accountNumber.getActivityCode());
	           }
	    private void populatePhaseC(AccountNum account, AccountDTO accountNumber) {
	    	    }
	    
		public Optional<AccountNum> findByAccountNumber(AccountNum accountNumRequest) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public AccountNum updateChecker(CheckerDTO checkerDTO ,String userRole) {
			AccountNum accountNum = accountNumRepository.findByaccountNumber(checkerDTO.getAccountNumber());
			if (accountNum == null) {
	            throw new RuntimeException("Account Number " + checkerDTO + " not found");
	        }
			accountNum.setDecision(checkerDTO.getDecision());
			accountNum.setReturnReason(checkerDTO.getReturnReason());
			accountNum.setCheckerId(checkerDTO.getCheckerId());
			
			 boolean allDecisionsAccepted = areAllDecisionsAcceptedChecker(checkerDTO);
//			 if(userRole!=null && userRole.equalsIgnoreCase("Admin")) {
				 if(userRole!=null && userRole.equalsIgnoreCase("Checker")) {
			 if(allDecisionsAccepted) {
				 accountNum.setStatus("Verified By Checker");
		        
		        }else {
		        	accountNum.setStatus("Queried By Checker");
		         
		        }
			 }else if (userRole!=null && userRole.equalsIgnoreCase("Maker") && accountNum.getStatus()!=null && accountNum.getStatus().equalsIgnoreCase("Queried By Checker")) {
				 accountNum.setStatus("pending");
			 }
			
			 
			 
//			if(accountNum.getStatus() == "return") {
//				accountNum.setStatus("pending");
//			}else
//			{
//			accountNum.setStatus("verified");
//			}
		//	accountNum.setCurrentStatus("pending at Checker");
			 return accountNumRepository.save(accountNum);
		}
		 private boolean areAllDecisionsAcceptedChecker(CheckerDTO accountNum)  {
		    	boolean formDataDecisionsAdmin =
		    			"approve".equalsIgnoreCase(accountNum.getDecision()) ;
		    		//	"approve".equalsIgnoreCase(accountNum.getReturnReason()) &&
		    		//	"approve".equalsIgnoreCase(accountNum.getCheckerId());
		    		  	return formDataDecisionsAdmin;
			}
		
		public AccountNum AdminCmnt(HistoryCmntDTO historyCmntDTO) {
			AccountNum accountNum = accountNumRepository.findByaccountNumber(historyCmntDTO.getAccountNumber());
			if (accountNum == null) {
	            throw new RuntimeException("Account Number " + historyCmntDTO + " not found");
	        }
			//accountNum.setCurrentDate(historyCmntDTO.getCurrentDate());
			accountNum.setCmntBy(historyCmntDTO.getCmntBy());
//			accountNum.setBorrowerComment(historyCmntDTO.getBorrowerComment());
//			accountNum.setBranchcomment(historyCmntDTO.getBranchcomment());
//			accountNum.setPanComment(historyCmntDTO.getPanComment());
//			accountNum.setCinComment(historyCmntDTO.getCinComment());
//			accountNum.setSchemecomment(historyCmntDTO.getSchemecomment());
//			accountNum.setActivitycomment(historyCmntDTO.getActivitycomment());
		//	accountNum.setProjComment(historyCmntDTO.getProjComment());
			accountNum.setSectorcomment(historyCmntDTO.getSectorcomment());
			
			accountNum.setLocationComment(historyCmntDTO.getLocationComment());
			
			
			accountNum.setDescpComment(historyCmntDTO.getDescpComment());
			accountNum.setSusobjComment(historyCmntDTO.getSusobjComment());
			accountNum.setStakeEng(historyCmntDTO.getStakeEngComment());
			accountNum.setReportReq(historyCmntDTO.getReportReqComment());
			accountNum.setTimelineComment(historyCmntDTO.getTimelineComment());
			accountNum.setBudgetComment(historyCmntDTO.getBudgetComment());
			accountNum.setEIAcommComment(historyCmntDTO.getEIAcommComment());
			accountNum.setLegalverComment(historyCmntDTO.getLegalverComment());
			accountNum.setFinancialHealthCmnt(historyCmntDTO.getFinancialHealthCmnt());
			accountNum.setEsgCompComment(historyCmntDTO.getEsgCompComment());
			accountNum.setVulnerabilityComment(historyCmntDTO.getVulnerabilityComment());
			accountNum.setCarbonintComment(historyCmntDTO.getCarbonintComment());
			accountNum.setSealevelComment(historyCmntDTO.getSealevelComment());
			accountNum.setAssestriskComment(historyCmntDTO.getAssestriskComment());
			accountNum.setSupplychainComment(historyCmntDTO.getSupplychainComment());
			accountNum.setShiftingComment(historyCmntDTO.getShiftingComment());
			accountNum.setBusinessComment(historyCmntDTO.getBusinessComment());
			accountNum.setClimateComment(historyCmntDTO.getClimateComment());
			accountNum.setBorrowermissionComment(historyCmntDTO.getBorrowermissionComment());
			accountNum.setPincodeComment(historyCmntDTO.getPincodeComment());
			accountNum.setLatitudeComment(historyCmntDTO.getLatitudeComment());
			accountNum.setLongitudeComment(historyCmntDTO.getLongitudeComment());
			accountNum.setOthersAddComment(historyCmntDTO.getOthersAddComment());
			// accountNum.setActivityFlag(historyCmntDTO.getActivityFlag());
			
			accountNum.setPlantLocations(historyCmntDTO.getPlantLocations());
			accountNum.setPlantLocationsFlag(historyCmntDTO.getPlantLocationsFlag());
			
			accountNum.setSegment(historyCmntDTO.getSegment());
			accountNum.setAssestriskFlag(historyCmntDTO.getAssestriskFlag());
			// accountNum.setBorrowerFlag(historyCmntDTO.getBorrowerFlag());
			 accountNum.setBorrowermissionFlag(historyCmntDTO.getBorrowermissionFlag());
			// accountNum.setBranchFlag(historyCmntDTO.getBranchFlag());
			 accountNum.setBudgetFlag(historyCmntDTO.getBudgetFlag());
			 accountNum.setBusinessFlag(historyCmntDTO.getBusinessFlag());
			 accountNum.setCarbonintFlag(historyCmntDTO.getCarbonintFlag());
			// accountNum.setCinFlag(historyCmntDTO.getCinFlag());
			 accountNum.setClimateFlag(historyCmntDTO.getClimateFlag());
			 accountNum.setDescpFlag(historyCmntDTO.getDescpFlag());
			 accountNum.setEIAcommFlag(historyCmntDTO.getEIAcommFlag());
			// accountNum.setEIAFileFlag(historyCmntDTO.getEIAFileFlag());
			 accountNum.setEsgCompFlag(historyCmntDTO.getEsgCompFlag());
			// accountNum.setESGFileFlag(historyCmntDTO.getESGFileFlag());
			// accountNum.setFinancialFileFlag(historyCmntDTO.getFinancialFileFlag());
			 accountNum.setFinancialHealthFlag(historyCmntDTO.getFinancialHealthFlag());
			// accountNum.setLegalFileFlag(historyCmntDTO.getLegalFileFlag());
			 accountNum.setLegalverFlag(historyCmntDTO.getLegalverFlag());				
			// accountNum.setLocationFlag(historyCmntDTO.getLocationFlag());
			 
			// accountNum.setPanFlag(historyCmntDTO.getPanFlag());
		//	 accountNum.setProjFlag(historyCmntDTO.getProjFlag());
			// accountNum.setReportReqFlag(accountNum.getReportReqFlag());	
			 //accountNum.setReportReqFlag(accountNum.getReportReqFlag());	
			// accountNum.setSchemeFlag(historyCmntDTO.getSchemeFlag());
			 accountNum.setSealevelFlag(historyCmntDTO.getSealevelFlag());
			 accountNum.setSectorFlag(historyCmntDTO.getSectorFlag());
			 accountNum.setShiftingFlag(historyCmntDTO.getShiftingFlag());
			 accountNum.setStakeEngFlag(historyCmntDTO.getStakeEngFlag());
			 accountNum.setSupplychainFlag(historyCmntDTO.getSupplychainFlag());
			 accountNum.setSusobjFlag(historyCmntDTO.getSusobjFlag());
			 accountNum.setTimelineFlag(historyCmntDTO.getTimelineFlag());
			 accountNum.setVulnerabilityFlag(historyCmntDTO.getVulnerabilityFlag());
			 accountNum.setPincodeFlag(historyCmntDTO.getPincodeFlag());
			 accountNum.setLongitudeFlag(historyCmntDTO.getLongitudeFlag());
			 accountNum.setLatitudeFlag(historyCmntDTO.getLatitudeFlag());
			 accountNum.setOthersAddFlag(historyCmntDTO.getOthersAddFlag());
			 //accountNum.setCurrentDate(LocalDateTime.now());
			 
		/*	 if(accountNum.getCurrentDate()==null) {
				 accountNum.setCurrentDate(LocalDateTime.now()); 
			 }else {
				 accountNum.setCurrentDate(historyCmntDTO.getCurrentDate());
			 }
			*/ 
				 
				 CmntHistory cmntHistory = new CmntHistory();
			//	 cmntHistory.setActivitycomment(accountNum.getActivitycomment());
				// cmntHistory.setCurrentDate(historyCmntDTO.getCurrentDate());
				 cmntHistory.setCmntBy(historyCmntDTO.getCmntBy());
//				 cmntHistory.setBorrowerComment(historyCmntDTO.getBorrowerComment());
//				 cmntHistory.setBranchcomment(historyCmntDTO.getBranchcomment());
//				 cmntHistory.setPanComment(historyCmntDTO.getPanComment());
//				 cmntHistory.setCinComment(historyCmntDTO.getCinComment());
//				 cmntHistory.setSchemecomment(historyCmntDTO.getSchemecomment());
//				 cmntHistory.setActivitycomment(historyCmntDTO.getActivitycomment());
				 cmntHistory.setProjComment(historyCmntDTO.getProjComment());
				 cmntHistory.setSectorcomment(historyCmntDTO.getSectorcomment());
				 cmntHistory.setLocationComment(historyCmntDTO.getLocationComment());
				 cmntHistory.setDescpComment(historyCmntDTO.getDescpComment());
				 cmntHistory.setSusobjComment(historyCmntDTO.getSusobjComment());
				 cmntHistory.setStakeEngComment(historyCmntDTO.getStakeEngComment());
				 cmntHistory.setTimelineComment(historyCmntDTO.getTimelineComment());
				 cmntHistory.setBudgetComment(historyCmntDTO.getBudgetComment());
				 cmntHistory.setEIAcommComment(historyCmntDTO.getEIAcommComment());
				 cmntHistory.setLegalverComment(historyCmntDTO.getLegalverComment());
				 cmntHistory.setFinancialHealthCmnt(historyCmntDTO.getFinancialHealthCmnt());
				 cmntHistory.setEsgCompComment(historyCmntDTO.getEsgCompComment());
				 cmntHistory.setVulnerabilityComment(historyCmntDTO.getVulnerabilityComment());
				 cmntHistory.setCarbonintComment(historyCmntDTO.getCarbonintComment());
				 cmntHistory.setSealevelComment(historyCmntDTO.getSealevelComment());
				 cmntHistory.setAssestriskComment(historyCmntDTO.getAssestriskComment());
				 cmntHistory.setSupplychainComment(historyCmntDTO.getSupplychainComment());
				 cmntHistory.setShiftingComment(historyCmntDTO.getShiftingComment());
				 cmntHistory.setBusinessComment(historyCmntDTO.getBusinessComment());
				 cmntHistory.setClimateComment(historyCmntDTO.getClimateComment());
				 cmntHistory.setBorrowermissionComment(historyCmntDTO.getBorrowermissionComment());
				 cmntHistory.setReturnReason(historyCmntDTO.getReturnReason());
				 cmntHistory.setPincodeComment(historyCmntDTO.getPincodeComment());
				 cmntHistory.setLatitudeComment(historyCmntDTO.getLatitudeComment());
				 cmntHistory.setLongitudeComment(historyCmntDTO.getLongitudeComment());
				 cmntHistory.setOthersAddComment(historyCmntDTO.getOthersAddComment());
				// cmntHistory.setCurrentDate(LocalDateTime.now());
				 
				 if(historyCmntDTO.getCurrentDate()==null) {
					 cmntHistory.setCurrentDate(LocalDateTime.now()); 
				 }else {
					 cmntHistory.setCurrentDate(historyCmntDTO.getCurrentDate());
				 }
				 
				 historyCmntRepository.save(cmntHistory);		
						 return accountNumRepository.save(accountNum);
					//	 return accountNumRepository.save(cmntHistory);
		}
	
		public AccountNum updateCmnts(CmntDTO cmntDTO) {
			AccountNum accountNum = accountNumRepository.findByaccountNumber(cmntDTO.getAccountNumber());
			if (accountNum == null) {
	            throw new RuntimeException("Account Number " + cmntDTO + " not found");
	        }
			if(cmntDTO.getAnnGHGComment()==null) {
				accountNum.setAnnGHGComment("");
			}
			else
			{
			accountNum.setAnnGHGComment(cmntDTO.getAnnGHGComment());
			}
			accountNum.setCo2Comment(cmntDTO.getCo2Comment());
			accountNum.setCapPlantComment(cmntDTO.getCapPlantComment());
			accountNum.setInfoStakeComnt(cmntDTO.getInfoStakeComnt());
			accountNum.setAnnEnergyCmnt(cmntDTO.getAnnEnergyCmnt());
			accountNum.setEnergyPrePostcmnt(cmntDTO.getEnergyPrePostcmnt());
			accountNum.setCleanVehicleCmnt(cmntDTO.getCleanVehicleCmnt());
			accountNum.setEstReductionCmnt(cmntDTO.getEstReductionCmnt());
			accountNum.setPollContCmnt(cmntDTO.getPollContCmnt());
			accountNum.setWaterUseCmnt(cmntDTO.getWaterPolluCmnt());
			accountNum.setAnnLevelCmnt(cmntDTO.getAnnLevelCmnt());
			accountNum.setWaterPolluCmnt(cmntDTO.getWaterPolluCmnt());
			accountNum.setReductionWatercmnt(cmntDTO.getReductionWatercmnt());
			accountNum.setAnnualWaterCmnt(cmntDTO.getAnnualWaterCmnt());
			accountNum.setAnnualAmountCmnt(cmntDTO.getAnnualWaterCmnt());
			accountNum.setAreaLandCmnt(cmntDTO.getAreaLandCmnt());
			accountNum.setAreaSustainCmnt(cmntDTO.getAreaSustainCmnt());
			accountNum.setSustainableComnt(cmntDTO.getSustainableComnt());
			accountNum.setRestorelandCmnt(cmntDTO.getRestorelandCmnt());
			accountNum.setRestorehabitCmnt(cmntDTO.getRestorehabitCmnt());
			accountNum.setProtectAreaComnt(cmntDTO.getProtectAreaComnt());
			accountNum.setNaturalLandCmnt(cmntDTO.getNaturalLandCmnt());
			accountNum.setNumberTrgtCmnt(cmntDTO.getNumberTrgtCmnt());
			
			 return accountNumRepository.save(accountNum);
		}

			
			
		
		public AccountNum UpdateChecker(String accountNumb, AccountDTO accountNumber) {
		AccountNum accountNum= accountNumRepository.findByaccountNumber(accountNumb);
		 if (accountNum == null) {
	            throw new RuntimeException("Account Number " + accountNumb + " not found");
	        }
		 //accountNum.setActivityFlag(accountNumber.getActivityFlag());
		 //accountNum.setAdminRejectFlag(accountNumber.getAdminRejectFlag());
		// accountNum.setAdminStatusFlag(accountNumber.getAdminStatusFlag());
		 accountNum.setAssestriskFlag(accountNumber.getAssestriskFlag());
		// accountNum.setBorrowerFlag(accountNumber.getBorrowerFlag());
		 accountNum.setBorrowermissionFlag(accountNumber.getBorrowermissionFlag());
		// accountNum.setBranchFlag(accountNumber.getBranchFlag());
		 accountNum.setBudgetFlag(accountNumber.getBudgetFlag());
		 accountNum.setBusinessFlag(accountNumber.getBusinessFlag());
		 accountNum.setCarbonintFlag(accountNumber.getCarbonintFlag());
		 //accountNum.setCheckerStatusFlag(accountNumber.getCheckerStatusFlag());
		// accountNum.setCinFlag(accountNumber.getCinFlag());
		 accountNum.setClimateFlag(accountNumber.getClimateFlag());
		 accountNum.setDescpFlag(accountNumber.getDescpFlag());
		 accountNum.setEIAcommFlag(accountNumber.getEIAcommFlag());
		// accountNum.setEIAFileFlag(accountNumber.getEIAFileFlag());
		 accountNum.setEsgCompFlag(accountNumber.getEsgCompFlag());
		// accountNum.setESGFileFlag(accountNumber.getESGFileFlag());
		// accountNum.setFinancialFileFlag(accountNumber.getFinancialFileFlag());
		 accountNum.setFinancialHealthFlag(accountNumber.getFinancialHealthFlag());
		// accountNum.setLegalFileFlag(accountNum.getLegalFileFlag());
		// accountNum.setLegalverFlag(accountNumber.getLegalverFlag());
		// accountNum.setLocationFlag(accountNumber.getLocationFlag());
		 
		 
		 accountNum.setPlantLocations(accountNumber.getPlantLocations());
		 accountNum.setPlantLocationsFlag(accountNumber.getPlantLocationsFlag());
		 
		 accountNum.setSegment(accountNumber.getSegment());
		 //accountNum.setPanFlag(accountNumber.getPanFlag());
	//	 accountNum.setProjFlag(accountNumber.getProjFlag());
		 accountNum.setReturnReason(accountNumber.getReturnReason());
		 accountNum.setReportReqFlag(accountNumber.getReportReqFlag());
		 //accountNum.setSchemeFlag(accountNumber.getSchemeFlag());
		 accountNum.setSealevelFlag(accountNumber.getSealevelFlag());
		 accountNum.setSectorFlag(accountNumber.getSectorFlag());
		 accountNum.setShiftingFlag(accountNumber.getShiftingFlag());
		 accountNum.setStakeEngFlag(accountNumber.getStakeEngFlag());
		 accountNum.setSupplychainFlag(accountNumber.getSupplychainFlag());
		 accountNum.setSusobjFlag(accountNumber.getSusobjFlag());
		 accountNum.setTimelineFlag(accountNumber.getTimelineFlag());
		 accountNum.setVulnerabilityFlag(accountNumber.getVulnerabilityFlag());
		 accountNum.setPincodeFlag(accountNumber.getPincodeFlag());
		 accountNum.setLatitudeFlag(accountNumber.getLatitudeFlag());
		 accountNum.setLongitudeFlag(accountNumber.getLongitudeFlag());
		 
		 accountNum.setOthersAddFlag(accountNumber.getOthersAddFlag());
		 
		 boolean allDecisionsAccepted = areAllDecisionsAccepted(accountNumber);
		 
		 if(allDecisionsAccepted) {
			 accountNum.setStatus("Admin");
	        
	        }else {
	        	accountNum.setStatus("Queried By Checker");
	         
	        }
	        
		 return accountNumRepository.save(accountNum);  // Save the updated entity
    }
		
		
		 private boolean areAllDecisionsAccepted(AccountDTO accountNum)  {
		    	boolean formDataDecisions =
		    			"approve".equalsIgnoreCase(accountNum.getAccStatusFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getActivityFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getAdminRejectFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getAdminStatusFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getAssestriskFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getBorrowerFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getBorrowermissionFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getBranchFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getBudgetFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getBusinessFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getCarbonintFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getCheckerStatusFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getCinFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getClimateFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getDescpFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getEIAcommFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getEIAFileFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getEsgCompFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getESGFileFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getFinancialFileFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getFinancialHealthFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getLegalFileFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getLegalverFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getLocationFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getPanFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getProjFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getRejectReasonFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getReportReqFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getSchemeFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getSealevelFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getSectorFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getShiftingFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getStakeEngFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getSupplychainFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getSusobjFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getTimelineFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getVulnerabilityFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getPincodeFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getLatitudeFlag()) &&
		    			"approve".equalsIgnoreCase(accountNum.getLongitudeFlag()) &&
		    			
		    			"approve".equalsIgnoreCase(accountNum.getPlantLocationsFlag()) &&
		    			
		    			"approve".equalsIgnoreCase(accountNum.getOthersAddFlag()) ;
		    	
		    	
		    			return formDataDecisions;
}
		 
		 
		 public AccountNum UpdateAdmin(String accountNumb, FlagDTO accountNumber ,String userRole) {
				AccountNum accountNum= accountNumRepository.findByaccountNumber(accountNumb);
				 if (accountNum == null) {
			            throw new RuntimeException("Account Number " + accountNumb + " not found");
			        }
				 //accountNum.setActivityFlag(accountNumber.getActivityFlag());
				 //accountNum.setActivitycomment(accountNumber.getActivitycomment());
				// accountNum.setAdminRejectFlag(accountNumber.getAdminRejectFlag());
				// accountNum.setAdminStatusFlag(accountNumber.getAdminStatusFlag());
				 accountNum.setAssestriskFlag(accountNumber.getAssestriskFlag());
				 accountNum.setAssestriskComment(accountNumber.getAssestriskComment());
				// accountNum.setBorrowerFlag(accountNumber.getBorrowerFlag());
				 //accountNum.setBorrowerComment(accountNumber.getBorrowerComment());
				 accountNum.setBorrowermissionFlag(accountNumber.getBorrowermissionFlag());
				 accountNum.setBorrowermissionComment(accountNumber.getBorrowermissionComment());
				// accountNum.setBranchFlag(accountNumber.getBranchFlag());
				// accountNum.setBranchcomment(accountNumber.getBranchcomment());
				 accountNum.setBudgetFlag(accountNumber.getBudgetFlag());
				 accountNum.setBudgetComment(accountNumber.getBudgetComment());
				 accountNum.setBusinessFlag(accountNumber.getBusinessFlag());
				 accountNum.setBusinessComment(accountNumber.getBusinessComment());
				 accountNum.setCarbonintFlag(accountNumber.getCarbonintFlag());
				 accountNum.setCarbonintComment(accountNumber.getCarbonintComment());
				// accountNum.setCheckerStatusFlag(accountNumber.getCheckerStatusFlag());
				// accountNum.setCinFlag(accountNumber.getCinFlag());
				// accountNum.setCinComment(accountNumber.getCinComment());
				 accountNum.setClimateFlag(accountNumber.getClimateFlag());
				 accountNum.setClimateComment(accountNumber.getClimateComment());
				 accountNum.setDescpFlag(accountNumber.getDescpFlag());
				 accountNum.setDescpComment(accountNumber.getDescpComment());
				 accountNum.setEIAcommFlag(accountNumber.getEIAcommFlag());
				 accountNum.setEIAcommComment(accountNumber.getEIAcommComment());
				// accountNum.setEIAFileFlag(accountNumber.getEIAFileFlag());
				 accountNum.setEsgCompFlag(accountNumber.getEsgCompFlag());
				 accountNum.setEsgCompComment(accountNumber.getEsgCompComment());
				 //accountNum.setESGFileFlag(accountNumber.getESGFileFlag());
				// accountNum.setFinancialFileFlag(accountNumber.getFinancialFileFlag());
				 accountNum.setFinancialHealthFlag(accountNumber.getFinancialHealthFlag());
				 accountNum.setFinancialHealthCmnt(accountNumber.getFinancialHealthCmnt());
				 //accountNum.setLegalFileFlag(accountNum.getLegalFileFlag());
				 accountNum.setLegalverFlag(accountNumber.getLegalverFlag());
				 accountNum.setLegalverComment(accountNumber.getLegalverComment());
				// accountNum.setLocationFlag(accountNumber.getLocationFlag());
				// accountNum.setLocationComment(accountNumber.getLocationComment());
				// accountNum.setPanFlag(accountNumber.getPanFlag());
				 //accountNum.setPanComment(accountNumber.getPanComment());
//				 accountNum.setProjFlag(accountNumber.getProjFlag());
//				 accountNum.setProjComment(accountNumber.getProjComment());
				 accountNum.setReportReqFlag(accountNumber.getReportReqFlag());
				 accountNum.setReportReqComment(accountNumber.getReportReqComment());
				// accountNum.setSchemeFlag(accountNumber.getSchemeFlag());
				// accountNum.setSchemecomment(accountNumber.getSchemecomment());
				 accountNum.setSealevelFlag(accountNumber.getSealevelFlag());
				 accountNum.setSealevelComment(accountNumber.getSealevelComment());
				 accountNum.setSectorFlag(accountNumber.getSectorFlag());
				 accountNum.setSectorcomment(accountNumber.getSectorcomment());
				 accountNum.setShiftingFlag(accountNumber.getShiftingFlag());
				 accountNum.setShiftingComment(accountNumber.getShiftingComment());
				 accountNum.setStakeEngFlag(accountNumber.getStakeEngFlag());
				 accountNum.setStakeEngComment(accountNumber.getStakeEngComment());
				 accountNum.setSupplychainFlag(accountNumber.getSupplychainFlag());
				 accountNum.setSupplychainComment(accountNumber.getSupplychainComment());
				 accountNum.setSusobjFlag(accountNumber.getSusobjFlag());
				 accountNum.setSusobjComment(accountNumber.getSusobjComment());
				 accountNum.setTimelineFlag(accountNumber.getTimelineFlag());
				 accountNum.setTimelineComment(accountNumber.getTimelineComment());
				 accountNum.setVulnerabilityFlag(accountNumber.getVulnerabilityFlag());
				 accountNum.setVulnerabilityComment(accountNumber.getVulnerabilityComment());
				 accountNum.setPincodeComment(accountNumber.getPincodeComment());
				 accountNum.setPincodeFlag(accountNumber.getPincodeFlag());
				 accountNum.setLongitudeFlag(accountNumber.getLongitudeFlag());
				 accountNum.setLongitudeComment(accountNumber.getLongitudeComment());
				 accountNum.setLatitudeComment(accountNumber.getLatitudeComment());
				 accountNum.setLatitudeFlag(accountNumber.getLatitudeFlag());
				 
//				 accountNum.setPlantLocationsFlag(accountNumber.getPlantLocationsFlag());
//				
//				 accountNum.setPlantLocationsComment(accountNumber.getPlantLocationsComment()); // if comment exists
			  
				 accountNum.setOthersAddComment(accountNumber.getOthersAddComment());
				 accountNum.setOthersAddFlag(accountNumber.getOthersAddFlag());
				 
				 
				 if(userRole!=null && userRole.equalsIgnoreCase("Admin")) {
					 boolean allDecisionsAccepted = areAllDecisionsAcceptedAdmin(accountNumber);
					 
					 if(allDecisionsAccepted) {
						 accountNum.setStatus("Completed by Admin");
				        
				      }else {
				         accountNum.setStatus("Queried By Admin");
				         
				      }
				 }else if (userRole!=null && userRole.equalsIgnoreCase("Maker") && accountNum.getStatus()!=null &&  (accountNum.getStatus().equalsIgnoreCase("Queried By Admin") || accountNum.getStatus().equalsIgnoreCase("Queried By Checker"))) {
					 accountNum.setStatus("pending");
				 }
			        
				 return accountNumRepository.save(accountNum); // Save the updated entity
		    }
				 private boolean areAllDecisionsAcceptedAdmin(FlagDTO accountNum)  {
				    	boolean formDataDecisionsAdmin =
				    			//"accept".equalsIgnoreCase(accountNum.getAccStatusFlag()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getActivityFlag()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getAdminRejectFlag()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getAdminStatusFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getAssestriskFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getAssestriskComment()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getBorrowerFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getBorrowermissionFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getBorrowermissionComment()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getBranchFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getBudgetFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getBudgetComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getBusinessFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getBusinessComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getCarbonintFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getCarbonintComment()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getCheckerStatusFlag()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getCinFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getClimateFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getClimateComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getDescpFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getDescpComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getEIAcommFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getEIAcommComment()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getEIAFileFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getEsgCompFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getEsgCompComment()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getESGFileFlag()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getFinancialFileFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getFinancialHealthFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getFinancialHealthCmnt()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getLegalFileFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getLegalverFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getLegalverComment()) &&
				    			
				    			
				    			"approve".equalsIgnoreCase(accountNum.getPlantLocationsFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getPlantLocationsComment()) &&
				    			
				    			"approve".equalsIgnoreCase(accountNum.getLocationFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getLocationComment()) &&
				    			
                      //		"accept".equalsIgnoreCase(accountNum.getPanFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getProjFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getProjComment()) &&
				    			//"accept".equalsIgnoreCase(accountNum.getRejectReasonFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getReportReqFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getReportReqComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getSealevelFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getSealevelComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getSectorFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getSealevelComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getShiftingFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getShiftingComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getStakeEngFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getStakeEngComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getSupplychainFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getSupplychainComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getSusobjFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getSusobjComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getTimelineFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getTimelineComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getVulnerabilityFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getVulnerabilityComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getPincodeComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getPincodeFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getLongitudeComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getLongitudeFlag()) &&
				    			"approve".equalsIgnoreCase(accountNum.getLatitudeComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getLatitudeFlag()) &&
				    			
				    			"approve".equalsIgnoreCase(accountNum.getOthersAddComment()) &&
				    			"approve".equalsIgnoreCase(accountNum.getOthersAddFlag());
				    	
				    							    					    			
				    	     	return formDataDecisionsAdmin;
		}

				public AccountNum saveOrUpdate(AccountNum accountToUpdate) {
					// TODO Auto-generated method stub
					return null;
				}
				public Phase1DTO getUserByAccount(Phase1DTO accountDTO) {
					// TODO Auto-generated method stub
					return null;
				}

				public List<AccountNum> getAllRecords(){
					return accountNumRepository.findAllrecord();
				}
//				public List<AccountNum> findAllrecordAdmin(){
//					return accountNumRepository.findAllrecordAdmin();
//				}
//				
				public List<AccountNum> findAllrecordAdmin() {
				    return accountNumRepository.findByStatus("Verified By Checker");
				}
				
				public List<AccountNum> findAllrecordReport() {
				    return accountNumRepository.findByStatus("Completed by Admin");
				}
				
				public List<AccountNum> findAllrecordQueriedAdmin() {
				    return accountNumRepository.findByStatus("Queried By Admin");
				}

				public List<AccountNum> getAllRecordsReturn(){
					return accountNumRepository.findReturnedRecords();
				}
				
				public List<AccountNum> getReturnedRecords() {
				    return accountNumRepository.findByStatus("Queried By Checker");
				}

				public Optional<AccountNum> getRecordsByAccountNumber(String accountNumber){
					return accountNumRepository.findByAccountNumber(accountNumber);
				}
				
				public Optional<AccountNum> getRecordsByAccountNumberAdmin(String accountNumber){
					return accountNumRepository.findByAccountNumber(accountNumber);
				}
				
				public List<AccountNum> getPendingTransaction(){
					return accountNumRepository.findByStatus("pending");
				}
				public List<AccountNum> getVerifiedTransaction(){
					return accountNumRepository.findByStatus("verified");
				}
		
				public List<AccountNum> getCompleteTransaction(){
					return accountNumRepository.findByStatus("Completed ");
				}
				
				 
}
	
	

	

