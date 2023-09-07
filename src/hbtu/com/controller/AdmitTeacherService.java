package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class AdmitTeacherService
 */
@WebServlet("/AdmitTeacherService")
public class AdmitTeacherService extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacher_id=request.getParameter("teacher_id");
		Connection con=null;
		Statement stmt=null;
		try{
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="update teacher set isHired='yes' where teacher_id="+teacher_id;
			int x=stmt.executeUpdate(sql);
			if(x!=0){
				String msg="Teacher ID "+teacher_id+" admitted successfully";
				request.setAttribute("msgAfterAdmitUnadmit",msg);
				request.getRequestDispatcher("AdmitTeacher").forward(request,response);
			}
			
		}catch(SQLException e){
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
