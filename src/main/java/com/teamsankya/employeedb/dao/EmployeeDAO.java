package com.teamsankya.employeedb.dao;


import com.teamsankya.employeedb.dto.EmployeeInfoBean;
import com.teamsankya.employeedb.dto.MasterBean;

public interface EmployeeDAO 
{
	public boolean createEmployee(MasterBean mbean);

	public void deleteEmployee(MasterBean mbean);

	public MasterBean searchEmployee(String eid,int k);

	public EmployeeInfoBean searchEmployee(String fname);
	
	public void updateEmployee(MasterBean mbean);
}
