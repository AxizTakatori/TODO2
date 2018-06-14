package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Detail;
import entity.Product;

public class BuyDao {

//	private static final String SQL_SELECT = "SELECT * FROM products ";
	private static final String SQL_SELECT_ALL = "SELECT p_id, category, name, price, num, del FROM products";
	private Connection con;

	public BuyDao(Connection connection) {
		this.con = connection;
	}

	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();

		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getString("p_id"), rs.getString("category"), rs.getString("name"), rs.getInt("price"), rs.getInt("num"), rs.getInt("del"));
				list.add(p);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	//Productから必要なデータ持ってくるよ
		public Product find(String id) {
			String SELECT_BY_ID = "SELECT * FROM products WHERE p_id = ?";

			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement(SELECT_BY_ID);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					return new Product(rs.getString("p_id"),rs.getString("category"),rs.getString("name"),rs.getInt("price"),rs.getInt("num"),rs.getInt("del"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return null;
		}
	//Detailリスト作るよ
	public Detail makelist(String id , int count) {
		Integer count1 = count ;
		Product pd = find(id);
		Integer price = pd.getPrice();
		Integer subtotal = price * count1;

		return new Detail(id , count1, subtotal);
	}


}