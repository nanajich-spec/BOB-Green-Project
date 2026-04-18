package com.bob.app.api.rest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import lombok.extern.slf4j.Slf4j;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.bob.app.exception.ResourceNotFoundException;
import com.bob.app.service.StudentService;
import com.bob.app.service.UploadService;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import com.bob.app.bean.*;
import com.bob.app.dao.jpa.*;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RequestMapping("/api2/v2")
//@CrossOrigin(origins = "http://localhost:3000"
public class StudentController {
	

	
	@Autowired
    private StudentRegRepository studentRegRepository;
	
	@Autowired
	private StudentService studentService;
	
	
	
	@PostMapping("custDataSave")
	public ResponseEntity<?> saveData(@RequestBody Student student){
		
		
		
		try {
			 
			  boolean emailExists = studentService.existsByEmail(student.getEmail());
	            boolean mobileExists = studentService.existsByMobile(student.getPhone());
	            if (emailExists || mobileExists) {
	                String errorMessage = "";
	                if (emailExists) {
	                    errorMessage = "Error: Email already exists: " + student.getEmail();
	                }
	                if (mobileExists) {
	                    errorMessage = errorMessage.isEmpty() ? "Error: Mobile number already exists: " + student.getPhone()
	                                                          : errorMessage + ", Mobile number already exists: " + student.getPhone();
	                }
	                // Return a bad request response with the appropriate error message
	                return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	            }
	            else{
//	               
	            	studentRegRepository.save(student);
	    			return ResponseEntity.ok(student);	
	            }
	            
			//log.info("receiving data : "+student);
			//    		saveModel.setCurrStatus(currStatus);
	               
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	

	
	}
	
	@PostMapping("fetchdata")
	public ResponseEntity<?> fetchData(@RequestBody Student student){
		boolean authenticated = studentService.authenticate(student.getEmail(),student.getPassword());
		if(authenticated) {
			Student studentData = studentService.getStudentByEmail(student.getEmail());
			  if (studentData != null) {
		            // Return retrieved data along with a success message
		            return ResponseEntity.ok(studentData);
		        } else {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User data not found");
		        }
		    } else {
		        // Return unauthorized status
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user");
		    }
}
	

	
	  @GetMapping("/getdata/{email}")
	    public Student getUserByEmail(@RequestParam String email) {
	        // Fetch user by email using the service
		  Student user = studentService.getStudentByEmail(email);
	        if (user==null) {
	            try {
					throw new ResourceNotFoundException("User with email " + email + " not found");
				} catch (ResourceNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	 
	        return user;
	    }
	  
	  @PostMapping("updatedata/{email}")
	  public ResponseEntity<?> updateUserByEmail(@PathVariable String email, @RequestBody Student updatedStudent) {
	      try {
	    	  System.out.println("Received request to update user with email: " + email);
	          Student existingStudent = studentService.getStudentByEmail(email);
	          if (existingStudent == null) {
	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with email " + email + " not found");
	          }
	          System.out.println("Existing student: " + existingStudent);
	          System.out.println("Updated student data: " + updatedStudent);
	          // Update fields
	          existingStudent.setFullName(updatedStudent.getFullName());
	          existingStudent.setPhone(updatedStudent .getPhone());
	          existingStudent.setAddress(updatedStudent.getAddress());
	          existingStudent.setDob(updatedStudent.getDob());
	          existingStudent.setGender(updatedStudent.getGender());
	          existingStudent.setCourse(updatedStudent.getCourse());
	         // existingStudent.setStuFile(updatedStudent.getStuFile());
	          studentRegRepository.save(existingStudent);
	         
	          System.out.println("User updated successfully: " + existingStudent);
	          return ResponseEntity.ok("User updated successfully");
	      } catch (Exception e) {
	    	  System.err.println("Error updating user: " + e.getMessage());
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
	      }
	  }
	  
	  
	   
	      @PostMapping("/uploading")
	      public ResponseEntity<Student> uploadFile(@RequestParam String email, 
	    		  @RequestParam("Stufile") MultipartFile Stufile) {
	    	  System.out.println("Api calling");
	          try {
	        	//  System.out.println("Api calling");
//	        	  MultipartFile stuFile = Stufile.getStufile();
//	        	  String email = Stufile.getEmail();
	              if (Stufile.isEmpty() || !Stufile.getContentType().equals("application/pdf")) {
//	                  return ResponseEntity.badRequest().body("Please upload a valid PDF file.");
	            	  return ResponseEntity.status(500).body(null);
	              }
	              
	              Optional<Student> upload2 = studentRegRepository.findByEmail(email);
	  			if(upload2.isPresent())
	  			{
	  				Student student=upload2.get();
	  				System.out.println(Stufile.getBytes());
	  				
	  				byte[] fileBytes = Stufile.getBytes();
	  				System.out.println("fileBytes : "+fileBytes);
	  				
	  				student.setStufile(fileBytes);
	  				 String fileName = Stufile.getOriginalFilename();
	  				 student.setFileName(fileName);
	  				
	  			
	  			//	Student up = upload2.get();
	             
	              //studentService.uploadFile(email, Stufile);
	              studentRegRepository.save(student);
	              
	              return ResponseEntity.ok(student);
	  			}} catch (Exception e) {
//	              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                                   .body("Error while uploading file: " + e.getMessage());
	        	  return ResponseEntity.status(500).body(null);
	          }
			return null;
			
			

	      }
	  
	  
	  

		  @PostMapping("/pickdata/{email}")
		    public Student getUserByEmail1(@PathVariable  String email) {
		        // Fetch user by email using the service
			  Student user = studentService.getStudentByEmail(email);
			  
		        if (user==null) {
		            try {
						throw new ResourceNotFoundException("User with email " + email + " not found");
					} catch (ResourceNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		 
		        return user;
		    }

		 
//			 
//			    @GetMapping("/download/{email}")
//			    public ResponseEntity<byte[]> downloadFile(@RequestParam String email) {
//			        Student fileEntity = studentService.getStudentByEmail(email);;
//			        
//			        return ResponseEntity.ok()
//			                .contentType(MediaType.parseMediaType(fileEntity.getFileName()))
//			                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFileName() + "\"")
//			                .body(new ByteArrayResource(fileEntity.getStufile()));
//			    }
//			}
	  

 

		  @PostMapping("/download/{email}")
		    public ResponseEntity<byte[]> downloadFile(@PathVariable String email) {
		        try {
		            Student file =studentService.getStudentByEmail(email);
		 
		            // Set headers for the response
		            HttpHeaders headers = new HttpHeaders();
		            headers.add("Content-Disposition", "attachment; filename=\"" + file.getFileName() + "\"");
		 
		            return new ResponseEntity<>(file.getStufile(), headers, HttpStatus.OK);
		        } catch (Exception e) {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		        }
		    }
}


		    
//		    @PostMapping("/download/{email}")
//		    public ResponseEntity<byte[]> downloadFile(@PathVariable String email) {
//		        // Fetch file data and filename from the database
//		        String filename = "example.pdf"; // Replace with actual filename from the database
//		        byte[] fileData = fetchFileDataFromDatabase(email); // Replace with actual logic
//		     
//		        return ResponseEntity.ok()
//		            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
//		            .contentType(MediaType.APPLICATION_PDF) // Adjust MIME type as needed
//		            .body(new ByteArrayResource(fileData));
//		    }
//
	  
	  
