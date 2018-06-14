package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Login;
import entity.User;
import service.LoginService;
import service.UserService;

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

		//フォームから入力された値を取得
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		//何も入力されていないときは『ログインできませんでした』を表示
		if((email==null || pass==null)||("".equals(email))||("".equals(pass))) {
			request.setAttribute("msg", "ログインできませんでした。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		//DBからemail、passを取得　nullじゃない時は判定用のインスタンスに入れる
		LoginService loginService = new LoginService();
		Login login = loginService.authentication(email, pass);
		boolean isSuccess = login != null;

		//入力されたものがDB内のemail、passと合っているか判定
		if(isSuccess) {

			//合っていた場合はそのuserのidをセッションスコープに保存、nameをuserInfoへ渡す
			UserService userService = new UserService();
			String id = login.getUid();
			User user = userService.authentication(id);

			request.setAttribute("user", user);
			HttpSession session = request.getSession();
			session.setAttribute("u_id", id);
			request.getRequestDispatcher("userInfo.jsp").forward(request, response);
		}else {
			//合っていない場合『ログインできませんでした』を表示
			request.setAttribute("msg", "ログインできませんでした。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}