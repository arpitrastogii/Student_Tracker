package hbtu.com.bo;

import java.sql.Timestamp;

public class EnrolledStudent {
private int enrollid;
private int rollno;
private String studentName;
public EnrolledStudent(int enrollid, int rollno, String studentName, Timestamp datetimeofjoining) {
	super();
	this.enrollid = enrollid;
	this.rollno = rollno;
	this.studentName = studentName;
	this.datetimeofjoining = datetimeofjoining;
}
private String batchName;
private String teacherName;
private String subjectName;
private Timestamp datetimeofjoining;

public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public String getSubjectName() {
	return subjectName;
}
public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}
public Timestamp getDatetimeofjoining() {
	return datetimeofjoining;
}
public void setDatetimeofjoining(Timestamp datetimeofjoining) {
	this.datetimeofjoining = datetimeofjoining;
}
public EnrolledStudent(int enrollid, String batchName, String teacherName, String subjectName,
		Timestamp datetimeofjoining) {
	super();
	this.enrollid = enrollid;
	this.batchName = batchName;
	this.teacherName = teacherName;
	this.subjectName = subjectName;
	this.datetimeofjoining = datetimeofjoining;
}
public EnrolledStudent(int enrollid, int rollno, String studentName, String batchName) {
	super();
	this.enrollid = enrollid;
	this.rollno = rollno;
	this.studentName = studentName;
	this.batchName = batchName;
}
public int getEnrollid() {
	return enrollid;
}
public void setEnrollid(int enrollid) {
	this.enrollid = enrollid;
}
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getBatchName() {
	return batchName;
}
public void setBatchName(String batchName) {
	this.batchName = batchName;
}
}
