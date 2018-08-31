package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jspsuv
 */
@WebServlet("/member_reg.do")
public class jspsuv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		//수신하기 전에 수신 인코딩 설정(전송방식이 POST일 경우)
		// 한글,특수문자,일본어,한자,
		request.setCharacterEncoding("utf-8");
		//전송시 인코딩, 전송과 수신시 용도가 다르다
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		String id   = request.getParameter("id");
		String pwd  = request.getParameter("pwd");
		
		//System.out.println(name);
		//취미 받기
		//member_reg.do?hobby=독서&hobby=영화&...
		String [] hobby_array = request.getParameterValues("hobby");
		//String [] hobby_array = {"독서","영화"};
		String hobby_str = "취미없음";
		//체크박스의 경우 체크표시가 등록된 값만 넘어온다.
		if(hobby_array!=null) {
			StringBuffer sb=new StringBuffer();
			for(String hobby : hobby_array) {
				sb.append(hobby);
				sb.append(" ");
			}
			hobby_str = sb.toString();
		}
		
		//System.out.println(hobby_str);
		//친구목록 //성별, 혈액형, 자기소개  받아서 웹에 출력
		//input 텍스트입력의 경우 입력값의 존재 유무와 관계없이 무조건 배열값이 넘어온다.
		String [] friend_array = request.getParameterValues("friend");
		String friend_str="";
				
				StringBuffer sb1 = new StringBuffer();
				for(String friend : friend_array) {
					
					sb1.append(friend);
					sb1.append("");
				}
				//친구가 없을경우
				//sb1 = "   ";
				friend_str = sb1.toString().trim();//공백을 제거한 상태로 받는다.
				//friend_str=""
				if(friend_str.isEmpty())
					friend_str="친구없음";
				
				System.out.println(friend_str);

				
				
			    //성별 단일값만 들어옴
				String sex_str  = request.getParameter("sex");
				
				System.out.println(sex_str);
				
				
				//혈액형
				String blood_str = request.getParameter("blood");
				System.out.println(blood_str);
				
				String profile_str  = request.getParameter("profile");
				System.out.println(profile_str);
	
				response.setContentType("text/html; charset=utf-8");//한글 인코딩
				
				
				response.getWriter().println("<html>");
				response.getWriter().println("<body>");
				response.getWriter().println("<table border='1' align='center' width='400'>");
				response.getWriter().println("<caption>입력된 항목</caption>");
				
				//1번째 줄
				response.getWriter().println("<tr><th>이름</th><td>");
				response.getWriter().println(name);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>아이디</th><td>");
				response.getWriter().println(id);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>비밀번호</th><td>");
				response.getWriter().println(pwd);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>성별</th><td>");
				response.getWriter().println(sex_str);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>취미</th><td>");
				response.getWriter().println(hobby_str);
				response.getWriter().println("</td></tr>");
				
				
				response.getWriter().println("<tr><th>자기소개</th><td>");
				response.getWriter().println(profile_str);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>혀랙형</th><td>");
				response.getWriter().println(blood_str);
				response.getWriter().println("</td></tr>");
				
				
				response.getWriter().println("</table>");
				response.getWriter().println("</body>");
				response.getWriter().println("</html>");
	
	
	
	
	}

			






}
