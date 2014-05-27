package MoneyWeb.web;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MoneyWeb.dao.MoneyWebDAO;
import MoneyWeb.entity.MoneyWebValueObject;

/**
 * 更新・編集
 */
@WebServlet("/RegistarServlet")
public class RegistarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    /**
	 *POSTメソッドのみ受け付ける。 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//リクエストパラメータを受け取り、更新VOに格納する準備をする
		Timestamp date = request.getParameter("date");
		String title = request.getParameter("title");
		String task = request.getParameter("task");
		int inputmoney = Integer.parseInt(request.getParameter("inputmoney"));
		int outputmoney = Integer.parseInt(request.getParameter("outputmoney"));
		int lastmoney = Integer.parseInt(request.getParameter("lastmoney"));
		
		//VOへ格納する。登録されるValueObjectの期限(limit)はvoではinputLimitになる。
		MoneyWebValueObject vo = new MoneyWebValueObject();
		vo.setDate(date); //日付
		vo.setTitle(title); //科目
		vo.setTask(task);  //内容
		vo.setInputMoney(inputmoney); //入金
		vo.setOutputMoney(outputmoney);    //出金
		vo.setLastMoney(lastmoney);  //残高
		
		//DAOの取得
		MoneyWebDAO dao = new MoneyWebDAO();
		
		try {
			dao.getConnection();
			/*更新または登録処理を行う
			//idが0のときは新規登録、id>=1のときは更新
			if (id == 0) {
			dao.registerInsert(vo);
			setMessage(request, "タスクの新規登録処理が完了しました。");
			} else {*/
			dao.registerUpdate(vo);
				setMessage(request, "タスク[ " + title + " ]の更新処理が完了しました。");
			
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			//DAOの処理が完了したら接続を閉じる
			dao.closeConnection();
		}
		
		//一覧画面へフォワードする
		RequestDispatcher rd = request.getRequestDispatcher("/list");
		rd.forward(request, response);
	}
	
	/**
	 * JSPで表示するメッセージを設定する。
	 */
	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}
}
