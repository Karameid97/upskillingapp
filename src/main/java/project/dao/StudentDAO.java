package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import project.bean.Student;
import project.database.Database;

public class StudentDAO {

	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Student> studentTable;
	private int row;

	public List<Student> selectAll() {
		studentTable = new ArrayList<Student>();
		try {
			db = new project.database.Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, student_aname, student_ename, mobile, birthdate, sex, email, final_average, max_average ,"
							+ " rate, graduate_year, graduate_sum , university_id, school_id, program_id from student  order by  student_id");
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getInt("student_id"), rs.getString("student_ename"),
						rs.getString("mobile"));
				student.setStudentAname(rs.getString("student_aname"));
				student.setStudentBirthDate(rs.getDate("birthdate"));
				student.setStudentSex(rs.getString("sex"));
				student.setStudentEmail(rs.getString("email"));
				student.setStudentFinalAverage(rs.getDouble("final_average"));
				student.setStudentMaxAverage(rs.getDouble("max_average"));
				student.setStudentRate(rs.getInt("rate"));
				student.setStudentGradeYear(rs.getInt("graduate_year"));
				student.setStudentGradeSum(rs.getInt("graduate_sum"));

				UniversityDAO universitydao = new UniversityDAO();
				student.setStudentUniversity(universitydao.selectById(rs.getInt("university_id")));
				SchoolDAO schooldao = new SchoolDAO();
				student.setStudentSchool(schooldao.selectById(rs.getInt("school_id")));
				ProgramDAO programdao = new ProgramDAO();
				student.setStudentProgram(programdao.selectById(rs.getInt("program_id")));
				studentTable.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return studentTable;
	}

	public Student selectById(int id) {
		Student student = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select  student_id, student_aname, student_ename, mobile, birthdate, sex, email, final_average, max_average ,"
							+ " rate, graduate_year, graduate_sum, university_id, school_id, program_id from student where student_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getInt("student_id"), rs.getString("student_ename"), rs.getString("mobile"));
				student.setStudentAname(rs.getString("student_aname"));
				student.setStudentBirthDate(rs.getDate("birthdate"));
				student.setStudentSex(rs.getString("sex"));
				student.setStudentEmail(rs.getString("email"));
				student.setStudentFinalAverage(rs.getDouble("final_average"));
				student.setStudentMaxAverage(rs.getDouble("max_average"));
				student.setStudentRate(rs.getInt("rate"));
				student.setStudentGradeYear(rs.getInt("graduate_year"));
				student.setStudentGradeSum(rs.getInt("graduate_sum"));

				UniversityDAO universitydao = new UniversityDAO();
				student.setStudentUniversity(universitydao.selectById(rs.getInt("university_id")));
				SchoolDAO schooldao = new SchoolDAO();
				student.setStudentSchool(schooldao.selectById(rs.getInt("school_id")));
				ProgramDAO programdao = new ProgramDAO();
				student.setStudentProgram(programdao.selectById(rs.getInt("program_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return student;
	}
	
	private int selectMaxId(Connection connection) {
		try {
			ps = connection.prepareStatement("select nvl(max(student_id),0) AS Student_Id from student");
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("student_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
		}
		return 0;
	}

	public int insert(Student student) {
		try {
			db = new Database();
			connection = db.getConnection();
			int maxId=selectMaxId(connection);
			ps = connection.prepareStatement(
					"insert into student ( student_id, student_aname, student_ename, mobile, birthdate, sex, email, final_average, max_average , rate, graduate_year, graduate_sum, university_id, school_id, program_id)"
							+ " values(?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)");
			int counter = 1;
			ps.setInt(counter++, maxId + 1);
			ps.setString(counter++, student.getStudentAname());
			ps.setString(counter++, student.getStudentEname());
			ps.setString(counter++, student.getStudentPhoneNo());
			ps.setDate(counter++, new Date(student.getStudentBirthDate().getTime()));
			ps.setString(counter++, student.getStudentSex());
			ps.setString(counter++, student.getStudentEmail());
			ps.setDouble(counter++, student.getStudentFinalAverage());
			ps.setDouble(counter++, student.getStudentMaxAverage());
			ps.setInt(counter++, student.getStudentRate());
			ps.setInt(counter++, student.getStudentGradeYear());
			ps.setInt(counter++, student.getStudentGradeSum());
			ps.setInt(counter++, student.getStudentUniversity().getUniversityID());
			ps.setInt(counter++, student.getStudentSchool().getSchoolID());
			ps.setInt(counter++, student.getStudentProgram().getProgramID());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	public int update(Student student) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update student set   student_aname=?, student_ename=?, mobile=?, birthdate=?, sex=?, email=?, final_average=?, max_average=? , rate=?, graduate_year=?,"
							+ " graduate_sum=?, university_id=?, school_id=?, program_id=? where student_id = ?");
			int counter = 1;
			ps.setString(counter++, student.getStudentAname());
			ps.setString(counter++, student.getStudentEname());
			ps.setString(counter++, student.getStudentPhoneNo());
			ps.setDate(counter++, new Date(student.getStudentBirthDate().getTime()));
			ps.setString(counter++, student.getStudentSex());
			ps.setString(counter++, student.getStudentEmail());
			ps.setDouble(counter++, student.getStudentFinalAverage());
			ps.setDouble(counter++, student.getStudentMaxAverage());
			ps.setInt(counter++, student.getStudentRate());
			ps.setInt(counter++, student.getStudentGradeYear());
			ps.setInt(counter++, student.getStudentGradeSum());
			ps.setInt(counter++, student.getStudentUniversity().getUniversityID());
			ps.setInt(counter++, student.getStudentSchool().getSchoolID());
			ps.setInt(counter++, student.getStudentProgram().getProgramID());
			ps.setInt(counter++, student.getStudentID());
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
			ps = connection.prepareStatement("delete from student where student_id = ?");
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
