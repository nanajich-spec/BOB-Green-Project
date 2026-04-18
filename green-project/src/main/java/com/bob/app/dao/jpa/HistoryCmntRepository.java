package com.bob.app.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bob.app.bean.AccountNum;
import com.bob.app.bean.CmntHistory;

public interface HistoryCmntRepository extends JpaRepository<CmntHistory, Long> {

}
