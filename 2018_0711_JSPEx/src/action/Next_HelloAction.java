package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Next_HelloAction
 */
@WebServlet("/Next_HelloAction.do")
public class Next_HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");	//수신인코딩 설정
	   //HellowAction에서 request를 통해 넘어온 result값을 다시 불러온다.
	//	String result =(String)request.getAttribute("result");	//
	//	String test_result =(String)request.getAttribute("test_result");
		
		
		//System.out.println(result);
	//	System.out.println(test_result);	
		
		String new_result="기존의 HelloAction이 새로운 값으로 변경된다.";
		String test_new_result="기존의 HelloAction이 새로운 값으로 변경된다.테스트";
		
	//	result="한번꺾어주고";
	//	test_result="다시한번 돌려주고 업데이트";	
		
		//request.setAttribute("final_result",result);
	//	request.setAttribute("final_test_result",test_result);
		
		request.setAttribute("result",new_result);
		request.setAttribute("test_result",test_new_result);
		
		RequestDispatcher disp = request.getRequestDispatcher("Final_Hello_Action.jsp");
		disp.forward(request, response);
		
	}

}
