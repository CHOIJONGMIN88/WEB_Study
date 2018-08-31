package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */			//hello.do=>경로는 WebContent이다.
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//hello.do?gubun=아침
		//hello.do?gobun=점심
		//hello.do?gobun=저녁
	
		//수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		String gubun = request.getParameter("gubun");
		
		if(gubun==null || gubun=="") {
			gubun = "아침";		
		}
			
		String message = "";
		String test_message = "이게 넘어가는게 트루?";
		
		switch(gubun)
		{
		case "아침": message="안녕히 주무셧습니까?"; break;
		case "점심": message="점심식사 하셧습니까?"; break;
		case "저녁": message="good evening?"; break;

		}
		
		String result_message = String.format("[%s]인사:%s",gubun,message);
		//계산된 결과를 출력객체(JSP)에게 전달해서 출력하게끔 forward시킨다.
		//Servlet과 JSP간의 데이터를 공유하기 위해서 Binding 시킨다.
		request.setAttribute("result",result_message);
		request.setAttribute("test_result",test_message);
		
		//System.out.println(result_message);
		//System.out.println(test_message);
		
		RequestDispatcher disp = request.getRequestDispatcher("Next_HelloAction.do");
		disp.forward(request, response);
		
	
	}

}
