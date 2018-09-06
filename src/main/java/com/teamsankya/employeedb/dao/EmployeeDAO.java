package com.teamsankya.employeedb.dao;


import com.teamsankya.employeedb.dto.EmployeeInfoBean;
import com.teamsankya.employeedb.dto.MasterBean;

public interface EmployeeDAO 
{
	public String createEmployee(MasterBean mbean);

	public String deleteEmployee(MasterBean mbean);

	public MasterBean searchEmployee(String eid,int k);

	public EmployeeInfoBean searchEmployee(String fname);
	
	public String updateEmployee(MasterBean mbean);
}
