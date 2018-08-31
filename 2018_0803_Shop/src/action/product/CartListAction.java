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
import javax.servlet.http.HttpSession;

import dao.CartDao;
import vo.CartVo;
import vo.MemberVo;

/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/shop/cart_list.do")
public class CartListAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVo user=(MemberVo)session.getAttribute("user");
		
		
		
		if(user==null) {
			//로그인을 2중 3중 체크
			response.sendRedirect("../member/login_form.do");
			return;
			
		}
	
		
		
		List<CartVo> list= CartDao.getInstance().selectList(user.getIdx());
		
		
		request.setAttribute("list",list);
		
		
		
		//forward시킬 페이지
		String forward_page ="cart_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

