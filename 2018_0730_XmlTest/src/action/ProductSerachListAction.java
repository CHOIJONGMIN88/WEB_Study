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

import util.MySearchUtil;
import vo.ProductVo;

/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/product/product_search.do")
public class ProductSerachListAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//product/search.do?p_name=��Ʈ��&start_page=3&display_count=20
		
		//request���ڵ�
		request.setCharacterEncoding("utf-8");
		
		//�Ѿ�� �Ķ���� ����
		
		String p_name=request.getParameter("p_name");
		int display = Integer.parseInt(request.getParameter("display_count"));
		int start_page=Integer.parseInt(request.getParameter("start_page"));
		int start=(start_page-1)*display+1;
		
		//start_page=2 display=10
		List<ProductVo> list=MySearchUtil.search_shop(p_name, start, display);
		
		request.setAttribute("list",list);
		
		
		//forward��ų ������
		String forward_page ="product_search_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
