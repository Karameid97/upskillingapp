package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import project.bean.Program;
import project.bean.School;
import project.bean.Student;
import project.bean.University;
import project.dao.ProgramDAO;
import project.dao.SchoolDAO;
import project.dao.StudentDAO;
import project.dao.UniversityDAO;
import util.Massage;

@ManagedBean(name = "addStu")
public class MBAddStudent {
	private Student student;
	private List<University> UniversityList;
	private List<School> SchoolList;
	private List<Program> ProgramList;
	private StudentDAO dao;
	private UniversityDAO daoUni;
	private SchoolDAO daoScho;
	private ProgramDAO daoProg;

	@PostConstruct
	public void init() {
		student = new Student();
		daoUni = new UniversityDAO();
		UniversityList = daoUni.selectAll();
		daoScho = new SchoolDAO();
		SchoolList = daoScho.selectAll();
		daoProg = new ProgramDAO();
		ProgramList = daoProg.selectAll();
		student.setStudentUniversity(new University());
		student.setStudentSchool(new School());
		student.setStudentProgram(new Program());
	}

	public String save() {
		dao = new StudentDAO();
		dao.insert(student);
		Massage.addMessagByKey("INFO", "", "msg_added");
		student = new Student();
		student.setStudentUniversity(new University());
		student.setStudentSchool(new School());
		student.setStudentProgram(new Program());
		return null;
	}

	// setters&&getters
	public StudentDAO getDao() {
		return dao;
	}

	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	public List<University> getUniversityList() {
		return UniversityList;
	}

	public void setUniversityList(List<University> universityList) {
		UniversityList = universityList;
	}

	public List<School> getSchoolList() {
		return SchoolList;
	}

	public void setSchoolList(List<School> schoolList) {
		SchoolList = schoolList;
	}

	public List<Program> getProgramList() {
		return ProgramList;
	}

	public void setProgramList(List<Program> programList) {
		ProgramList = programList;
	}

	public Student getStudent() {
		if (student == null) {
			student = new Student();
			student.setStudentUniversity(new University());
			student.setStudentSchool(new School());
			student.setStudentProgram(new Program());
		}
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
