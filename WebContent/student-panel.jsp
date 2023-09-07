<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

.image-container {
    width: 100%; /* Adjust width as needed */
    height: 100%; /* Adjust height as needed */
    border: 1px solid #ccc;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px auto;
    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
}

.image-container img {
    max-width: 100%;
    max-height: 100%;
}

/* Styles for the menu */
ul.menu {
  list-style-type: none;
  margin: 0;
  padding: 0;
  background-color: #333;
}

/* Styles for the menu items */
ul.menu li {
  display: inline-block;
  position: relative;
}

/* Styles for the menu item links */
ul.menu li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Styles for the child menus */
ul.submenu {
  display: none;
  position: absolute;
  background-color: #444;
}

/* Styles for the child menu items */
ul.submenu li {
  width: 200px;
}

/* Show child menus on hover */
ul.menu li:hover > ul.submenu {
  display: block;
}
</style>
</head>
<body>
<%
String username=(String)session.getAttribute("username"); 
String rollno=(String)session.getAttribute("student_id");
request.setAttribute("rollno",rollno);
%>
<% 
if(username==null || rollno==null ){
    response.sendRedirect("student-login.jsp");
}
%>
<h2 style="color:blue;"> Student Panel : Welcome <%=username %></h2>
<ul class="menu">
  <li>
    <a href="#profile">Profile</a>
    <ul class="submenu">
      <li><a href="ViewStudentProfile?vieworedit=view&rollno=<%=rollno%>">View Profile</a></li>
      <li><a href="ViewStudentProfile?vieworedit=edit&rollno=<%=rollno%>">Edit Profile</a></li>
    </ul>
  </li>
  
  <li>
    <a href="#batches">Batches</a>
    <ul class="submenu">
      <li><a href="ViewStudentEnrolledCourses?rollno=<%=rollno%>">View Enrolled Batches</a></li>
      <li><a href="JoinBatch?rollno=<%=rollno%>">Join a Batch</a></li>
    </ul>
  </li>
  <li>
    <a href="#assignment">Assignment</a>
    <ul class="submenu">
      <li><a href="SubmitAssignment?rollno=<%=rollno%>">View/Submit Assignment</a></li>
      <li><a href="ViewAndReSubmitSolution?rollno=<%=rollno%>">View My Solution/Re-Submit Assignment</a></li>
      
    </ul>
  </li>
  <li><a href="Logout?who=student">Logout</a></li>
</ul>
<div class="image-container">
        <img src= "images/a.jpg" alt="Your Image">
    </div>
</body>
</html>
    