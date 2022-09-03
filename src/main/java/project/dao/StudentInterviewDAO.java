package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import project.bean.StudentInterview;
import project.database.Database;

public class StudentInterviewDAO {
	
	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<StudentInterview> universityInterviewTable;
	private int row;
	


	public List<StudentInterview> selectAll() {
		universityInterviewTable = new ArrayList<StudentInterview>();
		try {
			db = new project.database.Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, interview_date, interview_time, interview_duration from student_interview  order by student_id");
			rs = ps.executeQuery();
			while (rs.next()) {
				StudentInterview studentInter = new StudentInterview();
				StudentDAO studentDAO = new StudentDAO();
				studentInter.setStudentId(studentDAO.selectById(rs.getInt("student_id")));
				studentInter.setInterviewDate(rs.getDate("interview_date"));
				studentInter.setInterviewTime(rs.getTime("interview_time"));
				studentInter.setInterviewDuration(rs.getTime("interview_duration"));
				universityInterviewTable.add(studentInter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return universityInterviewTable;
	}
	
	
	public List <String> selectEmails(){
		List<String> emailTable = new ArrayList<String>();
		try {
			db = new Database();
			//universityInterviewTable = new ArrayList<Student>();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select  email from student s, student_interview i  where s.student_id=i.student_id  order by email");
			rs = ps.executeQuery();

			while (rs.next()) {
				emailTable.add(rs.getString("email"));

			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return emailTable;
		
		
	}

	public StudentInterview selectById(int id) {
		StudentInterview studentInter = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, interview_date, interview_time, interview_duration from student_interview where by student_id =?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				studentInter = new StudentInterview();
				StudentDAO studentDAO = new StudentDAO();
				studentInter.setStudentId(studentDAO.selectById(rs.getInt("student_id")));
				studentInter.setInterviewDate(rs.getDate("interview_date"));
				studentInter.setInterviewDate(rs.getTime("interview_time"));
				studentInter.setInterviewDate(rs.getTime("interview_duration"));}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return studentInter;
	}
	
	
	

	public int insert(StudentInterview studentInter) {
		try {
			
			db = new Database();
			connection = db.getConnection();
			
			
			ps = connection.prepareStatement(
					"insert into student_interview(student_id, interview_date, interview_time,interview_duration) values(?, ?, ?, ?)");
			int counter = 1;
			ps.setInt(counter++,studentInter.getStudentId().getStudentID()); 
			ps.setDate(counter++, new Date(studentInter.getInterviewDate().getTime()));
			ps.setDate(counter++, new Date(studentInter.getInterviewTime().getTime()));
			ps.setDate(counter++, new Date(studentInter.getInterviewDuration().getTime()));
			
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	

	public int update(StudentInterview studentInter) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update student_interview set interview_date = ?, interview_time = ?, interview_duration=? where student_id = ?"); 
			int counter = 1;
			ps.setDate(counter++, new Date(studentInter.getInterviewDate().getTime()));
			ps.setDate(counter++, new Date(studentInter.getInterviewTime().getTime()));
			ps.setDate(counter++, new Date(studentInter.getInterviewDuration().getTime()));
			ps.setInt(counter++,studentInter.getStudentId().getStudentID());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from student_interview where student_id = ?");
			ps.setInt(1, id);
			row = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

}
