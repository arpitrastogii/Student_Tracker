package hbtu.com.bo;

import java.sql.Date;

public class Teacher {
  private int teacherId;  
  private String name;
  private java.sql.Date  dob;
  private String gender;
  private String fathername;
  private long contactNo;
  private String email;
  private String address;
  private String highestDegree;
  private String institute;
  private int experience;
  private String teachingSchedule;
public int getTeacherId() {
	return teacherId;
}
public void setTeacherId(int teacherId) {
	this.teacherId = teacherId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public java.sql.Date getDob() {
	return dob;
}
public void setDob(java.sql.Date dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getFathername() {
	return fathername;
}
public void setFathername(String fathername) {
	this.fathername = fathername;
}
public long getContactNo() {
	return contactNo;
}
public void setContactNo(long contactNo) {
	this.contactNo = contactNo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getHighestDegree() {
	return highestDegree;
}
public void setHighestDegree(String highestDegree) {
	this.highestDegree = highestDegree;
}
public String getInstitute() {
	return institute;
}
public void setInstitute(String institute) {
	this.institute = institute;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
public String getTeachingSchedule() {
	return teachingSchedule;
}
public void setTeachingSchedule(String teachingSchedule) {
	this.teachingSchedule = teachingSchedule;
}
public Teacher(String name, Date dob, String gender, String fathername, long contactNo, String email, String address,
		String highestDegree, String institute, int experience, String teachingSchedule) {
	super();
	this.name = name;
	this.dob = dob;
	this.gender = gender;
	this.fathername = fathername;
	this.contactNo = contactNo;
	this.email = email;
	this.address = address;
	this.highestDegree = highestDegree;
	this.institute = institute;
	this.experience = experience;
	this.teachingSchedule = teachingSchedule;
}
public Teacher(int teacherId, String name, Date dob, String gender, String fathername, long contactNo, String email,
		String address, String highestDegree, String institute, int experience, String teachingSchedule) {
	super();
	this.teacherId = teacherId;
	this.name = name;
	this.dob = dob;
	this.gender = gender;
	this.fathername = fathername;
	this.contactNo = contactNo;
	this.email = email;
	this.address = address;
	this.highestDegree = highestDegree;
	this.institute = institute;
	this.experience = experience;
	this.teachingSchedule = teachingSchedule;
}
  
  

	

}
