package com.bob.app.dao.jpa;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bob.app.bean.AccountStatement;


@Repository
public interface AccountStatementRepository extends JpaRepository<AccountStatement, Long> {
    
	@Query("SELECT accountNo FROM AccountDetails")
	List<String> findAllAccountNumber();

	
	@Transactional
	@Query(value="select account_number, sum(transaction_amount) as debit_amount from tb_account_statement where transaction_type = 'debit' group by account_number;",nativeQuery= true)
	List<Object[]> getSumOfDebitTransactionsGroupedByAccountNumber();
	    
}
