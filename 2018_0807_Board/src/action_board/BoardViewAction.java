package action_board;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import vo.BoardVo;



@WebServlet("/board/view.do")
public class BoardViewAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//System.out.println(idx);
		
		BoardVo vo=null;
		
	
		vo=BoardDao.getInstance().selectOne(idx);
		
		//본게시물을 봤는지 체크
		HttpSession session = request.getSession();
		if(session.getAttribute("show")==null) {
			int res=BoardDao.getInstance().update_readhit(idx);
			//세션에 봤다는 정보 기록
			session.setAttribute("show",true);	
		}
		
		// 조회한 데이터 바인딩
		request.setAttribute("vo",vo);
		
		
		
		//forward시킬 페이지
		String forward_page ="board_view.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
