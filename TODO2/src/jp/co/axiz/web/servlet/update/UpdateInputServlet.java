package jp.co.axiz.web.servlet.update;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.User_infoDao;
import entity.Task;
import util.DbUtil;

/**
 * Servlet implementation class UpdateInputServlet
 */
@WebServlet("/updateInput")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInputServlet() {
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

		request.setCharacterEncoding("UTF-8");

		// ログインID、パスワードを取得


		HttpSession session=request.getSession();

		String newTitle = request.getParameter("newTitle");
		String newTask = request.getParameter("newTask");
		String newLimitdate = request.getParameter("newLimitdate");
		String newName = request.getParameter("newName");
		String newStatus = request.getParameter("newStatus");

		Task taskinfo = (Task) session.getAttribute("update");
		Integer id = taskinfo.getId();


		Task task =(Task) session.getAttribute("select");

		// 入力値のチェック
		if (newTitle.equals(task.getTitle()) && newTask.equals(task.getTask()) && newLimitdate.equals(task.getLimitdate())&& newName.equals(task.getName())&& newStatus.equals(task.getStatus())) {//変更されているかのﾁｪｯｸ
			request.setAttribute("msg", "１項目以上変更してください");
			// 次画面指定

			request.getRequestDispatcher("UpdateDelete.jsp").forward(request, response);
		}else if(("".equals(newTitle)||"".equals(newTask)||"".equals(newLimitdate)||"".equals(newName)||"".equals(newStatus))){
			request.setAttribute("msg", "１項目以上変更してください");

			request.getRequestDispatcher("UpdateDelete.jsp").forward(request, response);
			}else {
				try(Connection conn = DbUtil.getConnection()){
					User_infoDao userinfoDao = new User_infoDao(conn);
					userinfoDao.update(id,newTitle,newTask,newLimitdate,newName,newStatus);
					request.getRequestDispatcher("updateResult.jsp").forward(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}

//				session.setAttribute("newname", newname);
//				session.setAttribute("newtel", newtel);
//				session.setAttribute("newpass", newpass);
//				session.setAttribute("id", Uinfo.getUser_id());
//
//				if(newpass.equals(Uinfo.getPassword())){
//
//					request.setAttribute("defopass", newpass);
//
//				}else {
//
//					request.setAttribute("defopass", "");
//
//				}
//			System.out.print("ccc");
			request.getRequestDispatcher("updateResult.jsp").forward(request, response);
		}
	}


	}


