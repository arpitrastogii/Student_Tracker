<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.TreeMap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faculty Allotment page</title>
</head>
<body>
<form action="FetchBatches" method="post"> 
<input type="Submit" value="Back"> 
</form>
<h2> Allotment of Faculty</h2>
<%
String batch_name=(String)request.getAttribute("batch_name");
int batch_id=(Integer)request.getAttribute("batch_id");
String msg="No faculty available for this subject";
%>
<%
LinkedHashMap<Integer,String> teachermap =(LinkedHashMap<Integer,String>)request.getAttribute("teachermap");
if(teachermap.size()==0){
%>
<h2 style="color:red;"> <%=msg %></h2>
<%
}
%>
<form action="BatchAllotmentFinal" method="post">
<table border="2">
<tr>
<td> Batch Name:</td>
<input type="hidden" name="batch_id" value="<%=batch_id%>">
<td> <input type="text" name="batch_name" value="<%=batch_name%>" disabled> </td>
</tr>
<tr>
<td> Faculty Name:</td>
<td> <select name="faculty"> 
<%
for(Integer teacher_id: teachermap.keySet()){
%>
<option  value="<%=teacher_id %>"> <%=teachermap.get(teacher_id)+"("+teacher_id+")" %> </option>
<%
}
%>
</select> </td>
</tr>
<tr> <td colspan="2" align="right"> <input type="submit" value="Submit"></td></tr>
</table>

</form>
</body>
</html>