package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int rollno=Integer.parseInt(request.getParameter("rollNo"));
		Connection con=null;
		Statement stmt=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			con=DriverManager.getConnection(url,"system","root");
			stmt=con.createStatement();
			String query="delete from student where rollno="+rollno;
			int x=stmt.executeUpdate(query);
			if(x!=0){
		        response.sendRedirect("DeleteSuccessfullyPage.jsp");
			}else{
		        response.sendRedirect("DeleteUnSuccessfullyPage.jsp");

			}
			
			
		}catch(ClassNotFoundException e){			
			System.out.println("Class not found"+e.getMessage());
		}catch(SQLException e){			
			System.out.println("SQL Exception found"+e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
