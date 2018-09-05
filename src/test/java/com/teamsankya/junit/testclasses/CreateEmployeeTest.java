package com.teamsankya.junit.testclasses;

import org.junit.Test;

import com.teamsankya.employeedb.dao.EmpDAOJDBCImpl;
import com.teamsankya.employeedb.dto.MasterBean;

public class CreateEmployeeTest {

	@Test
	public void createTest() {
		EmpDAOJDBCImpl emp= new EmpDAOJDBCImpl();
		MasterBean mbean = new MasterBean();
		 emp.createEmployee(mbean);
	}
}
