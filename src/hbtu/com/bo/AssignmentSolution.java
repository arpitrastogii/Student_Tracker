package hbtu.com.bo;

public class AssignmentSolution {

	private Integer solutionId;

	private Integer assignmentId;
	private String assignmentName;
	private String isViewed;
	private String remark;
	private Integer rollno;
	private String studentName;
	public AssignmentSolution(Integer solutionId, String studentName,Integer rollno, String isViewed,String remark) {
		super();
		this.solutionId = solutionId;
		this.rollno = rollno;
		this.studentName = studentName;
		this.isViewed=isViewed;
		this.remark=remark;
	}
	public AssignmentSolution(Integer solutionId,Integer assignmentId, String assignmentName, String isViewed, String remark) {
		super();
		this.solutionId = solutionId;
		this.assignmentId = assignmentId;
		this.assignmentName = assignmentName;
		this.isViewed = isViewed;
		this.remark = remark;
	}
	public Integer getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	public String getIsViewed() {
		return isViewed;
	}
	public void setIsViewed(String isViewed) {
		this.isViewed = isViewed;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
