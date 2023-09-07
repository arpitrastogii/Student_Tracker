<%@page import="hbtu.com.bo.AssignmentSolution"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View My Submitted Solutions</title>
</head>
<body>
<a href="student-panel.jsp"> Back</a>
<h2> View My Submitted Solutions</h2>
<%
ArrayList<AssignmentSolution> list=(ArrayList<AssignmentSolution>)request.getAttribute("list");
if(list.size()==0){
%>
<h3 style="color:red;"> No Submitted Solutions found</h3>
<%
}else{%>
<table border="3">
<tr> 
<th>S No. </th>
<th>Solution Id </th>
<th> Assignment Name</th>
<th> Viewed By Teacher </th>
<th> Remark</th>
<th> View Submitted Solution </th>
<th> ReSubmit Solution</th>
</tr>
<%
int sno=0;
for(AssignmentSolution obj: list){
%>
<tr> 
<td><%= ++sno%> </td>
<td> <%=obj.getSolutionId() %></td>
<td> <%=obj.getAssignmentName() %> </td>
<td align="center"> 
<%
if(obj.getIsViewed()!=null){
%>
<%="Yes" %>
<%}else{ %>
<%="-" %>
<%} %>
</td>
<td align="center"> 
<%
if(obj.getRemark()==null){
%>
<%="-"%>
<%}else{ %>
<%=obj.getRemark() %>
<%} %>
</td>

<td> <a href="OpenAssignmentSolutionFile?solution_id=<%=obj.getSolutionId()%>&who=student"> View</a></td>
<td>
<%
if(obj.getIsViewed()==null){
%>
 <a href="ReSubmitAssignmentSolution.jsp?solution_id=<%=obj.getSolutionId()%>"> Re-Submit</a>
 <%
 }else{%>
 <%="Solution Already Seen by Teacher" %>
 <%
 }%>
 </td>
</tr>
<%
}%>
</table>
<%} %>
</body>
</html>