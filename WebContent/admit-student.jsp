<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import ="hbtu.com.bo.Student" %>
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
List<Student> list = (List<Student>)request.getAttribute("list");
%>
<table border="1">
<caption> <%=list.size()+" result found" %> </caption>

  <tr> 
       <th> Student_ID</th>
       <th> Name</th>
       <th> Gender</th>
       <th> Course</th>
       <th> DOB</th>
       <th> Father's Name</th>
       <th> Address</th>
       <th> City</th>
       <th> State</th>
       <th> Pincode</th>
       <th> Contact No.</th>
       <th> Email</th>
  </tr>
 
<%  for(Student e : list) {%>
<tr>
<form>
<td><input type="text"  style="background-color:white" value="<%=e.getRollno()%>" size="1" disabled></td>
<td><%=e.getStudentName()%></td>
<td><%=e.getGender()%></td>
<td><%=e.getCourse()%></td>
<td><%=e.getDob()%></td>
<td><%=e.getFatherName()%></td>
<td><%=e.getStudentName()%></td>
<td><%=e.getAddress()%></td>
<td><%=e.getCity()%></td>
<td><%=e.getState()%></td>
<td><%=e.getPincode()%></td>
<td><%=e.getEmailId()%></td>
 <td> 
  <a href="AdmitService?stuid=<%=e.getRollno()%>">Admit</a>
  <a href="UnadmitService?stuid=<%=e.getRollno()%>">UnAdmit</a>
  </td>
</form>
</tr>
<%} %>
</table>

</body>
</html>