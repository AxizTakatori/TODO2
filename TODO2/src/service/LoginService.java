package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.AdminDao;
import entity.Admin;
import util.DbUtil;

public class LoginService {

	public Admin authentication(String admin_id, String password) {
		try(Connection con = DbUtil.getConnection()){
			AdminDao logindao = new AdminDao (con);
			Admin log = logindao.findByIdAndPass(admin_id, password);

			return log;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
