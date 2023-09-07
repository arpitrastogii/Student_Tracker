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

import hbtu.com.bo.Student;
import hbtu.com.bo.Teacher;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class ViewStudentProfile
 */
@WebServlet("/ViewTeacherProfile")
public class ViewTeacherProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		int teacher_id=Integer.parseInt(request.getParameter("teacher_id"));
     String vieworedit=request.getParameter("vieworedit");
     Connection con=null;
     Statement stmt=null;
     try {
		con=ProjectConnection.getConnection();
		stmt=con.createStatement();
		String sql="select * from teacher where teacher_id="+teacher_id+"and ISHIRED='yes' and isdeleted is null";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
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
		     
	  Teacher teacher=new Teacher(teacher_id,name,dob,gender,fathersname,contactno,email,address,highestDegree,institute,experience,teachingschedule);
         request.setAttribute("teacher", teacher);
			
         if(vieworedit.equals("view"))
         request.getRequestDispatcher("ViewTeacherProfile.jsp").forward(request, response);
         if(vieworedit.equals("edit"))
          request.getRequestDispatcher("EditTeacherProfile.jsp").forward(request, response);
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
