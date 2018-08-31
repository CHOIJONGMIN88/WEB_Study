package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

			
@WebServlet("/member/update_form.do")
public class MemberUpdateFormAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int idx= Integer.parseInt(request.getParameter("idx"));
		
	//	System.out.println(idx);
		
		MemberVo vo = MemberDao.getInstance().selectOne(idx);
		//System.out.println("데이터를 가지고 들어온다");
		
		request.setAttribute("vo", vo);
		
		//forward시킬 페이지
		String forward_page ="member_update_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
	
	}
	
}
