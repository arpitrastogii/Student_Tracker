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
 * Servlet implementation class StudentBatchRequest
 */
@WebServlet("/StudentBatchRequest")
public class StudentBatchRequest extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		int batch_id=Integer.parseInt(request.getParameter("batch_id"));
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ProjectConnection.getConnection();
			String sql="insert into student_enrolled_batches (enrollid,rollno,batch_id,isrequested)"
					+ " values(student_enrolled.nextval,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,rollno);
			pstmt.setInt(2,batch_id);
			pstmt.setString(3,"Yes");
			int x =pstmt.executeUpdate();
			if(x!=0){
				request.setAttribute("rollno",rollno);
				request.getRequestDispatcher("JoinBatch").forward(request, response);
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
