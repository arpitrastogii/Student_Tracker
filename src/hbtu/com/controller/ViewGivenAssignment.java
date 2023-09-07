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
 * Servlet implementation class ViewGivenAssignment
 */
@WebServlet("/ViewGivenAssignment")
public class ViewGivenAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int teacher_id=Integer.parseInt(request.getParameter("teacher_id"));
     ArrayList<Assignment> list=new ArrayList<Assignment>();
		Connection con=null;
     Statement stmt=null;
     try {
		con=ProjectConnection.getConnection();
		stmt=con.createStatement();
		String sql="select assignment_id,b.batch_id,batch_name,assignment_name,due_date, uploadtime from assignment a "
				+ "inner join batches b on a.batch_id=b.batch_id where teacher_id="+teacher_id;
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
		  int assignment_id=rs.getInt(1);
		  int batch_id=rs.getInt(2);
		  String batch_name=rs.getString(3);
		  String assignment_name=rs.getString(4);
		  java.sql.Date dueDate=rs.getDate(5);
		  java.sql.Timestamp givenTimeAndDate=rs.getTimestamp(6);
		  list.add(new Assignment(assignment_id,batch_id,batch_name,assignment_name,dueDate,givenTimeAndDate));
		  }
		request.setAttribute("mygivenassignments", list);
		request.getRequestDispatcher("MyGivenAssignments.jsp").forward(request, response);
		
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
