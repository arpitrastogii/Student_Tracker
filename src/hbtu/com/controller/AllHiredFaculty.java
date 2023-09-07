package hbtu.com.controller;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.Teacher;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class AllHiredFaculty
 */
@WebServlet("/AllHiredFaculty")
public class AllHiredFaculty extends HttpServlet {
	
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		Statement stmt=null;
		ArrayList<Teacher> list =new ArrayList<>();
		try{
			con=ProjectConnection.getConnection();
			stmt=con.createStatement();
			String query="Select * from teacher where isHired='yes' and isDeleted is null";
			ResultSet rs=stmt.executeQuery(query);
			boolean isEmpty=true;
			while(rs.next()){
				isEmpty=false;
				int teacher_id=rs.getInt(1);
				String name=rs.getString(2);
				java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date=null;
						date=sdf.parse(rs.getString(3));
				java.sql.Date dob=new java.sql.Date(date.getTime());
				String gender=rs.getString(4);
				String fathersname=rs.getString(5);
				long contactNo=Long.parseLong(rs.getString(6));
				String email=rs.getString(7);
				String address=rs.getString(8);
				String highestDegree=rs.getString(9);
				String institute=rs.getString(10);
				int experience =Integer.parseInt(rs.getString(11));
				String teachingschedule=rs.getString(12);
				list.add(new Teacher(teacher_id,name,dob,gender, fathersname,contactNo,email, address,highestDegree,institute,experience,teachingschedule));
			}
			
			System.out.println(list);
			if(isEmpty==false){
				request.setAttribute("list",list);
				request.getRequestDispatcher("HiredFaculty.jsp").forward(request, response);
			}else{
				String emptymsg="No Hired Faculty Found";
				request.setAttribute("emptymsg",emptymsg);
				request.getRequestDispatcher("HiredFaculty.jsp").forward(request, response);
			
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ParseException e) {
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
