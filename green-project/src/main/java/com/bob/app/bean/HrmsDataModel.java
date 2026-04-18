package com.bob.app.bean;




import javax.persistence.Entity;
import javax.persistence.Id;
 
import org.hibernate.annotations.Immutable;
 
@Immutable
 
@Entity
public class HrmsDataModel {
	private String curr_br_alpha;
	private String curr_grade;
	private String curr_org;
	private String curr_position;
	private String curr_sol_id;
	private String current_designation;
	private String current_organization_type;
	private String emp_name;
	@Id
	private String pan_no;
	private String username;
	
	
	public String getCurr_br_alpha() {
		return curr_br_alpha;
	}
	public void setCurr_br_alpha(String curr_br_alpha) {
		this.curr_br_alpha = curr_br_alpha;
	}
	public String getCurr_grade() {
		return curr_grade;
	}
	public void setCurr_grade(String curr_grade) {
		this.curr_grade = curr_grade;
	}
	public String getCurr_org() {
		return curr_org;
	}
	public void setCurr_org(String curr_org) {
		this.curr_org = curr_org;
	}
	public String getCurr_position() {
		return curr_position;
	}
	public void setCurr_position(String curr_position) {
		this.curr_position = curr_position;
	}
	public String getCurr_sol_id() {
		return curr_sol_id;
	}
	public void setCurr_sol_id(String curr_sol_id) {
		this.curr_sol_id = curr_sol_id;
	}
	public String getCurrent_designation() {
		return current_designation;
	}
	public void setCurrent_designation(String current_designation) {
		this.current_designation = current_designation;
	}
	public String getCurrent_organization_type() {
		return current_organization_type;
	}
	public void setCurrent_organization_type(String current_organization_type) {
		this.current_organization_type = current_organization_type;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}

