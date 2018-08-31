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


@WebServlet("/board/delete.do")
public class BoardDeleteAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int res=0;
	   
	//	System.out.println("들어왔구나~");
		
		String page=request.getParameter("page");
				
		int idx=Integer.parseInt(request.getParameter("idx"));
		
		res=BoardDao.getInstance().delete(idx);	
		
		
	
		
		
		response.sendRedirect("list.do?page=" + page);
		
/*		//forward시킬 페이지
		String forward_page ="list.do";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);*/
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
