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
			
		
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");// all name content name_content
		String search_text = request.getParameter("search_text");
		
		VisitVo vo = new VisitVo();//검색조건을 담을 vo
		if(search!=null && !search.equals("all")) {
			if(search.equals("name_content")) {//이름+내용
				vo.setName(search_text);
				vo.setContent(search_text);
			}else if(search.equals("name")) {//이름
				vo.setName(search_text);
			}else if(search.equals("content")) {//내용
				vo.setContent(search_text);
			}
		}
		
		//방명록 목록 가져오기
		List<VisitVo> list = VisitDao.getInstance().selectList(vo);
		
		//request binding...
		request.setAttribute("list", list);
		
		//forward시킬 페이지
		String forward_page = "visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}
	
}
