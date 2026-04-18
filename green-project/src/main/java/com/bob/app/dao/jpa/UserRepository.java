package com.bob.app.dao.jpa;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bob.app.bean.User;



public interface UserRepository extends JpaRepository<User, Long> {
 //   UserRepo findByDomainId(String domainId);
  //@Query("Select userid,password From USERS")
  	 boolean existsByUserid(String userid);
  	  User findByUserid(String userid);
  	  User findBybranchSol(String branchsol);
     // List<User> findByVerify(String verify); // Fetch users where verify is "N"
}
