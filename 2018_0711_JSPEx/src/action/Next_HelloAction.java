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
		request.setCharacterEncoding("utf-8");	//�������ڵ� ����
	   //HellowAction���� request�� ���� �Ѿ�� result���� �ٽ� �ҷ��´�.
	//	String result =(String)request.getAttribute("result");	//
	//	String test_result =(String)request.getAttribute("test_result");
		
		
		//System.out.println(result);
	//	System.out.println(test_result);	
		
		String new_result="������ HelloAction�� ���ο� ������ ����ȴ�.";
		String test_new_result="������ HelloAction�� ���ο� ������ ����ȴ�.�׽�Ʈ";
		
	//	result="�ѹ������ְ�";
	//	test_result="�ٽ��ѹ� �����ְ� ������Ʈ";	
		
		//request.setAttribute("final_result",result);
	//	request.setAttribute("final_test_result",test_result);
		
		request.setAttribute("result",new_result);
		request.setAttribute("test_result",test_new_result);
		
		RequestDispatcher disp = request.getRequestDispatcher("Final_Hello_Action.jsp");
		disp.forward(request, response);
		
	}

}
