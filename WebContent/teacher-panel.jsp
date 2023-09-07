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
String teacher_name=(String)session.getAttribute("teacher_name"); 
String teacher_id= (String) session.getAttribute("teacher_id");
%>
<% 
if(teacher_name==null || teacher_id==null){
    response.sendRedirect("teacher-login.jsp");
}
%>
<h2 style="color:blue;"> Teacher Panel : Welcome <%=teacher_name %></h2>
<ul class="menu">
  
  <li>
    <a href="#profile">Profile</a>
    <ul class="submenu">
      <li><a href="ViewTeacherProfile?teacher_id=<%=teacher_id%>&vieworedit=view">View Profile</a></li>
      <li><a href="EditTeacherProfile?teacher_id=<%=teacher_id%>&vieworedit=edit">Edit Profile</a></li>
      <li><a href="#">Previous Institutes</a>
       <ul class="submenu">
           <li><a href="#">Add  Previous Institutes</a></li>
           <li><a href="#">View Previous Institutes</a></li>
           <li><a href="#">Edit Previous Institutes</a></li>           
       </ul>
      </li>
     
    </ul>
  </li>
      <li><a href="#courses">My Courses</a>
      <ul class="submenu">
          <li><a href="TeacherSubjects?teacher_id=<%=teacher_id%>&who=teacher">View Courses </a></li>           
           <li><a href="#">Add Courses </a></li>
           <li><a href="#">Delete Courses</a></li> 
      </ul>
      </li>
  <li>
    <a href="#batches">Batches</a>
    <ul class="submenu">
      <li><a href="MyBatches?teacher_id=<%=teacher_id%>&forwardlocation=viewbatch">My Batches and Students</a></li>
    </ul>
  </li>
  <li>
    <a href="#assignment">Assignment</a>
    <ul class="submenu">
      <li><a href="MyBatches?teacher_id=<%=teacher_id%>&forwardlocation=giveassignment">Give Assignment</a></li>
      <li><a href="ViewGivenAssignment?teacher_id=<%=teacher_id%>">View Given Assignment</a></li>
    </ul>
  </li>
  <li><a href="Logout?who=teacher">Logout</a></li>
</ul>
<div class="image-container">
        <img src= "images/teacher.jpg" alt="Your Image">
    </div>
</body>
</html>
    