package hbtu.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
 * Servlet implementation class ReSubmitAssignmentSolution
 */
@WebServlet("/ReSubmitAssignmentSolutionService")
public class ReSubmitAssignmentSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Integer solution_id=null;
	InputStream file=null;
	long fileSize=0L;
	Connection con=null;
	PreparedStatement pstmt=null;
	List<FileItem> list=null;
	if(ServletFileUpload.isMultipartContent(request)==true){
		ServletFileUpload fileParser=new ServletFileUpload(new DiskFileItemFactory());
		try {
			list=fileParser.parseRequest(request);
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end of servletfileupload
	for(FileItem obj:list){
		if(obj.isFormField()==true){
			if(obj.getFieldName().equals("solution_id")){
				solution_id=Integer.parseInt(obj.getString());
			}
		}else{
			if(obj.getFieldName().equals("fileUpload")){
				file=obj.getInputStream();
				fileSize=obj.getSize();
			}
		}//end of else part
	}//end of for loop
	
	try {
		con=ProjectConnection.getConnection();
		String sql="update assignment_sol set solutionfile=? where solution_id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setBinaryStream(1, file, fileSize);
		pstmt.setInt(2, solution_id);
		int x=pstmt.executeUpdate();
		
		if(x!=0){
			String msg="Assignment Resubmitted Successfully";
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("").forward(request, response);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}
