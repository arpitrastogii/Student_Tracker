package hbtu.com.logout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String who=request.getParameter("who");
     HttpSession session=request.getSession(false);
     if(session!=null){
     session.invalidate();
     if(who.equals("admin"))
    	 response.sendRedirect("admin-login.jsp");
     if(who.equals("student"))
         response.sendRedirect("student-login.jsp");    	 
     if(who.equals("teacher"))
         response.sendRedirect("teacher-login.jsp");    
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
