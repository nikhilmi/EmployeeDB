package com.teamsankya.employeedb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.employeedb.dao.EmployeeDAO;
import com.teamsankya.employeedb.dto.EmployeeInfoBean;
import com.teamsankya.employeedb.dto.MasterBean;
import com.teamsankya.employeedb.util.EmployeeDAOFactory;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		
		EmployeeInfoBean           eibean = new EmployeeInfoBean();
	
		
		//--------------------------------------------------------------------------
		eibean.setEid(req.getParameter("eid"));

		//--------------------------------------------------------------------------
		MasterBean mbean=new MasterBean();
				
		mbean.setEibean(eibean);
	

		//--------------------------------------------------------------------------		
		EmployeeDAO dao=EmployeeDAOFactory.getEmployeeDAOInstance();
		dao.deleteEmployee(mbean);
		
		
		
	}

}
