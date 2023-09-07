<%@page import="hbtu.com.bo.EnrolledStudent"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Enrolled Courses</title>
</head>
<body>
<a href="student-panel.jsp"> Back </a>
<h3> Enrolled Courses List</h3>
<%
ArrayList<EnrolledStudent> list=(ArrayList<EnrolledStudent>)request.getAttribute("list");
if(list==null){
String msg="There is no Enrolled courses wait for admin aprrove if requested any courses";
%>
<%=msg %>
<%
}else{
%>
<table border="3">
<tr>
<th> SNo. </th>
<th> Enrollid </th>
<th>Subject_Name </th>
<th> Batch_Name</th>
<th> Teacher_Name</th>
<th> DATE_TIME_OF_JOINING</th>
</tr>
<%
int sno=0;
for(EnrolledStudent course: list){	
%>
<tr>
<td><%=++sno %> </td>
<td><%=course.getEnrollid() %> </td>
<td><%=course.getSubjectName() %> </td>
<td><%=course.getBatchName() %> </td>
<td> <%=course.getTeacherName() %> </td>
<td><%=course.getDatetimeofjoining()%> </td>
</tr>
<%
}
}
%>
</table>
</body>
</html>