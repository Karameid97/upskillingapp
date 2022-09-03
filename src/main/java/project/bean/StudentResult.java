package project.bean;

public class StudentResult {

	private int englishMark;
	private int interviewMark;
	private boolean acceptedFlag;
	private String notes;
	private Student studentID;
	private TrainingCourse trainingCourseID;

	public StudentResult() {
		// default constructor.
	}

	public StudentResult(int englishMark, Student studentID, TrainingCourse trainingCourseID) {
		this.englishMark = englishMark;
		this.studentID = studentID;
		this.trainingCourseID = trainingCourseID;
	}

	// setters & getters.
	public int getEnglishMark() {
		return englishMark;
	}

	public void setEnglishMark(int englishMark) {
		this.englishMark = englishMark;
	}

	public int getInterviewMark() {
		return interviewMark;
	}

	public void setInterviewMark(int interviewMark) {
		this.interviewMark = interviewMark;
	}

	public boolean isAcceptedFlag() {
		return acceptedFlag;
	}

	public void setAcceptedFlag(boolean acceptedFlag) {
		this.acceptedFlag = acceptedFlag;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Student getStudentID() {
		return studentID;
	}

	public void setStudentID(Student studentID) {
		this.studentID = studentID;
	}

	public TrainingCourse getTrainingCourseID() {
		return trainingCourseID;
	}

	public void setTrainingCourseID(TrainingCourse trainingCourseID) {
		this.trainingCourseID = trainingCourseID;
	}

	@Override
	public String toString() {
		return "StudentResult [englishMark=" + englishMark + ", interviewMark=" + interviewMark + ", acceptedFlag="
				+ acceptedFlag + ", notes=" + notes + ", studentID=" + studentID + ", trainingCourseID="
				+ trainingCourseID + "]"+"\n";
	}

}
