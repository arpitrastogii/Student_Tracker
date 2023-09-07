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

import hbtu.com.bo.EnrolledStudent;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class StudentRequestView
 */
@WebServlet("/StudentRequestView")
public class StudentRequestView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		Statement stmt=null;
		ArrayList<EnrolledStudent> list=new ArrayList<>();
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select enrollid, e.rollno,studentname,batch_name from student_enrolled_batches e "
					+ "inner join student s on s.rollno=e.rollno "
					+ "inner join batches b on b.batch_id=e.batch_id "
					+ "where isrequested='Yes' and isenrolled is null order by batch_name";
			ResultSet rs=stmt.executeQuery(sql);
			boolean isEmpty=true;
			while(rs.next()){
				isEmpty=false;
				int enrolled=rs.getInt(1);
				int rollno=rs.getInt(2);
				String studentname=rs.getString(3);
				String batch_name=rs.getString(4);
				list.add(new EnrolledStudent(enrolled,rollno,studentname,batch_name));
			}
			if(isEmpty==false){
			request.setAttribute("enrolledlist",list);
			}
			request.setAttribute("messageofapprovedecline",request.getAttribute("messageofapprovedecline"));
			request.getRequestDispatcher("ApproveStudentRequest.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
