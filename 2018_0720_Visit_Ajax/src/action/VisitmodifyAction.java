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
import vo.VisitVo;

/**
 * Servlet implementation class SungListAction
 */			
@WebServlet("/visit/modify.do")
public class VisitmodifyAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr(); //¿äÃ»ÀÚ IP
		//String regdate=request.getParameter("regdate");
		
		
	//	content=content.replaceAll("\n","<br>");
		
		VisitVo vo = new VisitVo(idx,name,content,pwd,ip);
		
		System.out.println(content);
		int res = VisitDao.getInstance().update(vo);
		
		response.sendRedirect("list.do");
		
		// TODO Auto-generated method stub
	}
	
}
