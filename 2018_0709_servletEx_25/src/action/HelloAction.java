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
	protected void service(HttpServletRequest request,  //��û ó����ü
			HttpServletResponse response) 				//���� ó����ü
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String ip = request.getRemoteAddr(); //��û�� IP
		
		
		System.out.printf("[%s]:Ű�߾ƾƾƾƾƾƾ�\n",ip);
		response.setContentType("text/html; charset=utf-8;");//Ŭ���̾�Ʈ�� �������ִ� ������ ���� �� ���ڵ� ����
		response.getWriter().println("�ȳ��ϼ���");
		
		
	}

}
