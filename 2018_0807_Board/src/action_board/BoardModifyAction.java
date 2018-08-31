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


@WebServlet("/board/modify_action.do")
public class BoardModifyAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//����Ʈ��ŷ�� ���� �Խ��ǹ�ȣ�� ����ؼ� ������ �ٴѴ�.
		int idx=	  Integer.parseInt(request.getParameter("idx"));
		String page=request.getParameter("page");
		
		
		
		String subject =request.getParameter("subject");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		//�������� �����ͺ��̽����� �����µ�
		BoardVo vo = BoardDao.getInstance().selectOne(idx);
		
		//����� ���� �־��ص� �����ͺ��̽��� ���� ������Ʈ �����ش�.
		vo.setSubject(subject);
		vo.setName(name);
		vo.setContent(content);
		
		 // ���ο�� �޾Ƽ� ����� ���� ������ ���̽��� ���� ������Ʈ �����ش�.
		int res = BoardDao.getInstance().update(vo);
		
		
		
		
//		request.setAttribute("page",page);
//		request.getAttribute("page");
	
		
		//forward��ų ������
//		String forward_page ="list.do?page="+page;
//		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
//		disp.forward(request, response);
		//System.out.println(page + "�̰� modify action�̴�.");
		response.sendRedirect("list.do?page="+page);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

