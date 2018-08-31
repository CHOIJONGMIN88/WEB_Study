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



@WebServlet("/board/modify_form.do")
public class BoardModifyForm extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//호출한 게시글로 돌아가기 위한 page번호(트래킹)
		
		String page = request.getParameter("page");
		int idx=Integer.parseInt(request.getParameter("idx"));
		
		
		
		//System.out.println(page);
		
		//수정을 위한 게시글 idx를 가지고 데이터베이스에서 호출 한뒤에 수정폼으로 전송
		
		BoardVo vo = BoardDao.getInstance().selectOne(idx);
		
	
		
		
		//해당 게시글을 바인딩 후에  수정폼으로 전송
		request.setAttribute("vo",vo);
		//request.setAttribute("page",page);
		
		
		
		//forward시킬 페이지
		String forward_page ="board_modify_form.jsp?page="+page;
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

