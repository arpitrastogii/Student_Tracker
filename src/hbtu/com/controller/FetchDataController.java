package hbtu.com.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.Student;

/**
 * Servlet implementation class FetchDataController
 */
@WebServlet("/FetchDataController")
public class FetchDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int rollno=Integer.parseInt(request.getParameter("rollNo"));
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			con=DriverManager.getConnection(url,"system","root");
			stmt=con.createStatement();
			String query="select * from student where rollno="+rollno;
			rs=stmt.executeQuery(query);
			boolean isEmpty=true;
			if(rs.next()){
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
				isEmpty=false;
				Student obj1=new Student(studentName,gender,course,dob,fatherName,address,city,state,pincode,contactNo,emailId);
                obj1.setRollno(rollno);
				request.setAttribute("obj1",obj1);
                
			}
			
			
			if(isEmpty==true){
				request.setAttribute("message","Student ID not found try/again");
				
			}
		}catch(ClassNotFoundException e){			
			System.out.println("Class not found"+e.getMessage());
		}catch(SQLException e){			
			System.out.println("SQL Exception found"+e.getMessage());
		}try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("update-student.jsp").forward(request, response);
	}

}
