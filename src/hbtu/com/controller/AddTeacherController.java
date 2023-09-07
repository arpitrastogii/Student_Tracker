package hbtu.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class AddTeacherController
 */
@WebServlet("/AddTeacherService")
public class AddTeacherController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=null;
		java.sql.Date dob=null;
		String gender=null;
		String fathersName=null;
		Long contactNo=null;
		String email=null;
		String address=null;
		String highestDegree=null;
		String institute=null;
		Integer experience=null;
		String institutionWorked=null;
        ArrayList<Long> selectedCourses = new ArrayList<Long>();

		String teachingSchedule=null;
		String docFileName=null;
		long docSize =0L;
		InputStream docFileData=null;
		
		List <FileItem> fileItemList =null;
		    if(ServletFileUpload.isMultipartContent(request)==true){
		    	ServletFileUpload multipartParser =new ServletFileUpload(new DiskFileItemFactory());
		    	try {
					fileItemList = multipartParser.parseRequest(request);
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    
		    for (FileItem item : fileItemList) {
                if (item.isFormField()) {
                	if (item.getFieldName().equals("fullname")) {
                        name=item.getString();
                    }if (item.getFieldName().equals("dob")) {
                    	 java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
        		    	 Date dob1=null;
        				try {
        					dob1 = sdf.parse(item.getString());
        				} catch (ParseException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				}
        				 dob=new java.sql.Date(dob1.getTime());
                     
                    }if (item.getFieldName().equals("gender")) {
                        gender=item.getString();
                    }if (item.getFieldName().equals("fathername")) {
                        fathersName=item.getString();
                    }if (item.getFieldName().equals("contact")) {
                        contactNo=Long.parseLong(item.getString());
                    }if (item.getFieldName().equals("email")) {
                        email=item.getString();
                    }if (item.getFieldName().equals("address")) {
                        address=item.getString();
                    }if (item.getFieldName().equals("degree")) {
                        highestDegree=item.getString();
                    }if (item.getFieldName().equals("institution")) {
                        institute=item.getString();
                    }if (item.getFieldName().equals("experience")) {
                        experience=Integer.parseInt(item.getString());
                    }if (item.getFieldName().equals("worked")) {
                        institutionWorked=item.getString();
                    }if (item.getFieldName().equals("subjects")) {
                    	selectedCourses.add(Long.parseLong(item.getString()));
                    	System.out.println(selectedCourses);
                    }else if (item.getFieldName().equals("schedule")) {
                        teachingSchedule=item.getString();
                    }
                }
                else {
                	if (item.getFieldName().equals("resume")) {
    				 docFileName=item.getName();
    				 docFileData=item.getInputStream();
    				 docSize=item.getSize();
                     }
                    }
		    }//end of for each loop
		    
            
		    
		    PreparedStatement pstmt1=null;
		    PreparedStatement pstmt2=null;
		    PreparedStatement pstmt3=null;
		    PreparedStatement pstmt=null;

		    Connection con=null;
		    
		    try{
		    	con=ProjectConnection.getConnection();
		    	String query="insert into teacher(TEACHER_ID,NAME,DOB,GENDER,FATHERNAME,CONTACTNO,EMAIL,ADDRESS,HIGHESTDEGREE,INSTITUTE,EXPERIENCE,TEACHINGSCHEDULE)values(TEACHER_ID.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
                String[] id={"TEACHER_ID"};
		        pstmt=con.prepareStatement(query,id);
		        pstmt.setString(1, name);
		        pstmt.setDate(2, dob);
		        pstmt.setString(3,gender);
		        pstmt.setString(4,fathersName);
		        pstmt.setLong(5,contactNo);
		        pstmt.setString(6,email);
		        pstmt.setString(7,address);
		        pstmt.setString(8,highestDegree);
		        pstmt.setString(9,institute);
		        pstmt.setInt(10,experience);
		        pstmt.setString(11,teachingSchedule);
		        int x=pstmt.executeUpdate();
		        ResultSet rsforID=pstmt.getGeneratedKeys();
		        int teacher_id=-1;
		        if(rsforID!=null && rsforID.next()){
		        	teacher_id=rsforID.getInt(1);
		        }
		        
		        String query1="insert into teacher_institute_worked(ID,TEACHER_ID,INSTITUTE)values(work_seq.nextval,?,?)";

		    	pstmt1=con.prepareStatement(query1);
		    	String[] insWorked=institutionWorked.split(",");
		        for(int i=0; i<insWorked.length; i++){
		        	pstmt1.setInt(1, teacher_id);
		        	pstmt1.setString(2, insWorked[i]);
		        	pstmt1.executeUpdate();
		        	
		        }
		        
		        String query2="insert into TEACHER_SUBJECTS(ID,TEACHER_ID,subject_id)values(taughtsubject_sequence.nextval,?,?)";
		    	pstmt2=con.prepareStatement(query2);
		     
		        for(int i=0; i<selectedCourses.size(); i++){
		        	pstmt2.setInt(1, teacher_id);
		        	pstmt2.setLong(2, selectedCourses.get(i));
		        	pstmt2.executeUpdate();
		        }
                String query3="insert into TEACHERCV(CVID,TEACHER_ID,CV,UPLOADTIME,CV_FILENAME)values(cv_seq.nextval,?,?,?,?)";
                pstmt3=con.prepareStatement(query3);

		        Date date=new Date();
		        java.sql.Timestamp time=new java.sql.Timestamp(date.getTime());
	        	pstmt3.setInt(1, teacher_id);
		        pstmt3.setBinaryStream(2,docFileData,(int)docSize);
		        pstmt3.setTimestamp(3, time);
		        pstmt3.setString(4,teacher_id+"_"+name+"_cv");
		        int z=pstmt3.executeUpdate();
		        if(z!=0){
		        	String msg="Form submitted to Admin : Now wait for Admin Response";
		        	request.setAttribute("message",msg);
		        	request.getRequestDispatcher("Teacher_SignUp.jsp").forward(request, response);
		       
		        }else{
		        	String msg="error found";
		        	request.setAttribute("message",msg);
		        	request.getRequestDispatcher("Teacher_SignUp.jsp").forward(request, response);
		           
		        }
		        
		    }catch(SQLException e){
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
