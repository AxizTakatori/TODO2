package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.History;
public class HistoryDao {

	private Connection connection;
	private static final String SQL_LOCK="LOCK TABLE buy_history IN ACCESS EXCLUSIVE MODE";
	private static final String SQL_INSERT ="INSERT INTO buy_history(buy_num,u_id,total,tax) VALUES(?,?,?,?)";

	public HistoryDao(Connection connection) {
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


	public void register(History history) {
		PreparedStatement stmt=null;
		int buy_num;
		lock(); //テーブルロック
		//id最大値取得
		try {
			String sql = "SELECT MAX(id) AS max FROM buy_history";

			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				buy_num = rs.getInt("max") + 1;
			} else {
				buy_num=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//ここまででbuy_numに最大値+1が入っている。
		try {
			stmt=connection.prepareStatement(SQL_INSERT);
			stmt.setInt(1,buy_num);
			stmt.setString(2,history.getU_id());
			stmt.setInt(3,history.getTotal());
			stmt.setInt(4, history.getTax());
			stmt.executeUpdate();	//これで挿入！
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		try {
			this.connection.commit();
			this.connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//最後コミット
	}







}
