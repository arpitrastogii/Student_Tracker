<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="admin-panel.jsp">Back</a>
<%
String msg=(String)request.getAttribute("errormessage");
if(msg!=null){
%>
<h1 style="color:red"><%=msg %> </h1>

<%} %>
<fieldset> 
<legend> Search Student </legend>

<table>
<form action="SearchServiceID" method="post">
<tr>
<td> <label for="StudentID"> Search by Student ID: </label></td>
<td> <input type="text" name="studentid">  </td>
</tr>
<tr><td colspan="2" align="right"> <input type="submit" value="Search" >  </td> </tr>
</form>
<form action="SearchByName" method="post">
<tr>
<td> <label for="Name"> Search by Name </label></td>
<td> <input type="text" name="name">  </td>
</tr>
<tr><td colspan="2" align="right"> <input type="submit" value="Search" >  </td> </tr>
</form>
</table>
</fieldset>
</body>
</html>