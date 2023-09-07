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

import hbtu.com.bo.AssignmentSolution;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class ReSubmitAssignment
 */
@WebServlet("/ViewAndReSubmitSolution")
public class ViewAndReSubmitSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		ArrayList<AssignmentSolution> list=new ArrayList<>();
		Connection con=null;
		Statement stmt=null;
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select  SOLUTION_ID , ass.ASSIGNMENT_ID, a.assignment_name, ISVIEWED, REMARK from assignment_sol ass "
					+ "inner join assignment a on ass.assignment_id=a.assignment_id where rollno="+rollno;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int solution_id=rs.getInt(1);
				int assignment_id=rs.getInt(2);
				String assignment_name=rs.getString(3);
				String isViewed=rs.getString(4);
				String remark=rs.getString(5);
				list.add(new AssignmentSolution(solution_id,assignment_id,assignment_name,isViewed,remark));
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("ViewMySolution.jsp").forward(request,response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
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
