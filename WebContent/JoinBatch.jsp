<%@page import="hbtu.com.bo.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Join a Batch</title>
</head>
<a href="student-panel.jsp"> Back</a>
<h2> Join Batch</h2>
<body>
<%		
int rollno=(Integer)request.getAttribute("rollno");			
%>
<%
ArrayList<Batch> list=(ArrayList<Batch>)request.getAttribute("list");
if(list!=null){
%>
<table  border="2">
<tr>
<th>S No. </th>
<th>Batch_id</th>
<th>Batch_name</th>
<th>Subject_name</th>
<th>Teacher_name</th>
<th> Join a Batch </th>
</tr>
<%
int sno=0;
for(Batch obj: list){
%>
<tr> 
<td> <%= ++sno%></td>
<td> <%=obj.getBatch_id() %></td>
<td> <%=obj.getBatch_name() %></td>
<td> <%=obj.getSubject_name() %></td>
<td> <%=obj.getTeacher_name() %></td>
<td> 
<%
if(obj.getIsEnrolled()==null){
if(obj.getIsRequested().equals("no")){
%>
<a href="StudentBatchRequest?rollno=<%=rollno%>&batch_id=<%=obj.getBatch_id()%>">Join Batch </a>
<%
}else{
%>
Already Requested
<%
}
}else{
%>
<%="Already Joined" %>
<%
} %>
</td>

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