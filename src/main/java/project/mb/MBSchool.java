package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.School;
import project.dao.SchoolDAO;
import util.Massage;

@ViewScoped
@ManagedBean(name = "mbScho")
public class MBSchool {
	
	private List<School> schoolTable;
	private School school;
	private SchoolDAO schoolDao;
	private List<School> selecteSchool;

	@PostConstruct
	public void init() {
		schoolDao=new SchoolDAO();
		setSchoolTable(schoolDao.selectAll());
		setSchool(new School());
	}

	public String update() {
		schoolDao.update(school);
		schoolTable = schoolDao.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully" );
		return null;
	}

	public String delete() {
		schoolDao.delete(school.getSchoolID());
		schoolTable = schoolDao.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully" );
		return null;
	}

	// setters && getters
	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public List<School> getSelecteSchool() {
		return selecteSchool;
	}

	public void setSelecteSchool(List<School> selecteSchool) {
		this.selecteSchool = selecteSchool;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
