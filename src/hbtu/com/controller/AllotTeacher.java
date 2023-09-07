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
 * Servlet implementation class AllotTeacher
 */
@WebServlet("/AllotTeacher")
public class AllotTeacher extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subject_id=Integer.parseInt(request.getParameter("subject_id"));
		int batch_id=Integer.parseInt(request.getParameter("batch_id"));

		String batch_name=request.getParameter("batch_name");
		Connection con=null;
		 Statement stmt=null;
	    LinkedHashMap<Integer,String> teachermap= new LinkedHashMap<Integer,String>();
		 try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select  t.name, t.teacher_id from teacher_subjects ts "
					+ "inner join teacher t on t.teacher_id=ts.teacher_id "
					+ "inner join subjects s on ts.subject_id=s.subject_id "
					+ "where t.ishired='yes' and subject_id="+subject_id;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String teacher_name=rs.getString(1);
				int id=rs.getInt(2);
				teachermap.put(id, teacher_name);
			}
			request.setAttribute("batch_name", batch_name);
			request.setAttribute("teachermap",teachermap);
			request.setAttribute("batch_id", batch_id);
			request.getRequestDispatcher("Allotmentpage.jsp").forward(request, response);
		 }catch(SQLException e){
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
