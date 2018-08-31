package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id2.do")
public class MemberCheckIdAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        //   /member/check_id.do?id=hong
		//�������ڵ�����
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		//id�� �ش�Ǵ� MemberVo��ü ������
		MemberVo vo = MemberDao.getInstance().selectOne(id);
		
		String result="no";
		
		if(vo==null)//��밡���� id
			result="yes";
		
		//����� :JSON����  :  {"result":"yes"}
		String result_json = String.format("{\"result\":\"%s\"}", result);
				
		//�������
		response.getWriter().println(result_json);  // 
		
		
		
		

	}

}