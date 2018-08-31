package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/JuminAction.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		request.setCharacterEncoding("utf-8");
		String jumin = request.getParameter("jumin");
		/*	MyInfo My =new MyInfo();
		String str_jumin_num = request.getParameter("jumin");

		int jumin_num = Integer.parseInt(str_jumin_num.substring(0,2));
		System.out.println(jumin_num);
		jumin_num+=1900;
		
		int birth =My.nai(jumin_num);	//³ªÀÌ
		String tti_name =My.get_tti(jumin_num);	//¶ì
		
		
		request.setAttribute("jumin",jumin_num);
		request.setAttribute("birth",birth);
		request.setAttribute("tti",tti_name);
		*/
		
		RequestDispatcher disp = request.getRequestDispatcher("tti.jsp");
		disp.forward(request, response);
		
		
		/*System.out.println(jumin_num);
		System.out.println(birth);
		System.out.println(tti_name);*/
	
	
	}

}
