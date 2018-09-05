package com.teamsankya.employeedb.dao;

import com.mysql.jdbc.Driver;
import com.teamsankya.employeedb.dto.EmployeeAddressBean;
import com.teamsankya.employeedb.dto.EmployeeCareerPastBean;
import com.teamsankya.employeedb.dto.EmployeeInfoBean;
import com.teamsankya.employeedb.dto.EmployeePersonalInfoBean;
import com.teamsankya.employeedb.dto.EmployeeCareerCurrentBean;
import com.teamsankya.employeedb.dto.MasterBean;
import com.teamsankya.employeedb.servlet.SearchEmployee;

import java.sql.*;

import org.apache.log4j.Logger;

public class EmpDAOJDBCImpl implements EmployeeDAO {

	final static Logger logger= Logger.getLogger(EmpDAOJDBCImpl.class);
	@Override
	public MasterBean searchEmployee(String eid, int k) {
		logger.info("searchEmployee  started");
		String dbUrl3 = "jdbc:mysql://localhost:3306/employee?user=root&password=admin";
		String sql1 = "select * from employee_info where eid=?";
		String sql2 = "select * from employee_personal_info where eid=?";
		String sql3 = "select * from employee_address where eid=?";
		String sql4 = "select * from employee_career_current where eid=?";
		String sql5 = "select * from employee_career_past where eid=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Creating JDBC objects");
			try (Connection con = DriverManager.getConnection(dbUrl3);
					PreparedStatement pstmt1 = con.prepareStatement(sql1);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);
					PreparedStatement pstmt3 = con.prepareStatement(sql3);
					PreparedStatement pstmt4 = con.prepareStatement(sql4);
					PreparedStatement pstmt5 = con.prepareStatement(sql5);

			) {

				pstmt1.setString(1, eid);
				pstmt2.setString(1, eid);
				pstmt3.setString(1, eid);
				pstmt4.setString(1, eid);
				pstmt5.setString(1, eid);

				ResultSet rs1 = pstmt1.executeQuery();

				ResultSet rs2 = pstmt2.executeQuery();

				ResultSet rs3 = pstmt3.executeQuery();

				ResultSet rs4 = pstmt4.executeQuery();

				ResultSet rs5 = pstmt5.executeQuery();

				EmployeeCareerPastBean ecpbean = new EmployeeCareerPastBean();
				EmployeeInfoBean eibean = new EmployeeInfoBean();
				EmployeeAddressBean eabean = new EmployeeAddressBean();
				EmployeePersonalInfoBean epibean = new EmployeePersonalInfoBean();
				EmployeeCareerCurrentBean eccbean = new EmployeeCareerCurrentBean();

				if (rs1.next()) {
					eibean.setEid(rs1.getString("eid"));
					eibean.setFname(rs1.getString("fname"));
					eibean.setLname(rs1.getString("lname"));
				}
				if (rs2.next()) {

					epibean.setContactNo(rs2.getLong("contactNo"));
					epibean.setEmail(rs2.getString("email"));
					epibean.setDob(rs2.getString("dob"));
				}
				if (rs3.next()) {

					eabean.setAddress(rs3.getString("address"));
					eabean.setPincode(rs3.getInt("pincode"));
					eabean.setCity(rs3.getString("city"));
					System.out.println(rs3.getString("city"));
				}
				if (rs4.next()) {

					eccbean.setJoinDate(rs4.getString("joindate"));
					eccbean.setCTC(rs4.getFloat("ctc"));
					eccbean.setDesignation(rs4.getString("designation"));
				}
				if (rs5.next()) {

					ecpbean.setExperience(rs5.getInt("experience"));
					ecpbean.setLastCompanyName(rs5.getString("lastcompanyname"));
				}

				MasterBean mbean = new MasterBean();
				mbean.setEibean(eibean);
				mbean.setEpibean(epibean);
				mbean.setEabean(eabean);
				mbean.setEccbean(eccbean);
				mbean.setEcpbean(ecpbean);
				logger.info("searchEmployee  successfully executed");
				return mbean;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
	}

	@Override
	public EmployeeInfoBean searchEmployee(String fname) {
		logger.info("searchEmployee  started");
		String dbUrl4 = "jdbc:mysql://localhost:3306/employee?user=root&password=admin";
		String sql4 = "select * from employee where fname=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Creating JDBC objects");
			try (Connection con = DriverManager.getConnection(dbUrl4);
					PreparedStatement pstmt = con.prepareStatement(sql4)) {
				pstmt.setString(1, fname);
				try (ResultSet rs = pstmt.executeQuery()) {
					EmployeeInfoBean bean = new EmployeeInfoBean();
					if (rs.next()) {
						// bean.setEid(rs.getInt("eid"));
						bean.setFname(fname);
						bean.setLname(rs.getString("lname"));
						/*
						 * bean.setEmail(rs.getString("email"));
						 * bean.setAddress(rs.getString("Address"));
						 * bean.setContactno(rs.getInt("Contactno")); bean.setDOB(rs.getString("DOB"));
						 * bean.setJoinDate(rs.getString("JoinDate"));
						 * bean.setDesignation(rs.getString("Designation"));
						 * bean.setExperience(rs.getInt("Experience"));
						 * bean.setLastCompanyName(rs.getString("LastCompanyName"));
						 * bean.setCTC(rs.getFloat("CTC"));
						 */
						logger.info("searchEmployee successfully executed");
						return bean;
					} else {
						return null;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean createEmployee(MasterBean mbean) {
		logger.info("createEmployee  started");
		String dbUrl1 = "jdbc:mysql://localhost:3306/employee?user=root&password=admin";
		String sql1 = "insert into employee_info values(?,?,?)";
		String sql2 = "insert into employee_personal_info values(?,?,?,?)";
		String sql3 = "insert into employee_address values(?,?,?,?)";
		String sql4 = "insert into employee_career_current values(?,?,?,?)";
		String sql5 = "insert into employee_career_past values(?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("creating jdbc obj for insertion");

			try (Connection con = DriverManager.getConnection(dbUrl1);
					PreparedStatement pstmt1 = con.prepareStatement(sql1);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);
					PreparedStatement pstmt3 = con.prepareStatement(sql3);
					PreparedStatement pstmt4 = con.prepareStatement(sql4);
					PreparedStatement pstmt5 = con.prepareStatement(sql5)) {
				System.out.println("Setting values to insert into db...");
				pstmt1.setString(1, mbean.getEibean().getEid());
				pstmt1.setString(2, mbean.getEibean().getFname());
				pstmt1.setString(3, mbean.getEibean().getLname());

				pstmt2.setString(1, mbean.getEibean().getEid());
				pstmt2.setLong(2, mbean.getEpibean().getContactNo());
				pstmt2.setString(3, mbean.getEpibean().getEmail());
				pstmt2.setString(4, mbean.getEpibean().getDob());

				pstmt3.setString(1, mbean.getEibean().getEid());
				pstmt3.setString(2, mbean.getEabean().getAddress());
				pstmt3.setInt(3, mbean.getEabean().getPincode());
				pstmt3.setString(4, mbean.getEabean().getCity());

				pstmt4.setString(1, mbean.getEibean().getEid());
				pstmt4.setString(2, mbean.getEccbean().getJoinDate());
				pstmt4.setFloat(3, mbean.getEccbean().getCTC());
				pstmt4.setString(4, mbean.getEccbean().getDesignation());

				pstmt5.setString(1, mbean.getEibean().getEid());
				pstmt5.setInt(2, mbean.getEcpbean().getExperience());
				pstmt5.setString(3, mbean.getEcpbean().getLastCompanyName());

				System.out.println("Executing insert command...");
				pstmt1.execute();
				System.out.println("Emplyee info inserted...");
				pstmt2.execute();
				System.out.println("Emplyee personal info inserted...");
				pstmt3.execute();
				System.out.println("Emplyee address inserted...");
				pstmt4.execute();
				System.out.println("Emplyee career current inserted...");
				pstmt5.execute();
				System.out.println("Emplyee current past inserted...");
				 boolean b=pstmt1.execute();
				
				System.out.println("Data inserted...");
				 return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void deleteEmployee(MasterBean mbean) {
		logger.info("deleteEmployee  started");
		String dbUrl2 = "jdbc:mysql://localhost:3306/employee?user=root&password=admin";
		String sql1 = "delete from employee_info where eid=?";
		String sql2 = "delete from employee_personal_info where eid=?";
		String sql3 = "delete from employee_address where eid=?";
		String sql4 = "delete from employee_career_current where eid=?";
		String sql5 = "delete from employee_career_past where eid=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("creating jdbc obj for deletion");

			try (Connection con = DriverManager.getConnection(dbUrl2);
					PreparedStatement pstmt1 = con.prepareStatement(sql1);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);
					PreparedStatement pstmt3 = con.prepareStatement(sql3);
					PreparedStatement pstmt4 = con.prepareStatement(sql4);
					PreparedStatement pstmt5 = con.prepareStatement(sql5)) {
				System.out.println("Setting values to delete from db...");
				pstmt1.setString(1, mbean.getEibean().getEid());

				System.out.println(mbean.getEibean().getEid());

				pstmt2.setString(1, mbean.getEibean().getEid());

				pstmt3.setString(1, mbean.getEibean().getEid());

				pstmt4.setString(1, mbean.getEibean().getEid());

				pstmt5.setString(1, mbean.getEibean().getEid());

				System.out.println("Executing delete command...");
				pstmt1.execute();
				System.out.println("Executing Employee Info delete command...");
				pstmt2.execute();
				System.out.println("Executing Employee personal  delete command...");
				pstmt3.execute();
				System.out.println("Executing Employee Address delete command...");
				pstmt4.execute();
				System.out.println("Executing Employee career current delete command...");
				pstmt5.execute();
				System.out.println("Executing Employe  career past delete command...");

				System.out.println("Data deleted...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("deleteEmployee successfully executed");
	}

	@Override
	public void updateEmployee(MasterBean mbean) {
		logger.info("updateEmployee  started");
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=admin");

					PreparedStatement pstmt1 = con
							.prepareStatement("update employee_info set fname=?,lname=? where eid=?");
					PreparedStatement pstmt2 = con.prepareStatement(
							"update employee_personal_info set contactno=?,email=?,dob=? where eid=?");

					PreparedStatement pstmt3 = con
							.prepareStatement("update employee_address set address=?,pincode=?,city=? where eid=?");

					PreparedStatement pstmt4 = con.prepareStatement(
							"update employee_career_current set joindate=?,designation=?,ctc=? where eid=?");

					PreparedStatement pstmt5 = con.prepareStatement(
							"update employee_career_past set experience=?,lastcompanyname=? where eid=?");

			)

			{
				pstmt1.setString(1, mbean.getEibean().getFname());
				pstmt1.setString(2, mbean.getEibean().getLname());
				pstmt1.setString(3, mbean.getEibean().getEid());

				pstmt2.setString(4, mbean.getEibean().getEid());
				pstmt2.setLong(1, mbean.getEpibean().getContactNo());
				pstmt2.setString(2, mbean.getEpibean().getEmail());
				pstmt2.setString(3, mbean.getEpibean().getDob());

				pstmt3.setString(4, mbean.getEibean().getEid());
				pstmt3.setString(1, mbean.getEabean().getAddress());
				pstmt3.setInt(2, mbean.getEabean().getPincode());
				pstmt3.setString(3, mbean.getEabean().getCity());

				pstmt4.setString(4, mbean.getEibean().getEid());
				pstmt4.setString(1, mbean.getEccbean().getJoinDate());
				pstmt4.setFloat(3, mbean.getEccbean().getCTC());
				pstmt4.setString(2, mbean.getEccbean().getDesignation());

				pstmt5.setString(3, mbean.getEibean().getEid());
				pstmt5.setInt(1, mbean.getEcpbean().getExperience());
				pstmt5.setString(2, mbean.getEcpbean().getLastCompanyName());

				System.out.println("Executing Update Command...");
				pstmt1.execute();

				pstmt2.execute();

				pstmt3.execute();

				pstmt4.execute();

				pstmt5.execute();
				System.out.println("Data Updated.....");
				// boolean b=pstmt.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("updateEmployee successfully executed");
	}

}
