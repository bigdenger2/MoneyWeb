package MoneyWeb.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MoneyWeb.entity.MoneyWebValueObject;

/**
 * 出納帳内容登録
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//voの作成
		MoneyWebValueObject vo = new MoneyWebValueObject();
		
		//新規登録であることを判別するためid=0としている。
		vo.setId(0);
		
		//タスク１件のvoをリクエスト属性へバインド
		request.setAttribute("vo", vo);
		
		//詳細画面を表示する
		RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//POST送信時もGETと同じ処理を行う
		doGet(request, response);
	}

}

