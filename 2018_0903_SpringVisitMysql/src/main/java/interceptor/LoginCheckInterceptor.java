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
		System.out.println("요청URI : " + uri );
		
		//  uri = "/adult/not_login.do"
		if(uri.contains("not_login")) {//로그인이 필요없는 페이지
			return super.preHandle(request, response, handler);
		}
		
		
		//로그인 체크
		HttpSession session = request.getSession();
		
		//로그인정보 구하기
		Object user = session.getAttribute("user");
		if(user==null){
			//로그인이 안된상태
			String contextPath = request.getContextPath();
			String redirect_page = String.format("%s/%s?error=not_login", contextPath,"login_form.do");
			response.sendRedirect(redirect_page);
			
			return false;
		}
					
		
		//원래 요청 URL로 이동시키기
		return super.preHandle(request, response, handler);
	}
	
}
