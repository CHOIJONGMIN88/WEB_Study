package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter
{

	@Override
	public boolean preHandle(
			HttpServletRequest  request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		String uri = request.getRequestURI();
		System.out.println("��ûURI : " + uri );
		
		//  uri = "/adult/not_login.do"
		if(uri.contains("not_login")) {//�α����� �ʿ���� ������
			return super.preHandle(request, response, handler);
		}
		
		
		//�α��� üũ
		HttpSession session = request.getSession();
		
		//�α������� ���ϱ�
		Object user = session.getAttribute("user");
		if(user==null){
			//�α����� �ȵȻ���
			String contextPath = request.getContextPath();
			String redirect_page = String.format("%s/%s?error=not_login", contextPath,"login_form.do");
			response.sendRedirect(redirect_page);
			
			return false;
		}
					
		
		//���� ��û URL�� �̵���Ű��
		return super.preHandle(request, response, handler);
	}
	
}
