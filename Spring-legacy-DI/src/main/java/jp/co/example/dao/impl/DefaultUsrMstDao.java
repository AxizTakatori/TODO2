package jp.co.example.dao.impl;

import org.springframework.stereotype.Repository;

import jp.co.example.dao.UsrMstDao;

@Repository
public class DefaultUsrMstDao implements UsrMstDao {
	/**
	 * 指定した条件に合致するレコード数を取得します。
	 *
	 * @paramuserIdユーザー{@code ID}
	 * @parampwdログインパスワード
	 * @return レコード数
	 */
	public int getCountByAccount(Integer userId, String pwd) {
		// 現状は固定で1を返却（仮）
		return 1;
	}
}
