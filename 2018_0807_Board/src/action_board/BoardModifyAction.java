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
import vo.BoardVo;


@WebServlet("/board/modify_action.do")
public class BoardModifyAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//세션트래킹을 위한 게시판번호를 계속해서 가지고 다닌다.
		int idx=	  Integer.parseInt(request.getParameter("idx"));
		String page=request.getParameter("page");
		
		
		
		String subject =request.getParameter("subject");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		//원본글을 데이터베이스에서 가져온뒤
		BoardVo vo = BoardDao.getInstance().selectOne(idx);
		
		//변경된 값을 넣어준뒤 데이터베이스를 통해 업데이트 시켜준다.
		vo.setSubject(subject);
		vo.setName(name);
		vo.setContent(content);
		
		 // 새로운값을 받아서 변경된 값을 데이터 베이스를 통해 업데이트 시켜준다.
		int res = BoardDao.getInstance().update(vo);
		
		
		
		
//		request.setAttribute("page",page);
//		request.getAttribute("page");
	
		
		//forward시킬 페이지
//		String forward_page ="list.do?page="+page;
//		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
//		disp.forward(request, response);
		//System.out.println(page + "이건 modify action이다.");
		response.sendRedirect("list.do?page="+page);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

