package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class BatchAllotmentFinal
 */
@WebServlet("/BatchAllotmentFinal")
public class BatchAllotmentFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int batch_id=Integer.parseInt(request.getParameter("batch_id"));
		int teacher_id=Integer.parseInt(request.getParameter("faculty"));
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			con=ProjectConnection.getConnection();
			String sql="update batches set teacher_id=? ,isactive=? where batch_id=?";
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, teacher_id);
			pstmt.setString(2,"Yes");
			pstmt.setInt(3,batch_id);
			int x=pstmt.executeUpdate();
		  if(x!=0){
			  String successmsg="Faculty alloted successfully of Batch_id"+batch_id;
			  request.setAttribute("successmsg",successmsg);
			  request.getRequestDispatcher("FetchBatches").forward(request, response);
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

}
