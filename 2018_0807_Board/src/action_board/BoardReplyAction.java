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



@WebServlet("/board/reply.do")
public class BoardReplyAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//답글의 기준글 번호==idx 
		
		
		
		
		int idx=	  Integer.parseInt(request.getParameter("idx"));
		
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		String page=request.getParameter("page");
	
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		
		//기준글에 해당되는 게시물 객체를 얻어옵니다.
		
		BoardVo baseVo = BoardDao.getInstance().selectOne(idx);
		
		
		//기준글보다 step이 큰 게시물의 step를 1씩 증가 
		//기준글의 답글을 먼저 +1 해주어 전부 밀어올린다 .
		int res = BoardDao.getInstance().update_step(baseVo);
		
		//답글 내용을 포장
		//새로운 포장한 글을 다음글에 넣는다.
		BoardVo vo = new BoardVo(id,name,subject,content,pwd,ip);
		
		vo.setRef(baseVo.getRef()); //기준글의 ref의 값을 그대로 받는다.
		vo.setStep(baseVo.getStep()+1); //답글 step = 기준글 step +1
		vo.setDepth(baseVo.getDepth()+1);//답글depth = 기준글 depth +1
		
		//답글을 DB reply
		
		res=BoardDao.getInstance().reply(vo);		
		
		//게시글idx-->view.jsp(idx)->boardform.jsp-->계속해서 idx트래킹중이다.
		//답글 작성 후에 최종적으로 호출했던 페이지와 게시글이 위치한 idx를 반환한다.
		
		request.setAttribute("page",page);
		request.setAttribute("idx",board_idx);
		
		
		//forward시킬 페이지
		String forward_page ="list.do";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
