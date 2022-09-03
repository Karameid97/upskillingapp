package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.bean.University;
import project.database.Database;

public class UniversityDAO {

	private project.database.Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<University> universityTable;
	private int row;
	


	public List<University> selectAll() {
		universityTable = new ArrayList<University>();
		try {
			db = new project.database.Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select university_id, university_aname, university_ename, website from university  order by university_id");
			rs = ps.executeQuery();
			while (rs.next()) {
				University university = new University(rs.getInt("university_id"), rs.getString("university_ename"));
				university.setUniversityAname(rs.getString("university_aname"));
				university.setWebsite(rs.getString("website"));
				universityTable.add(university);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return universityTable;
	}

	public University selectById(int id) {
		University university = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select university_id, university_aname, university_ename, website from university where university_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				university = new University(rs.getInt("university_id"), rs.getString("university_ename"));
				university.setUniversityAname("university_aname");
				university.setWebsite("website");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return university;
	}
	
	private int selectMaxId() {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select nvl(max(university_id),0) AS University_Id from university");
			rs = ps.executeQuery();
			if (rs.next()) {
				
				return rs.getInt("university_id");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
			
		}
		return 0;
	}
	

	public int insert(University university) {
		try {
			int maxId= selectMaxId();
			
			db = new Database();
			connection = db.getConnection();
			
			
			ps = connection.prepareStatement(
					"insert into university(university_id, university_aname, university_ename,website) values(?, ?, ?, ?)");
			int counter = 1;
			ps.setInt(counter++, maxId + 1);
			ps.setString(counter++, university.getUniversityAname());
			ps.setString(counter++, university.getUniversityEname());
			ps.setString(counter++, university.getWebsite());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	

	public int update(University university) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update university set university_aname = ?, university_ename = ?, website=? where university_id = ?");
			int counter = 1;
			ps.setString(counter++, university.getUniversityAname());
			ps.setString(counter++, university.getUniversityEname());
			ps.setString(counter++, university.getWebsite());
			ps.setInt(counter++, university.getUniversityID());
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
			ps = connection.prepareStatement("delete from university where university_id = ?");
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
