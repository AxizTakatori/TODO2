package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Login;

public class LoginDao {
	private Connection con;
	private static final String SQL_SELECT_ID_AND_PASS ="SELECT email, pass, u_id FROM login WHERE email = ? AND pass = ?";

	public LoginDao(Connection con){
		this.con=con;
	}

	public Login findByIdAndPass(String email, String pass) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ID_AND_PASS)){
			stmt.setString(1, email);
			stmt.setString(2, pass);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return new Login(rs.getString("email"),rs.getString("pass"),rs.getString("u_id"));
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

