package hbtu.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hbtu.com.bo.Batch;
import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class JoinBatch
 */
@WebServlet("/JoinBatch")
public class JoinBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=Integer.parseInt(request.getParameter("rollno"));
		Connection con=null;
		ArrayList<Batch> list=new ArrayList<Batch>();
		Statement stmt=null;
		try {
			con=ProjectConnection.getConnection();
			String sql="select b.batch_id,b.batch_name, subject_name,name as teacher_name, "
					+ "(case when exists(select rollno, batch_id from student_enrolled_batches where rollno="+rollno+" and batch_id=b.batch_id) "
					+ "then 'yes' else 'no' end) as result ,isEnrolled"
					+ " from batches b "
					+ "inner join subjects s on b.subject_id=s.subject_id "
					+ "inner join teacher t on t.teacher_id=b.teacher_id "
					+ "left join student_enrolled_batches se on se.batch_id=b.batch_id and rollno="+rollno
					+ " where isactive='Yes' order by batch_id";
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				int batch_id=rs.getInt(1);
				String batch_name=rs.getString(2);
				String subject_name=rs.getString(3);
				String teacher_name=rs.getString(4);
				String isRequested=rs.getString(5);
				String isEnrolled=rs.getString(6);
				list.add(new Batch(batch_id,batch_name,subject_name,teacher_name,isRequested,isEnrolled));
			}
			request.setAttribute("rollno",rollno);
			request.setAttribute("list",list);
			request.getRequestDispatcher("JoinBatch.jsp").forward(request,response);
		} catch (SQLException e) {
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
		doGet(request, response);
	}

}
