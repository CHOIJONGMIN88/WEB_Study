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

/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckidAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//forward시킬 페이지
		//member/check_id.do?id=hong
		//수신인코딩 설정
		request.setCharacterEncoding("utf-8");

		String id= request.getParameter("id");
		
		//id에 해당되는 MemberVo객체 얻어오기
		MemberVo vo = MemberDao.getInstance().selectOne(id);
		
		//String result="nonono";
		String result1="no";
		
		if(vo==null)//사용가능한 id(중복이 되지 않는다는뜻이다)
			result1="yes";
		
		//결과값 :JSON포장
		//JAVA스크립트상에서 넘어갈때 정상적으로 넘어가지 않는경우가 많아 JSON 배열로 묶어서 전송한다.
		//String result_json = String.format("[{'result':'%s'}]",result);
		String result_json1 = String.format("[{'result1':'%s'}]",result1);
		//System.out.println(result_json);
		//결과전송
		
		//response.setContentType("text/json;charset=utf-8;");
		//response.getWriter().print(result_json);
		response.getWriter().print(result_json1);
		
	
		
	}
	
}
