package service;

import java.sql.Connection;

import dao.ProductDao;
import util.DbUtil;

public class BuyService {
	public static Connection getConnection() {
		try {
			Connection con = DbUtil.getConnection();
				ProductDao buyDao = new ProductDao (con);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}