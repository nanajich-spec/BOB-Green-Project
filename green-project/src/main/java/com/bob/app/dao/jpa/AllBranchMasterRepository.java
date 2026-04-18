package com.bob.app.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bob.app.bean.ALL_BRANCH_MASTER;
import com.bob.app.dto.ZoneDTO;




@Repository
public interface AllBranchMasterRepository extends JpaRepository<ALL_BRANCH_MASTER, Long>{

	ALL_BRANCH_MASTER findByBrAlpha(String brAlpha);
	
	ALL_BRANCH_MASTER findByBrSolid(String brSolid);
	
	List<ALL_BRANCH_MASTER> findByRoAlpha(String roAlpha);
	
	List<ALL_BRANCH_MASTER> findByZoAlpha(String zoAlpha);
	

//@Query("SELECT DISTINCT ZoneDTO(s.zoAlpha, s.zoName) FROM ALL_BRANCH_MASTER s ")
//List<ZoneDTO> findDistinctZones(); com.bob.app.dto

	@Query("SELECT DISTINCT new com.bob.app.dto.ZoneDTO(s.zoAlpha, s.zoName) FROM ALL_BRANCH_MASTER s")
	List<ZoneDTO> findDistinctZones();


@Query("SELECT DISTINCT s.zoAlpha FROM ALL_BRANCH_MASTER s")
List<String> findDistinctZoAlphas();



@Query("SELECT DISTINCT s.roName FROM ALL_BRANCH_MASTER s WHERE s.zoAlpha = :zoAlpha")
List<String> findRosByZone(@Param("zoAlpha") String zoAlpha);
	


@Query("SELECT DISTINCT s.branchName FROM ALL_BRANCH_MASTER s WHERE s.roName = :roName")
List<String> findBranchesByRo(@Param("roName") String roName);



	
	@Query(value="select DISTINCT s.zo_alpha from all_branch_master s where s.category='CFS'",nativeQuery= true)
	List<String> findByCategory();
}