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
 * Servlet implementation class BatchHaveStudentFetch
 */
@WebServlet("/BatchHaveStudentFetch")
public class BatchHaveStudentFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int batch_id=Integer.parseInt(request.getParameter("batch_id"));
    String who=request.getParameter("who");
    ArrayList<EnrolledStudent> list=new ArrayList<EnrolledStudent>();
    Connection con=null;
    Statement stmt=null;
    try {
		con=ProjectConnection.getConnection();
		stmt=con.createStatement();
		String sql="select enrollid, e.rollno, studentname, DATETIME_OF_JOINING from student_enrolled_batches e "
				+ "inner join student s on s.rollno=e.rollno where batch_id="+batch_id+" and ISENROLLED='Yes'";
	ResultSet rs=stmt.executeQuery(sql);	
	while(rs.next()){
		int enrolledid=rs.getInt(1);
		int rollno=rs.getInt(2);
		String student_name=rs.getString(3);
		Timestamp datetime=rs.getTimestamp(4);
		list.add(new EnrolledStudent(enrolledid,rollno,student_name,datetime));
	}
	  request.setAttribute("list", list);
	  request.setAttribute("who", who);
	  request.getRequestDispatcher("ShowMyStudentBatchwise.jsp").forward(request, response);

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
	}

}
