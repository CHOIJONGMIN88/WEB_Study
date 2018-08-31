package action_board;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/board/reply_form.do")
public class boardReply_From extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String page=request.getParameter("page");
		
		
		
		
		
		//���� Ʈ��ŷ ���� ���ε� 
		//board_write.jsp���� ȣ��� ��ġ�� idx ���� Ʈ��ŷ ���ش�. 
		request.setAttribute("board_idx",idx);
		request.setAttribute("page",page);
		
		
	
		
		//forward��ų ������
		String forward_page ="board_reply_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

