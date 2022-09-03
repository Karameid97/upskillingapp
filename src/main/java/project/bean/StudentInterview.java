package project.bean;



import java.util.Date;




public class StudentInterview {
	
	private Student studentId;
	private Date interviewDate;
	private Date interviewTime;
	private Date interviewDuration;
	
	public Student getStudentId() {
		return studentId;
	}
	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public Date getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}
	public Date getInterviewDuration() {
		return interviewDuration;
	}
	public void setInterviewDuration(Date interviewDuration) {
		this.interviewDuration = interviewDuration;
	}
	@Override
	public String toString() {
		return "StudentInterview [studentId=" + studentId + ", interviewDate=" + interviewDate + ", interviewTime="
				+ interviewTime + ", interviewDuration=" + interviewDuration + "]";
	}

}
