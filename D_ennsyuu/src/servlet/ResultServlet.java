package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DetailDao;
import dao.HistoryDao;
import entity.Detail;
import entity.History;
import util.DbUtil;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/Result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResultServlet() {
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
		HttpSession session=request.getSession();
		List<Detail> list=(List<Detail>) session.getAttribute("detail");
		Integer tax=8;
		Integer total=(Integer) session.getAttribute("Total");


		//ここからbuy_historyテーブルにセットするよ
		String id=(String) session.getAttribute("u_id");
		History h= new History(id,total,tax);
		Connection con=DbUtil.getConnection();
		HistoryDao hdao=new HistoryDao(con);
		//HistoryService historyService = new HistoryService();
		hdao.register(h);	//ここでhdaoのメソッド呼び出して登録してもらうよ
		session.setAttribute("history", h);


		//次はbuy_history_detailテーブルにセットしていくよ
		for(Detail d:list) {	//拡張for文でまわしてるよ
			int i=0;
			DetailDao ddao=new DetailDao(con);
			ddao.register(d);	//ここでddaoのメソッド呼び出して履歴詳細登録してもらうよ
			ddao.update(list.get(i).getNum(),list.get(i).getP_id());
			i++;
		}

		//p_idとnumを取ってくる



		//最後に購入履歴ページに飛ばすよ
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
