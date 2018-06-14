package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BuyDao;
import entity.Detail;
import util.DbUtil;
/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/check")
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cartServlet() {
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
	List<Detail> list = new ArrayList<Detail>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//エントリーポイントを書くよ

		String id = request.getParameter("　　　　");

		Connection conn = DbUtil.getConnection() ;

		BuyDao buyDao = new BuyDao(conn);
		//BuyDaoのmakelistメソッドの呼び出し
		Detail d = buyDao.makelist(request.getParameter("p_id"),Integer.parseInt(request.getParameter("count")));
		list.add(d);

		HttpSession session = request.getSession();
		session.setAttribute("detail",list);



		request.getRequestDispatcher("cart.jsp").forward(request,response);
	}
}