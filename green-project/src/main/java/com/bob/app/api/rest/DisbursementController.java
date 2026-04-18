package com.bob.app.api.rest;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.bob.app.dto.DisbursementDto;
import com.bob.app.service.DisbursementService;

@RestController
@RequestMapping("/green-project/api/v1")
public class DisbursementController {

    private final DisbursementService service;

    public DisbursementController(DisbursementService service) {
        this.service = service;
    }

    @GetMapping("/fetchDisbursements/{accountNumber}")
    public List<DisbursementDto> getDisbursements(@PathVariable String accountNumber) {
        return service.getByAccountNumber(accountNumber);
    }
}
