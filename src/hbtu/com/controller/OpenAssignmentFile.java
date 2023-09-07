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

/**
 * Servlet implementation class OpenAssignmentFile
 */
@WebServlet("/OpenAssignmentFile")
public class OpenAssignmentFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int assignment_id=Integer.parseInt(request.getParameter("assignment_id"));
    Connection con=null;
	Statement stmt=null;
	
	try {
		con=ProjectConnection.getConnection();
		stmt=con.createStatement();
		String sql="select assignment_file from assignment where assignment_id="+assignment_id;
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			byte[] pdfData=rs.getBytes(1);
			request.setAttribute("pdfData", pdfData);
	        request.getRequestDispatcher("PDFView.jsp").forward(request, response);
	  
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
