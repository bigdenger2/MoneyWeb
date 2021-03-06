package MoneyWeb.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MoneyWeb.dao.MoneyWebDAO;
import MoneyWeb.entity.MoneyWebValueObject;

/**
 * 削除
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DAOの取得
		MoneyWebDAO dao = new MoneyWebDAO();
		try {
			dao.getConnection();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		//リクエストパラメーターから選択したタスクidを取得する。
		//String paramId = request.getParameter("id");
		String paramId = request.getParameter("id");
		
		MoneyWebValueObject vo;
		try {
			//intへ変換※NumberFormatExceptionが発生する可能性あり。チェック対象
			int id = Integer.parseInt(paramId);
			
			//Stringからintへ変換し、daoで処理を行う。
			//対象のタスクを１件削除し、成功すると１が返される。
			int result = dao.delete(id);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			//DAOの処理が完了したら接続を閉じる
			dao.closeConnection();
		}
		
		setMessage(request, "タスク[ " + paramId + " ]の削除処理が完了しました。");
		
		//一覧画面へフォワードする
		RequestDispatcher rd = request.getRequestDispatcher("/todo/Serch");
		rd.forward(request,  response);
	}
	
	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}
}

	
}
