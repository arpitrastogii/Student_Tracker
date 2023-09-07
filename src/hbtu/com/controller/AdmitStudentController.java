package hbtu.com.controller;

import java.io.IOException;
import java.util.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.Student;

/**
 * Servlet implementation class ViewAllStudentController
 */
@WebServlet("/AdmitStudent")
public class AdmitStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg=(String)request.getAttribute("msgAfterAdmitUnadmit");
		
		// TODO Auto-generated method stub
		ArrayList<Student> list=new ArrayList<Student>();
		Connection con=null;
		ResultSet rs=null;
		Statement stmt=null;
		  try{
		     Class.forName("oracle.jdbc.driver.OracleDriver");
			 String url="jdbc:oracle:thin:@localhost:1521:XE";
			 con=DriverManager.getConnection(url,"system","root");
			 stmt=con.createStatement();
			 String query="select * from student where isAdmited is null and isdeleted is null order by rollno";
			 rs=stmt.executeQuery(query);
			  boolean isEmpty=true;
			  while(rs.next()){
				     int rollno=rs.getInt("ROLLNO");
				     String studentName=rs.getString("STUDENTNAME");
					 String gender=rs.getString("GENDER");
					 String course=rs.getString("COURSE");
					 String dob=rs.getString("DOB");
					 String fatherName=rs.getString("FATHERNAME");
					 String address=rs.getString("ADDRESS");
					 String city=rs.getString("CITY");
					 String state=rs.getString("STATE");
					 int pincode=rs.getInt("PINCODE");
					 long contactNo=rs.getLong("CONTACTNO");
					 String emailId=rs.getString("EMAILID");
			  list.add(new Student(rollno,studentName,gender,course,dob,fatherName,address,city,state,pincode,contactNo,emailId));
			  }
			  request.setAttribute("list", list);
			 }catch(ClassNotFoundException e){
		     e.printStackTrace();
		  }catch(SQLException e){
		     e.printStackTrace();
		  }
		  try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  if(msg!=null)
		  request.setAttribute("message", msg);
          RequestDispatcher dispatcher=request.getRequestDispatcher("admit-student.jsp");
          dispatcher.forward(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
