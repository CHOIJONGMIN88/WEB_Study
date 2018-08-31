package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Num_Cal
 */
@WebServlet("/num_cal.do")
public class Num_Cal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("utf-8");
		//전송시 인코딩, 전송과 수신시 용도가 다르다
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	
		String number_1=request.getParameter("num1");
		String number_2=request.getParameter("num2");
		
		
		int num1=Integer.parseInt(number_1);
		int num2=Integer.parseInt(number_2);
	
		
		
		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
			
		response.getWriter().printf("%d + %d = %d<br>",num1,num2,num1+num2);
		
		response.getWriter().printf("%d - %d = %d<br>",num1,num2,num1-num2);

		response.getWriter().printf("%d * %d = %d<br>",num1,num2,num1*num2);

		response.getWriter().printf("%d / %d = %d<br>",num1,num2,num1/num2);
		
	
		response.getWriter().printf("%d / %d = %d<br>",num1,num2,num1/num2);
		
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		
	
		
		
	}

	
	

}
