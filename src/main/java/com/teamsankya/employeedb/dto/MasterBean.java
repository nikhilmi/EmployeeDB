package com.teamsankya.employeedb.dto;

public class MasterBean {

	private EmployeePersonalInfoBean epibean;
	private EmployeeAddressBean eabean;
	private EmployeeCareerPastBean ecpbean;
	private EmployeeInfoBean eibean;
	private EmployeeCareerCurrentBean eccbean;
	
	public EmployeePersonalInfoBean getEpibean() {
		return epibean;
	}
	public EmployeeAddressBean getEabean() {
		return eabean;
	}
	public EmployeeCareerPastBean getEcpbean() {
		return ecpbean;
	}
	public EmployeeInfoBean getEibean() {
		return eibean;
	}
	public EmployeeCareerCurrentBean getEccbean() {
		return eccbean;
	}
	public void setEpibean(EmployeePersonalInfoBean epibean) {
		this.epibean = epibean;
	}
	public void setEabean(EmployeeAddressBean eabean) {
		this.eabean = eabean;
	}
	public void setEcpbean(EmployeeCareerPastBean ecpbean) {
		this.ecpbean = ecpbean;
	}
	public void setEibean(EmployeeInfoBean eibean) {
		this.eibean = eibean;
	}
	public void setEccbean(EmployeeCareerCurrentBean eccbean) {
		this.eccbean = eccbean;
	}
	
	
}
