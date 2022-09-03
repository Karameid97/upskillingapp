package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.StudentTrainingCourse;
import project.bean.TrainingCourse;
import project.dao.StudentTrainingCourseDAO;
import project.dao.TrainingCourseDAO;
import util.Massage;

@ViewScoped
@ManagedBean(name = "mbstc")
public class MBStudentTriningCourse {

	private StudentTrainingCourse sTCourse;
	private StudentTrainingCourseDAO dao;
	private List<StudentTrainingCourse> sTCourseTable;
	private List<StudentTrainingCourse> selectCourse;
	private List<TrainingCourse> courseList;
	private List<TrainingCourse> course1;
	private List<TrainingCourse> course2;
	private List<TrainingCourse> course3;
	private TrainingCourseDAO courseDao;

	@PostConstruct
	public void init() {
		dao=new StudentTrainingCourseDAO();
		sTCourseTable = dao.selectAll();
		sTCourse = new StudentTrainingCourse();

		sTCourse.setTrainingCourseID(new TrainingCourse());
		sTCourse.setFirstChoice(new TrainingCourse());
		sTCourse.setSecondChoice(new TrainingCourse());
		sTCourse.setThirdChoice(new TrainingCourse());

		courseDao = new TrainingCourseDAO();
		courseList = courseDao.selectAll();
		course1 = courseDao.selectAll();
		course2 = courseDao.selectAll();
		course3 = courseDao.selectAll();

	}

	public String update() {
		dao.update(sTCourse);
		sTCourseTable = dao.selectAll();
		Massage.addMessagByKey("INFO", "", "msg_successfully");
		return null;
	}

	public String delete() {
		dao.delete(sTCourse.getStudent().getStudentID());
		sTCourseTable = dao.selectAll();
		Massage.addMessagByKey("INFO", "", "msg_successfully");
		return null;
	}

    //setters&&getters
	public StudentTrainingCourse getsTCourse() {
		return sTCourse;
	}

	public void setsTCourse(StudentTrainingCourse sTCourse) {
		this.sTCourse = sTCourse;
	}

	public List<StudentTrainingCourse> getsTCourseTable() {
		return sTCourseTable;
	}

	public void setsTCourseTable(List<StudentTrainingCourse> sTCourseTable) {
		this.sTCourseTable = sTCourseTable;
	}

	public List<StudentTrainingCourse> getSelectCourse() {
		return selectCourse;
	}

	public void setSelectCourse(List<StudentTrainingCourse> selectCourse) {
		this.selectCourse = selectCourse;
	}

	public List<TrainingCourse> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<TrainingCourse> courseList) {
		this.courseList = courseList;
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

	public TrainingCourseDAO getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(TrainingCourseDAO courseDao) {
		this.courseDao = courseDao;
	}

}
