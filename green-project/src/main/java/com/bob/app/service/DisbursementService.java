package com.bob.app.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bob.app.bean.Disbursement;
import com.bob.app.dto.DisbursementDto;
import com.bob.app.dao.jpa.DisbursementRepository;

@Service
public class DisbursementService {

    private final DisbursementRepository repo;

    public DisbursementService(DisbursementRepository repo) {
        this.repo = repo;
    }

    public List<DisbursementDto> getByAccountNumber(String accountNumber) {
        List<Disbursement> list = repo.findDisbursementsByForacid(accountNumber);
        return list.stream()
                .map(d -> new DisbursementDto(d.getDisbursementDate(),d.getDisbursementAmount()))
                .collect(Collectors.toList());
    }

}