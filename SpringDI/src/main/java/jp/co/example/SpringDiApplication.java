package jp.co.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jp.co.example.service.LoginService;

@SpringBootApplication
public class SpringDiApplication{
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringDiApplication.class, args);
		LoginService loginService= context.getBean(LoginService.class);
		final boolean isAllowLogin= loginService.isAllowLogin(101, "axiz");
		if (isAllowLogin) {
			System.out.println("***** ログインしました.");
		} else {
			System.out.println("***** ログインできません.");
		}
	}
}
