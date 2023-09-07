<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Give Assignment</title>
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
  }
  .container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  }
  h2 {
    margin-bottom: 15px;
    color: #333;
  }
  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
    color: #555;
  }
  select, input[type="text"], input[type="file"], input[type="date"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #fff;
    color: #555;
  }
  input[type="file"] {
    padding: 8px;
  }
  input[type="submit"] {
    background-color: #007BFF;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
</style>
</head>
<body>
<a href="teacher-panel.jsp">Back</a>
<%
LinkedHashMap<Integer,String> batchlist=(LinkedHashMap<Integer,String>)request.getAttribute("batchlist");
if(batchlist==null){
	String msg="No Allotted batches found";
%>
 <h2> <%=msg %> </h2>
<%
}else{
%>
  <div class="container">
    <h2>Give Assignment</h2>
    <form action="GiveAssignment" method="post" enctype="multipart/form-data">
      <label for="batch_name">Batch Name</label>
      <select id="batch_name" name="batch_name">
      <%
      for(Integer keys:batchlist.keySet()){
      %>  
      <option value=<%=keys %>> <%=batchlist.get(keys)+"("+keys+")" %></option>
      <%
      }%>
      </select>
      <label for="assignment_name">Assignment Name</label>
      <input type="text" id="assignment_name" name="assignment_name" required>
      <label for="assignment">Upload Assignment (PDF)</label>
      <input type="file" id="assignment" name="assignment" accept=".pdf" required>
      <label for="due_date">Due Date</label>
      <input type="date" id="due_date" name="due_date" required>
      <input type="submit" value="Submit Assignment">
    </form>
  </div>
  <%
  }
  %>
</body>