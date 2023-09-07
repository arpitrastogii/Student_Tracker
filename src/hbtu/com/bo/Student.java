package hbtu.com.bo;

import java.util.Date;

public class Student {
    @Override
	public String toString() {
		return "Student [rollno=" + rollno + ", studentName=" + studentName + ", gender=" + gender + ", course="
				+ course + ", dob=" + dob + ", fatherName=" + fatherName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", contactNo=" + contactNo + ", emailId=" + emailId
				+ "]";
	}
	private int rollno;
	private String studentName;
	private String gender;
	private String course;
	private String dob;
	private String fatherName;
	private String address;
	private String city;
	private String state;
	private int pincode;
	private long contactNo;
	private String emailId;
	
	public Student(int rollno, String studentName, String gender, String course, String dob, String fatherName,
			String address, String city, String state, int pincode, long contactNo, String emailId) {
		super();
		this.rollno = rollno;
		this.studentName = studentName;
		this.gender = gender;
		this.course = course;
		this.dob = dob;
		this.fatherName = fatherName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.contactNo = contactNo;
		this.emailId = emailId;
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
	public Student(String studentName, String gender, String course, String dob, String fatherName, String address,
			String city, String state, int pincode, long contactNo, String emailId) {
		super();
		this.studentName = studentName;
		this.gender = gender;
		this.course = course;
		this.dob = dob;
		this.fatherName = fatherName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.contactNo = contactNo;
		this.emailId = emailId;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
