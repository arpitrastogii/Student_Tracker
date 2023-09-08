package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.Teacher;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class SearchTeacher
 */
@WebServlet("/SearchTeacher")
public class SearchTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Teacher> teacherlist=new ArrayList<Teacher>();
		String teacherName=request.getParameter("teachername");
		Connection con=null;
		Statement stmt=null;
		
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select * from teacher where lower(name) like lower('"+teacherName+"%')";
			ResultSet rs=stmt.executeQuery(sql);
			boolean isEmpty=true;
			while(rs.next()){
				  int teacher_id=rs.getInt("teacher_id");
				     String name=rs.getString("name");
				     java.sql.Date dob=rs.getDate("dob");
				     String gender=rs.getString("gender");
				     String fathersname=rs.getString("fathername");
				     long contactno=rs.getLong("contactno");
				     String email=rs.getString("email");
				     String address=rs.getString("address");
				     String highestDegree=rs.getString("highestdegree");
				     String institute=rs.getString("institute");
				     int experience=rs.getInt("experience");
				     String teachingschedule=rs.getString("teachingschedule");
				     String ishired=rs.getString("isHired");
                     teacherlist.add(new Teacher(teacher_id,name,dob,gender,fathersname,contactno,email,address,highestDegree,institute,experience,teachingschedule,ishired));
			         isEmpty=false;
			}
			
			if(isEmpty==false){
			request.setAttribute("teacherlist", teacherlist);			
			request.getRequestDispatcher("ShowSearchTeacherList.jsp").forward(request, response);
			}else{
				request.setAttribute("emptyMsg", "No Record Found");			
				request.getRequestDispatcher("SearchTeacher.jsp").forward(request, response);
				
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

}
