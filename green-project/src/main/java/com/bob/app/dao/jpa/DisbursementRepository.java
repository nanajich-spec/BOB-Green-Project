package com.bob.app.dao.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bob.app.bean.Disbursement;

//public interface DisbursementRepository extends JpaRepository<Disbursement, Long> {
//    List<Disbursement> findByAccountNumber(String accountNumber);
//}
public interface DisbursementRepository extends JpaRepository<Disbursement, Long> {

    @Query(value = "SELECT * FROM GP_GREEN_LOAN_DTLS t WHERE t.FORACID = :acct AND t.DISB_AMT IS NOT NULL", nativeQuery = true)
    List<Disbursement> findDisbursementsByForacid(@Param("acct") String accountNumber);
}