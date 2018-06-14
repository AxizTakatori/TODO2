package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.HistoryProduct;
public class HistoryProductDao {
	private Connection con;
	public HistoryProductDao(Connection con){
		this.con=con;
	}
	private static final String SQL_JOIN="SELECT p.name, p.price, h.count, h.subtotal FROM(SELECT p_id, p.name, p.price, h.count, h.subtotal "
									+ "FROM products AS p, buy_history_detail AS h"
									+ "WHERE p.p_id=h.p_id) WHERE p_id=?";

	public List<HistoryProduct> history(String id){
		List<HistoryProduct> list = new ArrayList<HistoryProduct>();
		try (PreparedStatement stmt = con.prepareStatement(SQL_JOIN)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				HistoryProduct hp = new HistoryProduct(rs.getString("name"), rs.getInt("price"),rs.getInt("count"), rs.getInt("subtotal"));
				list.add(hp);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
