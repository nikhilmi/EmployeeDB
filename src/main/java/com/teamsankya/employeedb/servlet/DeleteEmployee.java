package com.teamsankya.employeedb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.teamsankya.employeedb.dao.EmployeeDAO;
import com.teamsankya.employeedb.dto.EmployeeInfoBean;
import com.teamsankya.employeedb.dto.MasterBean;
import com.teamsankya.employeedb.util.EmployeeDAOFactory;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger= Logger.getLogger(DeleteEmployee.class);
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	logger.info("delete employee started");
		EmployeeInfoBean           eibean = new EmployeeInfoBean();
	
		logger.info("object created for employeeinfobean ");
		//--------------------------------------------------------------------------
		eibean.setEid(req.getParameter("eid"));
		logger.info("field are set");
		//--------------------------------------------------------------------------
		MasterBean mbean=new MasterBean();
		logger.info("object created for masterbean");
		mbean.setEibean(eibean);
	
		logger.info("pass masterbean object");
		//--------------------------------------------------------------------------		
		EmployeeDAO dao=EmployeeDAOFactory.getEmployeeDAOInstance();
		dao.deleteEmployee(mbean);
	
		
	}

}
