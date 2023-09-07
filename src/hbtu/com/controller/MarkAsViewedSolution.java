package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class MarkAsViewedSolution
 */
@WebServlet("/MarkAsViewedSolution")
public class MarkAsViewedSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int solution_id=Integer.parseInt(request.getParameter("solution_id"));
      Connection con=null;
      Statement stmt=null;
      try {
		con=ProjectConnection.getConnection();
		stmt=con.createStatement();
		String sql="update assignment_sol set isviewed='yes' where solution_id="+solution_id;
		int x=stmt.executeUpdate(sql);
		if(x!=0){
		System.out.println("Viewed by teacher");	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      try {
		con.close();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}

}
