package com.teamsankya.employeedb.util;

import com.teamsankya.employeedb.dao.EmpDAOJDBCImpl;
import com.teamsankya.employeedb.dao.EmployeeDAO;

public class EmployeeDAOFactory 
{
	private EmployeeDAOFactory() {}
	private static String dbInteraction="jdbc";
	public static EmployeeDAO getEmployeeDAOInstance() 
	{
		EmployeeDAO dao=null;
		if(dbInteraction.equals("jdbc")) 
		{
			dao=new EmpDAOJDBCImpl();
		}
		/*else if(dbInteraction.equals("hibernate")){
			dao=new EmpDAOHibernateImpl();
		}*/
		return dao;
	}
	
}
