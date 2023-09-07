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
import hbtu.com.bo.EnrolledStudent;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class ViewBatchesAndStudents
 */
@WebServlet("/ViewBatchesAndStudents")
public class ViewBatchesAndStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    Connection con=null;
    Statement stmt=null;
    ArrayList<Batch> list=new ArrayList<Batch>();
    try {
		con=ProjectConnection.getConnection();
		stmt=con.createStatement();
		String sql="select batch_id, batch_name, s.subject_name, s.subject_id, name from batches b "
				+ "inner join subjects s on b.subject_id=s.subject_id "
				+ "inner join teacher t on t.teacher_id=b.teacher_id";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int batch_id=rs.getInt(1);
			String batch_name=rs.getString(2);
			String subject_name=rs.getString(3);
			int subject_id=rs.getInt(4);
			String name=rs.getString(5);
			list.add(new Batch(batch_id,batch_name,subject_id,subject_name,name));
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("ViewBatchesAndStudents.jsp").forward(request, response);
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
