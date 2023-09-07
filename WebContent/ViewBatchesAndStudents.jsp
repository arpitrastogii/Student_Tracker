<%@page import="hbtu.com.bo.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Batches</title>
</head>
<body>
<a href="admin-panel.jsp"> Back</a>
<%
ArrayList<Batch> list=(ArrayList<Batch>)request.getAttribute("list");
if(list==null){
	String msg="No Active Batches Found";
%>
<h3 style="color:red;"><%=msg %></h2>
<%
}else{
%>
<h2> View All Batches</h2>
<table border="3">
<tr>
<th> SNo </th>
<th> Batch_ID </th>
<th> Batch_Name </th>
<th> Subject_Name </th>
<th> Teacher Name </th>
<th> View Enrolled Students</th>
</tr>
<%
int sno=0;
for(Batch obj:list){
%>
<tr>
<td> <%=++sno %></td>
<td> <%=obj.getBatch_id() %></td>
<td> <%=obj.getBatch_name() %></td>
<td> <%=obj.getSubject_name() %></td>
<td> <%=obj.getTeacher_name() %></td>
<td> <a href="BatchHaveStudentFetch?batch_id=<%=obj.getBatch_id()%>&who=admin"> View</a></td>
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