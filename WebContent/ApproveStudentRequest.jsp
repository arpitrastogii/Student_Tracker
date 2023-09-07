<%@page import="hbtu.com.bo.EnrolledStudent"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Student Request</title>
</head>
<body>
<a href="admin-panel.jsp">Back</a>
<h2> Enrolled Students in Batches</h2>
<%
String messageofapprovedecline=(String)request.getAttribute("messageofapprovedecline");
if(messageofapprovedecline!=null){
%>
<h3 style="color:green;"><%=messageofapprovedecline %></h3>
<%
}
ArrayList<EnrolledStudent> list=(ArrayList<EnrolledStudent>)request.getAttribute("enrolledlist");
int sno=0;
if(list==null){
%>
<h2 style="color:red;"> No enrolled requests found</h2>
<%
}else{
	
%>
<table border="3">
<tr>
<th> S No.</th>
<th> RollNo</th>
<th> Student Name</th>
<th> Batch_Name</th>
</tr>

<%
for(EnrolledStudent obj :list){
%>
<tr> 
<td><%=++sno %>  </td>
<td><%=obj.getRollno() %>  </td>
<td><%=obj.getStudentName() %>  </td>
<td><%=obj.getBatchName() %>  </td>
<td> 
<a href="ApproveStudentRequest?enrollid=<%= obj.getEnrollid()%>"> Approve</a> 
<a href="DeclineStudentRequest?enrollid=<%= obj.getEnrollid()%>"> Decline</a> 
</td>
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