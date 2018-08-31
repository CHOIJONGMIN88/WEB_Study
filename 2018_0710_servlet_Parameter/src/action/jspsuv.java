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
	
	
		//�����ϱ� ���� ���� ���ڵ� ����(���۹���� POST�� ���)
		// �ѱ�,Ư������,�Ϻ���,����,
		request.setCharacterEncoding("utf-8");
		//���۽� ���ڵ�, ���۰� ���Ž� �뵵�� �ٸ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		String id   = request.getParameter("id");
		String pwd  = request.getParameter("pwd");
		
		//System.out.println(name);
		//��� �ޱ�
		//member_reg.do?hobby=����&hobby=��ȭ&...
		String [] hobby_array = request.getParameterValues("hobby");
		//String [] hobby_array = {"����","��ȭ"};
		String hobby_str = "��̾���";
		//üũ�ڽ��� ��� üũǥ�ð� ��ϵ� ���� �Ѿ�´�.
		if(hobby_array!=null) {
			StringBuffer sb=new StringBuffer();
			for(String hobby : hobby_array) {
				sb.append(hobby);
				sb.append(" ");
			}
			hobby_str = sb.toString();
		}
		
		//System.out.println(hobby_str);
		//ģ����� //����, ������, �ڱ�Ұ�  �޾Ƽ� ���� ���
		//input �ؽ�Ʈ�Է��� ��� �Է°��� ���� ������ ������� ������ �迭���� �Ѿ�´�.
		String [] friend_array = request.getParameterValues("friend");
		String friend_str="";
				
				StringBuffer sb1 = new StringBuffer();
				for(String friend : friend_array) {
					
					sb1.append(friend);
					sb1.append("");
				}
				//ģ���� �������
				//sb1 = "   ";
				friend_str = sb1.toString().trim();//������ ������ ���·� �޴´�.
				//friend_str=""
				if(friend_str.isEmpty())
					friend_str="ģ������";
				
				System.out.println(friend_str);

				
				
			    //���� ���ϰ��� ����
				String sex_str  = request.getParameter("sex");
				
				System.out.println(sex_str);
				
				
				//������
				String blood_str = request.getParameter("blood");
				System.out.println(blood_str);
				
				String profile_str  = request.getParameter("profile");
				System.out.println(profile_str);
	
				response.setContentType("text/html; charset=utf-8");//�ѱ� ���ڵ�
				
				
				response.getWriter().println("<html>");
				response.getWriter().println("<body>");
				response.getWriter().println("<table border='1' align='center' width='400'>");
				response.getWriter().println("<caption>�Էµ� �׸�</caption>");
				
				//1��° ��
				response.getWriter().println("<tr><th>�̸�</th><td>");
				response.getWriter().println(name);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>���̵�</th><td>");
				response.getWriter().println(id);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>��й�ȣ</th><td>");
				response.getWriter().println(pwd);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>����</th><td>");
				response.getWriter().println(sex_str);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>���</th><td>");
				response.getWriter().println(hobby_str);
				response.getWriter().println("</td></tr>");
				
				
				response.getWriter().println("<tr><th>�ڱ�Ұ�</th><td>");
				response.getWriter().println(profile_str);
				response.getWriter().println("</td></tr>");
				
				response.getWriter().println("<tr><th>������</th><td>");
				response.getWriter().println(blood_str);
				response.getWriter().println("</td></tr>");
				
				
				response.getWriter().println("</table>");
				response.getWriter().println("</body>");
				response.getWriter().println("</html>");
	
	
	
	
	}

			






}
