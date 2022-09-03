package project.mb;

import javax.faces.bean.ManagedBean;

import project.bean.School;
import project.dao.SchoolDAO;
import util.Massage;

@ManagedBean(name = "mbAddScho")
public class MBAddSchool {
	
	private School school;

	public String save() {
		SchoolDAO schoolDao = new SchoolDAO();
		schoolDao.insert(school);
		Massage.addMessagByKey("INFO", "", "msg_added");
		school = new School();
		return null;
	}

	// setters && getters
	public School getSchool() {
		if (school == null) {
			school = new School();
		}
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
