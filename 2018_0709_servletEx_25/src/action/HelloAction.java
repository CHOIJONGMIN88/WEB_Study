package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,  //요청 처리객체
			HttpServletResponse response) 				//응답 처리객체
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String ip = request.getRemoteAddr(); //요청자 IP
		
		
		System.out.printf("[%s]:키야아아아아아아아\n",ip);
		response.setContentType("text/html; charset=utf-8;");//클라이언트에 응답해주는 문서의 유형 및 인코딩 설정
		response.getWriter().println("안녕하세요");
		
		
	}

}
