<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Login</title>
<style>
body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
  background-color: #f5f5f5;
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

h1 {
  margin-bottom: 20px;
  color: #4285f4;
}

form {
  width: 300px;
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 20px;
  background-color: #fff;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button {
  background-color: #4285f4;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
}

button:hover {
  background-color: #2e75ca;
}


</style>
</head>
<body>


     <div class="container">
    <h1>Admin Login</h1>
    <%
String errormsg=(String)request.getAttribute("errormsglogin");
if(errormsg!=null){
%>
<h3 style="color:red"> 
<%=errormsg %>
</h3>
<%} %>
    <form action="AdminLogin" method="post">
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username"  required="required">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password"  required="required" >
      </div>
      <button type="submit">Login</button>
      <button type="reset">Reset</button>
      
    </form>
  </div>
</body>
</html>