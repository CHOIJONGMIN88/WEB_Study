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
 */			//hello.do=>��δ� WebContent�̴�.
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//hello.do?gubun=��ħ
		//hello.do?gobun=����
		//hello.do?gobun=����
	
		//�������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		String gubun = request.getParameter("gubun");
		
		if(gubun==null || gubun=="") {
			gubun = "��ħ";		
		}
			
		String message = "";
		String test_message = "�̰� �Ѿ�°� Ʈ��?";
		
		switch(gubun)
		{
		case "��ħ": message="�ȳ��� �ֹ��˽��ϱ�?"; break;
		case "����": message="���ɽĻ� �ϼ˽��ϱ�?"; break;
		case "����": message="good evening?"; break;

		}
		
		String result_message = String.format("[%s]�λ�:%s",gubun,message);
		//���� ����� ��°�ü(JSP)���� �����ؼ� ����ϰԲ� forward��Ų��.
		//Servlet�� JSP���� �����͸� �����ϱ� ���ؼ� Binding ��Ų��.
		request.setAttribute("result",result_message);
		request.setAttribute("test_result",test_message);
		
		//System.out.println(result_message);
		//System.out.println(test_message);
		
		RequestDispatcher disp = request.getRequestDispatcher("Next_HelloAction.do");
		disp.forward(request, response);
		
	
	}

}
