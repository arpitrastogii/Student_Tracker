package hbtu.com.controller;

import java.io.IOException;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.Student;
import hbtu.com.bo.Teacher;

/**
 * Servlet implementation class ViewAllStudentController
 */
@WebServlet("/AdmitTeacher")
public class AdmitTeacherController extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg=(String)request.getAttribute("msgAfterAdmitUnadmit");
		
		// TODO Auto-generated method stub
		ArrayList<Teacher> list=new ArrayList<Teacher>();
		Connection con=null;
		ResultSet rs=null;
		Statement stmt=null;
		  try{
		     Class.forName("oracle.jdbc.driver.OracleDriver");
			 String url="jdbc:oracle:thin:@localhost:1521:XE";
			 con=DriverManager.getConnection(url,"system","root");
			 stmt=con.createStatement();
			 String query="select * from teacher where isHired is null and isdeleted is null order by teacher_id";
			 rs=stmt.executeQuery(query);
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
				     
			  list.add(new Teacher(teacher_id,name,dob,gender,fathersname,contactno,email,address,highestDegree,institute,experience,teachingschedule));
	 
			  }
			  request.setAttribute("list", list);
			 }catch(ClassNotFoundException e){
		     e.printStackTrace();
		  }catch(SQLException e){
		     e.printStackTrace();
		  }
		  try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  if(msg!=null)
		  request.setAttribute("message", msg);
          RequestDispatcher dispatcher=request.getRequestDispatcher("admit-teacher.jsp");
          dispatcher.forward(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
