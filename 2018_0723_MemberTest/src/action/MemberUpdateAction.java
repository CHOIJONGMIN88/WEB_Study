package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

import vo.MemberVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/update.do")
public class MemberUpdateAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		
		int idx=Integer.parseInt(request.getParameter("idx"));
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String zipcode=request.getParameter("zipcode");
		String addr=request.getParameter("addr");
		String ip=request.getParameter("ip");
		
		
		MemberVo vo = new MemberVo(idx,name,id,pwd,zipcode,addr,ip);
		
	//	System.out.println(pwd);
		
		int res = MemberDao.getInstance().update(vo);
	//	System.out.println(res);
		response.sendRedirect("list.do");
		
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

