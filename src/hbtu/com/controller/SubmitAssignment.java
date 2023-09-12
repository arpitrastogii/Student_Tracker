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

import hbtu.com.bo.Assignment;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class SubmitAssignment
 */
@WebServlet("/SubmitAssignment")
public class SubmitAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int student_id=Integer.parseInt(request.getParameter("rollno"));
		Connection con=null;
		Statement stmt=null;
		ArrayList<Assignment> list=new ArrayList<Assignment>();
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select assignment_id,b.batch_name,assignment_name,t.name, "
					+ "due_date, uploadtime, "
					+ "(case when exists (select assignment_id from assignment_sol ass"
					+ " where ass.assignment_id=a.assignment_id and ass.rollno="+student_id+") "
				    + "then 'yes' else 'no' end) as isSubmitted from assignment a "
				    + "inner join batches b on a.batch_id=b.batch_id "
				    + "inner join teacher t on t.teacher_id=b.teacher_id "
				    + "where a.batch_id in(select batch_id from student_enrolled_batches"
				    + " where rollno="+student_id+" and isenrolled='Yes') order by  issubmitted,  due_date desc";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int assignment_id=rs.getInt(1);
				String batch_name=rs.getString(2);
				String assignment_name=rs.getString(3);
				String teacher_name=rs.getString(4);
				java.sql.Date due_date=rs.getDate(5);
				java.sql.Timestamp dateAndTimeOfAssignment=rs.getTimestamp(6);
				String isSubmitted=rs.getString(7);				
				list.add(new Assignment(assignment_id,batch_name,assignment_name,teacher_name,due_date,dateAndTimeOfAssignment,isSubmitted));
			}
			request.setAttribute("list",list);
			request.getRequestDispatcher("ViewAssignments.jsp").forward(request,response);
			
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
