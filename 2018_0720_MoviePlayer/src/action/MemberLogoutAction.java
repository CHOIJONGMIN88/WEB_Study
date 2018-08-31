package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogoutAction
 */
@WebServlet("/member/logout.do")
public class MemberLogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        //세션에 로그인된 정보를 삭제(user)
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		//로그인 페이지로 이동
		response.sendRedirect("login_form.do?reason=logout_success");
		
		

	}

}
