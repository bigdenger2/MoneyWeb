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
 * �폜
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DAO�̎擾
		MoneyWebDAO dao = new MoneyWebDAO();
		try {
			dao.getConnection();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		//���N�G�X�g�p�����[�^�[����I�������^�X�Nid���擾����B
		//String paramId = request.getParameter("id");
		String paramId = request.getParameter("id");
		
		MoneyWebValueObject vo;
		try {
			//int�֕ϊ���NumberFormatException����������\������B�`�F�b�N�Ώ�
			int id = Integer.parseInt(paramId);
			
			//String����int�֕ϊ����Adao�ŏ������s���B
			//�Ώۂ̃^�X�N���P���폜���A��������ƂP���Ԃ����B
			int result = dao.delete(id);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			//DAO�̏���������������ڑ������
			dao.closeConnection();
		}
		
		setMessage(request, "�^�X�N[ " + paramId + " ]�̍폜�������������܂����B");
		
		//�ꗗ��ʂփt�H���[�h����
		RequestDispatcher rd = request.getRequestDispatcher("/todo/Serch");
		rd.forward(request,  response);
	}
	
	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}
}

	
}
