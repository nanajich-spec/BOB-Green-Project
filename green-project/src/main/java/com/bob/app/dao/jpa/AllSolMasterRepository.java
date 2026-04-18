package com.bob.app.dao.jpa;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.bob.app.bean.ALL_SOL_MASTER;





@Repository
public interface AllSolMasterRepository extends JpaRepository<ALL_SOL_MASTER, Long>{

	ALL_SOL_MASTER findByBrAlpha(String brAlpha);
	
	ALL_SOL_MASTER findByBrSolid(String brSolid);
	
	List<ALL_SOL_MASTER> findByRoAlpha(String roAlpha);
	
	List<ALL_SOL_MASTER> findByZoAlpha(String zoAlpha);
	
	
	
	@Query(value="select DISTINCT s.zo_alpha from all_sol_master s where s.category='CFS'",nativeQuery= true)
	List<String> findByCategory();
}