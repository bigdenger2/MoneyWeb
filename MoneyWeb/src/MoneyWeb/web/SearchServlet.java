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

import MoneyWeb.dao.*;
import MoneyWeb.entity.MoneyWebValueObject;

/**
 * �^�X�N���e�Ō������A�������ʉ�ʂ�
 */
@WebServlet("/SerchServlet")
public class SearchServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
			//DAO�̎擾
			MoneyWebDAO dao = new MoneyWebDAO();
			try {
				dao.getConnection();
				//�������ʂ��擾���A���N�G�X�g�����֊i�[����
				List<MoneyWebValueObject> list = dao.todoList();
				
				request.setAttribute("MoneyWebList", list);
			} catch (Exception e) {
				throw new ServletException(e);
			} finally { 
				//DAO�̏���������������ڑ������
					dao.closeConnection();			
			}	
			//�����ꗗ��\������
			RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp");
			rd.forward(request, response);			
			}
			
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				//POST���M����GET�Ɠ����������s��
				doGet(request,response);
			}
}


