package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.EnrolledStudent;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class ViewStudentEnrolledCourses
 */
@WebServlet("/ViewStudentEnrolledCourses")
public class ViewStudentEnrolledCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		ArrayList<EnrolledStudent> list=new ArrayList<>();
		Connection con=null;
		Statement stmt=null;
		
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select enrollid, subject_name, batch_name, name, DATETIME_OF_JOINING from student_enrolled_batches s "
					+ " inner join batches b on s.batch_id=b.batch_id "
					+ "inner join teacher t on t.teacher_id=b.teacher_id "
					+ "inner join subjects su on b.subject_id=su.subject_id"
					+ " where rollno="+rollno+" and isenrolled='Yes'";
			ResultSet rs=stmt.executeQuery(sql);
			boolean isEmpty=true;
			while(rs.next()){
				isEmpty=false;
				int enrollId=rs.getInt(1);
				String subjectName=rs.getString(2);
				String batch_name=rs.getString(3);
				String teacher_name=rs.getString(4);
				Timestamp joiningDateAndTime=rs.getTimestamp(5);
				list.add(new EnrolledStudent(enrollId,subjectName,batch_name,teacher_name,joiningDateAndTime));
			}
			if(isEmpty==false){
				request.setAttribute("list",list);
			}
			request.getRequestDispatcher("ViewStudentEnrolledCourse.jsp").forward(request, response);

			
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
