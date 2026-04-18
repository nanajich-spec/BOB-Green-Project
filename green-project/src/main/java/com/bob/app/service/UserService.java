package com.bob.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.app.bean.User;
import com.bob.app.dao.jpa.AccountNumRepository;
import com.bob.app.dao.jpa.UserRepository;

@Service
public class UserService {
	
	  @Autowired
	  private UserRepository userRepository;
	
//	public String deleteUser(String userid, String modifiedBy) {
//        User user = userRepository.findByUserid(userid);
//        if (user != null) {
//            user.setEnable("N");
//            user.setModifiedBy(modifiedBy); // Log the user performing the operation
//            user.setModifiedOn(LocalDateTime.now()); // Set the modification timestamp
//            userRepository.save(user);
//            return "User disabled successfully.";
//        }
//        return "User not found.";
//    }
// 
// 
//public String enableUser(String userid, String modifiedBy) {
//        User user = userRepository.findByUserid(userid);
//        if (user != null) {
//            user.setEnable("Y");
//            user.setModifiedBy(modifiedBy); // Log the user performing the operation
//            user.setModifiedOn(LocalDateTime.now()); // Set the modification timestamp
//            userRepository.save(user);
//            return "User enabled successfully.";
//        }
//        return "User not found.";
//    }
 
 
// Get users wi all verify  
    public List<User> getUsersToVerify() {
        return userRepository.findAll();
    }
 
// Verify a specific user
    @Transactional
    public String verifyUser(String userId, String verifiedBy, String designation, String verifiedOn, String Enable, String verifyRemark) {
        if (designation.equalsIgnoreCase("CLERK.CLERK.CL")) {
            return "Only users with higher designations than Clerk can verify data.";
        }
     
        User user = userRepository.findByUserid(userId);
     
        if (user == null) {
            return "User not found.";
        }
     
        // Check if addedBy and verifiedBy are the same
        if (user.getAddedBy().equals(verifiedBy)) {
            return "You cannot verify the data uploaded by yourself.";
        }
     
        if ("N".equals(user.getVerified())) {
            user.setVerified("Y");
            user.setVerifiedBy(verifiedBy); // Set the logged-in user ID
            user.setVerifiedOn(LocalDateTime.now()); // Set the verification timestamp
//            user.setEnable("Y");
     
            userRepository.save(user);
            return "User verified successfully.";
        } else {
            return "User is already verified.";
        }
    }

}
