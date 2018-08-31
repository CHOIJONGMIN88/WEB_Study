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

import dao.BoardDao;
import myconst.MyConst;
import util.Paging;
import vo.BoardVo;



/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/board/list.do")
public class BoardListAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//검색어 캐치
		String search = request.getParameter("search");// all name content name_content
		String search_text = request.getParameter("search_text");
		
		Map map = new HashMap();
		
			
		if(search!=null && !search.equals("all")) {
			
			if(search.equals("name_subject_content")) {//이름+내용			
				map.put("name", search_text);				
				map.put("content", search_text);
			}else if(search.equals("name")) {//이름
				
				map.put("name", search_text);

			}else if(search.equals("content")) {//내용
				map.put("content", search_text);
			
			}else if(search.equals("subject")) {//제목?
				map.put("subject", search_text);
			
			
			
			}
		}
		

		
		
		
		int nowPage=1; //현재 보여지는 페이지 
		String strPage= request.getParameter("page");
	//	System.out.println(strPage);
		
		//정상적으로 page=1 들어왔으면
		if(strPage != null && !strPage.isEmpty()) 
			nowPage=Integer.parseInt(strPage);
		
		//결정된 page에 따라서 start,end계산
		
		int start = (nowPage-1)*MyConst.Board.BLOCKLIST + 1;
		int end   = start+MyConst.Board.BLOCKLIST-1;
		map.put("start", start);
		map.put("end",end);
		
		
		
				//게시판 목록 가져오고
		BoardDao dao = BoardDao.getInstance();
		
		List<BoardVo> list = dao.selectList(map);
		
		//request binding 
		
		
		
		//세션에서 게시물을 봤는가에 대한정보
		request.getSession().removeAttribute("show");
		
		int rowTotal;
		//페이지 메뉴 생성 
		if(search!=null && !search.equals("all")) {
		
		 rowTotal = dao.selectRowTotalSearch(map);
			
		}
		 else	
		{
		 rowTotal = dao.selectRowTotal();
		
		}
		
		System.out.println(rowTotal);
		
		
		String pageMenu = Paging.getPaging("list.do",
											nowPage, 
											rowTotal, 
											MyConst.Board.BLOCKLIST, 
											MyConst.Board.BLOCKPAGE);
		
		
		
		request.setAttribute("list",list);
		request.setAttribute("pageMenu",pageMenu);
		
		
		//forward시킬 페이지
		String forward_page ="board_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

