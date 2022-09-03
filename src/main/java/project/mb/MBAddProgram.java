package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import project.bean.Program;
import project.bean.School;
import project.dao.ProgramDAO;
import project.dao.SchoolDAO;
import util.Massage;


@ManagedBean(name = "mbAddProg")
public class MBAddProgram {

	private Program program;
	private List<School> schoolTable;
	ProgramDAO progDao;
	private SchoolDAO schoolDAO;

	@PostConstruct
	public void init() {
		progDao = new ProgramDAO();
		schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
	}

	public String save() {
		progDao.insert(program);
		Massage.addMessagByKey("INFO", "", "msg_added");		
		program = new Program();
		program.setSchool(new School());
		return null;

	}

	// setters && getters
	public Program getProgram() {
		if (program == null) {
			program = new Program();
			program.setSchool(new School());
		}
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

}
