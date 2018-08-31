
package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/gugudan.do")
public class GugudaunAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//gugudan.do?dan=5
		
		int dan= Integer.parseInt(request.getParameter("dan"));
		
		//결과 전송
		response.setContentType("text/html; charset=utf-8");
		//응답(누가요청)
		
		
	//	StringBuffer strb = new StringBuffer();
		String str_buffer ="";
		for(int i=2;i<=9;i++) {
			
			String str = i+ "x" + dan + "=" + i*dan +"<br>";
			str_buffer =str_buffer+str;
		}
			
		
		response.getWriter().print("구구단 결과 보내줘?");
		response.getWriter().print(str_buffer);
		
		}
}