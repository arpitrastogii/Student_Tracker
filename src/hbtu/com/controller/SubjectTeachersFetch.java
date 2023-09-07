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
 * Servlet implementation class SubjectTeachersFetch
 */
@WebServlet("/SubjectTeachersFetch")
public class SubjectTeachersFetch extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int subject_id=Integer.parseInt(request.getParameter("id"));
		HashMap<String,String> map=new HashMap<String,String>();
		Connection con=null;
		Statement stmt=null;
		boolean isEmpty=true;
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String query="select s.subject_name, t.name, t.ishired from teacher_subjects ts "
					+ "inner join teacher t on t.teacher_id=ts.teacher_id "
					+ "inner join subjects s on ts.subject_id=s.subject_id "
					+ "where t.ishired='yes' and subject_id="+subject_id;			
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				isEmpty=false;
				String subject_name=rs.getString("subject_name");
				String name=rs.getString("name");
				map.put(name,subject_name);
			}

			if(isEmpty==false){
				request.setAttribute("map", map);
				request.getRequestDispatcher("ViewSubjectTeachersFetch.jsp").forward(request, response);

			}else{
				String msg="No faculty found for this subject";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("ViewSubjectTeachersFetch.jsp").forward(request, response);

				
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
		
		
	}

}
