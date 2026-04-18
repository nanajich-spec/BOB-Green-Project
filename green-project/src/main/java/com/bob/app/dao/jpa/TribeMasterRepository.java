package com.bob.app.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bob.app.bean.TribeMaster;

import java.util.List;
import java.util.Optional;

@Repository
public interface TribeMasterRepository extends JpaRepository<TribeMaster, Long> {
    
	@Transactional
	@Query(value="select state, sum(PHASE_BUDGET) as total_budget from tb_tribe_master group by state",nativeQuery= true)
	List<Object[]> findPhaseBudgetSumByState();
	
	
	@Transactional
	@Query(value="select schoolId, sum(PHASE_BUDGET) as total_budget from tb_tribe_master group by schoolId",nativeQuery= true)
	List<Object[]> findPhaseBudgetSumBySchoolID();
	
	
	@Transactional
	@Query(value="\r\n" + 
			"SELECT\r\n" + 
			"    STATE,\r\n" + 
			"    COUNT(DISTINCT SCHOOL_ID) AS no_of_emrs,\r\n" + 
			"    SUM(CASE WHEN PHASE = 'P1' THEN 1 ELSE 0 END) AS p1_count,\r\n" + 
			"    SUM(CASE WHEN PHASE = 'P2' THEN 1 ELSE 0 END) AS p2_count,\r\n" + 
			"    SUM(CASE WHEN PHASE = 'SP' THEN 1 ELSE 0 END) AS sp_count\r\n" + 
			"FROM\r\n" + 
			"    TB_TRIBE_MASTER\r\n" + 
			"GROUP BY\r\n" + 
			"    STATE",nativeQuery= true)
	List<Object[]> getReportData();
}