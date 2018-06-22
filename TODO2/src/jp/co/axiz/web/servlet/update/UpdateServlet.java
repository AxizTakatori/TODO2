package jp.co.axiz.web.servlet.update;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_infoDao;
import util.DbUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		request.setCharacterEncoding("UTF-8");


		String newTitle = request.getParameter("newTitle");
		String newTask = request.getParameter("newTask");
		String newLimitdate = request.getParameter("newLimitdate");
		String newName = request.getParameter("newName");
		String newStatus = request.getParameter("newStatus");

		//フォームから入力された値を取得
		String id = request.getParameter("id");

		Integer Id=Integer.parseInt(id);

				try(Connection conn = DbUtil.getConnection()){
					User_infoDao userinfoDao = new User_infoDao(conn);
					userinfoDao.update(Id,newTitle,newTask,newLimitdate,newName,newStatus);
					request.getRequestDispatcher("updateResult.jsp").forward(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}

				request.getRequestDispatcher("updateResult.jsp").forward(request, response);
			}
		}




