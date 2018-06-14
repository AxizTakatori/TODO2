package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao {
	private Connection con;
	private static final String SQL_SELECT_ID = "SELECT u_id, name, email FROM users WHERE u_id = ?";

	public UserDao(Connection con){
		this.con = con;
	}

	public User findById(Integer uid) {
		try(PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ID)){
			stmt.setInt(1, uid);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return new User(rs.getInt("u_id"),rs.getString("name"),rs.getString("email"));
			}else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
