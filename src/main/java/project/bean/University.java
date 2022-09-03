package project.bean;

public class University {
	private int universityID;
	private String universityAname;
	private String universityEname;
	private String website;

	public University() {
		// default constructor.
	}

	public University(int universityID, String universityEname) {
		this.universityID = universityID;
		this.universityEname = universityEname;
	}

	public University(int universityID) {
		// TODO Auto-generated constructor stub
		this.universityID = universityID;
	}

	// setters & getters.
	public int getUniversityID() {
		return universityID;
	}

	public void setUniversityID(int universityID) {
		this.universityID = universityID;
	}

	public String getUniversityAname() {
		return universityAname;
	}

	public void setUniversityAname(String universityAname) {
		this.universityAname = universityAname;
	}

	public String getUniversityEname() {
		return universityEname;
	}

	public void setUniversityEname(String universityEname) {
		this.universityEname = universityEname;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "University [universityID=" + universityID + ", universityAname=" + universityAname
				+ ", universityEname=" + universityEname + ", website=" + website + "]" + "\n";
	}

}
