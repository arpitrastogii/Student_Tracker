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
 * Servlet implementation class DeclineStudentRequest
 */
@WebServlet("/DeclineStudentRequest")
public class DeclineStudentRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        int enrollid=Integer.parseInt(request.getParameter("enrollid"));
        Connection con=null;
        PreparedStatement pstmt=null;
        try {
   		con=ProjectConnection.getConnection();
   		String sql="delete from student_enrolled_batches where ENROLLID=?";
   		pstmt=con.prepareStatement(sql);
   		pstmt.setInt(1,enrollid);
   		int x=pstmt.executeUpdate();
   		if(x!=0){
   			String messageofapprovedecline="Request for Admiting Student having enrolledId "+enrollid+" is declined";
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
