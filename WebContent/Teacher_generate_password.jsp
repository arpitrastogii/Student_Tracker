<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Reset/Generate Password</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
    }
    .container {
      max-width: 400px;
      margin: 50px auto;
      padding: 20px;
      background-color: #ffffff;
      border-radius: 8px;
    }
    h1 {
      text-align: center;
      margin-bottom: 30px;
      color: #0f8617;
    }
    .form-group {
      margin-bottom: 20px;
    }
    label {
      display: block;
      font-weight: bold;
    }
    input[type="text"],
    input[type="email"],
    input[type="date"] {
      width: 90%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    .btn-group {
      text-align: center;
    }
    .btn {
      padding: 10px 20px;
      background-color: #0f8617;
      color: #ffffff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }
    .btn-reset {
      background-color: #dc3545;
      margin-right: 10px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1> Teacher Generate Password(First Time)</h1>
    <form action="TeacherFirstTimePassword" method="post">
      <div class="form-group">
        <label for="teacher_id">Teacher ID:</label>
        <input type="text" id="teacher_id" name="teacher_id" required>
      </div>
      <div class="form-group">
        <label for="email_id">Email:</label>
        <input type="text" id="email_id" name="email_id" required>
      </div>
      <div class="form-group">
        <label for="date_of_birth">Date of Birth:</label>
        <input type="date" id="date_of_birth" name="date_of_birth" required>
      </div>
      <div class="form-group">
        <label for="contact_no">Contact No:</label>
        <input type="text" id="contact_no" name="contact_no" required>
      </div>
      <div class="btn-group">
        <input type="submit" class="btn" value="Submit">
        <input type="reset" class="btn btn-reset" value="Reset">
      </div>
    </form>
  </div>
</body>
</html>
    