<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<a href="home.jsp"> Home</a>

<h1>Add Student</h1>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<h3 style="color:red;"> 
<%=msg %>
</h3>
<%} %>
    <form action="AddStudentService" method="post">
    <table border="1">
     <tr>
     <td>   <label for="studentName">Student Name:</label> </td>
     <td>   <input type="text" name="studentName" id="studentName" ></td>
        </tr>
        <tr>
        <td><label for="gender">Gender:</label> </td>
        <td> <input type="radio" name="gender" value="Male" id="genderMale" >
        <label for="genderMale">Male</label>
        <input type="radio" name="gender" value="Female" id="genderFemale">
        <label for="genderFemale">Female</label></td>
        </tr>
        <tr>
        <td><label for="course">Course:</label> </td>
        <td><input type="text" name="course" id="course" ></td>
        </tr>
      <tr>
       <td> <label for="dob">Date of Birth:</label> </td>
        <td><input type="date" name="dob" id="dob" ></td>
   </tr>     
   <tr>
       <td> <label for="fatherName">Father's Name:</label></td>
        <td><input type="text" name="fatherName" id="fatherName" ></td>
        </tr>
        <tr>
       <td> <label for="address">Address:</label></td>
        <td><textarea name="address" id="address" rows="3" ></textarea></td>
        <tr>
       <td> <label for="city">City:</label></td>
        <td><input type="text" name="city" id="city" ></td>
        </tr>
        <tr>
        <td><label for="state">State:</label></td>
       <td> <input type="text" name="state" id="state" ></td>
        </tr>
        <tr>
        <td><label for="pincode">Pincode:</label></td>
        <td><input type="text" name="pincode" id="pincode" ></td>
        </tr>
        <tr>
      <td>  <label for="contactNo">Contact Number:</label></td>
      <td> <input type="text" name="contactNo" id="contactNo" ></td>
      </tr>
        <tr>
        <td><label for="emailId">Email ID:</label></td>
        <td><input type="text" name="emailId" id="emailId" ></td>
        </tr>
        <tr>
        <td>  <input type="submit" value="Submit"> </td>
        </tr>
        </table>
    </form>
</body>
</html>