package hbtu.com.login;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/TeacherLoginService")
public class TeacherLogin extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login_id=request.getParameter("username");
		String password=request.getParameter("password");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           String url="jdbc:oracle:thin:@localhost:1521:XE";
           con=DriverManager.getConnection(url, "system", "root");
           String query="select * from teacher_login where LOGIN_ID=? and PASSWORD=?";
           pstmt=con.prepareStatement(query);
           pstmt.setString(1,login_id);
           pstmt.setString(2,password);
           rs=pstmt.executeQuery();
           if(rs.next()){
        	   String teacherName=rs.getString("teacher_name");
        	   String teacherId=""+rs.getInt("teacher_id");
        	   HttpSession session=request.getSession();
        	   session.setAttribute("teacher_name", teacherName);
        	   session.setAttribute("teacher_id", teacherId);
        	   request.getRequestDispatcher("teacher-panel.jsp").forward(request, response);

           }else{
        	   String errormsglogin="Incorrect username/password";
        	   request.setAttribute("errormsglogin", errormsglogin);
        	   request.getRequestDispatcher("teacher-login.jsp").forward(request, response);
        	   
           }

		}catch(ClassNotFoundException e){
          System.out.println("Class not found");
		}catch(SQLException e){
			System.out.println("SQL Exception found"+e.getMessage());
		}
	}

}
