<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Teacher Subjects</title>
</head>
<body>
<form action="ViewSubjectController" method="post"> 
<input type="Submit" value="Back"> 
</form>

<%
HashMap<String,String> map=(HashMap<String,String>)request.getAttribute("map");
String message="No Faculty found for this subject";
%>
<%
if(map==null){
%>
<h2 style="color:red;">
<%=message%>
</h2>
<%
}else{
%>
<table border="2">
<caption> <%=map.size()%> faculty found </caption>
<tr>
<th> Subject Name</th>
<th> Teacher Name</th>
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