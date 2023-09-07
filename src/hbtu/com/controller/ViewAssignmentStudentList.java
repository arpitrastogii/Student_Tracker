package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.AssignmentSolution;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class ViewAssignmentSolution
 */
@WebServlet("/ViewAssignmentStudentList")
public class ViewAssignmentStudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		int assignment_id=Integer.parseInt(request.getParameter("assignment_id"));
      int batch_id=Integer.parseInt(request.getParameter("batch_id"));
      Connection con=null;
      Statement stmt=null;
     ArrayList<AssignmentSolution> list=new ArrayList<>();
      try {
		con=ProjectConnection.getConnection();
		stmt=con.createStatement();
		String sql="select e.rollno, studentname , SOLUTION_ID, ISVIEWED, REMARK from student_enrolled_batches e "
				+ "inner join student s on s.rollno=e.rollno "
				+ "left join assignment_sol ass on e.rollno=ass.rollno and assignment_id="+assignment_id
				+ " where batch_id="+batch_id+" and ISENROLLED='Yes' order by e.rollno";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			Integer rollno=rs.getInt(1);
			String studentName=rs.getString(2);
			Integer solution_id=rs.getInt(3);
			String isViewed=rs.getString(4);
			String remark=rs.getString(5);
			list.add(new AssignmentSolution(solution_id,studentName,rollno,isViewed,remark));						
		}
		request.setAttribute("list",list );
		request.setAttribute("assignment_id",assignment_id);		
		request.setAttribute("batch_id",batch_id);		
		request.getRequestDispatcher("ViewStudentSolutionList.jsp").forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      finally{
    	  try {
			con.close();
			 stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
