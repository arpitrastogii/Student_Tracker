<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"  %>
<%@page import="hbtu.com.bo.Batch"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<a href="admin-panel.jsp">Back</a>
<h2> Allot Faculty</h2>
<%
String msg=(String)request.getAttribute("successmsg");
if(msg!=null){
%>
<h3 color="red"> <%=msg %></h3>
<%
}
%>
<%
ArrayList<Batch> list=(ArrayList<Batch>)request.getAttribute("batchlist");
if(list==null){
%>
All Batches have Faculty
<%
}else{
%>
<table border="2">
<caption><%=list.size() %> Batch has no Faculty</caption>

<tr>
<th> Batch_id </th>
<th> Batch_name </th>
<th> Subject_ID </th>

<th> Subject_name </th>
<th> Allot Batch </th>
</tr>
<%
	for(Batch batch : list){
%>

<tr>
<td> <%=batch.getBatch_id() %></td>
<td> <%=batch.getBatch_name() %></td>
<td> <%=batch.getSubject_id()%></td>
<td> <%=batch.getSubject_name()%></td>
<td>  <form action="AllotTeacher" method="post">
<input type="hidden"  name="batch_id" value="<%=batch.getBatch_id()%>">
<input type="hidden"  name="batch_name" value="<%=batch.getBatch_name()%>">
<input type="hidden"  name="subject_id" value="<%=batch.getSubject_id()%>">


<input type="submit" value="Allot"> </form></td>
</tr>
<%	
}
}%>
</table>
</body>
</html>