<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
 
    <title>ReSubmit Assignment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .heading {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input[type="file"] {
            display: block;
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .submit-btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #3498db;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
			<%
            String solution_id=request.getParameter("solution_id");
            %>
             
    <div class="container">
        <h1 class="heading">Re-Submit Assignment Solution</h1>
        <form action="ReSubmitAssignmentSolution" method="post" enctype="multipart/form-data">
            <input type="hidden" name="solution_id" value="<%=solution_id%>">
            <div class="form-group">
                 <label for="fileUpload">Select Assignment Solution:</label>
                <input type="file" id="fileUpload" name="fileUpload" accept=".pdf" required>
            </div>           
            
            <input type="submit" class="submit-btn"></input>
        </form>
    </div>
</body>
</html>
