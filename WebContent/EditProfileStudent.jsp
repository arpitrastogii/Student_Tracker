<%@page import="hbtu.com.bo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>
<a href="student-panel.jsp"> Back </a>
<%
Student student=(Student)request.getAttribute("studentobj");
%>
<h2> Edit Profile</h2>
<form action="EditProfileStudent" method="post">
    <table border="2">
     <tr>
     <td>   <label for="studentName">Student Name:</label> </td>
     <td>   <input type="text" name="studentName" id="studentName" value="<%=student.getStudentName()%>" disabled></td>
        </tr>
        <%
          String gender=student.getGender();
        %>
        <tr>
        <td><label for="gender">Gender:</label> </td>
        <td> <input type="radio" name="gender" value="Male"  <%=gender.equalsIgnoreCase("male")? "checked":"" %> >
        <label for="genderMale">Male</label>
        <input type="radio" name="gender" value="Female"  <%=gender.equalsIgnoreCase("female")? "checked":"" %> >
        <label for="genderFemale">Female</label></td>
        </tr>
        <tr>
        <td><label for="course">Course:</label> </td>
        <td><input type="text" name="course" id="course"value="<%=student.getCourse()%>" ></td>
        </tr>
      <tr>
       <td> <label for="dob">Date of Birth:</label> </td>
        <td><input type="date" name="dob" id="dob" value="<%=student.getDob()%>" ></td>
   </tr>     
   <tr>
       <td> <label for="fatherName">Father's Name:</label></td>
        <td><input type="text" name="fatherName" id="fatherName" value="<%=student.getFatherName()%>" ></td>
        </tr>
        <tr>
       <td> <label for="address">Address:</label></td>
        <td><textarea name="address" id="address" rows="3"> <%=student.getAddress()%> </textarea></td>
        <tr>
       <td> <label for="city">City:</label></td>
        <td><input type="text" name="city" id="city" value="<%=student.getCity()%>"></td>
        </tr>
        <tr>
        <td><label for="state">State:</label></td>
       <td> <input type="text" name="state" id="state" value="<%=student.getState()%>"></td>
        </tr>
        <tr>
        <td><label for="pincode">Pincode:</label></td>
        <td><input type="text" name="pincode" id="pincode" value="<%=student.getPincode()%>" ></td>
        </tr>
        <tr>
      <td>  <label for="contactNo">Contact Number:</label></td>
      <td> <input type="text" name="contactNo" id="contactNo" value="<%=student.getContactNo()%>" ></td>
      </tr>
        <tr>
        <td><label for="emailId">Email ID:</label></td>
        <td><input type="text" name="emailId" id="emailId" value="<%=student.getEmailId()%>" ></td>
        </tr>
          <input type="hidden" id="rollnohidden" name="rollnohidden" value="<%=student.getRollno() %>"> 
        <tr>
        <td>   <input type="submit" value="Update">  </td>
        </tr>
        </table>
    </form> 

</body>
</html>