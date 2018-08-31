package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        //   /member/login.do?id=hong&pwd=1234 
		
		String id  = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// id�� �ش�Ǵ� ȸ������ ���´�
		MemberVo user = MemberDao.getInstance().selectOne(id);
		
		if(user==null) {//id�� Ʋ�����
			// Session Tracking : GET���(Query String)�� �̿�
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		}
		
		//��й�ȣ üũ
		if(user.getPwd().equals(pwd)==false) { //��й�ȣ�� Ʋ�����
			// Session Tracking : GET���(Query String)�� �̿�
			response.sendRedirect("login_form.do?reason=fail_pwd");
			return;
		}
		
		//����α��� �Ǿ������ ó��....
		//�α��� �� ȸ�������� ���ǿ� ����
		// ��Scope : pageContext,request,session,application
		//           ���尡���� ������ =>�ڹ��� ��簴ü
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		//�α����Ŀ� ����������(movie_play.jsp)
		response.sendRedirect("../movie/list.do");
		
		
		

	}

}


