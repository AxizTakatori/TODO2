package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);

		//リクエスト、レスポンス時の文字化け防止
		request.setCharacterEncoding("UTF-8");
		response.setContentType("index.jsp; charset=UTF-8");
		HttpSession session = request.getSession();

		//フォームから入力された値を取得
				String user_name = request.getParameter("name");
				String telephone = request.getParameter("tel");
				String password = request.getParameter("pass");

				if((user_name==null || telephone==null|| password==null)||("".equals(user_name))||("".equals(telephone))||("".equals(password))) {
					request.setAttribute("msg", "必須項目が未入力です。");
					request.getRequestDispatcher("insert.jsp").forward(request, response);
					return;

				}else {
					//合っていない場合『ログイン失敗』を表示
					session.setAttribute("newname", user_name);
					session.setAttribute("newtel", telephone);
					session.setAttribute("newpass", password);
					request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
				}

	}

}
