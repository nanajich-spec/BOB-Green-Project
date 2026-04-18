//package com.bob.app.dao.jpa;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.bob.app.bean.AccountNum;
//import com.bob.app.bean.GreenFile;
//import com.bob.app.bean.Student;
//import com.bob.app.dto.Phase1DTO;
//
//import io.swagger.v3.oas.annotations.Parameter;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface AccountNumRepository extends JpaRepository<AccountNum, Long> {
//	Optional<AccountNum> findByAccountNumber(String accountNumber);
//
//	AccountNum findByaccountNumber(String accountNumber);
//
//	@Query(value = "select * from GP_GREEN_INFO  where FINAL_FLAG=''", nativeQuery = true)
//	List<AccountNum> findByFinalFlag(String FinalFlag);
//
//	@Query(value = "select * from GP_GREEN_INFO where ACCOUNT_NUMBER=:acct", nativeQuery = true)
//	AccountNum fetchAccountDetails(@Param("acct") String accountNumber);
//
//	List<AccountNum> findByStatus(String Status);
//
//	@Query(value = "select * from GP_GREEN_INFO", nativeQuery = true)
//	List<AccountNum> findAllrecord();
//
//}


package com.bob.app.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bob.app.bean.AccountNum;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountNumRepository extends JpaRepository<AccountNum, Long> {

    // Existing methods
    Optional<AccountNum> findByAccountNumber(String accountNumber);

    AccountNum findByaccountNumber(String accountNumber);
    

    @Query(value = "SELECT * FROM GP_GREEN_INFO WHERE FINAL_FLAG=''", nativeQuery = true)
    List<AccountNum> findByFinalFlag(String FinalFlag);

    @Query(value = "SELECT * FROM GP_GREEN_INFO WHERE ACCOUNT_NUMBER=:acct", nativeQuery = true)
    AccountNum fetchAccountDetails(@Param("acct") String accountNumber);

    List<AccountNum> findByStatus(String Status);

//    @Query(value = "SELECT * FROM GP_GREEN_INFO", nativeQuery = true)
//    List<AccountNum> findAllrecord();
    
    @Query(value = "SELECT * FROM GP_GREEN_INFO where STATUS ='pending'", nativeQuery = true)
    List<AccountNum> findAllrecord();
    
    @Query(value = "SELECT * FROM GP_GREEN_INFO WHERE STATUS = 'Queried By Checker'", nativeQuery = true)
    List<AccountNum> findReturnedRecords();
    
// // ✅ New query for Admin
//    @Query(value = "SELECT * FROM GP_GREEN_INFO WHERE STATUS = 'Queried By Admin'", nativeQuery = true)
//    List<AccountNum> findAdminReturnedRecords();
    
///  --------------------added feb2--------------------------------------//
    // ✅ New method: fetch all account numbers only
//    @Query(value = "SELECT DISTINCT ACCOUNT_NUMBER FROM GP_GREEN_INFO", nativeQuery = true)
//    List<String> findAllAccountNumbers();
//
//    // ✅ New method: fetch all accounts (full objects)
//    @Query(value = "SELECT * FROM GP_GREEN_INFO", nativeQuery = true)
//    List<AccountNum> findAllAccounts();
   //////----------------------------------feb4 adding 
//    @Query(value = "SELECT DISTINCT ACCOUNT_NUMBER FROM GP_GREEN_INFO WHERE SOL_ID = :solId AND STATUS = :status", nativeQuery = true)
//    List<String> findAccountNumbersBySolIdAndStatus(@Param("solId") String solId,
//                                                    @Param("status") String status);
    @Query(value = "SELECT DISTINCT ACCOUNT_NUMBER " + "FROM GP_GREEN_INFO " + 
      "WHERE SOL_ID = :solId " + "AND (:status IS NULL OR STATUS = :status)", nativeQuery = true)
    List<String> findAccountNumbersBySolIdAndStatus(@Param("solId") String solId, @Param("status") String status);
    
//    
   @Query(value = "SELECT * FROM GP_GREEN_INFO where STATUS ='verified'", nativeQuery = true)
   List<AccountNum> findAllrecordAdmin();
    
//    @Query(value = "SELECT * FROM GP_GREEN_INFO where STATUS ='verified '", nativeQuery = true)
//    List<AccountNum> findAllrecordAdmin();
//    
    
}

