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
 * �X�V�E�ҏW
 */
@WebServlet("/RegistarServlet")
public class RegistarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    /**
	 *POST���\�b�h�̂ݎ󂯕t����B 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//���N�G�X�g�p�����[�^���󂯎��A�X�VVO�Ɋi�[���鏀��������
		Timestamp date = request.getParameter("date");
		String title = request.getParameter("title");
		String task = request.getParameter("task");
		int inputmoney = Integer.parseInt(request.getParameter("inputmoney"));
		int outputmoney = Integer.parseInt(request.getParameter("outputmoney"));
		int lastmoney = Integer.parseInt(request.getParameter("lastmoney"));
		
		//VO�֊i�[����B�o�^�����ValueObject�̊���(limit)��vo�ł�inputLimit�ɂȂ�B
		MoneyWebValueObject vo = new MoneyWebValueObject();
		vo.setDate(date); //���t
		vo.setTitle(title); //�Ȗ�
		vo.setTask(task);  //���e
		vo.setInputMoney(inputmoney); //����
		vo.setOutputMoney(outputmoney);    //�o��
		vo.setLastMoney(lastmoney);  //�c��
		
		//DAO�̎擾
		MoneyWebDAO dao = new MoneyWebDAO();
		
		try {
			dao.getConnection();
			/*�X�V�܂��͓o�^�������s��
			//id��0�̂Ƃ��͐V�K�o�^�Aid>=1�̂Ƃ��͍X�V
			if (id == 0) {
			dao.registerInsert(vo);
			setMessage(request, "�^�X�N�̐V�K�o�^�������������܂����B");
			} else {*/
			dao.registerUpdate(vo);
				setMessage(request, "�^�X�N[ " + title + " ]�̍X�V�������������܂����B");
			
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			//DAO�̏���������������ڑ������
			dao.closeConnection();
		}
		
		//�ꗗ��ʂփt�H���[�h����
		RequestDispatcher rd = request.getRequestDispatcher("/list");
		rd.forward(request, response);
	}
	
	/**
	 * JSP�ŕ\�����郁�b�Z�[�W��ݒ肷��B
	 */
	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}
}
