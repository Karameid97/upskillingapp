package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import project.bean.Student;
import project.bean.StudentTrainingCourse;
import project.bean.TrainingCourse;
import project.dao.StudentDAO;
import project.dao.StudentTrainingCourseDAO;
import project.dao.TrainingCourseDAO;
import util.Massage;

@ManagedBean(name = "addstuTraiCors")
public class MBAddStudentTrainingCourse {

	private StudentTrainingCourse course;
	private List<Student> studentList;
	private List<TrainingCourse> courseList;
	private List<TrainingCourse> course1;
	private List<TrainingCourse> course2;
	private List<TrainingCourse> course3;

	private StudentTrainingCourseDAO dao;
	private StudentDAO studentDAO;
	private TrainingCourseDAO courseDao;

	@PostConstruct
	public void init() {
		course = new StudentTrainingCourse();

		studentDAO = new StudentDAO();
		studentList = studentDAO.selectAll();

		courseDao = new TrainingCourseDAO();
		courseList = courseDao.selectAll();
		course1 = courseDao.selectAll();
		course2 = courseDao.selectAll();
		course3 = courseDao.selectAll();

		course.setStudent(new Student());
		course.setTrainingCourseID(new TrainingCourse());
		course.setFirstChoice(new TrainingCourse());
		course.setSecondChoice(new TrainingCourse());
		course.setThirdChoice(new TrainingCourse());

	}

	public String insert() {
		dao = new StudentTrainingCourseDAO();
		dao.insert(course);
		Massage.addMessagByKey("INFO", "", "msg_added");
		course = new StudentTrainingCourse();
		course.setStudent(new Student());
		course.setTrainingCourseID(new TrainingCourse());
		course.setFirstChoice(new TrainingCourse());
		course.setSecondChoice(new TrainingCourse());
		course.setThirdChoice(new TrainingCourse());
		return null;

	}

    //setters&& getters
	public StudentTrainingCourse getCourse() {
		if (course == null) {
			course = new StudentTrainingCourse();
			course.setStudent(new Student());

			course.setTrainingCourseID(new TrainingCourse());
			course.setFirstChoice(new TrainingCourse());
			course.setSecondChoice(new TrainingCourse());
			course.setThirdChoice(new TrainingCourse());
		}
		return course;
	}

	public void setCourse(StudentTrainingCourse course) {
		this.course = course;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<TrainingCourse> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<TrainingCourse> courseList) {
		this.courseList = courseList;
	}

	public StudentTrainingCourseDAO getDao() {
		return dao;
	}

	public void setDao(StudentTrainingCourseDAO dao) {
		this.dao = dao;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public TrainingCourseDAO getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(TrainingCourseDAO courseDao) {
		this.courseDao = courseDao;
	}

	public List<TrainingCourse> getCourse1() {
		return course1;
	}

	public void setCourse1(List<TrainingCourse> course1) {
		this.course1 = course1;
	}

	public List<TrainingCourse> getCourse2() {
		return course2;
	}

	public void setCourse2(List<TrainingCourse> course2) {
		this.course2 = course2;
	}

	public List<TrainingCourse> getCourse3() {
		return course3;
	}

	public void setCourse3(List<TrainingCourse> course3) {
		this.course3 = course3;
	}

}
