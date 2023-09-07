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
 * Servlet implementation class AddCourses
 */
@WebServlet("/AddSubject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		String subject_name=request.getParameter("name");
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=ProjectConnection.getConnection();
			String sql="insert into subjects values(subject_id.nextval,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,subject_name);
			int x=pstmt.executeUpdate();
			if(x!=0){
				String msg="Courses added Successfully";
				request.setAttribute("msg",msg);
				request.getRequestDispatcher("AddSubject.jsp").forward(request, response);
			}
			else{
				String msg="Courses already exists";
				request.setAttribute("msg",msg);
				request.getRequestDispatcher("AddSubject.jsp").forward(request, response);
			
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
