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
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
           String query="select * from admin_login where login_id=? and password=?";
           pstmt=con.prepareStatement(query);
           pstmt.setString(1,login_id);
           pstmt.setString(2,password);
           rs=pstmt.executeQuery();
           boolean isLoginCorrect=false;
           if(rs.next()){
        	   String username=rs.getString("user_name");
        	   isLoginCorrect=true;
        	   System.out.println("login successful");
        	   HttpSession session=request.getSession();
        	   session.setAttribute("username", username);
        	   response.sendRedirect("admin-panel.jsp");
        	  
           }else{
        	   String errormsglogin="Incorrect username/password";
        	   request.setAttribute("errormsglogin", errormsglogin);
        	   request.getRequestDispatcher("admin-login.jsp").forward(request, response);
        	   
           }

		}catch(ClassNotFoundException e){
          System.out.println("Class not found");
		}catch(SQLException e){
			System.out.println("SQL Exception found"+e.getMessage());
		}
	}

}
