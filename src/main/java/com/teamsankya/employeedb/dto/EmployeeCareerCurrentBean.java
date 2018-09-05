package com.teamsankya.employeedb.dto;

public class EmployeeCareerCurrentBean {
	private String JoinDate;
	private String Designation;
	private float CTC;
	private String eid;
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getJoinDate() {
		return JoinDate;
	}
	public String getDesignation() {
		return Designation;
	}
	public float getCTC() {
		return CTC;
	}
	public void setJoinDate(String joinDate) {
		JoinDate = joinDate;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public void setCTC(float cTC) {
		CTC = cTC;
	}

	
}
