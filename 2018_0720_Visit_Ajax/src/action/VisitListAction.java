package action;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		
		//방명록 목록 가져오기
		List<VisitVo> list = VisitDao.getInstance().selectList();
		
		request.setAttribute("list",list);
		
		//System.out.println(list.get(0));
		//forward시킬 페이지
		String forward_page ="visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request,response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
