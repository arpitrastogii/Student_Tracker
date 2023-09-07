package hbtu.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class GiveAssignment
 */
@WebServlet("/GiveAssignment")
public class GiveAssignment extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer batch_id=null;
		java.sql.Date duedate=null;
		String assignment_name=null;
		String file_name=null;
		long docSize=0L;
		InputStream filedata=null;
		List<FileItem> parselist=null;
		Timestamp uploadTime=null;
		if(ServletFileUpload.isMultipartContent(request)==true){
			ServletFileUpload fileupload=new ServletFileUpload(new DiskFileItemFactory());
			try {
				parselist=fileupload.parseRequest(request);
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(FileItem item: parselist){
			if(item.isFormField()){
				if(item.getFieldName().equals("batch_name"))
					batch_id=Integer.parseInt(item.getString());
				if(item.getFieldName().equals("assignment_name"))
					assignment_name=item.getString();
				if(item.getFieldName().equals("due_date"))
					 duedate = java.sql.Date.valueOf(item.getString());		
					
			}//is formfield
			else{
				if(item.getFieldName().equals("assignment")){
				docSize=item.getSize();
				file_name=item.getName();
				filedata=item.getInputStream();
				}
			}
		}
			uploadTime=new Timestamp(new java.util.Date().getTime());
			Connection con=null;
			PreparedStatement pstmt=null;
			try {
				con=ProjectConnection.getConnection();
				String sql="insert into assignment(assignment_id,batch_id,assignment_name,file_name,"
						+ "assignment_file,due_date,uploadtime) "
						+ "values(assignment_id.nextval,?,?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,batch_id);
				pstmt.setString(2,assignment_name);
				pstmt.setString(3,file_name);
				pstmt.setBinaryStream(4, filedata,(int)docSize);
				pstmt.setDate(5,duedate);
				pstmt.setTimestamp(6, uploadTime);
				System.out.println(batch_id+" "+assignment_name+" "+file_name+" "+duedate+" "+uploadTime );
				int x=pstmt.executeUpdate();
				if(x!=0){
					String msg="Assignment created successfully";
					request.setAttribute("successmsg", msg);
					request.getRequestDispatcher("").forward(request, response);
			
				}
			} 
			catch (SQLIntegrityConstraintViolationException e) {
				String msg="Assignment is already created";
				request.setAttribute("exceptionmsg", msg);
				request.getRequestDispatcher("").forward(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
	}

}
