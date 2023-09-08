<%@page import="java.util.ArrayList"%>
<%@page import="hbtu.com.bo.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher's List</title>
</head>
<body>
<a href="SearchTeacher.jsp"> Back </a>
<%
ArrayList<Teacher> list=(ArrayList<Teacher>)request.getAttribute("teacherlist");
%>
<table border="3">
<caption> <%=list.size()+" result found" %> </caption>
	     
  <tr> 
       <th> Teacher_ID</th>
       <th> Name</th>
       <th> Date</th>
       <th> Gender</th>
       <th> Father's Name</th>
       <th> Contact No</th>
       <th> Email</th>           
       <th> Address</th>
       <th> HighestDegree</th>
       <th> Experience</th>
       <th> Teaching Schedule</th>
       <th> Is Hired </th>
  </tr>
 
<%  for(Teacher e : list) {%>
<tr>
<td><%=e.getTeacherId()%></td>
<td><%=e.getName()%></td>
<td><%=e.getDob()%></td>
<td><%=e.getGender()%></td>
<td><%=e.getFathername()%></td>
<td><%=e.getContactNo()%></td>
<td><%=e.getEmail()%></td>
<td><%=e.getAddress()%></td>
<td><%=e.getHighestDegree()%></td>
<td><%=e.getExperience()%></td>
<td><%=e.getTeachingSchedule()%></td>
<td>
<%
if(e.getIsHired()==null){ 
%> 
<%="No" %>
<%
}else{%>
<%=e.getIsHired() %>
<%
}%>
</td>
</tr>
<%} %>
</table>
</body>
</html>