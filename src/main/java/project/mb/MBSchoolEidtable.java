package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;


import project.bean.School;
import project.dao.SchoolDAO;
import util.Massage;

@ViewScoped
@ManagedBean(name = "mbSchoEi")
public class MBSchoolEidtable {
	
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
	
	public void onCellEdit(CellEditEvent event) {  
        Object oldValue = event.getOldValue();  
        Object newValue = event.getNewValue();  
        if(newValue != null && !newValue.equals(oldValue)) {  
            DataTable s = (DataTable) event.getSource();
            School dept = (School) s.getRowData();
            schoolDao.update(dept); 
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        } 
	 }

	public String update() {
		schoolDao.update(school);
		schoolTable = schoolDao.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully");
		return null;
	}

	public String delete() {
		schoolDao.delete(school.getSchoolID());
		schoolTable = schoolDao.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully");
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
