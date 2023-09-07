package hbtu.com.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class AdmitController
 */
@WebServlet("/AdmitService")
public class AdmitController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		String stu_id=request.getParameter("stuid");
		System.out.println(stu_id);
		Connection con=null;
		Statement stmt=null;
		try{
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String sql="update student set isAdmited='yes' where rollno="+stu_id;
			int x=stmt.executeUpdate(sql);
			if(x!=0){
				String msg="Student Id "+stu_id+" admitted successfully";
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
