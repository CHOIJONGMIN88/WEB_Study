package action;


import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;



@WebServlet("/member/insert.do")
public class MemberInsertAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String zipcode = request.getParameter("zipcode");
		String addr = request.getParameter("addr");
		String ip = request.getRemoteAddr();
		
		
	//	String name, String id, String pwd, String zipcode, String addr, String ip
		
		MemberVo vo = new MemberVo(name,id,pwd,zipcode,addr,ip);
		
		int res = MemberDao.getInstance().insert(vo);
	//	System.out.println(res);

		//ÀçÈ°¿ë
		response.sendRedirect("list.do");
	
	}
	
}
