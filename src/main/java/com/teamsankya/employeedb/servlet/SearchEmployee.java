package com.teamsankya.employeedb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.employeedb.dao.EmployeeDAO;
import com.teamsankya.employeedb.dto.MasterBean;
import com.teamsankya.employeedb.util.EmployeeDAOFactory;

@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		MasterBean mbean=new MasterBean();
		String eid = req.getParameter("eid");
		
		
			EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAOInstance();
			
			mbean= dao.searchEmployee(eid,4);
			//System.out.println(mbean.getEabean().getCity());
			
				req.setAttribute("mbean", mbean);
				req.getRequestDispatcher("/SearchResponse.jsp")
								.forward(req, resp);
			
			
			
			
		}
		
	}


