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
import com.teamsankya.employeedb.util.EmployeeDAOFactory;

@WebServlet("/SearchEmployeeName")
public class SearchEmployeeName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger= Logger.getLogger(SearchEmployee.class);
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		logger.info("search by name employee started");
		EmployeeInfoBean bean=new EmployeeInfoBean();
		logger.info("object created for employeeinfobean");
		String fname=req.getParameter("fname");
		logger.info("field are set");
		
		EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAOInstance();
		//bean = dao.searchEmployee(fname);
		req.setAttribute("bean", bean);
		logger.info("forward to response page");
		req.getRequestDispatcher("/SearchResponse.jsp")
						.forward(req, resp);
		
	}

}
