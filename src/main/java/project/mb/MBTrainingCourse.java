package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.TrainingCourse;
import project.dao.TrainingCourseDAO;
import util.Massage;

@ViewScoped
@ManagedBean(name = "mbTCourse")
public class MBTrainingCourse {

	private List<TrainingCourse> courseTable;
	private List<TrainingCourse> selectCourse;
	private TrainingCourseDAO courseDao;
	private TrainingCourse trainCourse;
	private TrainingCourse Course;

	@PostConstruct
	public void init() {
		setCourseDao(new TrainingCourseDAO());
		setCourseTable(getCourseDao().selectAll());
		trainCourse = new TrainingCourse();
	}

	public String update() {
		courseDao.update(getTrainCourse());
		courseTable = courseDao.selectAll();
		Massage.addMessagByKey("INFO", "", "msg_successfully");
		return null;
	}

	public String delete() {
		courseDao.delete(getTrainCourse().getCourseID());
		courseTable = courseDao.selectAll();
		Massage.addMessagByKey("INFO", "", "msg_successfully");
		return null;
	}

	// setters && getters
	public TrainingCourseDAO getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(TrainingCourseDAO courseDao) {
		this.courseDao = courseDao;
	}

	public List<TrainingCourse> getCourseTable() {
		return courseTable;
	}

	public void setCourseTable(List<TrainingCourse> courseTable) {
		this.courseTable = courseTable;
	}

	public List<TrainingCourse> getSelectCourse() {
		return selectCourse;
	}

	public void setSelectCourse(List<TrainingCourse> selectCourse) {
		this.selectCourse = selectCourse;
	}

	public TrainingCourse getTrainCourse() {
		return trainCourse;
	}

	public void setTrainCourse(TrainingCourse trainCourse) {
		this.trainCourse = trainCourse;
	}

	public TrainingCourse getCourse() {
		return Course;
	}

	public void setCourse(TrainingCourse course) {
		Course = course;
	}

}
