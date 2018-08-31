package action;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;

/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/visit/delete.do")
public class VisiDeleteAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//삭제할 idx값 수신
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int res = VisitDao.getInstance().delete(idx);
		
		response.sendRedirect("list.do");
		
		//forward시킬 페이지
	//	String forward_page ="";
	//	RequestDispatcher disp = request.getRequestDispatcher(forward_page);
	//	disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
