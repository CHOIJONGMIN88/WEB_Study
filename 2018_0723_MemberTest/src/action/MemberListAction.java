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

import dao.MemberDao;
import vo.MemberVo;


/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/member/list.do")
public class MemberListAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ȸ������ ��� ��������
		
		List<MemberVo> list = MemberDao.getInstance().selectList();		
		
		//request binding
		
		request.setAttribute("list",list);
			
		//forward��ų ������
		String forward_page ="Photo_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
				
		// TODO Auto-generated method stub
	}
	
}
