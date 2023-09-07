<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="hbtu.com.bo.Assignment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Assignments</title>
</head>
<h3> View & Submit Assignment</h3>
<body>
<a href="student-panel.jsp">Back</a>
<%
ArrayList<Assignment> list=(ArrayList<Assignment>)request.getAttribute("list");
if(list==null){
%>
<h3 style="color:red;">No Assignments found </h3>
<%
}else{%>
<table border="3">
<tr>
<th> S No. </th>
<th> Assignment ID </th>
<th> Batch_Name</th>
<th> Assignment_Name</th>
<th> Teacher Name</th>
<th> Upload Time</th>
<th> Due_Date</th>
<th> View Assignment</th>
<th> Submit </th>
</tr>
<%
int sno=0;
for(Assignment obj :list){
%>
<tr>
<td><%=++sno %> </td>
<td><%=obj.getAssignment_id() %> </td>
<td><%=obj.getBatch_name() %></td>
<td><%=obj.getAssignment_name() %></td>
<td><%=obj.getTeacher_name() %> </td>
<td><%=obj.getAssignmentGivenTime() %> </td>
<td><%=obj.getDue_date()%> </td>

<td><a href="OpenAssignmentFile?assignment_id=<%=obj.getAssignment_id()%>">View</a> </td>
<td><%
if(obj.getIsSubmitted().equals("yes")){ 
	String msg="Already Submitted";
%> 
<%=msg %>
<%
}else if(obj.getIsSubmitted().equals("no")){
	Date sqlDate=obj.getDue_date();
	LocalDate sqlDate1=sqlDate.toLocalDate();
	LocalDate today=LocalDate.now();
	int com=today.compareTo(sqlDate1);
	if(com<=0){
		String student_id=(String)session.getAttribute("student_id");
		request.setAttribute("student_id",student_id);
%>
<a href="SubmitAssignmentSolution.jsp?assignment_id=<%=obj.getAssignment_id()%>&student_id=<%=student_id%>" >Submit Assignment</a>
<% }else{ 
String msg="DueDate is crossed";	
%>
<%=msg %>
<%
}
}%>
</td>

</tr>
<%
}%>
</table>
<%
}
%>
</body>
</html>