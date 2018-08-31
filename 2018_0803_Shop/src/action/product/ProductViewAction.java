package action.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVo;

/**
 * Servlet implementation class ProductViewAction
 */
@WebServlet("/shop/view.do")
public class ProductViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /shop/view.do?idx=5
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//idx에 해당되는 상품정보 얻어오기
		ProductVo  vo = ProductDao.getInstance().selectOne(idx);
		
		//request binding
		request.setAttribute("vo", vo);
		
		//forward시킬 페이지
		String forward_page = "product_content.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}