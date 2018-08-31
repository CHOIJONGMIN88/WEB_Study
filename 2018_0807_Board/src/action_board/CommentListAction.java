package action_board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import myconst.MyConst;
import util.Paging;
import vo.CommentVo;


/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/board/comment_list.do")
public class CommentListAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//board/comment_list.do?b_idx=3
		
		int b_idx=Integer.parseInt(request.getParameter("b_idx"));
		int nowPage=1;
		
		String strPage=request.getParameter("page");
		
		if(strPage != null && !strPage.isEmpty())
			nowPage = Integer.parseInt(strPage);
		
		
		int start = (nowPage-1)*MyConst.Comment.BLOCKLIST + 1;
		int end   = start+MyConst.Comment.BLOCKLIST-1;
	
		
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end",end);
		map.put("b_idx",b_idx);	//누구의 글인지 게시글 인덱스 전송  
		
		
		List<CommentVo> list = CommentDao.getInstance().selectList(map);
		
		
		
		
		int rowTotal = CommentDao.getInstance().selectRowTotal(b_idx);
		
		String pageMenu = Paging.getCommentPaging( nowPage,				
											rowTotal, 
											MyConst.Board.BLOCKLIST, 
											MyConst.Board.BLOCKPAGE
											);
									
		
	
		
		request.setAttribute("list",list);
		request.setAttribute("pageMenu", pageMenu);
		
		//forward시킬 페이지
		String forward_page ="comment_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

