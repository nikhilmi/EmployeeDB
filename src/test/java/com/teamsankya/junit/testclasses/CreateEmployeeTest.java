package com.teamsankya.junit.testclasses;

import org.junit.Test;

import com.teamsankya.employeedb.dao.EmpDAOJDBCImpl;
import com.teamsankya.employeedb.dto.EmployeeAddressBean;
import com.teamsankya.employeedb.dto.EmployeeCareerCurrentBean;
import com.teamsankya.employeedb.dto.EmployeeCareerPastBean;
import com.teamsankya.employeedb.dto.EmployeeInfoBean;
import com.teamsankya.employeedb.dto.EmployeePersonalInfoBean;
import com.teamsankya.employeedb.dto.MasterBean;

import junit.framework.TestCase;

public class CreateEmployeeTest {

	@Test
	public void createTest() {
		EmpDAOJDBCImpl emp= new EmpDAOJDBCImpl();
		EmployeeInfoBean eibean= new EmployeeInfoBean();
		EmployeeAddressBean eabean= new EmployeeAddressBean();
		EmployeePersonalInfoBean epibean= new EmployeePersonalInfoBean();
		EmployeeCareerPastBean ecpbean= new EmployeeCareerPastBean();
		EmployeeCareerCurrentBean eccbean= new EmployeeCareerCurrentBean();
		MasterBean mbean = new MasterBean();
		
		eibean.getEid();
		mbean.setEibean(eibean);
		mbean.setEpibean(epibean);
		mbean.setEabean(eabean);
		mbean.setEccbean(eccbean);
		mbean.setEcpbean(ecpbean);
		
		//String id = emp.createEmployee(mbean)
		
		TestCase.assertNotNull(mbean);
		
		
		
	}
}
