package project.mb;

import javax.faces.bean.ManagedBean;

import project.bean.University;
import project.dao.UniversityDAO;
import util.Massage;

@ManagedBean(name = "mbAddUni")
public class MBAddUniversity {

	private University university;

	public String save() {	
		UniversityDAO universityDao = new UniversityDAO();
		universityDao.insert(university);
		Massage.addMessagByKey("INFO", "","msg_added");
		university = new University();
		return null;
	}

	// setters && getters
	public University getUniversity() {
		if (university == null) {
			university = new University();
		}
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

}
