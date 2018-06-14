package service;

import java.sql.Connection;

import dao.UserDao;
import entity.User;
import util.DbUtil;

public class UserService {

	public User authentication(String uid) {
		try(Connection conn = DbUtil.getConnection()){
			UserDao userDao = new UserDao(conn);
			User user = userDao.findById(Integer.parseInt(uid));

			return user;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
