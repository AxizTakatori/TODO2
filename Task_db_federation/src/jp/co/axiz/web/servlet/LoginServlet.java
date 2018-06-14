package jp.co.axiz.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;
import service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエスト、レスポンス時の文字化け防止
		request.setCharacterEncoding("UTF-8");
		response.setContentType("index.jsp; charset=UTF-8");
		HttpSession session = request.getSession();

		//フォームから入力された値を取得
		String admin_id = request.getParameter("id");
		String password = request.getParameter("pass");

		//何も入力されていないときは『ログインできませんでした』を表示
		if((admin_id==null || password==null)||("".equals(admin_id))||("".equals(password))) {
			request.setAttribute("msg", "ログインできませんでした。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		//DBからid、passを取得　nullじゃない時は判定用のインスタンスに入れる
		LoginService loginService = new LoginService();
		Admin login = loginService.authentication(admin_id, password);
		boolean isSuccess =(login != null);

		//入力されたものがDB内のadmin_id、passwordと合っているか判定
		if(isSuccess) {

			//合っていた場合はそのadminのidをセッションスコープに保存
			session.setAttribute("loginname", login.getAdmin_name());
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}else {
			//合っていない場合『ログイン失敗』を表示
			request.setAttribute("msg", "ログイン失敗。");
			//次画面指定
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}