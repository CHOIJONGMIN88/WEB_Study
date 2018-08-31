package action.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;

/**
 * Servlet implementation class CartUpdateAction
 */
@WebServlet("/shop/cart_update.do")
public class CartUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        //   /shop/cart_update.do?c_idx=1&c_cnt=2
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int c_cnt = Integer.parseInt(request.getParameter("c_cnt"));
		
		//여러정보를 포장해서 전달할 목적
		CartVo vo = new CartVo();
		vo.setC_idx(c_idx);
		vo.setC_cnt(c_cnt);
		
		//DB수정		
		int res = CartDao.getInstance().update(vo);
			
		
		
		//수정완료후 장바구니 보기로 이동
		response.sendRedirect("cart_list.do");
		
		
		

	}

}