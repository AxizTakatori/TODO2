package jp.co.example.dao;

/**
 * ユーザーマスター({@code USR_MST})テーブルアクセスのための{@code DAO}インターフェース。
 *
 */



public interface UsrMstDao {

	/**
	 * 指定した条件に合致するレコード数を取得します。
	 *
	 * @param userId ユーザー{@code ID}
	 * @param pwd ログインパスワード
	 * @return レコード数
	 */

	public int getCountByAccount(Integer userId, String pwd);

}
