package action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVo;


@WebServlet("/shop/list.do")
public class ProductListAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		request.setCharacterEncoding("utf-8");
		String category = request.getParameter("category");
		if(category==null||category.isEmpty()) {
			category = "com001";
		}
		
		List<ProductVo> list = ProductDao.getInstance().selectList(category);
		
		request.setAttribute("list",list);
		
		
		//forward시킬 페이지
		String forward_page ="product_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
