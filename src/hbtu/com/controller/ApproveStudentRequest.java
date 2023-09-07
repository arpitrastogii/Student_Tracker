package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class ApproveStudentRequest
 */
@WebServlet("/ApproveStudentRequest")
public class ApproveStudentRequest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int enrollid=Integer.parseInt(request.getParameter("enrollid"));
     Timestamp datetime=new Timestamp(new java.util.Date().getTime());
     Connection con=null;
     PreparedStatement pstmt=null;
     try {
		con=ProjectConnection.getConnection();
		String sql="update student_enrolled_batches set"
				+ " ISENROLLED=? , DATETIME_OF_JOINING=? where ENROLLID=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,"Yes");
		pstmt.setTimestamp(2, datetime);
		pstmt.setInt(3, enrollid);
		int x=pstmt.executeUpdate();
		if(x!=0){
			String messageofapprovedecline="Student having enrolledId "+enrollid+" is successfully admitted in the batch";
			request.setAttribute("messageofapprovedecline", messageofapprovedecline);
			request.getRequestDispatcher("StudentRequestView").forward(request, response);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
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
