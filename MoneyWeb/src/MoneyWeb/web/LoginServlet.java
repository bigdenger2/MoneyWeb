package MoneyWeb.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 認証確認
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		//ユーザ情報の生成
		try { 
			request.login(userid, pass);
			RequestDispatcher rd = request.getRequestDispatcher("/List.jsp");
			rd.forward(request,  response);
		} catch (ServletException e) {
	    	e.printStackTrace();
	    	out.println("認証済みであるか、ユーザ名／パスワードが間違っています。");
		}
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
