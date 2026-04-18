package com.bob.app.service;
 
import com.bob.app.dao.jpa.StudentRegRepository;
import com.bob.app.bean.*;
import com.bob.app.dao.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
 
@Service
public class UploadService {
	
	@Autowired
	private StudentRegRepository studentRegRespository;
	
//	public Student uploadFile(String email, MultipartFile Stufile) throws Exception {
//		Student upload = new Student();
//		upload.setEmail(email);
//		//upload.setFiletype(filetype);
//		upload.setFileName(Stufile.getOriginalFilename());
//		upload.setStufile(Stufile.getBytes());
//		return studentRegRespository.save(upload);
//	}
//	
//	
//	
	
	public void uploadFile(String email, MultipartFile file) throws IOException {
        // Find the student by email
        Optional<Student> student = studentRegRespository.findByEmail(email);
                            //.orElseThrow(() -> new RuntimeException("Student not found with email: " + email));
        if(student !=null) {
        // Set the file content
        //student.setStuFile(file.getBytes());
 
        // Save the updated student entity
        //studentRegRespository.save(student);
        	System.out.println("File saved");
    }
	else {
		System.out.println("file failed");
	
	}
	
	}}
	
	
	
////	public Upload uploadFile(String customerid,String filetype, MultipartFile file) throws Exception {
////		
////		
////		Optional<Upload> existingRecord= uploadRepository.findByCustomeridAndFiletype(customerid, filetype); 
////		Upload up = existingRecord.get();
////		
////		if(up != null) {
////			up.setFlag("Y");
////			uploadRepository.save(up);
////		}
////		
////		
////		Upload upload = new Upload();
////		upload.setCustomerid(customerid);
////		upload.setFiletype(filetype);
////		upload.setFileName(file.getOriginalFilename());
////		upload.setFile(file.getBytes());
////		upload.setFlag("N");
////		return uploadRepository.save(upload);
////	}
//
//	}
//	}
