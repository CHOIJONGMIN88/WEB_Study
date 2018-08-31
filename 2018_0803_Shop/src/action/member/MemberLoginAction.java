package action.member;

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
		//System.out.println(id);
		// id에 해당되는 회원정보 얻어온다
		MemberVo user = MemberDao.getInstance().selectOne(id);
		
	
		
		if(user==null) {//id가 틀린경우
			// Session Tracking : GET방식(Query String)을 이용
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		}
		
		//비밀번호 체크
		if(user.getPwd().equals(pwd)==false) { //비밀번호가 틀린경우
			// Session Tracking : GET방식(Query String)을 이용
			response.sendRedirect("login_form.do?reason=fail_pwd");
			return;
		}
		
		//정상로그인 되었을경우 처리....
		//로그인 한 회원정보를 세션에 저장
		// 각Scope : pageContext,request,session,application
		//           저장가는한 데이터 =>자바의 모든객체
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		
		response.sendRedirect("../shop/list.do");
		
		
		

	}

}


