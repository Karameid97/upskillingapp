package project.bean;

public class Program {
	private int programID;
	private String programAname;
	private String programEname;
	private School school;

	public Program() {
		// default constructor.
	}

	public Program(int programID, String programEname) {
		this.programID = programID;
		this.programEname = programEname;
	}

	public Program(int programID) {
		this.programID = programID;
	}

	// setters & getters.
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public int getProgramID() {
		return programID;
	}

	public void setProgramID(int programID) {
		this.programID = programID;
	}

	public String getProgramAname() {
		return programAname;
	}

	public void setProgramAname(String programAname) {
		this.programAname = programAname;
	}

	public String getProgramEname() {
		return programEname;
	}

	public void setProgramEname(String programEname) {
		this.programEname = programEname;
	}

	@Override
	public String toString() {
		return "Program [school=" + school + ", programID=" + programID + ", programEname=" + programEname + "]" + "\n";
	}
}
