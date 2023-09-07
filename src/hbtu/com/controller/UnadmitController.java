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
 * Servlet implementation class UnadmitStudent
 */
@WebServlet("/UnadmitService")
public class UnadmitController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String stu_id=request.getParameter("stuid");
		System.out.println(stu_id);
		Connection con=null;
		Statement stmt=null;
		try{
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="update student set isDeleted='yes' where rollno="+stu_id;
			int x=stmt.executeUpdate(sql);
			if(x!=0){
				String msg="Student Id "+stu_id+" Unadmitted";
				request.setAttribute("msgAfterAdmitUnadmit",msg);
				request.getRequestDispatcher("AdmitStudent").forward(request,response);
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
