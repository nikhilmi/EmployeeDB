package com.teamsankya.employeedb.dto;

public class EmployeePersonalInfoBean {
	private String eid;
	private long contactNo;
	private String email;	
	private String dob;
	
	public String getEid() {
		return eid;
	}
	public long getContactNo() {
		return contactNo;
	}
	public String getEmail() {
		return email;
	}
	public String getDob() {
		return dob;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
}
