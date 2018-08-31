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

import Vo.BookVo;
import util.MySearchUtil;


@WebServlet("/book/book_serch.do")
public class BookSearch_ListAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request인코딩
				request.setCharacterEncoding("utf-8");
		
		String book_name=request.getParameter("book_name");
		int display = Integer.parseInt(request.getParameter("display_count"));
		int start_page=Integer.parseInt(request.getParameter("start_page"));
		int start=(start_page-1)*display+1;
		
		List<BookVo> list =MySearchUtil.search_book(book_name, start, display);
		
		
		request.setAttribute("list",list);
		
		//forward시킬 페이지
		String forward_page ="Book_search_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
