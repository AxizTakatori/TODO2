package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Admin;



public class AdminDao {
	private Connection con;
	private static final String SQL_SELECT_USER_ID_AND_PASSWORD ="SELECT user_id, user_name, password FROM usertable WHERE user_id = ? AND password = ?";

	public AdminDao(Connection con){
		this.con=con;
	}

	public Admin findByIdAndPass(String user_id, String password) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_USER_ID_AND_PASSWORD)){
			stmt.setString(1, user_id);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return new Admin(rs.getString("user_id"),rs.getString("user_name"),rs.getString("password"));
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

