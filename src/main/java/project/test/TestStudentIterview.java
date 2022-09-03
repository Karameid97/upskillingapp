package project.test;

//import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.bean.Student;
import project.bean.StudentInterview;
import project.dao.StudentInterviewDAO;

public class TestStudentIterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentInterviewDAO dao= new StudentInterviewDAO();
		StudentInterview studentInter= new StudentInterview();
		int row;
		
		row=dao.delete(1);
		System.err.println("daleted " + row);
		
		studentInter.setStudentId(new Student(1));
		studentInter.setInterviewDate(new Date());
		//studentInter.setInterviewTime(new Time(1, 0, 0));
		//studentInter.setInterviewDuration(new Time(1,1,1));
		row= dao.insert(studentInter);
		System.err.println(row +" inserted");
		
		studentInter.setStudentId(new Student(1));
		studentInter.setInterviewDate(new Date());
		row=dao.update(studentInter);
		System.out.println("updated " + row);
		
				
		
		List<StudentInterview> interviews = new ArrayList<StudentInterview>();
		interviews=dao.selectAll();
		System.err.println(interviews);

	}

}
