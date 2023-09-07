<%@page import="hbtu.com.bo.Assignment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Given Assignments</title>
</head>
<body>
<a href="teacher-panel.jsp">Back</a>
<h2>My Given Assignments & Students Solution</h2>
<%
ArrayList<Assignment> list=(ArrayList<Assignment>)request.getAttribute("mygivenassignments");
if(list.size()==0){
	String msg="No assignments given yet";
%>
<h3 style="color:red;"><%=msg %></h3>
<%
}else{%>
<table border="3">
<tr>
<th> SNo. </th>
<th> AssignmentId</th>
<th> BatchName </th>
<th> Assignment_Name</th>
<th> Due_Date</th>
<th> Given Time</th>
<th> View Assignment </th>
<th> View Submitted Solution </th>

</tr>
<%
int sno=0;
for(Assignment obj: list){
%>
<tr> 
<td> <%=++sno %></td>
<td> <%=obj.getAssignment_id() %></td>
<td> <%=obj.getBatch_name() %></td>
<td> <%=obj.getAssignment_name() %></td>
<td> <%=obj.getDue_date() %></td>
<td> <%=obj.getAssignmentGivenTime() %></td>
<td> <a href="OpenAssignmentFile?assignment_id=<%=obj.getAssignment_id()%>"> View</a></td>
<td> <a href="ViewAssignmentStudentList?assignment_id=<%=obj.getAssignment_id()%>&batch_id=<%=obj.getBatch_id()%>"> View</a></td>
</tr>
<%
}%>
</table>
<%
}
%>
</body>
</html>