package com.teamsankya.employeedb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.employeedb.dao.EmployeeDAO;
import com.teamsankya.employeedb.dto.EmployeeAddressBean;
import com.teamsankya.employeedb.dto.EmployeeCareerCurrentBean;
import com.teamsankya.employeedb.dto.EmployeeCareerPastBean;
import com.teamsankya.employeedb.dto.EmployeeInfoBean;
import com.teamsankya.employeedb.dto.EmployeePersonalInfoBean;
import com.teamsankya.employeedb.dto.MasterBean;
import com.teamsankya.employeedb.util.EmployeeDAOFactory;

@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		EmployeeInfoBean           eibean = new EmployeeInfoBean();
		EmployeePersonalInfoBean   epibean=new EmployeePersonalInfoBean();
		EmployeeAddressBean        eabean=new EmployeeAddressBean();
		EmployeeCareerCurrentBean eccbean=new EmployeeCareerCurrentBean();
		EmployeeCareerPastBean     ecpbean=new EmployeeCareerPastBean();
		
		//---------------------employee info bean--------------------------
		eibean.setEid(req.getParameter("eid"));
		System.out.println(eibean.getEid());
		eibean.setFname(req.getParameter("fname"));
		eibean.setLname(req.getParameter("lname"));
		
		//---------------------employee personal info bean--------------------------
		 
		epibean.setContactNo(Long.parseLong(req.getParameter("contactno")));
		epibean.setEmail(req.getParameter("email"));
		epibean.setDob(req.getParameter("dob"));

		
		
		//---------------------employee address bean--------------------------
		eabean.setAddress(req.getParameter("address"));
		eabean.setPincode(Integer.parseInt(req.getParameter("pincode")));
		eabean.setCity(req.getParameter("city"));
		
		//---------------------employee career current bean--------------------------
		eccbean.setJoinDate(req.getParameter("joindate"));
		eccbean.setDesignation(req.getParameter("designation"));
		eccbean.setCTC(Float.parseFloat(req.getParameter("ctc")));
		
		//---------------------employee career past--------------------------
		ecpbean.setExperience(Integer.parseInt(req.getParameter("experience")));
		ecpbean.setLastCompanyName(req.getParameter("lastcompanyname"));

	MasterBean mbean=new MasterBean();
		
		mbean.setEibean(eibean);
		mbean.setEpibean(epibean);
		mbean.setEabean(eabean);
		mbean.setEccbean(eccbean);
		mbean.setEcpbean(ecpbean);
		
		
		
		EmployeeDAO dao=EmployeeDAOFactory.getEmployeeDAOInstance();
		
		dao.updateEmployee(mbean);
		
		
		//req.getRequestDispatcher("UpdateStudentResponse.jsp").forward(req, resp);
	
	}

}
