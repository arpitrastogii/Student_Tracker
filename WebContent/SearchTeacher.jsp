<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Teacher</title>
</head>
<body>
<a href="admin-panel.jsp">Back </a>
<%
String emptyMsg=(String)request.getAttribute("emptyMsg");
if(emptyMsg!=null){
%>
<h3 style="color:red;"> <%=emptyMsg %> </h3>
<%
}%>
<h3> Search Teacher </h3>
<fieldset>
<table border="3">
<form action="SearchTeacher" method="post">
<tr>
<td> <label for="Name" id="name"> Search by Name:</label> </td>
<td> <input type="text" id="name" name="teachername"> </td>
</tr>
<tr>
<td colspan="2" align="right"> <input type="submit" value="Search"> </td>
</tr>
</form>
</table>
</fieldset>
</body>
</html>