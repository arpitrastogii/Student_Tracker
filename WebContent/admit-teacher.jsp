<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import ="hbtu.com.bo.Teacher" %>
<%@page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Student</title>
</head>
<body>
<a href="admin-panel.jsp"> Home</a>
<%
String msg=(String)request.getAttribute("message");
if(msg!=null){
%>
<h1>  <%= msg %></h1>
<%
}
%>
<%
List<Teacher> list = (List<Teacher>)request.getAttribute("list");
%>
<table border="1">
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
  </tr>
 
<%  for(Teacher e : list) {%>
<tr>
<form>
<td><input type="text"  style="background-color:white" value="<%=e.getTeacherId()%>" size="1" disabled></td>
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
  <a href="AdmitTeacherService?teacher_id=<%=e.getTeacherId()%>">Admit</a>
  <a href="UnadmitService?stuid=<%=e.getTeacherId()%>">UnAdmit</a>
  </td>
</form>
</tr>
<%} %>
</table>

</body>
</html>