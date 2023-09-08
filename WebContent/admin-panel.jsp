<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="hbtu.com.logout.Logout" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin Panel</title>
    <style>
        /* Reset some default browser styles */
        body, form {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        /* Header Styles */
        h1 {
            background-color: #007bff;
            color: white;
            text-align: center;
            padding: 10px;
            margin: 0;
        }

        /* Logout Button Styles */
        form[action="Logout"] {
            text-align: right;
            margin: 10px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }

        /* Welcome Message Styles */
        h2 {
            text-align: center;
            margin-top: 20px;
        }

        /* Main Container */
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        /* Fieldset Styles */
        fieldset {
            flex: 0 0 calc(33.33% - 40px); /* Adjust as needed for your layout */
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin: 20px;
        }

        legend {
            font-weight: bold;
            color: #007bff;
        }

        /* Button Styles */
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
            margin: 5px;
        }
    </style>
</head>
<body>
    <form action="Logout" method="get">
        <input type="hidden" name="who" value="admin">
        <input type="submit" value="Logout">
    </form>
    <% String username=(String)session.getAttribute("username");
    if(username==null){
    	response.sendRedirect("admin-login.jsp");
    %>    
    <%}else{ %>
    <h1>Welcome user: <%= username %></h1>
    <h2>Admin Panel</h2>

    <div class="container">
        <fieldset>
        <legend>Student Section</legend>
        <form action="ViewAllStudentController" method="post">
            <input type="submit" value="All Admitted Students">
        </form>
        <form action="search-student.jsp" method="post">
            <input type="submit" value="Search Students">
        </form>
        <form action="AdmitStudent" method="post">
            <input type="submit" value="Admit Students">
        </form>
        <form action="update-student.jsp" method="post">
            <input type="submit" value="Update Student Details">
        </form>
        <form action="StudentRequestView" method="post">
            <input type="submit" value="Enroll Students to batches">
        </form>
        <form action="" method="post">
            <input type="submit" value="Block Student">
        </form>
        </fieldset>

        <fieldset>
        <legend>Teacher Section</legend>
        <form action="AllHiredFaculty" method="post">
            <input type="submit" value="All Hired Faculty">
        </form>
        <form action="SearchTeacher.jsp" method="post">
            <input type="submit" value="Search Faculty">
        </form>
        <form action="AdmitTeacher" method="post">
            <input type="submit" value="Hire Faculty">
        </form>
        <form action="" method="post">
            <input type="submit" value="Block Faculty">
        </form>
    </fieldset>

    <fieldset>
        <legend>Courses and Batches</legend>
        <form action="AddSubject.jsp" method="post">
            <input type="submit" value="Add Subject">
        </form>
        <form action="ViewSubjectController" method="post">
            <input type="submit" value="View Subject">
        </form>
        <form action="AddBatchSubjectFetch" method="post">
            <input type="submit" value="Add Batch">
        </form>
        <form action="ViewBatchesAndStudents" method="post">
            <input type="submit" value="View Batches & Enrolled Students">
        </form>
        <form action="FetchBatches" method="post">
            <input type="submit" value="Allot Faculty">
        </form>
    </fieldset>
    </div>
    <%} %>
</body>
</html>
