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
		
		
		
		//�˻��� ĳġ
		String search = request.getParameter("search");// all name content name_content
		String search_text = request.getParameter("search_text");
		
		Map map = new HashMap();
		
			
		if(search!=null && !search.equals("all")) {
			
			if(search.equals("name_subject_content")) {//�̸�+����			
				map.put("name", search_text);				
				map.put("content", search_text);
			}else if(search.equals("name")) {//�̸�
				
				map.put("name", search_text);

			}else if(search.equals("content")) {//����
				map.put("content", search_text);
			
			}else if(search.equals("subject")) {//����?
				map.put("subject", search_text);
			
			
			
			}
		}
		

		
		
		
		int nowPage=1; //���� �������� ������ 
		String strPage= request.getParameter("page");
	//	System.out.println(strPage);
		
		//���������� page=1 ��������
		if(strPage != null && !strPage.isEmpty()) 
			nowPage=Integer.parseInt(strPage);
		
		//������ page�� ���� start,end���
		
		int start = (nowPage-1)*MyConst.Board.BLOCKLIST + 1;
		int end   = start+MyConst.Board.BLOCKLIST-1;
		map.put("start", start);
		map.put("end",end);
		
		
		
				//�Խ��� ��� ��������
		BoardDao dao = BoardDao.getInstance();
		
		List<BoardVo> list = dao.selectList(map);
		
		//request binding 
		
		
		
		//���ǿ��� �Խù��� �ô°��� ��������
		request.getSession().removeAttribute("show");
		
		int rowTotal;
		//������ �޴� ���� 
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
		
		
		//forward��ų ������
		String forward_page ="board_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

