package project.test;

import java.util.ArrayList;
import java.util.List;
import project.bean.Student;
import project.bean.StudentTrainingCourse;
import project.bean.TrainingCourse;
import project.dao.StudentTrainingCourseDAO;

public class TestStudentTrainingCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentTrainingCourseDAO studentTrainingCoursDAO = new StudentTrainingCourseDAO();
		List<StudentTrainingCourse> studentTrainingCourseTable = new ArrayList<StudentTrainingCourse>();
		int row;

		// delete
		row = studentTrainingCoursDAO.delete(23);
		System.out.println("daleted" + row);

		// insertTable
		StudentTrainingCourse studentTrainingCourse = new StudentTrainingCourse();

		studentTrainingCourse.setStudent(new Student(23));
		studentTrainingCourse.setTrainingCourseID(new TrainingCourse(3));
		studentTrainingCourse.setPriority(10);
		row = studentTrainingCoursDAO.insert(studentTrainingCourse);
		System.out.println("inserted " + row);

		// update
		studentTrainingCourse.setStudent(new Student(23));
		studentTrainingCourse.setTrainingCourseID(new TrainingCourse(4));
		studentTrainingCourse.setPriority(9);
		row = studentTrainingCoursDAO.update(studentTrainingCourse);
		System.out.println("updated " + row);

		// selectTable
		studentTrainingCourseTable = studentTrainingCoursDAO.selectAll();
		System.out.println(studentTrainingCourseTable);

	}

}
