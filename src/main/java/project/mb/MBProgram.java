
package project.mb;

import java.awt.image.BufferedImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import project.bean.Program;
import project.dao.ProgramDAO;
import report.Report;
import util.Massage;

@ViewScoped
@ManagedBean(name = "mbprog")
public class MBProgram {

	private List<Program> programTable;
	private List<Program> selectProgram;
	private Program program;
	private ProgramDAO programDoa;

	@PostConstruct
	public void init() {
		programDoa = new ProgramDAO();
		programTable = programDoa.selectAll();
		setProgram(new Program());
	}

	public String update() {
		programDoa.update(getProgram());
		programTable = programDoa.selectAll();
		Massage.addMessagByKey("INFO", "", "msg_successfully");
		return null;
	}

	public String delete() {
		programDoa.delete(getProgram().getProgramID());
		programTable = programDoa.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully" );
		return null;

	}

	public String runProgramReport() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/img/HTU Logo200.png"));
		param.put("p_image", image);
		Report report = new Report();
		report.runPdf("program.jasper", param);
		return null;
	}

	// setter && getters
	public List<Program> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<Program> programTable) {
		this.programTable = programTable;
	}

	public List<Program> getSelectProgram() {
		return selectProgram;
	}

	public void setSelectProgram(List<Program> selectProgram) {
		this.selectProgram = selectProgram;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

}
