package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudentController
 */
@WebServlet("/AddStudentService")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		String studentName=request.getParameter("studentName");
		 String gender=request.getParameter("gender");
		 String course=request.getParameter("course");
		 String dob=request.getParameter("dob");
		 String fatherName=request.getParameter("fatherName");
		 String address=request.getParameter("address");
		 String city=request.getParameter("city");
		 String state=request.getParameter("state");
		 int pincode=Integer.parseInt(request.getParameter("pincode"));
		 long contactNo=Long.parseLong(request.getParameter("contactNo"));
		 String emailId=request.getParameter("emailId");
		 
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 
		 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 String url="jdbc:oracle:thin:@localhost:1521:XE";
			 con=DriverManager.getConnection(url, "system", "root");
			 System.out.println("database connected");
			 String query="insert into student(rollno,studentname,gender,course,dob,fathername,address,city,state,pincode,contactno,emailid)values(studentrollno.nextval,?,?,?,?,?,?,?,?,?,?,?)";
			 System.out.println(query);
             pstmt=con.prepareStatement(query);
             pstmt.setString(1,studentName);
             pstmt.setString(2,gender);
             pstmt.setString(3,course);
             pstmt.setString(4,dob);
             pstmt.setString(5,fatherName);
             pstmt.setString(6,address);
             pstmt.setString(7,city);
             pstmt.setString(8,state);
             pstmt.setInt(9, pincode);
             pstmt.setLong(10,contactNo);
             pstmt.setString(11,emailId);
             
             int x=pstmt.executeUpdate();
             
             if(x!=0){
            	 System.out.println("Student added successfully");
            	 String msg="Form Submitted to Admin: now wait for admin response";
            	 request.setAttribute("msg", msg);

            	 request.getRequestDispatcher("AddStudentForm.jsp").forward(request, response);

             }
		 }catch(ClassNotFoundException e){
			 System.out.println("Class not found"+e.getMessage());
		 }catch(SQLException e){
			 System.out.println("SQLException"+e.getMessage());
		 }
		 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
