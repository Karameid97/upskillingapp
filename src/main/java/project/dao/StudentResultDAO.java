package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.bean.StudentResult;
import project.database.Database;

public class StudentResultDAO {
	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<StudentResult> studentResultTable;
	private int row;

	public List<StudentResult> selectAll() {
		studentResultTable = new ArrayList<StudentResult>();
		try {
			db = new project.database.Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select english_mark, interview_mark,accepted_flag, notes,student_id,course_id from student_result  order by student_id,course_id");
			rs = ps.executeQuery();
			while (rs.next()) {
				StudentResult studentResult = new StudentResult();
				studentResult.setEnglishMark(rs.getInt("english_mark"));
				studentResult.setInterviewMark(rs.getInt("interview_mark"));
				studentResult.setAcceptedFlag(rs.getBoolean("accepted_flag"));
				studentResult.setNotes(rs.getString("notes"));
				StudentDAO stuDao = new StudentDAO();
				studentResult.setStudentID(stuDao.selectById(rs.getInt("student_id")));
				TrainingCourseDAO courseDAO = new TrainingCourseDAO();
				studentResult.setTrainingCourseID(courseDAO.selectById(rs.getInt("course_id")));
				studentResultTable.add(studentResult);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return studentResultTable;
	}

	public StudentResult selectById(int id) {
		StudentResult studentResult = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select english_mark, interview_mark,accepted_flag, notes ,student_id,course_id from student_result where student_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				studentResult = new StudentResult();
				studentResult.setEnglishMark(rs.getInt("english_mark"));
				studentResult.setInterviewMark(rs.getInt("interview_mark"));
				studentResult.setAcceptedFlag(rs.getBoolean("accepted_flag"));
				studentResult.setNotes(rs.getString("notes"));
				TrainingCourseDAO courseDAO = new TrainingCourseDAO();
				studentResult.setTrainingCourseID(courseDAO.selectById(rs.getInt("course_id")));
				StudentDAO stuDao = new StudentDAO();
				studentResult.setStudentID(stuDao.selectById(rs.getInt("student_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return studentResult;
	}

	public int insert(StudentResult studentResult) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student_result (english_mark , interview_mark , accepted_flag , notes ,course_id, student_id )"
							+ " values(?, ?, ?, ?, ?, ?)");
			int counter = 1;
			ps.setInt(counter++, studentResult.getEnglishMark());
			ps.setInt(counter++, studentResult.getInterviewMark());
			ps.setBoolean(counter++, studentResult.isAcceptedFlag());
			ps.setString(counter++, studentResult.getNotes());
			ps.setInt(counter++, studentResult.getTrainingCourseID().getCourseID());
			ps.setInt(counter++, studentResult.getStudentID().getStudentID());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	public int update(StudentResult studentResult) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update student_result set english_mark=? , interview_mark=? ,accepted_flag=? , notes=? ,course_id=? where student_id = ?");
			int counter = 1;
			ps.setInt(counter++, studentResult.getEnglishMark());
			ps.setInt(counter++, studentResult.getInterviewMark());
			ps.setBoolean(counter++, studentResult.isAcceptedFlag());
			ps.setString(counter++, studentResult.getNotes());
			ps.setInt(counter++, studentResult.getTrainingCourseID().getCourseID());
			ps.setInt(counter++, studentResult.getStudentID().getStudentID());
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
			ps = connection.prepareStatement("delete from student_result where student_id = ?");
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
