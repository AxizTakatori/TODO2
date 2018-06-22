package jp.co.axiz.web.servlet.detail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Task;
import service.selectservice;

/**
 * タスク詳細画面を表示するサーブレット。
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
//	    doGet(request,response);
		HttpSession session= request.getSession();


		String paramId = request.getParameter("id");
		Integer id =Integer.parseInt(paramId);
		selectservice selectservice=new selectservice();
		List<Task> select = selectservice.findid(id);
		Task taskid = select.get(0);

			session.setAttribute("deleteId", paramId);
			request.setAttribute("select", taskid);
			request.getRequestDispatcher("UpdateDelete.jsp").forward(request, response);
	}
}