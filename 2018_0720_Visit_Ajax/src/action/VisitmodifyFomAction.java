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
		
		
		//visit/modify_form.do?idx=11로 넘어았다.
		
		//수정해야될 게시물 idx를 얻어옵니다.
		
		int idx= Integer.parseInt(request.getParameter("idx"));
		
		System.out.println(idx);
		
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		// text area의 경우 html이 아니기때문에 <br>이 아니라 \n 줄바꿈으로 인식한다.
		
		//System.out.println(vo.getContent());
	
		String cont = vo.getContent().replaceAll("<br>","\n");
		vo.setContent(cont);
		
		request.setAttribute("vo", vo);
		
		//forward시킬 페이지
		String forward_page ="visit_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
