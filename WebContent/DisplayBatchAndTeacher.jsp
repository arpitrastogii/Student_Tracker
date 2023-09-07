<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Batch and Faculty Name</title>
</head>
<body>
<form action="ViewSubjectController" method="post"> 
<input type="Submit" value="Back"> 
</form>
<%
HashMap<String,String> map=(HashMap<String,String>) request.getAttribute("pair");
String message="No batches found";
if(map.size()==0){
%>
<h2 style="color:red;">
<%=message%>
</h2>
<%
}else{
%>
<table border="2">
<tr>
<th> Batch Name </th>
<th> Teacher Name </th>
</tr>
<% 
for(String keys: map.keySet()){
%>
<tr>
<td><%=keys %> </td>
<td><%=map.get(keys) %> </td>
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