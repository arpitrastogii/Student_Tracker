<%@page import="hbtu.com.bo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile</title>
</head>
<body>
<a href="student-panel.jsp"> Back </a>
<h3> View Profile</h3>
<%
Student studentobj=(Student)request.getAttribute("studentobj");
%>
<table border="2">
<tr>
<td>RollNo:</td>
<td><%=studentobj.getRollno() %> </td>
</tr>
<tr>
<td>Name:</td>
<td><%=studentobj.getStudentName()%> </td>
</tr>
<tr>
<td>Gender:</td>
<td><%=studentobj.getGender() %> </td>
</tr>
<tr>
<td>Course:</td>
<td><%=studentobj.getCourse() %> </td>
</tr>
<tr>
<td>DOB:</td>
<td><%=studentobj.getDob() %> </td>
</tr>
<tr>
<td>Father Name:</td>
<td><%=studentobj.getFatherName() %> </td>
</tr>
<tr>
<td>Address</td>
<td><%=studentobj.getAddress() %> </td>
</tr>
<tr>
<td>City</td>
<td><%=studentobj.getCity() %> </td>
</tr>
<tr>
<td>State:</td>
<td><%=studentobj.getState() %> </td>
</tr>
<tr>
<td>Pincode:</td>
<td><%=studentobj.getPincode() %> </td>
</tr>
<tr>
<td>Contact No:</td>
<td><%=studentobj.getContactNo() %> </td>
</tr>
<tr>
<td>EmailID:</td>
<td><%=studentobj.getEmailId() %> </td>
</tr>
</table>
</body>
</html>