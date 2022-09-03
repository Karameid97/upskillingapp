package project.test;

import java.util.ArrayList;
import java.util.List;

import project.bean.University;
import project.dao.UniversityDAO;

public class TestUniversity {

	public static void main(String[] args) {

		UniversityDAO universitydao = new UniversityDAO();
		List<University> UniversityTable = new ArrayList<University>();
		int row;

		// delete
		row = universitydao.delete(23);
		System.out.println("daleted" + row);

		// insertTable
		row = universitydao.insert(new University(23, "nameUniversity"));
		System.out.println("inserted " + row);

		// update
		row = universitydao.update(new University(23, "testNameUniversity"));
		System.out.println("updated " + row);

		// selectTable
		UniversityTable = universitydao.selectAll();
		System.out.println(UniversityTable);

	}

}
