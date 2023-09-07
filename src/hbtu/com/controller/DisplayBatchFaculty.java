package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class DisplayBatchFaculty
 */
@WebServlet("/DisplayBatchFaculty")
public class DisplayBatchFaculty extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		int subjectId=Integer.parseInt(request.getParameter("subject_id"));
		Connection con=null;
		Statement stmt=null;
		HashMap<String,String> map=new HashMap<String,String>();
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select batch_name, t.name from batches b "
					+ "inner join teacher t "
					+ "on t.teacher_id=b.teacher_id where b.subject_id="+subjectId;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String batchName=rs.getString(1);
				String teacherName=rs.getString(2);
				map.put(batchName,teacherName);				
			}
			request.setAttribute("pair", map);
			request.getRequestDispatcher("DisplayBatchAndTeacher.jsp").forward(request,response);
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
	
	}

}
