package jp.co.axiz.web.servlet.delete;

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
 * Servlet implementation class DeleteServlet
 */

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("index.jsp; charset=UTF-8");
		HttpSession session = request.getSession();
		String paramId = (String) session.getAttribute("deleteId");
		Integer id =Integer.parseInt(paramId);

		Task taskId =null;
		selectservice taskinfo=new selectservice();
		List<Task> list = taskinfo.findid(id);
		taskId = list.get(0);
		Integer deleteId = taskId.getId();
		selectservice Task=new selectservice();
		Task.delete(deleteId);

		request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
	}
}



//		try(User_infoDao dao = new User_infoDao()) {
//			// intへ変換※NumberFormatExceptionが発生する可能性あり。チェック対象。
//			int id = Integer.parseInt(paramId);
//
//			// Stringからintへ変換し、daoで処理を行う。対象のタスクを１件削除し、成功すると１が返される。
//			int result = dao.delete(id);
//		} catch (Exception e) {
//			throw new ServletException(e);
//		}
//
//		setMessage(request, "タスク[ " + paramId + " ]の削除処理が完了しました。");
//
//		// 画面を返す
//		// 完了画面を表示する
//		request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
//	}
//
//	/**
//	 * JSPで表示するメッセージを設定する。
//	 *
//	 * @param request
//	 *            サーブレットリクエスト
//	 * @param message
//	 *            メッセージ文字列
//	 */
//	protected void setMessage(HttpServletRequest request, String message) {
//		request.setAttribute("message", message);
//	}
//}

//		try {
//			//idを取得
//			String idBuf = (String)request.getParameter("id");//Bufに意味は無し:定型？
//
//			//空のid,nema,tel.passを用意
//			Task uid = null;
//
//			//入力値idが空でも空白でもない
//			if(idBuf != null && !"".equals(idBuf)) {
//
//				//空のidにuidを代入
//				Integer id = Integer.parseInt(idBuf);
//
//				selectservice userinfo=new selectservice();
//
//				//DBからidを取得
//				List<Task> list = userinfo.findid(id);
//
//				//idが登録されていないなら
//				if(list.size() == 0) {
//				}
//
//				//idが登録されていれば1つめを持ってくる
//				else {
//					uid=list.get(0);
//				}
//			}
//
//			//入力値idが空か空白であれば
//			else {
//				request.setAttribute("msg", "必須項目を入力してください");
//				request.getRequestDispatcher("delete.jsp").forward(request, response);
//			}
//
//			//idが空ならば
//			if(uid != null) {
//
//				//入力されたデータを取得
//				HttpSession session=request.getSession();
//
//				//id,nema,tel.passを格納
//				session.setAttribute("info", uid);
//				request.getRequestDispatcher("deleteConfirm.jsp").forward(request, response);
//			}else {//入力値が取得できなかったら
//				request.setAttribute("msg", "入力されたデータは存在しません");
//				request.getRequestDispatcher("delete.jsp").forward(request, response);
//			}
//		}
//		//入力値IDがint型ではないとき
//		catch(Exception e) {
//			request.setAttribute("msg", "入力されたデータは存在しません");
//			request.getRequestDispatcher("delete.jsp").forward(request, response);
//		}
//	}
//
//	}


