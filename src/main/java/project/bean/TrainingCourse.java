package project.bean;

public class TrainingCourse {

	private int courseID;
	private String courseAname;
	private String courseEname;
	private int maxStudent;
	private String shortDesc;
	private String detailedDesc;

	public TrainingCourse() {
		// default constructor.
	}

	public TrainingCourse(int courseID, String courseEname, int maxStudent) {
		this.courseID = courseID;
		this.courseEname = courseEname;
		this.maxStudent = maxStudent;
	}

	public TrainingCourse(int courseID) {
		// TODO Auto-generated constructor stub
		this.courseID = courseID;
	}

	// setters & getters.
	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseAname() {
		return courseAname;
	}

	public void setCourseAname(String courseAname) {
		this.courseAname = courseAname;
	}

	public String getCourseEname() {
		return courseEname;
	}

	public void setCourseEname(String courseEname) {
		this.courseEname = courseEname;
	}

	public int getMaxStudent() {
		return maxStudent;
	}

	public void setMaxStudent(int maxStudent) {
		this.maxStudent = maxStudent;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getDetailedDesc() {
		return detailedDesc;
	}

	public void setDetailedDesc(String detailedDesc) {
		this.detailedDesc = detailedDesc;
	}

	@Override
	public String toString() {
		return "TrainingCourse [courseID=" + courseID + ", courseAname=" + courseAname + ", courseEname=" + courseEname
				+ ", maxStudent=" + maxStudent + ", shortDesc=" + shortDesc + ", detailedDesc=" + detailedDesc + "]"
				+ "\n";
	}

}
