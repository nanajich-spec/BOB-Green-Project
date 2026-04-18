package com.bob.app.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bob.app.bean.LoanDetails;
import com.bob.app.dto.LineChartDTO;
import com.bob.app.dto.LoanChartDTO;
import com.bob.app.dto.PieChartDTO;
import com.bob.app.dto.SegmentChartDTO;
import com.bob.app.dto.SchemeActivityChartDTO;

public interface LoanDetailsRepository extends JpaRepository<LoanDetails, Long>{
	
	//  Optional<LoanDetails> findByAccountNumber(String accountNumber);
	  List<LoanDetails> findAll();
	  List<LoanDetails> findByZone(String zone);
	 
	  @Query(value = "SELECT * FROM GP_GREEN_LOAN_DTLS WHERE FORACID = :foracid  AND DISB_DATE = (SELECT MAX(DISB_DATE) FROM GP_GREEN_LOAN_DTLS WHERE FORACID = :foracid)", nativeQuery = true)
	  LoanDetails findLatestDisbursementByForacid(@Param("foracid") String foracid);

	  
//	  @Query(value = "SELECT * FROM GP_GREEN_LOAN_DTLS g WHERE g.DISB_DATE = (SELECT MIN(d.DISB_DATE) FROM GP_GREEN_LOAN_DTLS d  WHERE d.ACCOUNT_NUMBER = g.ACCOUNT_NUMBER) AND g.ACCOUNT_NUMBER = '40590600001108'", nativeQuery = true)
//	  List<LoanDetails> findFirstDisbursementPerAccount();
	  
	  
	  @Query(value = "SELECT ZONE, REGION,SOL_DESC,	SOL_ID, CUST_ID, " +
			    " ACCOUNT_NUMBER,ACCT_NAME,	ACCOUNT_OPENED_DATE, LIM_SANCT_DATE, AGGREGATE_DISBURSEMENT_AMOUNT, OUTSTANDING_AMOUNT,	MATURITY,	" +
			    " ACCOUNT_SEGMENT, ACTIVITY_CODE, ACTIVITY_GROUP,	CIN,	CREDIT_SPREAD,INTERNAL_RATING, EXTERNAL_RATING,	FINAL_ROI,INSTALMENT_START_DATE,INSTALMENT_AMOUNT,	INSTALMENT_FREQUENCY FROM GP_GREEN_LOAN_DTLS g " +
			              "WHERE g.DISB_DATE = ( " +
			              "  SELECT MAX(d.DISB_DATE) " +
			              "  FROM GP_GREEN_LOAN_DTLS d " +
			              "  WHERE d.ACCOUNT_NUMBER = g.ACCOUNT_NUMBER order by ZONE, REGION,SOL_DESC, ACCOUNT_NUMBER" +
			              ")", nativeQuery = true)
List<LoanDetails> findFirstDisbursementPerAccount();
//   ---------------------------working--------------------------------------------------------
//	  @Query(value = "SELECT * FROM GP_GREEN_LOAN_DTLS g " +
//              "WHERE g.DISB_DATE = ( " +
//              "  SELECT MIN(d.DISB_DATE) " +
//              "  FROM GP_GREEN_LOAN_DTLS d " +
//              "  WHERE d.ACCOUNT_NUMBER = g.ACCOUNT_NUMBER " +
//              ")", nativeQuery = true)
//List<LoanDetails> findFirstDisbursementPerAccount();

	  @Query(value = "SELECT * FROM GP_GREEN_LOAN_DTLS WHERE ACCOUNT_NUMBER = :acct ORDER BY DISB_DATE ASC",nativeQuery = true)
	  List<LoanDetails> findByAccountNumberOrderByDateOfAmountDisbursementAsc(@Param("acct") String acct);
//	-------------------------------------------------------------------------------------------------------------------------------------  
//	  @Query(value = "SELECT account_number,AGGREGATE_DISBURSEMENT_AMOUNT,disb_amt,PREPAID_DATE, PREPAID_AMT FROM GP_GREEN_LOAN_DTLS WHERE ACCOUNT_NUMBER = :acct ORDER BY DISB_DATE ASC",nativeQuery = true)
//	  List<LoanDetails> findByAccountNumberOrderByDateOfAmountDisbursementAsc(@Param("acct") String acct);
	  
	  @Query(value = "SELECT * FROM GP_GREEN_LOAN_DTLS " +
              "WHERE ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'YYYY-MM-DD') " +
              "AND TO_DATE(:todate, 'YYYY-MM-DD')",
      nativeQuery = true)
List<LoanDetails> fetchLoanDateWise(@Param("fromdate") String fromdate,
                                   @Param("todate") String todate);


///-----------------------------------------------------------------------------------------------------------------------//
//	  @Query(value="SELECT ACCOUNT_SEGMENT AS accountSegment, COUNT(*) AS count " +
//"FROM GP_GREEN_LOAN_DTLS GROUP BY ACCOUNT_SEGMENT", nativeQuery= true)
//	  List<LoanChartDTO> fetchLoanData(); 
	//-------------------------------------the above working below tryong-----------------------------------------------------------  
	
//	  
//	  @Query(value="SELECT ACCOUNT_SEGMENT AS accountSegment, SUM(OUTSTANDING_AMOUNT)/10000000 AS count FROM GP_GREEN_LOAN_DTLS GROUP BY ACCOUNT_SEGMENT", nativeQuery= true)
//   List<LoanChartDTO> fetchLoanData();
	  
//     march 
//	  @Query(value="SELECT ACCOUNT_SEGMENT AS accountSegment,  SUM(OUTSTANDING_AMOUNT*(-1))/10000000 AS count   FROM GP_GREEN_LOAN_DTLS    WHERE ACCOUNT_SEGMENT NOT IN ('STAFF', 'RETAIL_LABOD', 'MSME_LABOD', 'LCB_LABOD')   GROUP BY ACCOUNT_SEGMENT", nativeQuery= true)
//List<LoanChartDTO> fetchLoanData();
	  
	  
	  @Query(value = "SELECT ACCOUNT_SEGMENT AS accountSegment, " +
              "SUM(OUTSTANDING_AMOUNT * -1)/10000000 AS count " +
              "FROM GP_GREEN_LOAN_DTLS " +
              "WHERE ACCOUNT_SEGMENT NOT IN ('STAFF', 'RETAIL_LABOD', 'MSME_LABOD', 'LCB_LABOD') " +
              "AND ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') " +
              "AND TO_DATE(:todate, 'DD-MM-YYYY') " +
              "GROUP BY ACCOUNT_SEGMENT " +
              "ORDER BY ACCOUNT_SEGMENT", nativeQuery = true)
List<LoanChartDTO> fetchLoanData(@Param("fromdate") String fromdate,
                                @Param("todate") String todate);


//  @Query(value="SELECT ACCOUNT_SEGMENT AS accountSegment, COUNT(*) AS count " +
//        "FROM GP_GREEN_LOAN_DTLS  WHERE ACCOUNT_SEGMENT NOT IN ('STAFF', 'RETAIL_LABOD', 'MSME_LABOD', 'LCB_LABOD')  GROUP BY ACCOUNT_SEGMENT", nativeQuery= true)
//  List<SegmentChartDTO> fetchSegmentData();
	  
	  
	  @Query(value = "SELECT ACCOUNT_SEGMENT AS accountSegment, COUNT(*) AS count " +
              "FROM GP_GREEN_LOAN_DTLS " +
              "WHERE ACCOUNT_SEGMENT NOT IN ('STAFF', 'RETAIL_LABOD', 'MSME_LABOD', 'LCB_LABOD') " +
              "AND ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
              "GROUP BY ACCOUNT_SEGMENT " +
              "ORDER BY ACCOUNT_SEGMENT", nativeQuery = true)
List<SegmentChartDTO> fetchSegmentData(@Param("fromdate") String fromdate,
                                      @Param("todate") String todate);

  
  
//  @Query(value = "SELECT SCHM_CODE AS schemeCode, ACTIVITY_CODE AS activityCode, COUNT(*) AS count " +
//          "FROM GP_GREEN_LOAN_DTLS GROUP BY SCHM_CODE, ACTIVITY_CODE", nativeQuery = true)
//List<SchemeActivityChartDTO> fetchSchemeActivityData();
  
//  @Query(value = "SELECT ACTIVITY_CODE AS activityCode, COUNT(*) AS count " +
//          "FROM GP_GREEN_LOAN_DTLS GROUP BY ACTIVITY_CODE", nativeQuery = true)
//List<SchemeActivityChartDTO> fetchSchemeActivityData();

	  
	  @Query(value = "SELECT ACTIVITY_CODE AS activityCode, SUM(OUTSTANDING_AMOUNT * -1)/10000000 AS count " +
              "FROM GP_GREEN_LOAN_DTLS " +
              "WHERE ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') " +
              "AND TO_DATE(:todate, 'DD-MM-YYYY') " +
              "GROUP BY ACTIVITY_CODE " +
              "ORDER BY ACTIVITY_CODE", nativeQuery = true)
List<SchemeActivityChartDTO> fetchSchemeActivityData(@Param("fromdate") String fromdate,
                                                    @Param("todate") String todate);


//
//  @Query(value = "SELECT TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY') AS year, " +
//          "TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') AS month, " +
//          "SUM(SUM(OUTSTANDING_AMOUNT)/10000000*(-1)) OVER (ORDER BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM')) AS cumulativeAmount " +
//          "FROM GP_GREEN_LOAN_DTLS " +
//          "WHERE ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') " +
//          "AND TO_DATE(:todate, 'DD-MM-YYYY') " +
//          "GROUP BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') " +
//          "ORDER BY year, month",
//  nativeQuery = true)
//List<LineChartDTO> fetchCumulativeMonthlyLoanData(@Param("fromdate") String fromdate,
//                                             @Param("todate") String todate);

  @Query(value = "SELECT TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY') AS year, " +
          "TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') AS month, " +
          "SUM(SUM(OUTSTANDING_AMOUNT)/10000000 * -1) OVER (ORDER BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM')) AS cumulativeAmount " +
          "FROM GP_GREEN_LOAN_DTLS " +
          "WHERE ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') " +
          "AND TO_DATE(:todate, 'DD-MM-YYYY') " +
          "GROUP BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') " +
          "ORDER BY year, month", nativeQuery = true)
List<LineChartDTO> fetchCumulativeMonthlyLoanData(@Param("fromdate") String fromdate,
                                             @Param("todate") String todate);


  }

//	  @Query(value = "SELECT * FROM GP_GREEN_LOAN_DTLS " + 
//	  "WHERE ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YY') " + "AND TO_DATE(:todate, 'DD-MM-YY')", 
//	  nativeQuery = true) List<LoanDetails> fetchLoanDateWise(@Param("todate") String todate, @Param("fromdate") String fromdate); }