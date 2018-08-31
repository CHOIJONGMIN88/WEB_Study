package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckidAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//forward��ų ������
		//member/check_id.do?id=hong
		//�������ڵ� ����
		request.setCharacterEncoding("utf-8");

		String id= request.getParameter("id");
		
		//id�� �ش�Ǵ� MemberVo��ü ������
		MemberVo vo = MemberDao.getInstance().selectOne(id);
		
		//String result="nonono";
		String result1="no";
		
		if(vo==null)//��밡���� id(�ߺ��� ���� �ʴ´ٴ¶��̴�)
			result1="yes";
		
		//����� :JSON����
		//JAVA��ũ��Ʈ�󿡼� �Ѿ�� ���������� �Ѿ�� �ʴ°�찡 ���� JSON �迭�� ��� �����Ѵ�.
		//String result_json = String.format("[{'result':'%s'}]",result);
		String result_json1 = String.format("[{'result1':'%s'}]",result1);
		//System.out.println(result_json);
		//�������
		
		//response.setContentType("text/json;charset=utf-8;");
		//response.getWriter().print(result_json);
		response.getWriter().print(result_json1);
		
	
		
	}
	
}
