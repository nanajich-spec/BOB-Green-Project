package com.bob.app.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.bob.app.bean.DepositDetails;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.bob.app.dto.BarChartDTO;
import com.bob.app.dto.DepositLoanLineChartDTO;
import com.bob.app.dto.LoanBarChartDTO;
import com.bob.app.dto.LoanBarChartDailyDTO;

@Repository
public interface ReportRepository extends JpaRepository<DepositDetails, Long> {

//    @Query(value = "SELECT TO_CHAR(NVL(d.month_date, l.month_date), 'YYYY-MM') AS month, " +
//                   "NVL(d.deposit_count, 0) AS depositsCount, " +
//                   "NVL(l.loan_count, 0) AS loansCount " +
//                   "FROM (SELECT TRUNC(ACCOUNTOPENINGDATE, 'MM') AS month_date, COUNT(*) AS deposit_count " +
//                   "      FROM GP_GREEN_DEPOSIT_DETAILS " +
//                   "      WHERE TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') = '2025' " +
//                   "      GROUP BY TRUNC(ACCOUNTOPENINGDATE, 'MM')) d " +
//                   "FULL OUTER JOIN (SELECT TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'MM') AS month_date, COUNT(*) AS loan_count " +
//                   "                 FROM GP_GREEN_LOAN_DTLS " +
//                   "                 WHERE TO_CHAR(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'YYYY') = '2025' " +
//                   "                 GROUP BY TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'MM')) l " +
//                   "ON d.month_date = l.month_date " +
//                   "ORDER BY month", nativeQuery = true)
//    List<DepositLoanChartDTO> fetchMonthlyDepositLoanData();
//    

//	@Query(value = "SELECT TO_CHAR(DISB_DATE, 'YYYY') AS year, " +
//            "TO_CHAR(DISB_DATE, 'MM') AS month, " +
//            "SUM(OUTSTANDING_AMOUNT)/10000000 AS entryCount " +
//            "FROM GP_GREEN_DEPOSIT_DETAILS " +
//            "WHERE DISB_DATE BETWEEN TO_DATE(:todate, 'DD-MM-YYYY') AND TO_DATE(:fromdate, 'DD-MM-YYYY') " +
//            "GROUP BY TO_CHAR(DISB_DATE, 'YYYY'), TO_CHAR(DISB_DATE, 'MM') " +
//            "ORDER BY year, month", nativeQuery = true)
//List<LoanBarChartDTO> fetchMonthlyLoanData(@Param("todate") String todate,
//                                        @Param("fromdate") String fromdate);

//	@Query(value = "SELECT TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') AS year, "
//			+ "TO_CHAR(ACCOUNTOPENINGDATE, 'MM') AS month, " + "SUM(OUTSTANDING_AMOUNT)/10000000 AS entryCount "
//			+ "FROM GP_GREEN_DEPOSIT_DETAILS "
//			+ "WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:todate, 'DD-MM-YYYY') AND TO_DATE(:fromdate, 'DD-MM-YYYY') "
//			+ "GROUP BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM') "
//			+ "ORDER BY year, month", nativeQuery = true)
//	List<BarChartDTO> fetchMonthlyDepositData(@Param("todate") String todate, @Param("fromdate") String fromdate);
//
//
//	@Query(value = "SELECT TO_CHAR(DISB_DATE, 'YYYY') AS year, " + "TO_CHAR(DISB_DATE, 'MM') AS month, "
//			+ "SUM(OUTSTANDING_AMOUNT)/10000000 AS entryCount " + "FROM GP_GREEN_LOAN_DTLS "
//			+ "WHERE DISB_DATE BETWEEN TO_DATE(:todate, 'DD-MM-YYYY') AND TO_DATE(:fromdate, 'DD-MM-YYYY') "
//			+ "GROUP BY TO_CHAR(DISB_DATE, 'YYYY'), TO_CHAR(DISB_DATE, 'MM') "
//			+ "ORDER BY year, month", nativeQuery = true)
//	List<LoanBarChartDTO> fetchMonthlyLoanData(@Param("todate") String todate, @Param("fromdate") String fromdate);
//
//	@Query(value = "SELECT TO_CHAR(TRUNC(DISB_DATE), 'dd-MM-yyyy') AS entryDate, "
//			+ "SUM(OUTSTANDING_AMOUNT) AS entryCount " + "FROM GP_GREEN_LOAN_DTLS "
//			+ "WHERE TO_CHAR(DISB_DATE, 'MM') = LPAD(:month, 2, '0') " + "AND TO_CHAR(DISB_DATE, 'YYYY') = :year "
//			+ "GROUP BY TRUNC(DISB_DATE) " + "ORDER BY entryDate", nativeQuery = true)
//	List<LoanBarChartDailyDTO> fetchDateWiseLoanData(@Param("month") String month, @Param("year") String year);
	
//	@Query(value = "SELECT TO_CHAR(NVL(d.month_date, l.month_date), 'YYYY-MM') AS month, " +
//            "NVL(d.deposit_count, 0) AS depositsCount, " +
//            "NVL(l.loan_count, 0) AS loansCount " +
//            "FROM (SELECT TRUNC(ACCOUNTOPENINGDATE, 'MM') AS month_date, " +
//            "             SUM(OUTSTANDING_AMOUNT)/10000000 AS deposit_count " +
//            "      FROM GP_GREEN_DEPOSIT_DETAILS " +
//            "      WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:todate, 'DD-MM-YYYY') AND TO_DATE(:fromdate, 'DD-MM-YYYY') " +
//            "      GROUP BY TRUNC(ACCOUNTOPENINGDATE, 'MM')) d " +
//            "FULL OUTER JOIN (SELECT TRUNC(DISB_DATE, 'MM') AS month_date, " +
//            "                        SUM(OUTSTANDING_AMOUNT)/10000000 AS loan_count " +
//            "                 FROM GP_GREEN_LOAN_DTLS " +
//            "                 WHERE DISB_DATE BETWEEN TO_DATE(:todate, 'DD-MM-YYYY') AND TO_DATE(:fromdate, 'DD-MM-YYYY') " +
//            "                 GROUP BY TRUNC(DISB_DATE, 'MM')) l " +
//            "ON d.month_date = l.month_date " +
//            "ORDER BY month", nativeQuery = true)
//List<LoanBarChartDTO> fetchMonthlyDepositLoanData(@Param("todate") String todate,
//                                                   @Param("fromdate") String fromdate);
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//	@Query(value = "SELECT TO_CHAR(NVL(d.month_date, l.month_date), 'YYYY-MM') AS month, " +
//	        "NVL(d.deposit_count, 0) AS depositsCount, " +
//	        "NVL(l.loan_count, 0) AS loansCount " +
//	        "FROM (SELECT TRUNC(ACCOUNTOPENINGDATE, 'MM') AS month_date, " +
//	        "             SUM(OUTSTANDING_AMOUNT)/10000000 AS deposit_count " +
//	        "      FROM GP_GREEN_DEPOSIT_DETAILS " +
//	        "      WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
//	        "      GROUP BY TRUNC(ACCOUNTOPENINGDATE, 'MM')) d " +
//	        "FULL OUTER JOIN (SELECT TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'MM') AS month_date, " +
//	        "                        SUM(OUTSTANDING_AMOUNT*(-1))/10000000 AS loan_count " +
//	        "                 FROM GP_GREEN_LOAN_DTLS " +
//	        "                 WHERE TO_DATE(DISB_DATE, 'YYYY-MM-DD') BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
//	        "                 GROUP BY TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'MM')) l " +
//	        "ON d.month_date = l.month_date " +
//	        "ORDER BY month", nativeQuery = true)
//	List<LoanBarChartDTO> fetchMonthlyDepositLoanData(@Param("fromdate") String fromdate,
//	                                                  @Param("todate") String todate);
//	
	
	
	
	@Query(value = "SELECT TO_CHAR(NVL(d.month_date, l.month_date), 'YYYY-MM') AS month, " +
            "NVL(d.deposit_count, 0) AS depositsCount, " +
            "NVL(l.loan_count, 0) AS loansCount " +
            "FROM (SELECT TRUNC(ACCOUNTOPENINGDATE, 'MM') AS month_date, " +
            "             SUM(OUTSTANDING_AMOUNT)/10000000 AS deposit_count " +
            "      FROM GP_GREEN_DEPOSIT_DETAILS " +
            "      WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
            "      GROUP BY TRUNC(ACCOUNTOPENINGDATE, 'MM')) d " +
            "FULL OUTER JOIN (SELECT TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'MM') AS month_date, " +
            "                        SUM(OUTSTANDING_AMOUNT * -1)/10000000 AS loan_count " +
            "                 FROM GP_GREEN_LOAN_DTLS " +
            "                 WHERE TO_DATE(DISB_DATE, 'YYYY-MM-DD') BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
            "                 GROUP BY TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'MM')) l " +
            "ON d.month_date = l.month_date " +
            "ORDER BY month", nativeQuery = true)
List<LoanBarChartDTO> fetchMonthlyDepositLoanData(@Param("fromdate") String fromdate,
                                               @Param("todate") String todate);


	// Daily deposits vs loans (for given month/year)
//	@Query(value = "SELECT TO_CHAR(NVL(d.day_date, l.day_date), 'dd-MM-yyyy') AS entryDate, " +
//            "NVL(d.deposit_count, 0) AS depositsCount, " +
//            "NVL(l.loan_count, 0) AS loansCount " +
//            "FROM (SELECT TRUNC(ACCOUNTOPENINGDATE) AS day_date, SUM(OUTSTANDING_AMOUNT)10000000  AS deposit_count " +
//            "      FROM GP_GREEN_DEPOSIT_DETAILS " +
//            "      WHERE TO_CHAR(ACCOUNTOPENINGDATE, 'MM') = LPAD(:month, 2, '0') " +
//            "        AND TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') = :year " +
//            "      GROUP BY TRUNC(ACCOUNTOPENINGDATE)) d " +
//            "FULL OUTER JOIN (SELECT TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD')) AS day_date,   SUM(OUTSTANDING_AMOUNT)/10000000 AS loan_count " +
//            "                 FROM GP_GREEN_LOAN_DTLS " +
//            "                 WHERE TO_CHAR(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'MM') = LPAD(:month, 2, '0') " +
//            "                   AND TO_CHAR(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'YYYY') = :year " +
//            "                 GROUP BY TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD'))) l " +
//            "ON d.day_date = l.day_date " +
//            "ORDER BY entryDate", nativeQuery = true)
//List<LoanBarChartDailyDTO> fetchDailyDepositLoanData(@Param("month") String month,
//                                                      @Param("year") String year);
	
	


    @Query(value = "SELECT TO_CHAR(NVL(d.day_date, l.day_date), 'dd-MM-yyyy') AS entryDate, " +
          "NVL(d.deposit_count, 0) AS depositsCount, " +
          "NVL(l.loan_count, 0) AS loansCount " +
          "FROM (SELECT TRUNC(ACCOUNTOPENINGDATE) AS day_date, SUM(OUTSTANDING_AMOUNT)/10000000  AS deposit_count " +
          "      FROM GP_GREEN_DEPOSIT_DETAILS " +
          "      WHERE TO_CHAR(ACCOUNTOPENINGDATE, 'MM') = LPAD(:month, 2, '0') " +
          "        AND TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') = :year " +
          "      GROUP BY TRUNC(ACCOUNTOPENINGDATE)) d " +
          "FULL OUTER JOIN (SELECT TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD')) AS day_date,   SUM(OUTSTANDING_AMOUNT * -1)/10000000 AS loan_count " +
          "                 FROM GP_GREEN_LOAN_DTLS " +
          "                 WHERE TO_CHAR(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'MM') = LPAD(:month, 2, '0') " +
          "                   AND TO_CHAR(TO_DATE(DISB_DATE, 'YYYY-MM-DD'), 'YYYY') = :year " +
          "                 GROUP BY TRUNC(TO_DATE(DISB_DATE, 'YYYY-MM-DD'))) l " +
          "ON d.day_date = l.day_date " +
          "ORDER BY entryDate", nativeQuery = true)
List<LoanBarChartDailyDTO> fetchDailyDepositLoanData(@Param("month") String month,
                                                    @Param("year") String year);


//@Query(value = "SELECT d.year, d.month, d.cumulativeAmount AS cumulativeDepositAmount, " +
//        "l.cumulativeAmount AS cumulativeLoanAmount " +
//        "FROM ( " +
//        "   SELECT TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') AS year, " +
//        "          TO_CHAR(ACCOUNTOPENINGDATE, 'MM') AS month, " +
//        "          SUM(SUM(OUTSTANDING_AMOUNT)/10000000) OVER (ORDER BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM')) AS cumulativeAmount " +
//        "   FROM GP_GREEN_DEPOSIT_DETAILS " +
//        "   WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
//        "   GROUP BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM') " +
//        ") d " +
//        "FULL OUTER JOIN ( " +
//        "   SELECT TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY') AS year, " +
//        "          TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') AS month, " +
//        "          SUM(SUM(OUTSTANDING_AMOUNT)/10000000) OVER (ORDER BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM')) AS cumulativeAmount " +
//        "   FROM GP_GREEN_LOAN_DTLS " +
//        "   WHERE ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
//        "   GROUP BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') " +
//        ") l " +
//        "ON d.year = l.year AND d.month = l.month " +
//        "ORDER BY d.year, d.month",
//        nativeQuery = true)
//List<DepositLoanLineChartDTO> fetchCumulativeDepositVsLoanData(@Param("fromdate") String fromdate,
//                                                             @Param("todate") String todate);




//                  march-----------------------------------------

//	    @Query(value = "SELECT d.year, d.month, d.cumulativeAmount AS cumulativeDeposit, " +
//	                   "       l.cumulativeAmount AS cumulativeLoan " +
//	                   "FROM ( " +
//	                   "    SELECT TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') AS year, " +
//	                   "           TO_CHAR(ACCOUNTOPENINGDATE, 'MM') AS month, " +
//	                   "           SUM(SUM(OUTSTANDING_AMOUNT)/10000000) " +
//	                   "             OVER (ORDER BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM')) AS cumulativeAmount " +
//	                   "    FROM gp_green_deposit_details " +
//	                   "    WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
//	                   "    GROUP BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM') " +
//	                   ") d " +
//	                   "FULL OUTER JOIN ( " +
//	                   "    SELECT TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY') AS year, " +
//	                   "           TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') AS month, " +
//	                   "           SUM(SUM(OUTSTANDING_AMOUNT*(-1))/10000000) " +
//	                   "             OVER (ORDER BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM')) AS cumulativeAmount " +
//	                   "    FROM gp_green_loan_dtls " +
//	                   "    WHERE ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
//	                   "    GROUP BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') " +
//	                   ") l " +
//	                   "ON d.year = l.year AND d.month = l.month " +
//	                   "ORDER BY d.year, d.month",
//	           nativeQuery = true)
//	    List<DepositLoanLineChartDTO> fetchDepositVsLoanData(@Param("fromdate") String fromdate,
//	                                                         @Param("todate") String todate);
	
	@Query(value = "SELECT d.year, d.month, d.cumulativeAmount AS cumulativeDeposit, " +
            "       l.cumulativeAmount AS cumulativeLoan " +
            "FROM ( " +
            "    SELECT TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') AS year, " +
            "           TO_CHAR(ACCOUNTOPENINGDATE, 'MM') AS month, " +
            "           SUM(SUM(OUTSTANDING_AMOUNT)/10000000) " +
            "             OVER (ORDER BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM')) AS cumulativeAmount " +
            "    FROM gp_green_deposit_details " +
            "    WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
            "    GROUP BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM') " +
            ") d " +
            "FULL OUTER JOIN ( " +
            "    SELECT TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY') AS year, " +
            "           TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') AS month, " +
            "           SUM(SUM(OUTSTANDING_AMOUNT * -1)/10000000) " +
            "             OVER (ORDER BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM')) AS cumulativeAmount " +
            "    FROM gp_green_loan_dtls " +
            "    WHERE ACCOUNT_OPENED_DATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
            "    GROUP BY TO_CHAR(ACCOUNT_OPENED_DATE, 'YYYY'), TO_CHAR(ACCOUNT_OPENED_DATE, 'MM') " +
            ") l " +
            "ON d.year = l.year AND d.month = l.month " +
            "ORDER BY d.year, d.month",
    nativeQuery = true)
List<DepositLoanLineChartDTO> fetchDepositVsLoanData(@Param("fromdate") String fromdate,
                                                  @Param("todate") String todate);

	
	}







