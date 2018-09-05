
<%@page import="com.teamsankya.employeedb.dto.MasterBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
MasterBean           mbean = (MasterBean)request.getAttribute("mbean");

%>
<body>
<form action="./UpdateEmp" method="get">
<%if(mbean!=null) {%>
	<table border='1'>
		<tr>
			<td>Eid</td>
			<td>Fname</td>
			<td>Lname</td>
			<td>ContactNo</td>
			<td>Email</td>
			<td>DOB</td>
			<td>Address</td>
			<td>Pincode</td>
			<td>City</td>
			<td>JoinDate</td>
			<td>Designation</td>
			<td>CTC</td>
			<td>Experience</td>
			<td>Last Company Name</td>
			
		</tr>
		<tr>
			<td><%=mbean.getEibean().getEid() %><input type="text" name="eid"       value="<%=mbean.getEibean().getEid() %>" hidden/></td>
			<td><input type="text" name="fname"       value="<%=mbean.getEibean().getFname() %>"/></td>
			<td><input type="text" name="lname"       value="<%=mbean.getEibean().getLname() %>"/></td>
		
			<td><input type="text" name="contactno"       value="<%=mbean.getEpibean().getContactNo() %>"/></td>
			<td><input type="text" name="email"           value="<%=mbean.getEpibean().getEmail()%>"/></td>
			<td><input type="text" name="dob"         value="<%=mbean.getEpibean().getDob() %>"/></td>
			
			<td><input type="text" name="address"     value="<%=mbean.getEabean().getAddress() %>"/></td>
			<td><input type="text" name="pincode"     value="<%=mbean.getEabean().getPincode() %>"/></td>
			<td><input type="text" name="city"     value="<%=mbean.getEabean().getCity() %>"/></td>
			
			<td><input type="text" name="joindate"         value="<%=mbean.getEccbean().getJoinDate() %>"/></td>
			<td><input type="text" name="designation"      value="<%=mbean.getEccbean().getDesignation()%>"/></td>
			<td><input type="text" name="ctc"       value="<%=mbean.getEccbean().getCTC()%>"/></td>
			
			<td><input type="text" name="experience"  value="<%=mbean.getEcpbean().getExperience()%>"/></td>
			<td><input type="text" name="lastcompanyname"  value="<%=mbean.getEcpbean().getLastCompanyName()%>"/></td>     
			<td><input type="submit" value="Update"/></td>
		</tr>
	</table>
	<%}else { %>
	<h1>Employee id/name does not exist</h1>
	<%} %>
	<a href='./Add_Emp.html'>Click here to insert more employee</a><br>
	<a href='./SearchEmpById.html'>Click here to search an employee id</a><br>
	<a href='./SearchEmpByName.html'>Click here to search an employee name</a>
</form>
</body>
</html>