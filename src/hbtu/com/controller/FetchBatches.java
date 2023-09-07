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

import hbtu.com.bo.Batch;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class FetchBatches
 */
@WebServlet("/FetchBatches")
public class FetchBatches extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 Connection con=null;
	 Statement stmt=null;
	 ArrayList<Batch> list=new ArrayList<Batch>();
	 try {
		con=ProjectConnection.getConnection();
		stmt=con.createStatement();
		String sql="select batch_id,batch_name,s.subject_name,s.subject_id from batches b "
				+ "inner join subjects s on b.subject_id=s.subject_id"
				+ " where b.teacher_id is null";
		boolean isEmpty=true;
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int batch_id=rs.getInt(1);
			String batch_name=rs.getString(2);
			String subject_name=rs.getString(3);
			int subject_id=rs.getInt(4);
			list.add(new Batch(batch_id,batch_name,subject_id,subject_name));
			isEmpty=false;
		}
		if(isEmpty==false){
			request.setAttribute("successmsg", request.getAttribute("successmsg"));
			request.setAttribute("batchlist", list);

			request.getRequestDispatcher("AllotTeacher.jsp").forward(request, response);
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

}
