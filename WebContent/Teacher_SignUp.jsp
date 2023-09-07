<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Sign up</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f1f1f1;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 600px;
    margin: 50px auto;
    background-color: #fff;
    padding: 30px;
    border-radius: 5px;
}

h1 {
    text-align: center;
    color: #444;
}

fieldset {
    margin-bottom: 20px;
    border: 1px solid #ddd;
    padding: 15px;
}

legend {
    font-size: 1.2em;
    font-weight: bold;
    color: #444;
}

label {
    display: block;
    margin-bottom: 8px;
    color: #666;
}

input[type="text"],
input[type="email"],
input[type="tel"],
input[type="number"],
select,
textarea {
    width: 90%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 3px;
    margin-bottom: 10px;
}

textarea {
    resize: vertical;
}

input[type="radio"] {
    margin-right: 5px;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: #fff;
    padding: 12px 20px;
    border: none;
    border-radius: 3px;
    cursor: pointer;
    font-weight: bold;
}

input[type="submit"]:hover {
    background-color: #45a049;
}


</style>
</head>

<body>
<%
String msg=(String)request.getAttribute("message");
if(msg!=null){
%>
<h1> <%=msg %></h1>
<%} %>
    <div class="container">
        <h1>Teacher Signup Form</h1>
        <form action="AddTeacherService" method="post" enctype="multipart/form-data">
            <!-- Personal Information Section -->
            <fieldset>
                <legend>Personal Information</legend>
                <!-- Full Name -->
                <label for="fullname">Full Name:</label>
                <input type="text" id="fullname" name="fullname" placeholder="Enter Name" required>
                <!-- Date of Birth -->
                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" required>
                <!-- Gender -->
                <label>Gender:</label>
                <input type="radio" id="male" name="gender" value="male" required>
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="female" required>
                <label for="female">Female</label>
                <!-- Father's Name -->
                <label for="fathername">Father's Name:</label>
                <input type="text" id="fathername" name="fathername" placeholder="Enter Father's Name" required>
                <!-- Contact Number -->
                <label for="contact">Contact Number:</label>
                <input type="tel" id="contact" name="contact" placeholder="Enter Contact No."required>
                <!-- Email Address -->
                <label for="email">Email Address:</label>
                <input type="email" id="email" name="email" placeholder="Enter EmailID" required>
                <!-- Home Address -->
                <label for="address">Home Address:</label>
                <textarea id="address" name="address" rows="3" placeholder="Enter Address"required></textarea>
            </fieldset>

            <!-- Educational Background Section -->
            <fieldset>
                <legend>Educational Background</legend>
                <!-- Highest Degree Attained -->
                <label for="degree">Highest Degree Attained:</label>
                <input type="text" id="degree" name="degree" required>
                <!-- Name of Institution -->
                <label for="institution">Name of Institution:</label>
                <input type="text" id="institution" name="institution" placeholder="Enter Name of Institution" required>
            </fieldset>

            <!-- Teaching Experience Section -->
            <fieldset>
                <legend>Teaching Experience</legend>
                <!-- Total Years of Teaching Experience -->
                <label for="experience">Total Years of Teaching Experience:</label>
                <input type="number" id="experience" name="experience" required>
                <!-- Name of Schools/Institutions Worked -->
                <label for="worked">Name of Schools/Institutions Worked:</label>
                <input type="text" id="worked" name="worked" placeholder="Enter schools/Institution Name (if 2 or more use (,)Comma)"required>
                <!-- Subjects/Courses Taught -->
                <label for="subjects1">Subjects/Courses Taught:</label>
                <fieldset>
                <%
                   Map<Long,String> map= (Map<Long,String>)request.getAttribute("map");
                if(map!=null){
                	for(Long key: map.keySet()){
                %>                
              <label> <input type="checkbox" name="subjects" value="<%=key %>" ><%=map.get(key) %> </label>                
                <%
                  }
                }
                %>
               
               </fieldset>
                
            </fieldset>

            <!-- Teaching Preferences Section -->
            <fieldset>
                <legend>Teaching Preferences</legend>
                <!-- Preferred Teaching Schedule -->
                <label for="schedule">Preferred Teaching Schedule:</label>
                <select id="schedule" name="schedule" required>
                    <option value="full-time">Full-time</option>
                    <option value="part-time">Part-time</option>
                </select>
            </fieldset>

            <!-- Resume/CV Upload Section -->
            <fieldset>
                <legend>Resume/CV Upload</legend>
                <label for="resume">Upload your resume/CV:</label>
                <input type="file" id="resume" name="resume" accept=".pdf" required>
            </fieldset>

            <!-- Submit Button -->
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>