package com.bob.app.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bob.app.bean.NcgtcMaster;

@Repository
public interface NcgtcRepository extends JpaRepository<NcgtcMaster,Long>{
	

List<NcgtcMaster> findByReportDate(String reportDate);

NcgtcMaster findByRefNo(String refNo);

@Query("SELECT DISTINCT s.reportDate FROM NcgtcMaster s ")
List<String> findByReportDate1();

}