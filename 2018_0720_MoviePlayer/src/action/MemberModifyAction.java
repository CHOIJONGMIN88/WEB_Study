package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/member/modify.do")
public class MemberModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int   idx		=   Integer.parseInt(request.getParameter("idx"));
		String name		=	request.getParameter("name");
		String id  		= 	request.getParameter("id");
		String pwd		=	request.getParameter("pwd");
		String zipcode 	= 	request.getParameter("zipcode");
		String addr 	= 	request.getParameter("addr");
		
		String ip		= 	request.getRemoteAddr();
		
		
		MemberVo  vo = new MemberVo(idx,name, id, pwd, zipcode, addr, ip);
		
		
		int res = MemberDao.getInstance().update(vo);
		
		response.sendRedirect("list.do");
		
		
		
		
		

	}

}