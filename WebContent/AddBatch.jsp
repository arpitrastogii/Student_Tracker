<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.LinkedHashMap" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Batch</title>
</head>
<body>
<a href="admin-panel.jsp">Back</a>
<%
String msg=(String)request.getAttribute("batchmsg");
if(msg!=null){
%>
<h3 style="color:red;">
<%=msg %>
</h3>
<%
}else
%>
<h2>
Create Batch
</h2>
<form action="CreateBatchController" method="post">
<table border="2">
  <tr>
     <td>Enter Batch Name: </td>
     <td><input type="text" name="batchname" required></td>
 </tr>
  <tr>
     <td>Select Subject Name: </td>
     <td><select name="subject">
     <%
     LinkedHashMap<Long, String> map=(LinkedHashMap<Long, String>)request.getAttribute("map");
    if(map!=null){
     for(Long key: map.keySet()){
    %>
      <option value="<%= key %>"> <%=map.get(key) %></option>
     
     <%} 
     
    }%>
     </select>
     </td>      
  </tr>
  <tr>
  <td colspan="2" align ="right"><input type="submit" value="Create Batch"> </td>
  </tr>
</table>
</form>
</body>
</html>