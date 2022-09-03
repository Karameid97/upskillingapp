package project.bean;

public class StudentTrainingCourse {
	private Student student;
	private TrainingCourse trainingCourseID;
	private int priority;
	private TrainingCourse  firstChoice;
	private TrainingCourse  secondChoice;
	private TrainingCourse thirdChoice;

	public TrainingCourse getFirstChoice() {
		return firstChoice;
	}

	public void setFirstChoice(TrainingCourse firstChoice) {
		this.firstChoice = firstChoice;
	}

	public TrainingCourse getSecondChoice() {
		return secondChoice;
	}

	public void setSecondChoice(TrainingCourse secondChoice) {
		this.secondChoice = secondChoice;
	}

	public StudentTrainingCourse() {
		// default constructor.
	}

	public StudentTrainingCourse(Student student, TrainingCourse trainingCourseID, int priority) {
		this.student = student;
		this.trainingCourseID = trainingCourseID;
		this.priority = priority;
	}

	// setters & getters.
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student studentID) {
		this.student = studentID;
	}

	public TrainingCourse getTrainingCourseID() {
		return trainingCourseID;
	}

	public void setTrainingCourseID(TrainingCourse trainingCourseID) {
		this.trainingCourseID = trainingCourseID;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public TrainingCourse getThirdChoice() {
		return thirdChoice;
	}

	public void setThirdChoice(TrainingCourse thirdChoice) {
		this.thirdChoice = thirdChoice;
	}

	@Override
	public String toString() {
		return "StudentTrainingCourse [studentID=" + student + ", trainingCourseID=" + trainingCourseID + ", priority="
				+ priority + "]" + "\n";
	}

}
