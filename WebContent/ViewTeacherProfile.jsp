<%@page import="hbtu.com.bo.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile</title>
</head>
<body>
<a href="teacher-panel.jsp"> Back </a>
<h3> View Profile</h3>
<%
Teacher teacher=(Teacher)request.getAttribute("teacher");
%>
<table border="2">
<tr>
<td>ID</td>
<td><%=teacher.getTeacherId() %> </td>
</tr>
<tr>
<td>Name:</td>
<td><%=teacher.getName()%> </td>
</tr>
<tr>
<td>Gender:</td>
<td><%=teacher.getGender() %> </td>
</tr>

<tr>
<td>DOB:</td>
<td><%=teacher.getDob() %> </td>
</tr>
<tr>
<td>Father Name:</td>
<td><%=teacher.getFathername() %> </td>
</tr>
<tr>
<td>Contact No:</td>
<td><%=teacher.getContactNo() %> </td>
</tr>
<tr>
<td>EmailID:</td>
<td><%=teacher.getEmail() %> </td>
</tr>
<tr>
<td>Address</td>
<td><%=teacher.getAddress() %> </td>
</tr>
<tr>
<td>Highest Degree</td>
<td><%=teacher.getHighestDegree() %> </td>
</tr>
<tr>
<td>Institute:</td>
<td><%=teacher.getInstitute()%> </td>
</tr>
<tr>
<td>Experience</td>
<td><%=teacher.getExperience() %> </td>
</tr>
<tr>
<td>Teaching Schedule</td>
<td><%=teacher.getTeachingSchedule()%> </td>
</tr>

</table>
</body>
</html>