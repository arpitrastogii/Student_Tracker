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
      color: #007bff;
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
      background-color: #007bff;
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
    <h1>Reset/Generate Password</h1>
    <form action="ResetForgotService" method="post">
      <div class="form-group">
        <label for="student_id">Student ID:</label>
        <input type="text" id="student_id" name="student_id" required>
      </div>
      <div class="form-group">
        <label for="email_id">Email:</label>
        <input type="text" id="email_id" name="email_id" required>
      </div>
      <div class="form-group">
        <label for="date_of_birth">Date of Birth:</label>
        <input type="text" id="date_of_birth" name="date_of_birth" required>
      </div>
      <div class="form-group">
        <label for="address_pincode">Address Pincode:</label>
        <input type="text" id="address_pincode" name="address_pincode" required>
      </div>
      <div class="btn-group">
        <input type="submit" class="btn" value="Submit">
        <input type="reset" class="btn btn-reset" value="Reset">
      </div>
    </form>
  </div>
</body>
</html>
    