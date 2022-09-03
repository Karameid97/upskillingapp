package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.bean.Program;
import project.database.Database;

public class ProgramDAO {

	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Program> programTable;
	private int row;

	public List<Program> selectAll() {
		programTable = new ArrayList<Program>();
		try {
			db = new project.database.Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select program_id, program_aname, program_ename,school_id from program  order by school_id,program_id");
			rs = ps.executeQuery();
			while (rs.next()) {
				Program program = new Program();
				program.setProgramID(rs.getInt("program_id"));
				program.setProgramAname(rs.getString("program_aname"));
				program.setProgramEname(rs.getString("program_ename"));

				SchoolDAO schooldao = new SchoolDAO();
				program.setSchool(schooldao.selectById(rs.getInt("school_id")));

				programTable.add(program);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return programTable;
	}

	public Program selectById(int id) {
		Program program = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select program_id, program_aname, program_ename from program where program_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				program = new Program(rs.getInt("program_id"), rs.getString("program_ename"));
				program.setProgramAname(rs.getString("program_aname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return program;
	}

	private int selectMaxId(Connection connection) {
		try {
			ps = connection.prepareStatement("select nvl(max(program_id),0) AS Program_Id from program");
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("program_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
		}
		return 0;
	}

	public int insert(Program program) {
		try {
			db = new Database();
			connection = db.getConnection();
			int maxId = selectMaxId(connection);
			ps = connection.prepareStatement(
					"insert into program (program_id, program_aname, program_ename,school_id) values(?, ?, ?, ?)");
			int counter = 1;
			ps.setInt(counter++, maxId + 1);
			ps.setString(counter++, program.getProgramAname());
			ps.setString(counter++, program.getProgramEname());
			ps.setInt(counter++, program.getSchool().getSchoolID());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	public int update(Program program) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update program set program_aname = ?, program_ename = ?, school_id=? where program_id = ?");
			int counter = 1;
			ps.setString(counter++, program.getProgramAname());
			ps.setString(counter++, program.getProgramEname());
			ps.setInt(counter++, program.getSchool().getSchoolID());
			ps.setInt(counter++, program.getProgramID());
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
			ps = connection.prepareStatement("delete from program where program_id = ?");
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
