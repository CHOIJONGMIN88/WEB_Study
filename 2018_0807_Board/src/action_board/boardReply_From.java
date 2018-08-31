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
		
		
		
		
		
		//세션 트래킹 위한 바인딩 
		//board_write.jsp에서 호출된 위치의 idx 값을 트래킹 해준다. 
		request.setAttribute("board_idx",idx);
		request.setAttribute("page",page);
		
		
	
		
		//forward시킬 페이지
		String forward_page ="board_reply_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

