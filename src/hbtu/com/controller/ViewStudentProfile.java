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
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class ViewStudentProfile
 */
@WebServlet("/ViewStudentProfile")
public class ViewStudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int rollno=Integer.parseInt(request.getParameter("rollno"));
     String vieworedit=request.getParameter("vieworedit");
     Connection con=null;
     Statement stmt=null;
     try {
		con=ProjectConnection.getConnection();
		stmt=con.createStatement();
		String sql="select * from student where rollno="+rollno+"and ISADMITED='yes' and isdeleted is null";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			String name=rs.getString("studentname");
			String gender=rs.getString("gender");
			String course=rs.getString("course");
			String dob=rs.getString("dob");
			String fathername=rs.getString("FATHERNAME");
			String address=rs.getString("address");
			String city=rs.getString("CITY");
			 String state=rs.getString("STATE");
			 int pincode=rs.getInt("PINCODE");
			 long contactNo=rs.getLong("CONTACTNO");
			 String emailId=rs.getString("EMAILID");
	  Student studentobj=new Student(rollno,name,gender,course,dob,fathername,address,city,state,pincode,contactNo,emailId);
         request.setAttribute("studentobj", studentobj);
         if(vieworedit.equals("view"))
         request.getRequestDispatcher("ViewStudentProfile.jsp").forward(request, response);
         if(vieworedit.equals("edit"))
          request.getRequestDispatcher("EditProfileStudent.jsp").forward(request, response);
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
