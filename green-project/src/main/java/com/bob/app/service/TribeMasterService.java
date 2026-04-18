package com.bob.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.app.dao.jpa.TribeMasterRepository;

@Service
public class TribeMasterService {
	
	@Autowired
	private TribeMasterRepository tribeMasterRepository;
	
	public List<Map<String, Object>> getPhaseBudgetSumByState(){
		List<Object[]> results = tribeMasterRepository.findPhaseBudgetSumByState();
		
		List<Map<String, Object>> response = new ArrayList<>();
		
		for(Object[] result : results) {
			Map<String, Object> map = new HashMap<>();
			map.put("State", result[0]);
			map.put("Total Budget", result[1]);
			response.add(map);
			
			
		}
		return response;
	}
	
	public List<Map<String, Object>> getPhaseBudgetSumBySchoolId(){
		List<Object[]> results = tribeMasterRepository.findPhaseBudgetSumBySchoolID();
		
		List<Map<String, Object>> response = new ArrayList<>();
		
		for(Object[] result : results) {
			Map<String, Object> map = new HashMap<>();
			map.put("School ID", result[0]);
			map.put("Total Budget", result[1]);
			response.add(map);
			
			
		}
		return response;
	}
	
	
	public List<Map<String, Object>> getStateWiseReportData(){
		List<Object[]> results = tribeMasterRepository.getReportData();
		
		List<Map<String, Object>> response = new ArrayList<>();
		
		for(Object[] result : results) {
			Map<String, Object> map = new HashMap<>();
			map.put("State", result[0]);
			map.put("No of EMRS", result[1]);
			map.put("Phase 1 Count", result[2]);
			map.put("Phase 2 Count", result[3]);
			map.put("Single Phase Count", result[4]);
			response.add(map);
			
			
		}
		return response;
	}
	
}