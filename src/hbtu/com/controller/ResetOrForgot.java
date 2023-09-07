package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.Student;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class ResetOrForgot
 */
@WebServlet("/ResetForgotService")
public class ResetOrForgot extends HttpServlet {
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
		Student obj=null;
		int student_id=Integer.parseInt(request.getParameter("student_id"));
		String email=request.getParameter("email_id");
		String dob=request.getParameter("date_of_birth");
		int pincode=Integer.parseInt(request.getParameter("address_pincode"));
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
		 con=ProjectConnection.getConnection();
		 String sql="select * from student where rollno=? and emailid=? and dob=?  and pincode=? and isadmited=?";
		 pstmt=con.prepareStatement(sql);
		 pstmt.setInt(1, student_id);
		 pstmt.setString(2,email);
		 pstmt.setString(3, dob);
		 pstmt.setInt(4, pincode);
		 pstmt.setString(5,"yes");
		 ResultSet rs=pstmt.executeQuery();
		 if(rs.next()){
			 int rollno=rs.getInt("ROLLNO");
		     String studentName=rs.getString("STUDENTNAME");
			 String gender=rs.getString("GENDER");
			 String course=rs.getString("COURSE");
			 String fatherName=rs.getString("FATHERNAME");
			 String address=rs.getString("ADDRESS");
			 String city=rs.getString("CITY");
			 String state=rs.getString("STATE");
			 long contactNo=rs.getLong("CONTACTNO");
			 String emailId=rs.getString("EMAILID");
			  obj=new Student(rollno,studentName,gender,course,dob,fatherName,address,city,state,pincode,contactNo,emailId);
		 }else{
			 System.out.println("Incorrect details");
		 }
		}catch(SQLException e){
			e.printStackTrace();
		}
        
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date datee=null;
		try {
			 datee=sdf.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(datee);
         Connection con1=null;
         if(obj!=null){
        		String name=obj.getStudentName();
        		String name1=name;
        		String password="";
                name=name.replace('.',' ');
                name=name.replaceAll(" ", "");
                name=name.substring(0,4).toUpperCase();
                String dob1=obj.getDob();
                String date=dob1.substring(8,10);
                String month=dob1.substring(5,7);
                password=name+"@"+date+""+month;
        		String email1=obj.getEmailId();
        	    int student_id1=obj.getRollno();
        	PreparedStatement pstmt1=null;
        	 try{
        		 con1=ProjectConnection.getConnection();
        		 String query="insert into student_login values(?,?,?,?)";
        		 pstmt1=con1.prepareStatement(query);
        		 pstmt1.setString(1,email1);
        		 pstmt1.setString(2,password);
        		 pstmt1.setInt(3,student_id1);
        		 pstmt1.setString(4,name1);
        		 int x=pstmt1.executeUpdate();
        		 if(x!=0){
        			 response.sendRedirect("password-generated-success.jsp");
        		 }
        	 }catch(SQLException ae){
        		 ae.printStackTrace();
        	 }
        	 try {
     			con.close();
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        	 
        	 
         }
	}

}
