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

import hbtu.com.connection.ProjectConnection;
import hbtu.com.bo.Student;
import java.util.*;
/**
 * Servlet implementation class SearchByNameController
 */
@WebServlet("/SearchByName")
public class SearchByNameController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		ArrayList<Student> list=new ArrayList<Student>();
		Connection con=null;
		Statement stmt=null;
		String name=request.getParameter("name");
		boolean isEmpty=true;
		try{
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select * from student where lower(studentname) like lower('"+name+"%')";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				isEmpty=false;
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
				 list.add(new Student(ID,studentName,gender,course,dob,fatherName,address,city,state,pincode,contactNo,emailId));
	}
			if(isEmpty==true){
				String errormessage="Student Name not found";
				request.setAttribute("errormessage",errormessage);
				request.getRequestDispatcher("search-student.jsp").forward(request, response);
			}else{
				request.setAttribute("list", list);
				request.setAttribute("searchbynamerollno","searchbynamerollno" );
				request.getRequestDispatcher("show-student-admitted.jsp").forward(request, response);

			}
		}catch(SQLException ae){
			ae.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
