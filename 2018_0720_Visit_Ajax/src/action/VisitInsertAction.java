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



@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.�������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//2.parameter�ޱ� & IP�ޱ� 
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		
		//�ۼ��� IP 
	//	content=content.replaceAll("\n","<br>");
		
		String ip = request.getRemoteAddr(); //��û�� IP
		
		//3.VisitVo�� ����
		VisitVo vo = new VisitVo(name,content,pwd,ip);
		
		//4.DB Insert
		int res = VisitDao.getInstance().insert(vo);
		System.out.println(res);
		
	//���� ��Ϻ���� �̵� 
		response.sendRedirect("list.do");
		
		
	}
	
}
