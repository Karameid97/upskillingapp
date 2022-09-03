package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import project.bean.Program;
import project.bean.School;
import project.bean.Student;
import project.bean.University;
import project.dao.ProgramDAO;
import project.dao.SchoolDAO;
import project.dao.StudentDAO;
import project.dao.UniversityDAO;
import util.Massage;

@ViewScoped
@ManagedBean(name = "mbStu")
public class MBStudent {

	private List<Student> studentTable;
	private List<Student> selectStudent;
	private Student student;
	private StudentDAO studentDAO;
	private List<University> universityTable;
	private UniversityDAO uniDao;
	private List<School> schoolTable;
	private SchoolDAO scholDao;
	private List<Program> programTable;
	private ProgramDAO progDao;
	private Student stuSelect;

	@PostConstruct
	public void init() {
		stuSelect = new Student();

		studentDAO = new StudentDAO();
		studentTable = studentDAO.selectAll();

		student = new Student();
		student.setStudentUniversity(new University());
		uniDao = new UniversityDAO();
		setUniversityTable(uniDao.selectAll());

		student.setStudentSchool(new School());
		scholDao = new SchoolDAO();
		setSchoolTable(scholDao.selectAll());

		student.setStudentProgram(new Program());
		progDao = new ProgramDAO();
		setProgramTable(progDao.selectAll());

	}

	public String update() {
		studentDAO.update(getStudent());
		studentTable = studentDAO.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully");
		return null;
	}

	public String delete() {
		studentDAO.delete(student.getStudentID());
		studentTable = studentDAO.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully");
		return null;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Customer Selected",
				String.valueOf(((Student) event.getObject()).getStudentID()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	// setters %% getters
	public List<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public List<Student> getSelectStudent() {
		return selectStudent;
	}

	public void setSelectStudent(List<Student> selectStudent) {
		this.selectStudent = selectStudent;
	}

	public Student getStudent() {
		// student= new Student();
		// student.setStudentUniversity(new University());
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public List<University> getUniversityTable() {
		return universityTable;
	}

	public void setUniversityTable(List<University> universityTable) {
		this.universityTable = universityTable;
	}

	public UniversityDAO getUniDao() {
		return uniDao;
	}

	public void setUniDao(UniversityDAO uniDao) {
		this.uniDao = uniDao;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public SchoolDAO getScholDao() {
		return scholDao;
	}

	public void setScholDao(SchoolDAO scholDao) {
		this.scholDao = scholDao;
	}

	public List<Program> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<Program> programTable) {
		this.programTable = programTable;
	}

	public ProgramDAO getProgDao() {
		return progDao;
	}

	public void setProgDao(ProgramDAO progDao) {
		this.progDao = progDao;
	}

	public Student getStuSelect() {
		return stuSelect;
	}

	public void setStuSelect(Student stuSelect) {
		this.stuSelect = stuSelect;
	}

}
