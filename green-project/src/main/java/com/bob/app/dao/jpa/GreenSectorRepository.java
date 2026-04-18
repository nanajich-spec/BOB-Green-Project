package com.bob.app.dao.jpa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bob.app.bean.AccountNum;
import com.bob.app.bean.GreenSector;

public interface GreenSectorRepository extends JpaRepository<GreenSector, Long>  {
	
//	@Query("select * from GP_GREEN_SECTOR  where sector = ")
//	List<GreenSector>findBySector(@Param("sector") String sector);
  List<GreenSector> findBySector(String sector);
//  GreenSector findById(String id);
//  @Modifying
//  @Transactional
//  @Query("UPDATE GP_Green_Sector g SET g.cmnt = :cmnt where g.id = :id")
// 
//  int updateCmntById(Long id,String cmnt);
//    


}
