package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.StudentResult;
import project.bean.TrainingCourse;
import project.dao.StudentResultDAO;
import project.dao.TrainingCourseDAO;
import util.Massage;

@ViewScoped
@ManagedBean(name = "mbStuRlt")
public class MBStudentResult {
	private List<StudentResult> resultTable;
	private List<StudentResult> selectResult;
	private StudentResultDAO dao;
	private StudentResult result;

	private List<TrainingCourse> courseList;
	private TrainingCourseDAO courseDao;

	@PostConstruct
	public void init() {
		dao = new StudentResultDAO();
		setResultTable(dao.selectAll());
		result = new StudentResult();

		result.setTrainingCourseID(new TrainingCourse());
		courseDao = new TrainingCourseDAO();
		courseList = courseDao.selectAll();
	}

	public String update() {
		dao.update(result);
		resultTable = dao.selectAll();
		Massage.addMessagByKey("INFO", "", "msg_successfully");
		return null;
	}

	public String delete() {
		dao.delete(result.getStudentID().getStudentID());
		resultTable = dao.selectAll();
		Massage.addMessagByKey("INFO", "", "msg_successfully");
		return null;
	}

    //setters&&getters
	public List<StudentResult> getSelectResult() {
		return selectResult;
	}

	public void setSelectResult(List<StudentResult> selectResult) {
		this.selectResult = selectResult;
	}

	public StudentResultDAO getDao() {
		return dao;
	}

	public void setDao(StudentResultDAO dao) {
		this.dao = dao;
	}

	public StudentResult getResult() {
		return result;
	}

	public void setResult(StudentResult result) {
		this.result = result;
	}

	public List<StudentResult> getResultTable() {
		return resultTable;
	}

	public void setResultTable(List<StudentResult> resultTable) {
		this.resultTable = resultTable;
	}

	public List<TrainingCourse> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<TrainingCourse> courseList) {
		this.courseList = courseList;
	}

}
