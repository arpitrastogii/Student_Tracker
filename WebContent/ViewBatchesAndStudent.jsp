<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Batches and Student</title>
</head>
<body>
<a href="teacher-panel.jsp">Back</a>
<%
LinkedHashMap<Integer,String> batchlist=(LinkedHashMap<Integer,String>)request.getAttribute("batchlist");
if(batchlist==null){
	String msg="No Allotted batches found";
%>
<h2 style="color:red;">
<%=msg %>
</h2>
<%} else{%>
<h2> My Batches</h2>
<table border="3">
<tr> 
<th>S No. </th>
<th>Batch Id </th>
<th>Batch_Name </th>
</tr>
<%
int sno=0;
for(Integer key:batchlist.keySet()){
%>
<tr> 
<td><%=++sno %> </td>
<td><%=key %> </td>
<td><%=batchlist.get(key) %> </td>
<td><a href="BatchHaveStudentFetch?batch_id=<%=key%>&who=teacher">View Enrolled Students</a> </td>
</tr>
<%
}%>
</table>
<%} %>
</body>
</html>