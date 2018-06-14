package jp.co.example.service;

/**
 * ログイン処理ビジネスサービス・インターフェース。
 *
 */


public interface LoginService {

	/**
	 * 指定したユーザーアカウントでのログインを許可するかどうかを判定します。<p/>
	 *
	 * ログインを許可する場合は{@code true}を、
	 * 許可しない場合は{@code false}を返却します。
	 *
	 * @param am userId ユーザー{@code ID}
	 * @param pwd ログインパスワード
	 * @return 判定結果
	 */

	public boolean isAllowLogin(Integer userId, String pwd);


}
