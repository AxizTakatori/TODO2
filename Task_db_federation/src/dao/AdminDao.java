package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Admin;



public class AdminDao {
	private Connection con;
	private static final String SQL_SELECT_ADMIN_ID_AND_PASSWORD ="SELECT admin_id, admin_name, password FROM admin WHERE admin_id = ? AND password = ?";
	private static final String SQL_SELECT_ALL = "SELECT admin_id, admin_name, password";

//	private static final String SQL_SELECT_USER_ID_AND_USER_NAME_AND_TELEPHNE_AND_PASSWORD  ="SELECT user_id, user_name,telephone, password FROM user_info WHERE user_id = ? AND user_name = ?\" AND telephone = ?\" AND password = ?";
//	private static final String SQL_SELECT_ALL1 = "SELECT user_id, user_name,telephone , password";

	public AdminDao(Connection con){
		this.con=con;
	}

	public Admin findByIdAndPass(String admin_id, String password) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ADMIN_ID_AND_PASSWORD)){
			stmt.setString(1, admin_id);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return new Admin(rs.getString("admin_id"),rs.getString("admin_name"),rs.getString("password"));
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Admin> findAll(){
		List<Admin> list = new ArrayList<Admin>();

		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)){
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Admin lg = new Admin(rs.getString("admin_id"),rs.getString("admin_name"),rs.getString("password"));
				list.add(lg);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	}

