package hbtu.com.controller;

import java.io.*;
import java.sql.*;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class ViewSubjectController
 */
@WebServlet("/ViewSubjectController")
public class ViewSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		Statement stmt=null;
		LinkedHashMap<Integer,String> map=new LinkedHashMap<Integer,String>();
		try {
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String query="select * from subjects";
			ResultSet rs=stmt.executeQuery(query);
			boolean isEmpty=true;
			while(rs.next()){
				int subject_id= rs.getInt(1);
				String subject_name=rs.getString(2);
				map.put(subject_id	,subject_name);
				isEmpty=false;
			}
			if(isEmpty==false){
				request.setAttribute("map", map);
				request.getRequestDispatcher("ViewSubjects.jsp").forward(request,response);				
			}else{
				request.setAttribute("msg", "No subjects found");
				request.getRequestDispatcher("ViewSubjects.jsp").forward(request,response);				
			
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
