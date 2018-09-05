package com.teamsankya.employeedb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.employeedb.dao.EmployeeDAO;
import com.teamsankya.employeedb.dto.EmployeeInfoBean;
import com.teamsankya.employeedb.util.EmployeeDAOFactory;

@WebServlet("/SearchEmployeeName")
public class SearchEmployeeName extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		EmployeeInfoBean bean=new EmployeeInfoBean();
		
		String fname=req.getParameter("fname");
		
		
		EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAOInstance();
		
		bean = dao.searchEmployee(fname);
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("/SearchResponse.jsp")
						.forward(req, resp);
	}

}
