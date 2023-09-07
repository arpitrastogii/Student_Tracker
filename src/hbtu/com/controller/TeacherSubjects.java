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
 * Servlet implementation class TeacherSubjects
 */
@WebServlet("/TeacherSubjects")
public class TeacherSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		int teacher_id=Integer.parseInt(request.getParameter("teacher_id"));
	    String who=request.getParameter("who");
	    Connection con=null;
	    Statement stmt=null;
	    LinkedHashMap<Integer,String> subjectlist=new LinkedHashMap<Integer,String>();
	    try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select t.subject_id as id, subject_name from teacher_subjects t "
					+ "inner join subjects s on s.subject_id=t.subject_id "
					+ "where teacher_id="+teacher_id;
			ResultSet rs=stmt.executeQuery(sql);			
			while(rs.next()){
            int subject_id=rs.getInt(1);
            String subject_name=rs.getString(2);
            subjectlist.put(subject_id,subject_name);
			}
			request.setAttribute("subjectlist", subjectlist);
			request.setAttribute("who", who);
			request.getRequestDispatcher("Show_Teacher_subjects.jsp").forward(request, response);
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
