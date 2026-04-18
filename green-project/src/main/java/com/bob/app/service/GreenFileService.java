package com.bob.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.app.bean.AccountNum;
import com.bob.app.bean.GreenFile;
import com.bob.app.dao.jpa.GreenFileRepository;






@Service
public class GreenFileService {
	
	@Autowired
	private GreenFileRepository greenFileRepository;
	
	
    public GreenFile saveOrUpdateForm(GreenFile greenFile) {
        if (greenFile.getAccountNumber() == null || greenFile.getAccountNumber().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
 
        // Find if the account already exists
        Optional<GreenFile> existingForm = greenFileRepository.findByAccountNumber(greenFile.getAccountNumber());
 
        if (existingForm.isPresent()) {
            // Update the existing record
        	GreenFile existingAccount = existingForm.get();
            existingAccount.setEIAfile(greenFile.getEIAfile());
            existingAccount.setLegalVerificationFile(greenFile.getLegalVerificationFile());
            existingAccount.setFinancialHealthFile(greenFile.getFinancialHealthFile());
            existingAccount.setESGfile(greenFile.getESGfile());
            existingAccount.setEIAFileName(greenFile.getEIAFileName());
            existingAccount.setLegalVerificationFileName(greenFile.getLegalVerificationFileName());
            existingAccount.setFinancialFileName(greenFile.getFinancialFileName());
            existingAccount.setESGFileName(greenFile.getESGFileName());
           
            return greenFileRepository.save(existingAccount); // Save updated record
        } else {
            // Save new record
            return greenFileRepository.save(greenFile);
        }
    }
    
    
    public Optional<GreenFile> getUserByAccountNumber(String accountNum) {
    	Optional<GreenFile> accountNumber= greenFileRepository.findByAccountNumber(accountNum);
    	System.out.println("Fetching user with email: " + accountNum);
        return accountNumber;
    }
    


}
