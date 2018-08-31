package action.product;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import sun.util.resources.cldr.fr.CalendarData_fr_TD;
import vo.CartVo;


@WebServlet("/shop/cart_insert.do")
public class CartInsertAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		CartVo vo =new CartVo();
		vo.setM_idx(m_idx);
		vo.setP_idx(p_idx);
		
		CartVo result_vo = CartDao.getInstance().selectOne(vo);
		
		String result="";
		if(result_vo==null) {
			//장바구니에 등록되지 않는 경우 장바구니에 객체를 생성
			result="success";
				int res=CartDao.getInstance().insert(vo);
		}else {
			result="exist";		
		}
		
		//결과전송							자바는 "를 문자열로 인식하기때문에 앞에\을 선언해서 json객체로 인식한다.
		String result_json = String.format("{\"result\":\"%s\"}", result);
		response.setContentType("text/html; charset=utf-8");
		
		response.getWriter().println(result_json);
		
		
	
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

