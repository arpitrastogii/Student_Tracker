<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Subject</title>
</head>
<h2> Add Subject</h2>
<body>
<a href="admin-panel.jsp"> Back </a>
<%
String msg=(String) request.getAttribute("msg");
if(msg!=null){
%>
<h3 style="color:red;">
<%= msg %>
</h3>
<%
}
%>
<form action="AddSubject" method="post">
<table border="2">
<tr> 
<td>Enter Subject Name: </td>
<td> <input type="text" name="name" required></td>
</tr>
<tr>
<td colspan="2" align="right"><input type="submit" value="Add"> </td>

</tr>
</table>
</form>
</body>
</html>