package hbtu.com.bo;

public class Batch {
 private int batch_id;
 private String batch_name;
 private int subject_id;
 private String subject_name;
 private String teacher_name;
 private String isRequested;
 private String isEnrolled;

 
public Batch( int batch_id, String batch_name, String subject_name, String teacher_name, String isRequested,String isEnrolled) {
	super();
	this.batch_id = batch_id;
	this.batch_name = batch_name;
	this.subject_name = subject_name;
	this.teacher_name = teacher_name;
	this.isRequested = isRequested;
	this.isEnrolled=isEnrolled;
}
public Batch(int batch_id, String batch_name, int subject_id, String subject_name, String teacher_name) {
	super();
	this.batch_id = batch_id;
	this.batch_name = batch_name;
	this.subject_id = subject_id;
	this.subject_name = subject_name;
	this.teacher_name = teacher_name;
}

public String getIsEnrolled() {
	return isEnrolled;
}
public void setIsEnrolled(String isEnrolled) {
	this.isEnrolled = isEnrolled;
}
public String getTeacher_name() {
	return teacher_name;
}
public void setTeacher_name(String teacher_name) {
	this.teacher_name = teacher_name;
}
public String getIsRequested() {
	return isRequested;
}
public void setIsRequested(String isRequested) {
	this.isRequested = isRequested;
}
public int getBatch_id() {
	return batch_id;
}
public void setBatch_id(int batch_id) {
	this.batch_id = batch_id;
}
public String getBatch_name() {
	return batch_name;
}
public void setBatch_name(String batch_name) {
	this.batch_name = batch_name;
}
public String getSubject_name() {
	return subject_name;
}
public void setSubject_name(String subject_name) {
	this.subject_name = subject_name;
}
public int getSubject_id() {
	return subject_id;
}
public void setSubject_id(int subject_id) {
	this.subject_id = subject_id;
}
public Batch(int batch_id, String batch_name, int subject_id, String subject_name) {
	super();
	this.batch_id = batch_id;
	this.batch_name = batch_name;
	this.subject_id = subject_id;
	this.subject_name = subject_name;
}

 
 
	
}
