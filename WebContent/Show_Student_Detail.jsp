<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="hbtu.com.bo.Student" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Student</title>
</head>
<body>
<a href="search-student.jsp">Back</a>
<%Student studentobj=(Student)request.getAttribute("studentobj");
%>
<h2> Student Details</h2>
<table border="1">
    <tr>
     <td>   <label for="studentID">StudentID:</label> </td>
     <td>   <%=studentobj.getRollno() %></td>
     </tr>
     <tr>
     <td>   <label for="studentName">Student Name:</label> </td>
     <td>   <%=studentobj.getStudentName() %></td>
        </tr>
        <tr>
        <td><label for="gender">Gender:</label> </td>
        <td> <%=studentobj.getGender() %></td>
        </tr>
        <tr>
        <td><label for="course">Course:</label> </td>
        <td><%=studentobj.getCourse() %></td>
        </tr>
      <tr>
       <td> <label for="dob">Date of Birth:</label> </td>
        <td><%=studentobj.getDob() %></td>
   </tr>     
   <tr>
       <td> <label for="fatherName">Father's Name:</label></td>
               <td><%=studentobj.getFatherName() %></td>       
        </tr>
        <tr>
       <td> <label for="address">Address:</label></td>
               <td><%=studentobj.getAddress() %></td>
       
        <tr>
       <td> <label for="city">City:</label></td>
        <td><%=studentobj.getCity() %></td>
        </tr>
        <tr>
        <td><label for="state">State:</label></td>
        <td><%=studentobj.getState() %></td>
        </tr>
        <tr>
        <td><label for="pincode">Pincode:</label></td>
        <td><%=studentobj.getPincode() %></td>
        </tr>
        <tr>
      <td>  <label for="contactNo">Contact Number:</label></td>
        <td><%=studentobj.getContactNo() %></td>
      </tr>
        <tr>
        <td><label for="emailId">Email ID:</label></td>
        <td><%=studentobj.getEmailId() %></td>
        </tr>
        </table>
</body>
</html>