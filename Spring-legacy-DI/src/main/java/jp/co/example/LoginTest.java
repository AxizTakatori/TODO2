package jp.co.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jp.co.example.service.LoginService;

/**
 * ログイン処理の動作確認のためのテストクラス。
 *
 * @author {@code AxiZ}
 */
public class LoginTest{
	/** {@code Bean}定義ファイル名を表す定数。*/
	private static final String BEANS_XML = "beans.xml";

	/**
	 * エントリーポイントとしての処理を実行します。
	 *
	 * @paramargsデフォルト･パラメーター
	 */
	public static void main(String[] args) {
		// final DefaultLoginServiceloginService= new DefaultLoginService();
		final ApplicationContext appContext= new ClassPathXmlApplicationContext(BEANS_XML);
		final LoginService loginService = appContext.getBean(LoginService.class);
		final boolean isAllwLogin= loginService.isAllowLogin(101, "axiz");
		if (isAllwLogin) {
			System.out.println("***** ログインしました.");
		} else {
			System.out.println("***** ログインできません.");
		}
	}
}