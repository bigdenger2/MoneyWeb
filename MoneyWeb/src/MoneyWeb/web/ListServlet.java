package MoneyWeb.web;

import java.io.IOException;
import java.util.List;
import java.util.List.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MoneyWeb.dao.MoneyWebDAO;
import MoneyWeb.entity.MoneyWebValueObject;

/**
 * リスト一覧を検索し、一覧結果へ
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
			//DAOの取得
			MoneyWebDAO dao = new MoneyWebDAO();
			try {
				dao.getConnection();
				//タスクのリストを一覧で取得し、リクエスト属性へ格納する
				List<MoneyWebValueObject> list = dao.todoList();
				
				request.setAttribute("MoneyWebList", list);
			} catch (Exception e) {
				throw new ServletException(e);
			} finally { 
				//DAOの処理が完了したら接続を閉じる
					dao.closeConnection();			
			}	
			//検索一覧を表示する
			RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
			rd.forward(request, response);			
			}
			
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				//POST送信時もGETと同じ処理を行う
				doGet(request,response);
			}
		}


