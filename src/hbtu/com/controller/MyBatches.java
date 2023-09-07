package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class MyBatches
 */
@WebServlet("/MyBatches")
public class MyBatches extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacher_id=Integer.parseInt(request.getParameter("teacher_id"));
		String forwardlocation=request.getParameter("forwardlocation");
		Connection con=null;
		Statement stmt=null;
		LinkedHashMap<Integer,String> batchlist=new LinkedHashMap<Integer,String>();
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="select batch_id, batch_name from batches b "
					+ "inner join subjects s on s.subject_id=b.subject_id "
					+ "where teacher_id="+teacher_id;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int batch_id=rs.getInt(1);
				String batch_name=rs.getString(2);
				batchlist.put(batch_id, batch_name);
			}
			request.setAttribute("batchlist",batchlist);
			if(forwardlocation.equals("giveassignment")){
				request.getRequestDispatcher("GiveAssignment.jsp").forward(request, response);

			}else{
				request.getRequestDispatcher("ViewBatchesAndStudent.jsp").forward(request, response);
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
