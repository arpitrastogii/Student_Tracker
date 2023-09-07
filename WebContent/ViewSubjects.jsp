<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedHashMap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Subjects</title>
</head>
<body>
<a href="admin-panel.jsp"> Back</a>
<h2>
View Subjects
</h2>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<%=msg %>
<%
}
%>

<%
LinkedHashMap<Integer,String> subjectlist=(LinkedHashMap<Integer,String>)request.getAttribute("map");
if(subjectlist!=null){
%>
<table border="2">
<tr>
<th> Subject ID </th>
<th> Subject Name </th>
<th> Can Teach </th>
<th> View Batches</th>
</tr>
<%
for(Integer keys: subjectlist.keySet()){
%>
<tr>
<td> <%= keys %>  </td>
<td> <%= subjectlist.get(keys) %>  </td>
<td> <a href="SubjectTeachersFetch?id=<%=keys%>">View </a></td>
<td> <a href="DisplayBatchFaculty?subject_id=<%=keys%>">View </a></td>
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