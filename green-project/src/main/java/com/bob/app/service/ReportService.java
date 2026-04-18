package com.bob.app.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Optional;
import com.bob.app.bean.LoanDetails;
import com.bob.app.dao.jpa.LoanDetailsRepository;
import com.bob.app.dao.jpa.ReportRepository;
import com.bob.app.dto.LoanChartDTO;
import com.bob.app.dto.SegmentChartDTO;
import com.bob.app.dto.SchemeActivityChartDTO;
import com.bob.app.dto.DepositLoanLineChartDTO;
import com.bob.app.dto.LineChartDTO;
//import com.bob.app.dto.DepositLoanChartDTO;
import com.bob.app.dto.LoanBarChartDTO;
import com.bob.app.dto.LoanBarChartDailyDTO;

@Service 
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

//    public List<DepositLoanChartDTO> getMonthlyDepositLoanData() {
//        return reportRepository.fetchMonthlyDepositLoanData();
//    }
//}

   

     

        public ReportService(ReportRepository reportRepository) {
            this.reportRepository = reportRepository;
        }

//        public List<DepositLoanLineChartDTO> getDepositVsLoanData(String fromDate, String toDate) {
//            return reportRepository.fetchDepositVsLoanData(fromDate, toDate);
//        }
 
        public List<DepositLoanLineChartDTO> getDepositVsLoanData(int startYear) {
            int endYear = startYear + 1;

            LocalDate fyStart = LocalDate.of(startYear, 4, 1);
            LocalDate fyEnd = LocalDate.of(endYear, 3, 31);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            return reportRepository.fetchDepositVsLoanData(
                fyStart.format(formatter),
                fyEnd.format(formatter)
            );
        }


   

//        public List<LoanBarChartDTO> getMonthlyDepositLoanData() {
//            LocalDate today = LocalDate.now();
//            int year = today.getYear();
//            int month = today.getMonthValue();
//
//            int startYear, endYear;
//            if (month >= 4) {
//                startYear = year;
//                endYear = year + 1;
//            } else {
//                startYear = year - 1;
//                endYear = year;
//            }
//
//            LocalDate fyStart = LocalDate.of(startYear, 4, 1);
//            LocalDate fyEnd = LocalDate.of(endYear, 3, 31);
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//            return reportRepository.fetchMonthlyDepositLoanData(
//                    fyStart.format(formatter),
//                    fyEnd.format(formatter)
//            );
//        }
        
        
        public List<LoanBarChartDTO> getMonthlyDepositLoanData(int startYear) {
            int endYear = startYear + 1;

            LocalDate fyStart = LocalDate.of(startYear, 4, 1);
            LocalDate fyEnd = LocalDate.of(endYear, 3, 31);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            return reportRepository.fetchMonthlyDepositLoanData(
                fyStart.format(formatter),
                fyEnd.format(formatter)
            );
        }


        public List<LoanBarChartDailyDTO> getDailyDepositLoanData(String month, String year) {
            String formattedMonth = String.format("%02d", Integer.parseInt(month));
            return reportRepository.fetchDailyDepositLoanData(formattedMonth, year);
        }
        
        
//        public List<DepositLoanLineChartDTO> getCumulativeDepositVsLoanData() {
//            LocalDate today = LocalDate.now();
//            int year = today.getYear();
//            int month = today.getMonthValue();
//
//            int startYear = (month >= 4) ? year : year - 1;
//            int endYear = (month >= 4) ? year + 1 : year;
//
//            LocalDate fyStart = LocalDate.of(startYear, 4, 1);
//            LocalDate fyEnd = LocalDate.of(endYear, 3, 31);
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//            return reportRepository.fetchCumulativeDepositVsLoanData(
//                    fyStart.format(formatter), fyEnd.format(formatter));
//        }

        
       


    }

  
