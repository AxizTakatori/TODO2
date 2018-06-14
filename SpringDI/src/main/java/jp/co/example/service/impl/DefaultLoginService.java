package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.UsrMstDao;
import jp.co.example.service.LoginService;

@Service
public class DefaultLoginService implements LoginService{
	/** {@link UsrMstDao}オブジェクトを保持します。*/

	@Autowired
	private UsrMstDao usrMstDao;
	/**
	 * 指定した値を{@link #usrMstDao}に設定します。
	 * @paramusrMstDao{@link #usrMstDao}に設定する値
	 */
	public void setUsrMstDao(UsrMstDao usrMstDao) {
		this.usrMstDao= usrMstDao;
	}

	/**
	 * 指定したユーザーアカウントでのログインを許可するかどうかを判定します。
	 * <p>ログインを許可する場合は{@code true}を、許可しない場合は{@code false}を返却します。</p>
	 *
	 * @paramuserIdユーザー{@code ID}
	 * @parampwdログインパスワード
	 * @return 判定結果
	 */
	public boolean isAllowLogin(Integer userId, String pwd) {
		// usrMstDao= new DefaultUsrMstDao();
		if (0 < usrMstDao.getCountByAccount(userId, pwd)) {
			return true;
		}
		return false;
	}
}