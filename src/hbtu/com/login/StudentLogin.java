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
@WebServlet("/StudentLoginService")
public class StudentLogin extends HttpServlet {
	
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
           String query="select * from student_login where LOGIN_ID=? and PASSWORD=?";
           pstmt=con.prepareStatement(query);
           pstmt.setString(1,login_id);
           pstmt.setString(2,password);
           rs=pstmt.executeQuery();
           boolean isLoginCorrect=false;
           if(rs.next()){
        	   String username=rs.getString("STUDENT_NAME");
        	   int student_id=rs.getInt("STUDENT_ID");
        	   isLoginCorrect=true;
        	   HttpSession session=request.getSession();
        	   session.setAttribute("username", username);
        	   session.setAttribute("student_id", ""+student_id);
        	   request.getRequestDispatcher("student-panel.jsp").forward(request, response);

           }else{
        	   String errormsglogin="Incorrect username/password";
        	   request.setAttribute("errormsglogin", errormsglogin);
        	   request.getRequestDispatcher("student-login.jsp").forward(request, response);
        	   
           }

		}catch(ClassNotFoundException e){
          System.out.println("Class not found");
		}catch(SQLException e){
			System.out.println("SQL Exception found"+e.getMessage());
		}
	}

}
