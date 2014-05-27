package MoneyWeb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import MoneyWeb.dao.MoneyWebDAO;
import MoneyWeb.entity.MoneyWebValueObject;

/**
 * Servlet implementation class SearchServlet
 */

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userid = request.getRemoteUser();
		request.setAttribute("LoginUserId", userid);

		boolean isAdmin = request.isUserInRole("admin");
		request.setAttribute("isAdmin", isAdmin);

		MoneyWebDAO dao = new MoneyWebDAO();

		try{
			dao.getConnection();
			List<MoneyWebValueObject> list = dao.MoneyWeb_List();
			request.setAttribute("MoneyWeb_List", list);
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			dao.closeConnection();

		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}