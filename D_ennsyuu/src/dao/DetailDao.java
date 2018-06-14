package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Detail;

public class DetailDao {

	private Connection connection;
	private static final String SQL_LOCK="LOCK TABLE buy_history IN ACCESS EXCLUSIVE MODE";
	private static final String SQL_INSERT="INSERT INTO buy_history_detail VALUES(?,?,?,?)";
	private static final String SQL_UPDATE="UPDATE products SET num= ? WHERE p_id = ?";



	public DetailDao(Connection connection) {
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


		public void register(Detail detail) {
			PreparedStatement stmt=null;
			int buy_num;
			lock(); //テーブルロック
			//id最大値取得
			try {
				String sql = "SELECT MAX(id) AS max FROM buy_history";

				stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					buy_num = rs.getInt("max");
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
			}//ここまででbuy_numにhistoryの最大値が入っている。
			//ここから情報の登録に入る
			try {
				stmt=connection.prepareStatement(SQL_INSERT);
				stmt.setInt(1, buy_num);
				stmt.setString(2,detail.getP_id());
				stmt.setInt(3,detail.getNum());
				stmt.setInt(3,detail.getSubtotal());
				stmt.executeUpdate();
			}catch(SQLException e) {
				throw new RuntimeException(e);
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

		public void update(Integer num,String p_id) {
			PreparedStatement stmt=null;
			lock(); //テーブルロック
			//id最大値取得
			try {

				stmt = connection.prepareStatement(SQL_UPDATE);
				//stmt.setInt(1, Product.getNum()-num);
				stmt.setString(2, p_id);
				stmt.executeUpdate();

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
			}
		}














}
