<%@page import="hbtu.com.bo.EnrolledStudent"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Students</title>
</head>
<body>
<%
String who=(String)request.getAttribute("who");
ArrayList<EnrolledStudent> list=(ArrayList<EnrolledStudent>)request.getAttribute("list");
if(who.equals("teacher")){
%>
<a href="teacher-panel.jsp">Back</a>
<%
}else{
%>
<form action="ViewBatchesAndStudents" method="post"> 
<input type="Submit" value="Back"> 
</form>
<%
}
if(list==null){
String msg="No Student Enrolled yet";
%>
<%=msg %>
<%
}else{
%>
<table border="3">
<tr>
<th>S No. </th>
<th>Enrolled Id</th>
<th>RollNo</th>
<th>Student Name</th>
<th>Date&Time of Joining </th>
</tr>
<%
int sno=0;
for(EnrolledStudent obj:list){
%>
<tr>
<td><%=++sno %> </td>
<td><%=obj.getEnrollid() %> </td>
<td><%=obj.getRollno() %> </td>
<td><%=obj.getStudentName() %> </td>
<td><%=obj.getDatetimeofjoining()%> </td>
</tr>
<%
}
%>
</table>
<%
}
%>
</body>
</html>