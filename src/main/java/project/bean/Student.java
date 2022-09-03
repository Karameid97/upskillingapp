package project.bean;

import java.util.Date;

public class Student {

	private int studentID;
	private String studentAname;
	private String studentEname;
	private String studentPhoneNo;
	private Date studentBirthDate;
	private String studentSex;
	private String studentEmail;
	private double studentFinalAverage;
	private double studentMaxAverage;
	private int studentRate;
	private int studentGradeYear;
	private int studentGradeSum;
	private University studentUniversity;
	private School studentSchool;
	private Program studentProgram;

	public Student() {
		// default constructor.
	}

	public Student(Integer studentID, String studentEname, String studentPhoneNo) {
		this.studentID = studentID;
		this.studentEname = studentEname;
		this.studentPhoneNo = studentPhoneNo;
	}

	public Student(Integer studentID) {
		// TODO Auto-generated constructor stub
		this.studentID = studentID;
	}

	// setters & getters.


	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentAname() {
		return studentAname;
	}

	public void setStudentAname(String studentAname) {
		this.studentAname = studentAname;
	}

	public String getStudentEname() {
		return studentEname;
	}

	public void setStudentEname(String studentEname) {
		this.studentEname = studentEname;
	}

	public String getStudentPhoneNo() {
		return studentPhoneNo;
	}

	public void setStudentPhoneNo(String studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}

	public Date getStudentBirthDate() {
		return studentBirthDate;
	}

	public void setStudentBirthDate(Date studentBirthDate) {
		this.studentBirthDate = studentBirthDate;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public double getStudentFinalAverage() {
		return studentFinalAverage;
	}

	public void setStudentFinalAverage(double studentFinalAverage) {
		this.studentFinalAverage = studentFinalAverage;
	}

	public double getStudentMaxAverage() {
		return studentMaxAverage;
	}

	public void setStudentMaxAverage(double studentMaxAverage) {
		this.studentMaxAverage = studentMaxAverage;
	}

	public int getStudentRate() {
		return studentRate;
	}

	public void setStudentRate(int studentRate) {
		this.studentRate = studentRate;
	}

	public int getStudentGradeYear() {
		return studentGradeYear;
	}

	public void setStudentGradeYear(int studentGradeYear) {
		this.studentGradeYear = studentGradeYear;
	}

	public int getStudentGradeSum() {
		return studentGradeSum;
	}

	public void setStudentGradeSum(int studentGradeSum) {
		this.studentGradeSum = studentGradeSum;
	}

	public University getStudentUniversity() {
		return studentUniversity;
	}

	public void setStudentUniversity(University studentUniversity) {
		this.studentUniversity = studentUniversity;
	}

	public School getStudentSchool() {
		return studentSchool;
	}

	public void setStudentSchool(School studentSchool) {
		this.studentSchool = studentSchool;
	}

	public Program getStudentProgram() {
		return studentProgram;
	}

	public void setStudentProgram(Program studentProgram) {
		this.studentProgram = studentProgram;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentAname=" + studentAname + ", studentEname=" + studentEname
				+ ", studentPhoneNo=" + studentPhoneNo + ", studentBirthDate=" + studentBirthDate + ", studentSex="
				+ studentSex + ", studentEmail=" + studentEmail + ", studentFinalAverage=" + studentFinalAverage
				+ ", studentMaxAverage=" + studentMaxAverage + ", studentRate=" + studentRate + ", studentGradeYear="
				+ studentGradeYear + ", studentGradeSum=" + studentGradeSum + ", studentUniversity=" + studentUniversity
				+ ", studentSchool=" + studentSchool + ", studentProgram=" + studentProgram + "]" + "\n";
	}



}
