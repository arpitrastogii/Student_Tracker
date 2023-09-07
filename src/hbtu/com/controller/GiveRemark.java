package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class GiveRemark
 */
@WebServlet("/GiveRemark")
public class GiveRemark extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 int solution_id=Integer.parseInt(request.getParameter("solution_id"));
	 int assignment_id=Integer.parseInt(request.getParameter("assignment_id"));
	 int batch_id=Integer.parseInt(request.getParameter("batch_id"));
	 
	 String remark=request.getParameter("remark");
	 Connection con=null;
	 PreparedStatement pstmt=null;
	 try {
		con=ProjectConnection.getConnection();
		String sql="update assignment_sol set remark=? where solution_id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, remark);
		pstmt.setInt(2, solution_id);
		int x=pstmt.executeUpdate();
		if(x!=0){
			String msg="Remark Updated";
			//request.getRequestDispatcher("ViewAssignmentStudentList?assignment_id="+assignment_id+"&batch_id="+batch_id);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally{
		 
		 try {
			con.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }//end of finally block
		response.sendRedirect("ViewAssignmentStudentList?assignment_id="+assignment_id+"&batch_id="+batch_id);

	}

}
