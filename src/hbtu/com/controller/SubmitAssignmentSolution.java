package hbtu.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import hbtu.com.connection.ProjectConnection;

/**
 * Servlet implementation class SubmitAssignmentSolution
 */
@WebServlet("/SubmitAssignmentSolution")
public class SubmitAssignmentSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session==null){
			response.sendRedirect("student-login.jsp");
		}
		String student_id=(String)session.getAttribute("student_id");
		String assignment_id=null;
		String docFileName=null;
		long docSize =0L;
		InputStream docFileData=null;
		List<FileItem> fileItemList=null;
		if(ServletFileUpload.isMultipartContent(request)==true){
			ServletFileUpload multipartParser=new ServletFileUpload(new DiskFileItemFactory());
			try {
				fileItemList=multipartParser.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(FileItem obj: fileItemList){
			if(obj.isFormField()){
				if(obj.getFieldName().equals("student_id"))
					student_id=obj.getString();
				if(obj.getFieldName().equals("assignment_id"))
					assignment_id=obj.getString();

			}else{
				if(obj.getFieldName().equals("fileUpload")){
					docSize=obj.getSize();
					docFileData=obj.getInputStream();
					docFileName="AssID"+assignment_id+"Stud"+student_id;
				}
			}			
		}//end of for loop
		
		Connection con=null;
		PreparedStatement pstmt=null;
	    try {
			con=ProjectConnection.getConnection();
			String sql="insert into assignment_sol(solution_id,assignment_id,rollno,solution_filename,solutionfile)values(assignment_solution.nextval,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(assignment_id));
			pstmt.setInt(2,Integer.parseInt(student_id));
			pstmt.setString(3,docFileName);
		    pstmt.setBinaryStream(4,docFileData,docSize);
		    int x=pstmt.executeUpdate();
		    if(x!=0){
		    	String msg="Assignment Successfully submitted";
		    	request.setAttribute("msg", msg);
		    	request.getRequestDispatcher("").forward(request,response);
		    }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally{
	    	try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
	    	
	    }
		
	}

}
