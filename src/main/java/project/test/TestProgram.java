package project.test;

import java.util.ArrayList;
import java.util.List;

import project.bean.Program;
import project.bean.School;
import project.dao.ProgramDAO;

public class TestProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgramDAO programdao= new ProgramDAO();
		List<Program> programTable = new ArrayList<Program>();
		int row;

		//delete
		row = programdao.delete(24);
		System.out.println("daleted" + row);

		//insertTable
		Program program=new Program(24, "nameProgram");
		program.setSchool(new School(1));
		row=programdao.insert(program); 
		System.out.println("inserted " + row);

		//update
		program.setProgramID(23);
		program .setProgramEname("TestnameProgram");
		program.setSchool(new School(1));
		row=programdao.update(program);
		System.out.println("updated " + row);
		

		//selectTable
		programTable = programdao.selectAll();
		System.out.println(programTable);
	
		
	

	}

}
