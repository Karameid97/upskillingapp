package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import project.bean.Student;
import project.bean.StudentResult;
import project.bean.TrainingCourse;
import project.dao.StudentDAO;
import project.dao.StudentResultDAO;
import project.dao.TrainingCourseDAO;
import util.Massage;

@ManagedBean(name = "addSturslt")
public class MBAddStudentResult {
	private StudentResult result;
	private List<Student> studentList;
	private List<TrainingCourse> courseList;
	private StudentResultDAO dao;
	private StudentDAO studentDAO;
	private TrainingCourseDAO courseDao;

	@PostConstruct
	public void init() {
		result = new StudentResult();

		studentDAO = new StudentDAO();
		studentList = studentDAO.selectAll();

		courseDao = new TrainingCourseDAO();
		courseList = courseDao.selectAll();

		result.setStudentID(new Student());
		result.setTrainingCourseID(new TrainingCourse());
	}

	public String insert() {
		dao = new StudentResultDAO();
		dao.insert(result);
		Massage.addMessagByKey("INFO", "", "msg_added");
		result = new StudentResult();
		result.setStudentID(new Student());
		result.setTrainingCourseID(new TrainingCourse());
		return null;
	}

	// setters&&getters
	public StudentResult getResult() {
		if (result == null) {
			result = new StudentResult();
			result.setStudentID(new Student());
			result.setTrainingCourseID(new TrainingCourse());
		}
		return result;
	}

	public void setResult(StudentResult result) {
		this.result = result;
	}

	public StudentResultDAO getDao() {
		return dao;
	}

	public void setDao(StudentResultDAO dao) {
		this.dao = dao;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public List<TrainingCourse> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<TrainingCourse> courseList) {
		this.courseList = courseList;
	}

	public TrainingCourseDAO getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(TrainingCourseDAO courseDao) {
		this.courseDao = courseDao;
	}

}
