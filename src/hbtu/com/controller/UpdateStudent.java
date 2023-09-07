package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudentService")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		 int studentid=Integer.parseInt(request.getParameter("rollnohidden"));
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 
		 try{
			 con=ProjectConnection.getConnection();
			 String query="update student set studentname=? ,gender=?, course=?,dob=?, fathername=?,address=?,city=?,state=?,pincode=?,contactno=?,emailId=? where rollno=?";
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
             pstmt.setInt(12, studentid);
             
             int x=pstmt.executeUpdate();
       
             if(x!=0){
 				request.setAttribute("message","Details Updated Successfully");
 				request.getRequestDispatcher("update-student.jsp").forward(request, response);


             }
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
