package MoneyWeb.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MoneyWeb.dao.*;
import MoneyWeb.entity.MoneyWebValueObject;

/**
 * �A�J�E���g�V�K�o�^�̓��͉�ʂ�
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	MoneyWebDAO dao = new MoneyWebDAO();
    	try {
    		dao.getConnection();
    	} catch (Exception e) {
    		throw new ServletException(e);
    	} finally {
    		//DAO�̏������ς񂾂�ڑ��I��
    		dao.closeConnection();
    	}
    
    RequestDispatcher rd = request.getRequestDispatcher("/List.jsp");
	rd.forward(request,  response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
