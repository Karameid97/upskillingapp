package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import project.bean.Student;
import project.bean.StudentInterview;

import project.dao.StudentDAO;
import project.dao.StudentInterviewDAO;

import util.Massage;

@ManagedBean(name = "mbaddinterv")
public class MBAddStudentInterview {

	private StudentInterview interview;
	private List<Student> studentList;
	private StudentInterviewDAO dao;
	private StudentDAO studentDAO;

	@PostConstruct
	public void init() {
		interview = new StudentInterview();
		studentDAO = new StudentDAO();
		studentList = studentDAO.selectAll();
		interview.setStudentId(new Student());
	}

	public String insert() {
		dao = new StudentInterviewDAO();
		dao.insert(interview);
		Massage.addMessagByKey("INFO", "", "msg_added");
		interview = new StudentInterview();
		interview.setStudentId(new Student());
		return null;
	}

	// setters&&getters
	public StudentInterview getInterview() {
		if (interview == null) {
			interview = new StudentInterview();
			interview.setStudentId(new Student());
		}
		return interview;
	}

	public void setInterview(StudentInterview interview) {
		this.interview = interview;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public StudentInterviewDAO getDao() {
		return dao;
	}

	public void setDao(StudentInterviewDAO dao) {
		this.dao = dao;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}
