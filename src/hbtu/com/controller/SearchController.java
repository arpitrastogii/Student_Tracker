package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.Student;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchServiceID")
public class SearchController extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int studentID=Integer.parseInt(request.getParameter("studentid"));
       Student studentobj=null;
       
       Connection con=null;
       Statement stmt=null;
			try{
			 con=ProjectConnection.getConnection();
			 stmt=con.createStatement();
			 String query="select * from student where rollno="+studentID;
			 ResultSet rs=stmt.executeQuery(query);
			 if(rs.next()){
				 int ID=rs.getInt("ROLLNO");
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
				 studentobj= new Student(ID,studentName,gender,course,dob,fatherName,address,city,state,pincode,contactNo,emailId);

			 }
			 if(studentobj!=null){
				 request.setAttribute("studentobj", studentobj);
				 request.getRequestDispatcher("Show_Student_Detail.jsp").forward(request, response);
			 }else{
				 String errormessage="Student_Id not found";
				 request.setAttribute("errormessage",errormessage);
				 request.getRequestDispatcher("search-student.jsp").forward(request, response);
			 }
			 
			}catch(SQLException e){
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
