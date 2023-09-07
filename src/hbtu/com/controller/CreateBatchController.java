package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class CreateBatchController
 */
@WebServlet("/CreateBatchController")
public class CreateBatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String batchname=request.getParameter("batchname");
		int subject_id= Integer.parseInt(request.getParameter("subject"));
		System.out.println(batchname+" "+subject_id);
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=ProjectConnection.getConnection();
			String query="insert into batches(batch_id,batch_name,subject_id)values(batchsequence.nextval,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,batchname);
			pstmt.setInt(2,subject_id);
			int x=pstmt.executeUpdate();
			if(x!=0){
				String msg="Batch Created successfully";
				request.setAttribute("batchmsg", msg);
				request.getRequestDispatcher("AddBatchSubjectFetch").forward(request, response);
			}
		}catch (SQLException e) {
			String msg="Batch Already exists";
			request.setAttribute("batchmsg", msg);
			request.getRequestDispatcher("AddBatchSubjectFetch").forward(request, response);
			
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
