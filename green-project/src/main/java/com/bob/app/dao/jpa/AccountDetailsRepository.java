package com.bob.app.dao.jpa;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bob.app.bean.AccountDetails;


@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
    
	@Query("SELECT accountNo FROM AccountDetails")
	List<String> findAllAccountNumber();
}
