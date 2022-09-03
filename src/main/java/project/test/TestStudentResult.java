package project.test;

import java.util.ArrayList;
import java.util.List;

import project.bean.Student;
import project.bean.StudentResult;
import project.bean.TrainingCourse;
import project.dao.StudentResultDAO;

public class TestStudentResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentResultDAO resultDAO = new StudentResultDAO();
		List<StudentResult> studentResultTable  = new ArrayList<StudentResult>();
		int row;

		// delete
		row = resultDAO.delete(2);
		System.out.println("daleted" + row);

		// insertTable
		StudentResult studentResult=new StudentResult();
		studentResult.setStudentID(new Student(2));
		studentResult.setTrainingCourseID(new TrainingCourse(3));
		studentResult.setEnglishMark(10);
		row=resultDAO.insert(studentResult); 
		
		System.out.println("inserted " + row);

		//update
		studentResult.setStudentID(new Student(2));
		studentResult.setTrainingCourseID(new TrainingCourse(4));
		studentResult.setEnglishMark(9);
		row=resultDAO.update(studentResult);
		System.out.println("updated " + row);

		// selectTable
		studentResultTable = resultDAO.selectAll();
		System.out.println(studentResultTable);
	
		
	

	}

	}


