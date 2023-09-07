<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Teacher Subjects</title>
</head>
<body>
<%
String who=(String)request.getAttribute("who");
if(who.equals("teacher")){
%>
<a href="teacher-panel.jsp">Back</a>
<%
}else{%>
<a href="admin-panel.jsp">Back</a>
<%
}
%>
<h2> View Subjects </h2>
<%
LinkedHashMap<Integer,String> list=(LinkedHashMap<Integer,String>) request.getAttribute("subjectlist");
String msg="No Subject Alotted ";
int sno=0;
if(list==null){
%>
<h3 style="color:red;"> <%=msg %></h3>
<%
}else{
%>
<table border="3">
<tr>
<th> SNo.</th>
<th> Subject Code </th>
<th> Subject Name</th>
</tr>
<%
for(Integer num :list.keySet()){
%>
<tr> 
<td><%=++sno %> </td>
<td><%=num %> </td>
<td><%=list.get(num) %> </td>
</tr>
<%
}
%>
</table>
<%
}%>
</body>
</html>