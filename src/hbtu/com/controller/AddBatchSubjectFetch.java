package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class SubjectFetch
 */
@WebServlet("/AddBatchSubjectFetch")
public class AddBatchSubjectFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		LinkedHashMap<Long,String> map=new LinkedHashMap<>();
		boolean isEmpty=true;
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String query="select * from subjects";
			rs=stmt.executeQuery(query);
			while(rs.next()){
				long subject_id=rs.getLong("subject_id");
				String subject_name=rs.getString("subject_name");
				map.put(subject_id, subject_name);
				isEmpty=false;
			}
			if(isEmpty==false){
				request.setAttribute("map",map);
				request.getRequestDispatcher("AddBatch.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("AddBatch.jsp").forward(request, response);
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
