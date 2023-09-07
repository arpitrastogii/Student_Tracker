<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="hbtu.com.bo.Teacher" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hired Faculty </title>
</head>
<body>
<a href="admin-panel.jsp"> Back </a>
<table border="2">
<%
ArrayList<Teacher> list= (ArrayList<Teacher>)request.getAttribute("list");
%>
<%if(list!=null) {%>
<caption>  <%=list.size() %> Hired Faculty</caption>
<tr> 
<th> ID </th>
<th> Name </th>
<th> DOB </th>
<th> Gender </th>
<th> Father's Name </th>
<th> Contact No </th>
<th> Email </th>
<th> Address </th>
<th> HighestDegree </th>
<th> Institute </th>
<th> Experience </th>
<th> Schedule </th>
<th> Previous Institutes</th>
<th> Subjects  </th>
<th> CV  </th>

</tr>
<%}%>
<%
if(list!=null){
	
	for(Teacher obj: list){
%>
<tr>
<td><%=obj.getTeacherId() %></td>
<td><%=obj.getName() %></td>
<td><%=obj.getDob() %></td>
<td><%=obj.getGender() %></td>
<td><%=obj.getFathername() %></td>
<td><%=obj.getContactNo() %></td>
<td><%=obj.getEmail() %></td>
<td><%=obj.getAddress() %></td>
<td><%=obj.getHighestDegree() %></td>
<td><%=obj.getInstitute() %></td>
<td><%=obj.getExperience() %></td>
<td><%=obj.getTeachingSchedule() %></td>
<td> <a href=""> View </a></td>
<td> <a href="TeacherSubjects?teacher_id=<%=obj.getTeacherId()%>&who=admin"> View </a></td>
<td> <a href="ViewCV?teacher_id=<%=obj.getTeacherId()%>"> View </a></td>

</tr>
<%
	}
}
%>
<%
String msg=(String)request.getAttribute("emptymsg");
if(msg!=null){
%>
<%=msg %>
<%
}
%>
</table>
</body>
</html>