package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//hello.do?color = blue
		
		String color = request.getParameter("color");
		
		if(color==null)
			color="red";
		
		response.setContentType("text/html; charset=utf-8");//한글 인코딩
		//응답처리
		
		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>하이~</title></head>");
		response.getWriter().println("<body bgcolor=" +color +">");
		
		response.getWriter().println("<h1>HI~~~~Everyomne!!~~~~~~~~~~~~~~<br></h1>");//html 문서를 전송한다
		response.getWriter().println("안녕하세요!!");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

}
