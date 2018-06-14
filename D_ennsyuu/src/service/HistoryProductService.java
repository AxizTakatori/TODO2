package service;

import java.sql.Connection;
import java.util.List;

import dao.HistoryProductDao;
import entity.HistoryProduct;
import util.DbUtil;

public class HistoryProductService {
	public List<HistoryProduct> authentication(String id) {
		try(Connection conn = DbUtil.getConnection()){
			HistoryProductDao historyProductDao = new HistoryProductDao(conn);
			return historyProductDao.history(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
