package project.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.bean.Program;
import project.bean.School;
import project.bean.Student;
import project.bean.University;
import project.dao.StudentDAO;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDAO studentdao= new StudentDAO();
		List<Student> studentTable = new ArrayList<Student>();
		int row;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
	    System.out.println(sdf.format(now));

		// delete
		row = studentdao.delete(23);
		System.out.println("daleted" + row);

		// insertTable
		Student student=new Student(23, "nameStudent","078888888");
		student.setStudentSchool(new School(23));
		student.setStudentUniversity(new University(23));
		student.setStudentProgram(new Program(23));
		student.setStudentBirthDate(new Date());
		row=studentdao.insert(student); 
		
		System.out.println("inserted " + row);

		// update
		student.setStudentID(23);
		student .setStudentEname("TestNameStudent");
		student.setStudentSchool(new School(23));
		row=studentdao.update(student);
		
		System.out.println("updated " + row);

		// selectTable
		studentTable = studentdao.selectAll();
		System.out.println(studentTable);
	
		
	

	}

	}


