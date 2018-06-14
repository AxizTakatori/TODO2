package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {

//	private static final String SQL_SELECT = "SELECT * FROM products ";
	private static final String SQL_SELECT_ALL = "SELECT p_id, category, name, price, num, del FROM products";
	private Connection con;

	public ProductDao(Connection connection) {
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
}