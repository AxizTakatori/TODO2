package service;

import java.sql.Connection;

import dao.LoginDao;
import entity.Login;
import util.DbUtil;

public class LoginService {

	public Login authentication(String email,String pass) {
		try(Connection conn = DbUtil.getConnection()){
			LoginDao loginDao = new LoginDao(conn);
			Login login = loginDao.findByIdAndPass(email,pass);

			return login;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
