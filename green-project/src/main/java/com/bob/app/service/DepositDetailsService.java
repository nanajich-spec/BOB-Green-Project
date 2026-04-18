package com.bob.app.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.app.bean.DepositDetails;
import com.bob.app.bean.LoanDetails;
import com.bob.app.dao.jpa.DepositDetailsRepository;
import com.bob.app.dto.PieChartDTO;
import com.bob.app.dto.BarChartDTO;
import com.bob.app.dto.BarChartDailyDTO;
import com.bob.app.dto.LineChartDTO;


@Service
public class DepositDetailsService {
	
	  @Autowired
	  private DepositDetailsRepository depositDetailsRepository;
	  
//	  public List<DepositDetails>getUserByDeposit(String schemecode) {
//	    	List<DepositDetails> Schmecd= depositDetailsRepository.findByschemeCode(schemecode);
//	    	System.out.println("Fetching user with accountNumber: " + schemecode);
//	        return Schmecd;
//	    }
	  public List<DepositDetails> getAllRecordsDeposit(){
		  
		  
			//return depositDetailsRepository.fetchDepositData();
			return depositDetailsRepository.findAll();
		}
	  
	  public List<DepositDetails> getAllRecordsDepositDateWise(String todate, String fromdate){
		  
		  
			return depositDetailsRepository.fetchDateWise(todate,fromdate);
		}
	  
//	  public List<PieChartDTO> getAllRecordsDepositForCharts(){
//		  
//          
//		  
//			//return depositDetailsRepository.fetchDepositData();
//		  
//			return depositDetailsRepository.fetchDepositData();
//		}
	  
	  public List<PieChartDTO> getAllRecordsDepositForCharts(String startYear) {
		    return depositDetailsRepository.fetchDepositData(startYear);
		}


	
//	  public List<BarChartDTO> getMonthlyDepositData() { 
//		  
//		  LocalDate today = LocalDate.now();
//
//          int year = today.getYear();
//          int month = today.getMonthValue();
//
//          // Financial year starts in April
//          int startYear;
//          int endYear;
//
//          if (month >= 4) {
//              // April to December → financial year starts this calendar year
//              startYear = year;
//              endYear = year + 1;
//          } else {
//              // January to March → financial year started last calendar year
//              startYear = year - 1;
//              endYear = year;
//          }
//
//          LocalDate fyStart = LocalDate.of(startYear, 4, 1);
//          LocalDate fyEnd = LocalDate.of(endYear, 3, 31);
//
//          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//          System.out.println("Current Financial Year: " + startYear + "-" + endYear);
//          System.out.println("Start Date: " + fyStart.format(formatter));
//          System.out.println("End Date: " + fyEnd.format(formatter));
//          
//		  return depositDetailsRepository.fetchMonthlyDepositData(fyStart.format(formatter),fyEnd.format(formatter));
//		  }
//	  
	  
	  public List<BarChartDTO> getMonthlyDepositData(int startYear) {
		    int endYear = startYear + 1;
		    LocalDate fyStart = LocalDate.of(startYear, 4, 1);
		    LocalDate fyEnd = LocalDate.of(endYear, 3, 31);

		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		    return depositDetailsRepository.fetchMonthlyDepositData(
		        fyStart.format(formatter),
		        fyEnd.format(formatter)
		    );
		}

	 
	  public List<BarChartDailyDTO> getDailyDepositData(String month, String year) {
		    int monthInt = Integer.parseInt(month); // convert String to int
		    String formattedMonth = String.format("%02d", monthInt); // pad with leading zero if needed

		    return depositDetailsRepository.fetchDateWiseDepositData(formattedMonth, year);
		}

	  
//	  public List<LineChartDTO> getCumulativeMonthlyDepositData() {
//		    LocalDate today = LocalDate.now();
//		    int year = today.getYear();
//		    int month = today.getMonthValue();
//
//		    int startYear = (month >= 4) ? year : year - 1;
//		    int endYear = (month >= 4) ? year + 1 : year;
//
//		    LocalDate fyStart = LocalDate.of(startYear, 4, 1);
//		    LocalDate fyEnd = LocalDate.of(endYear, 3, 31);
//
//		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//		    return depositDetailsRepository.fetchCumulativeMonthlyDepositData(
//		        fyStart.format(formatter), fyEnd.format(formatter));
//		}
	  
	  public List<LineChartDTO> getCumulativeMonthlyDepositData(int startYear) {
		    int endYear = startYear + 1;

		    LocalDate fyStart = LocalDate.of(startYear, 4, 1);
		    LocalDate fyEnd = LocalDate.of(endYear, 3, 31);

		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		    return depositDetailsRepository.fetchCumulativeMonthlyDepositData(
		        fyStart.format(formatter),
		        fyEnd.format(formatter)
		    );
		}
  
	  

}
