package project.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import project.bean.TrainingCourse;
import project.dao.TrainingCourseDAO;
import util.Massage;

@ManagedBean(name = "addTrainCrs")
public class MBAddTrainingCourse {
	private TrainingCourse course;
	private TrainingCourseDAO dao;

	@PostConstruct
	public void init() {
		course = new TrainingCourse();
		dao = new TrainingCourseDAO();
	}

	public String insert() {
		dao.insert(course);
		course = new TrainingCourse();
		Massage.addMessagByKey("INFO", "", "msg_added");
		return null;
	}

	// setters&&getters
	public TrainingCourse getCourse() {
		if (course == null) {
			course = new TrainingCourse();
		}
		return course;
	}

	public void setCourse(TrainingCourse course) {
		this.course = course;
	}

	public TrainingCourseDAO getDao() {
		return dao;
	}

	public void setDao(TrainingCourseDAO dao) {
		this.dao = dao;
	}

}
