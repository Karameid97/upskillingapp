package project.bean;

public class School {

	private int schoolID;
	private String schoolAname;
	private String schoolEname;
	private byte[] imgSchool;

	public School() {
		// Default Constructor
	}

	public School(int schoolID, String schoolEname) {
		this.schoolID = schoolID;
		this.schoolEname = schoolEname;
	}


	public School(int schoolID) {
		// TODO Auto-generated constructor stub
		this.schoolID = schoolID;

	}

	// setters and getters.
	public int getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}

	public String getSchoolAname() {
		return schoolAname;
	}

	public void setSchoolAname(String schoolAname) {
		this.schoolAname = schoolAname;
	}

	public String getSchoolEname() {
		return schoolEname;
	}

	public void setSchoolEname(String schoolEname) {
		this.schoolEname = schoolEname;
	}

	@Override
	public String toString() {
		return "School [schoolID=" + schoolID + ", schoolAname=" + schoolAname + ", schoolEname=" + schoolEname + "]";
	}

	public byte[] getImgSchool() {
		return imgSchool;
	}

	public void setImgSchool(byte[] imgSchool) {
		this.imgSchool = imgSchool;
	}



}
