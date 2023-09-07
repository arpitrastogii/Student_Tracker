package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class EditProfileStudent
 */
@WebServlet("/EditProfileStudent")
public class EditProfileStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int student_id=Integer.parseInt(request.getParameter("rollnohidden"));
		String gender=request.getParameter("gender");
		String course=request.getParameter("course");				
		String dob=request.getParameter("dob");		
		String fathersname=request.getParameter("fatherName");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		long contactNo=Long.parseLong(request.getParameter("contactNo"));
		String email=request.getParameter("emailId");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=ProjectConnection.getConnection();
			String sql="update student set gender=?,course=?,dob=?,fathername=?,address=?,city=?,state=?,pincode=?,contactNo=?,emailId=? where rollno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,gender);
			pstmt.setString(2,course);
			pstmt.setString(3,dob);
			pstmt.setString(4,fathersname);
			pstmt.setString(5,address);
			pstmt.setString(6,city);
			pstmt.setString(7,state);
			pstmt.setInt(8,pincode);
			pstmt.setLong(9, contactNo);
			pstmt.setString(10,email);
			pstmt.setInt(11,student_id);
			
			int x=pstmt.executeUpdate();
			if(x!=0){
				request.getRequestDispatcher("student-panel.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
