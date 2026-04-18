package com.bob.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//import com.bob.app.api.rest.Upload;
import com.bob.app.bean.Student;
import com.bob.app.dao.jpa.StudentRegRepository;
import com.bob.app.dao.jpa.TribeMasterRepository;

import com.google.common.base.Optional;

@Service
public class StudentService<Upload> {
	
	@Autowired
	private StudentRegRepository studentRegRespository;
	
	public boolean existsByEmail(String email) {
        return studentRegRespository.existsByEmail(email);
    }
 
    public boolean existsByMobile(String phone) {
        return studentRegRespository.existsByPhone(phone);
    }
// public List<Student>getAllUsers(){
//	 return studentRegRespository.findAll();
// }
    
    public boolean authenticate(String email, String password) {
    	Student student= studentRegRespository.findByemail(email);
    	return student != null && student.getPassword().equals(password);
    }

    public Student getStudentByEmail(String email) {
    	Student student= studentRegRespository.findByemail(email);
    	System.out.println("Fetching user with email: " + email);
        return student;
    }
    
//    public String saveUserData(Student student, MultipartFile file) throws IOException {
//        if (file != null && !file.isEmpty()) {
//        //	student.setStuFile(file.getOriginalFilename());
//        	student.setStuFile(file.getBytes());  // Save the file as byte array
//        }
//        studentRegRespository.save(student);  // Save the data in the database
//        return "User data saved successfully";
//    }

	public Upload uploadFile(String email, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	@Override
//	public byte[] getPdfData(String email, String flag) {
//		Optional<Upload> upload = studentRegRespository.findByemailAndFiletype(email,flag);
//		return upload.map(Upload::getFile).orElse(null);
//	}
//	//public Optional<Upload> getPdfFile(Long id) {
//	//	return uploadRepository.findById(id);
//	//}
}
