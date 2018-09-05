package com.teamsankya.employeedb.dto;

public class EmployeeCareerPastBean {
	private String eid;
	private int experience;
	private String lastCompanyName;
	
	
	public String getEid() {
		return eid;
	}
	public int getExperience() {
		return experience;
	}
	public String getLastCompanyName() {
		return lastCompanyName;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public void setLastCompanyName(String lastCompanyName) {
		this.lastCompanyName = lastCompanyName;
	}
	
	
}
