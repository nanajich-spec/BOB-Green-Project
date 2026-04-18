package com.bob.app.dao.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bob.app.bean.DepositDetails;
import com.bob.app.bean.LoanDetails;
import com.bob.app.dto.PieChartDTO;
import com.bob.app.dto.BarChartDTO;
import com.bob.app.dto.BarChartDailyDTO;
import com.bob.app.dto.LineChartDTO;

@Repository
public interface DepositDetailsRepository extends JpaRepository<DepositDetails, Long>{
	
	
//	   @Query(value="select * from GP_Green_Deposit_Details  where Scheme_Code= :SchemeCode", nativeQuery= true)
//	  List<DepositDetails> findByschemeCode(@Param("SchemeCode") String SchemeCode);
	
	//@Query(value="select * from GP_Green_Deposit_Details ", nativeQuery=true)

	   List<DepositDetails>findAll();
	   
	   @Query(value="select * from GP_Green_Deposit_Details  where ACCOUNTOPENINGDATE between TO_DATE( :todate,'dd-mm-yy') and TO_DATE( :fromdate,'dd-mm-yy')", nativeQuery= true)
		 List<DepositDetails> fetchDateWise(@Param("todate") String todate,@Param("fromdate") String fromdate);

//	   @Query(value="SELECT schemecode, sum(OUTSTANDING_AMOUNT)/ 10000000 AS count FROM gp_green_Deposit_Details GROUP BY schemecode", nativeQuery= true)
//		 List<PieChartDTO> fetchDepositData();
	   
	   
	   @Query(value = "SELECT schemecode, SUM(OUTSTANDING_AMOUNT)/10000000 AS count " +
               "FROM gp_green_deposit_details " +
               "WHERE TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') = :startYear " +
               "GROUP BY schemecode",
       nativeQuery = true)
List<PieChartDTO> fetchDepositData(@Param("startYear") String startYear);






	   //mar2
//	   @Query(value = "SELECT TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') AS year, TO_CHAR(ACCOUNTOPENINGDATE, 'MM') AS month, SUM(SUM(OUTSTANDING_AMOUNT)/10000000) OVER (ORDER BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM')) AS cumulativeAmount FROM gp_green_deposit_details WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:todate, 'DD-MM-YYYY') AND TO_DATE(:fromdate, 'DD-MM-YYYY') GROUP BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM') ORDER BY year, month", nativeQuery = true)
//			List<LineChartDTO> fetchCumulativeMonthlyDepositData(@Param("todate") String todate, @Param("fromdate") String fromdate);
	   
	   
	   @Query(value = "SELECT TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') AS year, " +
               "TO_CHAR(ACCOUNTOPENINGDATE, 'MM') AS month, " +
               "SUM(SUM(OUTSTANDING_AMOUNT)/10000000) OVER (ORDER BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM')) AS cumulativeAmount " +
               "FROM gp_green_deposit_details " +
               "WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') " +
               "GROUP BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM') " +
               "ORDER BY year, month", nativeQuery = true)
List<LineChartDTO> fetchCumulativeMonthlyDepositData(@Param("fromdate") String fromdate,
                                                     @Param("todate") String todate);


	  
	// @Query(value = "SELECT TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') AS year,TO_CHAR(ACCOUNTOPENINGDATE, 'MM')   AS month, COUNT(*) AS entryCount FROM gp_green_deposit_details WHERE TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') = '2025' GROUP BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM') ORDER BY year, month", nativeQuery = true)
//	   @Query(value = "SELECT TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') AS year,TO_CHAR(ACCOUNTOPENINGDATE, 'MM') AS month,sum(OUTSTANDING_AMOUNT)/ 10000000 AS entryCount FROM gp_green_deposit_details WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:todate, 'DD-MM-YYYY') AND TO_DATE(:fromdate, 'DD-MM-YYYY') GROUP BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM') ORDER BY year, month", nativeQuery = true)
//	   List<BarChartDTO> fetchMonthlyDepositData(@Param("todate") String todate,@Param("fromdate") String fromdate);
//	   
	   
	   @Query(value = "SELECT TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') AS year, TO_CHAR(ACCOUNTOPENINGDATE, 'MM') AS month, SUM(OUTSTANDING_AMOUNT)/10000000 AS entryCount FROM gp_green_deposit_details WHERE ACCOUNTOPENINGDATE BETWEEN TO_DATE(:fromdate, 'DD-MM-YYYY') AND TO_DATE(:todate, 'DD-MM-YYYY') GROUP BY TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY'), TO_CHAR(ACCOUNTOPENINGDATE, 'MM') ORDER BY year, month", nativeQuery = true)
              List<BarChartDTO> fetchMonthlyDepositData(@Param("fromdate") String fromdate,
                                  @Param("todate") String todate);

	  

	   
	   @Query(value = "SELECT TO_CHAR(TRUNC(ACCOUNTOPENINGDATE), 'dd-MM-yyyy') AS entryDate,SUM(OUTSTANDING_AMOUNT) AS entryCount FROM gp_green_deposit_details WHERE TO_CHAR(ACCOUNTOPENINGDATE, 'MM') = :month AND TO_CHAR(ACCOUNTOPENINGDATE, 'YYYY') = :year GROUP BY TRUNC(ACCOUNTOPENINGDATE) ORDER BY entryDate", nativeQuery = true)
	   List<BarChartDailyDTO> fetchDateWiseDepositData(@Param("month") String month,@Param("year") String year);
	   }




