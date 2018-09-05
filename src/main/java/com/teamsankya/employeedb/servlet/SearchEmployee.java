package com.teamsankya.employeedb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.teamsankya.employeedb.dao.EmployeeDAO;
import com.teamsankya.employeedb.dto.MasterBean;
import com.teamsankya.employeedb.util.EmployeeDAOFactory;

@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger= Logger.getLogger(SearchEmployee.class);

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.info("search employee started");
		logger.info("masterbean object created");
		MasterBean mbean=new MasterBean();
		logger.info("field are set");
		
		String eid = req.getParameter("eid");
			EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAOInstance();
			
			mbean= dao.searchEmployee(eid,4);
			logger.info("response taken from dao implementation");
			//System.out.println(mbean.getEabean().getCity());
				req.setAttribute("mbean", mbean);
				logger.info("forward to response page");
				req.getRequestDispatcher("/SearchResponse.jsp")
								.forward(req, resp);
			
			
			
		}
		
	}


