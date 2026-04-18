package com.bob.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.app.bean.NcgtcMaster;
import com.bob.app.dao.jpa.NcgtcRepository;
import com.google.common.base.Predicate;


@Service
public class NcgtcService {

	@Autowired
	private NcgtcRepository ncgtcRepository;
	
	
	public NcgtcMaster saveMerchant(NcgtcMaster ncgtc) {
		return ncgtcRepository.save(ncgtc);
	}
	
	public NcgtcMaster saveBorrowerDetails(NcgtcMaster ncgtc) {
		return ncgtcRepository.save(ncgtc);
		}
	
    public List<NcgtcMaster> getAllNcgtc() {
        return ncgtcRepository.findAll();
    }
    

    public List<NcgtcMaster> getNcgtcByReportDate(String reportDate) {
    return ncgtcRepository.findByReportDate(reportDate);
    }
    public NcgtcMaster getBorrowerDetailsByRefNo(String refNo) {
    	return ncgtcRepository.findByRefNo(refNo);
    	}


//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<NcgtcMaster> getFilteredNcgtcData(String zoneAlpha, String regionName, String branchName, String date) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<NcgtcMaster> query = cb.createQuery(NcgtcMaster.class);
//        Root<NcgtcMaster> root = query.from(NcgtcMaster.class);
//
//
//List<Predicate> predicates = new ArrayList<>();
//
//
//        if (zoneAlpha != null && !zoneAlpha.isEmpty()) {
//            predicates.add(cb.equal(root.get("zoneAlpha"), zoneAlpha));
//        }
//        if (regionName != null && !regionName.isEmpty()) {
//            predicates.add(cb.equal(root.get("regionName"), regionName)); // changed from regionAlpha
//        }
//        if (branchName != null && !branchName.isEmpty()) {
//            predicates.add(cb.equal(root.get("branchName"), branchName)); // changed from brAlpha
//        }
//        if (date != null && !date.isEmpty()) {
//            predicates.add(cb.equal(root.get("reportDate"), date));
//        }
//
//        query.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
//        return entityManager.createQuery(query).getResultList();
//    }

   

    
}