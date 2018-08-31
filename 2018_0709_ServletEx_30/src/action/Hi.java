package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hi
 */
@WebServlet("/Hi.do")
public class Hi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /hi.do?nation=kor 
		// /hi.do?nation=eng 
		// /hi.do?nation=jpn 
		// /hi.do?nation=cha 
		
		response.setContentType("text/html; charset=utf-8");
		String nation = request.getParameter("nation");
		
		if(nation ==null)nation="kor";
			
		String greet_msg = "�ȳ��ϼ���";
		
		if(nation.equals("jpn"))greet_msg = "���۳�";
		else if(nation.equals("cha"))greet_msg = "���Ͽ�";
		else if(nation.equals("eng"))greet_msg = "����";
	
		

		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>"); 
		response.getWriter().print(greet_msg);  
		response.getWriter().println("</title></head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<br><a href='hi.html'>�ٽ��ϱ�</a>");
		
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		
		
		
		
	
	}



}
