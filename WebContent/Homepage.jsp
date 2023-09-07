<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
  <title>Student Tracker</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
    }

     {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }

    .logo {
      font-size: 36px;
      font-weight: bold;
      color: #4285f4;
      margin-bottom: 20px;
    }

    /* Button container styles */
    .button-container {
      display: flex;
      gap: 20px;
    }

    /* Generic button styles */
    .button {
      padding: 12px 20px;
      font-size: 16px;
      font-weight: bold;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    /* Specific button styles */
    .admin {
      background-color: #4285f4;
    }

    .teacher {
      background-color: #34a853;
    }

    .student {
      background-color: #fbbc05;
    }
  </style>
</head>

<body>
  <div class="container">
    <div class="logo">Student Tracker</div>
    <div class="button-container">
      <a class="button admin" href="admin-login.jsp">Admin Login</a>
      <br>
      <a class="button teacher" href="teacher-login.jsp">Teacher Login</a>
      <br>
      <a class="button student" href="student-login.jsp">Student Login</a>
      <br>
    </div>
  </div>
</body>

</html>
