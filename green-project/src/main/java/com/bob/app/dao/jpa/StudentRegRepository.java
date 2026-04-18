package com.bob.app.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bob.app.bean.Student;

import java.util.Optional;

@Repository
public interface StudentRegRepository extends JpaRepository<Student, Long> {


    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
    Optional<Student> findByEmail(String email);
    Student findByemail(String email);
  // Optional<Student> findByEmailAndFiletype(String email);
	//Optional<Student> findByEmail(String Customerid);
//Optional<Student> findByEmailAndFiletype(String email);
    public interface studentService {
    	//Optional<Upload> getPdfFile(Long id);
   public byte[] viewPdfData(String email, String flag);
    	public byte[] getPdfData(String email, String flag);
    }
 
}
