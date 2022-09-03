package project.mb;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import project.bean.University;
import project.dao.UniversityDAO;
import report.Report;
import util.Massage;

@ViewScoped
@ManagedBean(name = "mbUni")
public class MBUniversity {

	private List<University> universityTable;
	private UniversityDAO universityDao;
	private University university;
	private List<University> selecetUniver;

	public void web(University uni) throws IOException {
		university = uni;
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect("http://" + university.getWebsite());
	}

	@PostConstruct
	public void init() {
		universityDao = new UniversityDAO();
		setUniversityTable(universityDao.selectAll());
		setUniversity(new University());
	}

	public String update() {	
		universityDao.update(university);
		universityTable = universityDao.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully");
		return null;
	}

	public String delete() {
		universityDao.delete(university.getUniversityID());
		universityTable = universityDao.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully");
		return null;
	}
	
	public String runUniversityReport() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/img/HTU Logo200.png"));
		param.put("p_image",  image);
		Report report = new Report();
		report.runPdf("university.jasper", param);
		return null;
	}

	// setters && getters
	public List<University> getUniversityTable() {
		return universityTable;
	}

	public void setUniversityTable(List<University> universityTable) {
		this.universityTable = universityTable;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public List<University> getSelecetUniver() {
		return selecetUniver;
	}

	public void setSelecetUniver(List<University> selecetUniver) {
		this.selecetUniver = selecetUniver;
	}

}
