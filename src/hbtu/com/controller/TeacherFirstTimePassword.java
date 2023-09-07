package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.Teacher;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class TeacherFirstTimePassword
 */
@WebServlet("/TeacherFirstTimePassword")
public class TeacherFirstTimePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacher_id=Integer.parseInt(request.getParameter("teacher_id"));
		String email=request.getParameter("email_id");
		String dob=request.getParameter("date_of_birth");
		long contactno=Long.parseLong(request.getParameter("contact_no"));
		Teacher obj=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date datee=null;
		try {
			 datee=sdf.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(datee);
		Connection con=null;
		PreparedStatement pstmt=null;
		java.sql.Date datedob=new java.sql.Date(datee.getTime());
		try {
			con=ProjectConnection.getConnection();
			String sql="select * from teacher where ishired='yes' and teacher_id=? and email=? and dob=? and contactno=?";
			pstmt=con.prepareStatement(sql);			
			pstmt.setInt(1,teacher_id);
			pstmt.setString(2,email);
			pstmt.setDate(3,datedob);
			pstmt.setLong(4,contactno);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
			     String name=rs.getString("name");
			     String gender=rs.getString("gender");
			     String fathersname=rs.getString("fathername");
			     String address=rs.getString("address");
			     String highestDegree=rs.getString("highestdegree");
			     String institute=rs.getString("institute");
			     int experience=rs.getInt("experience");
			     String teachingschedule=rs.getString("teachingschedule");
		   obj=new Teacher(teacher_id,name,datedob,gender,fathersname,contactno,email,address,highestDegree,institute,experience,teachingschedule);

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
		
		if(obj!=null){
			String name=obj.getName();
    		String name1=""+name;
    		String password="";
            name=name.replace('.',' ');
            name=name.replaceAll(" ", "");
            name=name.substring(0,4).toUpperCase();
           
            String date=dob.substring(8,10);
            String month=dob.substring(5,7);
            password=name+"@"+date+""+month;
    		PreparedStatement pstmt1=null;
    		try {
				con=ProjectConnection.getConnection();
				String sql="insert into teacher_login values(?,?,?,?)";
				pstmt1=con.prepareStatement(sql);
				pstmt1.setString(1,email);
				pstmt1.setString(2,password);
				pstmt1.setInt(3,teacher_id);
				pstmt1.setString(4,name1);
				 int x=pstmt1.executeUpdate();
        		 if(x!=0){
        			 response.sendRedirect("password-generated-success.jsp");
        		 }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		
		}

	}

}
