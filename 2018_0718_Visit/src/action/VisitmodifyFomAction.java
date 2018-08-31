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
@WebServlet("/visit/modify_form.do")
public class VisitmodifyFomAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//visit/modify_form.do?idx=11�� �Ѿ�Ҵ�.
		
		//�����ؾߵ� �Խù� idx�� ���ɴϴ�.
		
		int idx= Integer.parseInt(request.getParameter("idx"));
		
		System.out.println(idx);
		
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		// text area�� ��� html�� �ƴϱ⶧���� <br>�� �ƴ϶� \n �ٹٲ����� �ν��Ѵ�.
		
		//System.out.println(vo.getContent());
	
		String cont = vo.getContent().replaceAll("<br>","\n");
		vo.setContent(cont);
		
		request.setAttribute("vo", vo);
		
		//forward��ų ������
		String forward_page ="visit_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
