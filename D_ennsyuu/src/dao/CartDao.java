package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Cart;
public class CartDao {

	private Connection connection;
	private static final String SQL_LOCK="LOCK TABLE buy_history IN ACCESS EXCLUSIVE MODE";



	public CartDao(Connection connection) {
		this.connection=connection;
	}


	//テーブルロックメソッド
	private  void lock() {
		PreparedStatement stmt=null;
		try {
			stmt = this.connection.prepareStatement(SQL_LOCK);
			stmt.executeUpdate();
		}catch (SQLException e) {
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
	}


}
