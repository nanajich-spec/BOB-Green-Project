package com.bob.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bob.app.bean.LoanDetails;
import com.bob.app.dao.jpa.LoanDetailsRepository;
import com.bob.app.dto.LineChartDTO;
import com.bob.app.dto.LoanChartDTO;
import com.bob.app.dto.SegmentChartDTO;
import com.bob.app.dto.SchemeActivityChartDTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


//import com.bob.app.bean.LoanDtls;
//import com.bob.app.dao.jpa.LoanDetailsRepository;
//import com.bob.app.dao.jpa.LoanDtlsRepository;

@Service
public class LoanDetailsService {
	
	 @Autowired
	 private LoanDetailsRepository loanDetailsRepository;
	  
//	
//	 public Optional<LoanDetails>getUserByLoan(String accountNumber) {
//	    	Optional<LoanDetails> accountNumb= loanDetailsRepository.findByAccountNumber(accountNumber);
//	    	System.out.println("Fetching user with accountNumber: " + accountNumber);
//	        return accountNumb;
//	    }
	 public List<LoanDetails> getAllRecordsLoan(){
		 //return loanDetailsRepository.findAll();
		 
	
			 //   Pageable pageable = PageRequest.of(0, 100, Sort.by("id").ascending());
			 //   return loanDetailsRepository.findAll(pageable).getContent();
			
			    return loanDetailsRepository.findFirstDisbursementPerAccount();
			    
			    

		}
		
	 public List<LoanDetails> getAllRecordsLoanDateWise(String todate, String fromdate) {
		    return loanDetailsRepository.fetchLoanDateWise(todate, fromdate);
		}


public List<LoanDetails> getAllRecordsLoanByZone(String zone) { 
	return loanDetailsRepository.findByZone(zone);
	} 

public List<LoanDetails> getDisbRecordsByAcc(String acc) { 
	return loanDetailsRepository.findByAccountNumberOrderByDateOfAmountDisbursementAsc(acc);
	}

//public List<LoanChartDTO> getAllRecordsLoanForCharts() { 
//	return loanDetailsRepository.fetchLoanData();
//	}



public List<LoanChartDTO> getLoanData(int startYear) {
    int endYear = startYear + 1;

    LocalDate fyStart = LocalDate.of(startYear, 4, 1);
    LocalDate fyEnd = LocalDate.of(endYear, 3, 31);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    return loanDetailsRepository.fetchLoanData(
        fyStart.format(formatter),
        fyEnd.format(formatter)
    );
}

//public List<SegmentChartDTO> getAllRecordsSegmentForCharts() {
//    return loanDetailsRepository.fetchSegmentData();
//}

public List<SegmentChartDTO> getSegmentData(int startYear) {
    int endYear = startYear + 1;

    LocalDate fyStart = LocalDate.of(startYear, 4, 1);
    LocalDate fyEnd = LocalDate.of(endYear, 3, 31);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    return loanDetailsRepository.fetchSegmentData(
        fyStart.format(formatter),
        fyEnd.format(formatter)
    );
}




//public List<SchemeActivityChartDTO> getAllRecordsSchemeActivityForCharts() {
//    return loanDetailsRepository.fetchSchemeActivityData();
//}

public List<SchemeActivityChartDTO> getSchemeActivityData(int startYear) {
    int endYear = startYear + 1;

    LocalDate fyStart = LocalDate.of(startYear, 4, 1);
    LocalDate fyEnd = LocalDate.of(endYear, 3, 31);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    return loanDetailsRepository.fetchSchemeActivityData(
        fyStart.format(formatter),
        fyEnd.format(formatter)
    );
}


 

//    public List<LineChartDTO> getCumulativeMonthlyLoanData() {
//        LocalDate today = LocalDate.now();
//        int year = today.getYear();
//        int month = today.getMonthValue();
//
//        int startYear = (month >= 4) ? year : year - 1;
//        int endYear = (month >= 4) ? year + 1 : year;
//
//        LocalDate fyStart = LocalDate.of(startYear, 4, 1);
//        LocalDate fyEnd = LocalDate.of(endYear, 3, 31);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//        return loanDetailsRepository.fetchCumulativeMonthlyLoanData(
//            fyStart.format(formatter), fyEnd.format(formatter));
//    }


public List<LineChartDTO> getCumulativeMonthlyLoanData(int startYear) {
    int endYear = startYear + 1;

    LocalDate fyStart = LocalDate.of(startYear, 4, 1);
    LocalDate fyEnd = LocalDate.of(endYear, 3, 31);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    return loanDetailsRepository.fetchCumulativeMonthlyLoanData(
        fyStart.format(formatter),
        fyEnd.format(formatter)
    );
}


}

