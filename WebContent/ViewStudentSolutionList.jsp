<%@page import="hbtu.com.bo.AssignmentSolution"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students Submitted List</title>
</head>
<body>
<a href="teacher-panel.jsp">Home</a>
<a href="ViewGivenAssignment?teacher_id=<%=session.getAttribute("teacher_id")%>">Back</a>

<h2>Solution Submitted Student List</h2>
<%
ArrayList<AssignmentSolution> list=(ArrayList<AssignmentSolution>)request.getAttribute("list");
if(list.size()==0){
	String msg="No Students found";
%>
<h3 style="color:red;"><%=msg %></h3>
<%
}else{%>
<table border="3">
<tr>
<th> SNo. </th>
<th> Student ID </th>
<th> Student_name</th>
<th> Solution Id</th>
<th> View Solution </th>
<th> View/Give Remark </th>
</tr>
<%
int sno=0;
int studentsSubmitted=0;
for(AssignmentSolution obj: list){
%>
<tr> 
<td> <%=++sno %></td>
<td> <%=obj.getRollno() %></td>
<td> <%=obj.getStudentName() %></td>
<td align="center">
<%if(obj.getSolutionId()!=0) {%> 
<%=obj.getSolutionId()%>
<%}else{
	++studentsSubmitted;%>
 <%="-" %>
 <%} %>
</td>
<td>
<%
if(obj.getSolutionId()!=0){
%> 
<a href="OpenAssignmentSolutionFile?solution_id=<%=obj.getSolutionId()%>&who=teacher"> View</a>
<%
}else{%>
<%="Not Submitted"%>
<%} %>
</td>
<td align="center">
<%
if(obj.getRemark()!=null){
%>
<%=obj.getRemark() %>
<%
}else{
%>
<%
if(obj.getSolutionId()!=0){
	if(obj.getIsViewed()!=null){
%> 

<form action="GiveRemark" method="post"> 
<input type="hidden" name="solution_id" value="<%=obj.getSolutionId()%>">
<input type="hidden" name="assignment_id" value="<%=request.getAttribute("assignment_id")%>">
<input type="hidden" name="batch_id" value="<%=request.getAttribute("batch_id")%>">
<input type="text" name="remark">
<input type="submit" value="Submit">
</form>
<%
}else{
%>
<%="Assignment Solution Not Viewed" %>
<%
}
}else{%>
<%="-"%>
<%} %>
</td>
</tr>
<%
}
}%>
</table>
<h3>Total Student= <%=list.size() %></h3>
<h3>Assignment Submitted = <%=studentsSubmitted %></h3>
<h3>Assignment Not Submitted =<%=list.size()-studentsSubmitted %></h3>
<%
}
%>

</body>
</html>