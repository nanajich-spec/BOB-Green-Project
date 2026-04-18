package com.bob.app.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.app.dao.jpa.AccountStatementRepository;



@Service
public class AccountStatementService {
	

    @Autowired
    private AccountStatementRepository accountStatementRepository;

    public List<Map<String, Object>> getDebitTransactionSums() {
        List<Object[]> results = accountStatementRepository.getSumOfDebitTransactionsGroupedByAccountNumber();

        List<Map<String, Object>> response = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("AccountNumber", result[0]);
            map.put("TotalDebitAmount", result[1]);
            response.add(map);
        }
        return response;
    }
}