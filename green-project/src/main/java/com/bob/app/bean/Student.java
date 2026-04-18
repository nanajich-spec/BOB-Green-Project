package com.bob.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Immutable
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="StudentReg")

public class Student {
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
	private String fullName;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String dob;
	private String gender;
	private String course;
	
	@Lob
	@Column(name="Stufile")
	private byte[] Stufile;
	
	private String fileName;
	
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public byte[] getStufile() {
		return Stufile;
	}
	public void setStufile(byte[] Stufile) {
		this.Stufile = Stufile;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	
	}
	
}
