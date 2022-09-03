package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dp.factory.Notification;
import dp.factory.NotificationFactory;
import project.bean.Student;
import project.bean.StudentInterview;
import project.dao.StudentDAO;
import project.dao.StudentInterviewDAO;
import util.Massage;

@ViewScoped
@ManagedBean(name = "mbStuInter")
public class MBStudentInterview {

	private List<StudentInterview> studentInterviewTable;
	private List<StudentInterview> interviewSelect;
	private List<String> studentemails;
	private List<Student> studentsTable;
	private StudentDAO daStudentDAO;
	private StudentInterview interview;
	private StudentInterview interview1;
	private StudentInterviewDAO dao;
	private Student student;
	private String subject ;
	private String body;

	@PostConstruct
	public void init() {
		student= new Student();
		dao = new StudentInterviewDAO();
		studentInterviewTable = dao.selectAll();
		setStudentemails(dao.selectEmails());
		interview = new StudentInterview();
		interview.setStudentId(new Student());
		
		interview1 = new StudentInterview();
		interview1.setStudentId(new Student());
	}
	
	public String update() {
		dao.update(interview1);
		studentInterviewTable = dao.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully");
		return null;
	}

	public String delete() {
		dao.delete(interview1.getStudentId().getStudentID());
		studentInterviewTable = dao.selectAll();
		Massage.addMessagByKey("INFO","","msg_successfully");
		return null;
	}

	public String sendEmail() {
		NotificationFactory factory = new NotificationFactory();
		Notification notification = factory.createNotification();
		notification.notifyUser(getStudentemails(),getSubject(),getBody());
		Massage.addMessagByKey("INFO","","msg_successfully");
		return null;
	}

	// setters && getters
	public List<StudentInterview> getStudentInterviewTable() {
		return studentInterviewTable;
	}

	public void setStudentInterviewTable(List<StudentInterview> studentInterviewTable) {
		this.studentInterviewTable = studentInterviewTable;
	}

	public List<StudentInterview> getInterviewSelect() {
		return interviewSelect;
	}

	public void setInterviewSelect(List<StudentInterview> interviewSelect) {
		this.interviewSelect = interviewSelect;
	}

	public StudentInterview getInterview() {
		return interview;
	}

	public void setInterview(StudentInterview interview) {
		this.interview = interview;
	}

	public StudentInterviewDAO getDao() {
		return dao;
	}

	public void setDao(StudentInterviewDAO dao) {
		this.dao = dao;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<String> getStudentemails() {
		return studentemails;
	}

	public void setStudentemails(List<String> studentemails) {
		this.studentemails = studentemails;
	}

	public List<Student> getStudentsTable() {
		return studentsTable;
	}

	public void setStudentsTable(List<Student> studentsTable) {
		this.studentsTable = studentsTable;
	}

	public StudentDAO getDaStudentDAO() {
		return daStudentDAO;
	}

	public void setDaStudentDAO(StudentDAO daStudentDAO) {
		this.daStudentDAO = daStudentDAO;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentInterview getInterview1() {
		return interview1;
	}

	public void setInterview1(StudentInterview interview1) {
		this.interview1 = interview1;
	}

}
