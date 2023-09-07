package hbtu.com.bo;

import java.sql.Date;
import java.sql.Timestamp;

public class Assignment {
	private int assignment_id;
	private int batch_id;
	private String batch_name;
	private String assignment_name;
	private String teacher_name;
	private java.sql.Date due_date;
	private java.sql.Timestamp assignmentGivenTime;
	private String isSubmitted;
	
	public Assignment(int assignment_id, String batch_name, String assignment_name, String teacher_name,
			 Date due_date, Timestamp assignmentGivenTime, String isSubmitted) {
		super();
		this.assignment_id = assignment_id;
		this.batch_name = batch_name;
		this.assignment_name = assignment_name;
		this.teacher_name = teacher_name;
		this.due_date = due_date;
		this.assignmentGivenTime = assignmentGivenTime;
		this.isSubmitted = isSubmitted;
	}
	public int getAssignment_id() {
		return assignment_id;
	}
	public Assignment(int assignment_id, int batch_id,String batch_name, String assignment_name, Date due_date,
			Timestamp assignmentGivenTime) {
		super();
		this.assignment_id = assignment_id;
		this.batch_id = batch_id;

		this.batch_name = batch_name;
		this.assignment_name = assignment_name;
		this.due_date = due_date;
		this.assignmentGivenTime = assignmentGivenTime;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	public void setAssignment_id(int assignment_id) {
		this.assignment_id = assignment_id;
	}
	public String getBatch_name() {
		return batch_name;
	}
	public void setBatch_name(String batch_name) {
		this.batch_name = batch_name;
	}
	public String getAssignment_name() {
		return assignment_name;
	}
	public void setAssignment_name(String assignment_name) {
		this.assignment_name = assignment_name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	
	public java.sql.Date getDue_date() {
		return due_date;
	}
	public void setDue_date(java.sql.Date due_date) {
		this.due_date = due_date;
	}
	public java.sql.Timestamp getAssignmentGivenTime() {
		return assignmentGivenTime;
	}
	public void setAssignmentGivenTime(java.sql.Timestamp assignmentGivenTime) {
		this.assignmentGivenTime = assignmentGivenTime;
	}
	public String getIsSubmitted() {
		return isSubmitted;
	}
	public void setIsSubmitted(String isSubmitted) {
		this.isSubmitted = isSubmitted;
	}
	
	

}
