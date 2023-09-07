<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="admin-panel.jsp"> Home</a>

<h1>Delete Student </h1>
    
    
    <form action="DeleteController" method="post">
        <label for="rollNo">Enter Roll Number:</label>
        <input type="text" id="rollNo" name="rollNo">
        <input type="submit" value="Delete Data">
    </form>
    
       
    
           

</body>
</html>