package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;


@WebServlet("/visit/check_pwd.do")
public class VisidCheckPwdAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// TODO Auto-generated method stub
		// /visit/check_pwd.do?idx=33&c_pwd=1234
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		//idx에 해당되는 게시물 정보 얻기 
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String result ="yes";//
		
		//비밀번호 체크
		//System.out.println(vo.getPwd());
		System.out.println(c_pwd);
		
		if(vo.getPwd().equals(c_pwd)==false)result = "no";
		
		
		//요청한 Ajax에게 결과 전송 
		//호출한 jsp가 있는 위치에 값을 반환한다.
		response.getWriter().print(result);

		
	}
	
}
