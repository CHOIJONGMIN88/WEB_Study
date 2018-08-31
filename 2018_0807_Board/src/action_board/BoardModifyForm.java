package action_board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;



@WebServlet("/board/modify_form.do")
public class BoardModifyForm extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//ȣ���� �Խñ۷� ���ư��� ���� page��ȣ(Ʈ��ŷ)
		
		String page = request.getParameter("page");
		int idx=Integer.parseInt(request.getParameter("idx"));
		
		
		
		//System.out.println(page);
		
		//������ ���� �Խñ� idx�� ������ �����ͺ��̽����� ȣ�� �ѵڿ� ���������� ����
		
		BoardVo vo = BoardDao.getInstance().selectOne(idx);
		
	
		
		
		//�ش� �Խñ��� ���ε� �Ŀ�  ���������� ����
		request.setAttribute("vo",vo);
		//request.setAttribute("page",page);
		
		
		
		//forward��ų ������
		String forward_page ="board_modify_form.jsp?page="+page;
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

