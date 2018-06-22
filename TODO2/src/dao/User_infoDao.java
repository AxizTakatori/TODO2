package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Task;



public class User_infoDao {
	private Connection con;

	private static final String SQL_INSERT_INTO_TASK = "INSERT INTO task (title,task,limitdate,name,status) VALUES(?,?,?,?,?)";
	private static final String SQL_SELECT_ALL = "SELECT id,title,task,limitdate,name,status FROM task ORDER BY id" ;
	private static final String SQL_SELECT_TASK_ID = "SELECT * FROM task WHERE id = ?  ";
	private static final String SQL_DELETE="DELETE FROM task WHERE id = ?";
	private static final String SQL_UPDATE="UPDATE task SET title=?, task=?, limitdate=?, name=?, status=? WHERE id=?";

	public User_infoDao(Connection con){
		this.con=con;
	}

	//タスクの追加
	public void register(String title, String task, String limitdate, String name, String status) {
		// TODO 自動生成されたメソッド・スタブ
		try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT_INTO_TASK)){
			stmt.setString(1, title);
			stmt.setString(2, task);
			stmt.setString(3, limitdate);
			stmt.setString(4, name);
			stmt.setString(5, status);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//タスクの全件表示
	public List<Task> findAll(){
		List<Task> list = new ArrayList<Task>();

		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)){
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Task lg = new Task(rs.getInt("id"),rs.getString("title"),rs.getString("task"),rs.getString("limitdate"),rs.getString("name"),rs.getString("status"));
				list.add(lg);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	//タスクのID探す
	public List<Task> findbyid(Integer id) {
		List<Task> list = new ArrayList<Task>();
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_TASK_ID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Task userinfo = new Task(rs.getInt("id"),rs.getString("title"),rs.getString("task"),rs.getString("limitdate"),rs.getString("name"),rs.getString("status"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	//削除
	public void delete(Integer id) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_DELETE)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//更新
	public void update(Integer id, String title, String task, String limitdate, String name, String status) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_UPDATE)){
			stmt.setString(1, title);
			stmt.setString(2, task);
			stmt.setString(3, limitdate);
			stmt.setString(4, name);
			stmt.setString(5, status);
			stmt.setInt(6, id);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}








