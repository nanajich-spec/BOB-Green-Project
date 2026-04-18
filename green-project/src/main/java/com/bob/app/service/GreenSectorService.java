package com.bob.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.app.bean.AccountNum;
import com.bob.app.bean.GreenSector;
import com.bob.app.dao.jpa.AccountNumRepository;
import com.bob.app.dao.jpa.GreenSectorRepository;
import com.bob.app.dto.AccountDTO;

@Service
public class GreenSectorService {


	  @Autowired
	  private GreenSectorRepository greenSectorRepository ;
	  
	  public List<GreenSector> getUserBySector(String sector) {
	    	List<GreenSector> accountNumb= greenSectorRepository.findBySector(sector);
	    	//Optional<GreenSector> sectorid= greenSectorRepository.findById(id);
	    	System.out.println("Fetching user with sector: " + sector);
	        return accountNumb;
	    }
//	  public GreenSector UpdateCmnt(Long id) {
//		  GreenSector greenSector= greenSectorRepository.findById(id);
//			 if (greenSector == null) {
//		            throw new RuntimeException("Account Number " + id + " not found");
//		        }
//	  
//	  public int updateCmnt(Long id, String Cmnt) {
//		  return greenSectorRepository.updateCmntById(id,Cmnt);
//	  }
//	
	  }

