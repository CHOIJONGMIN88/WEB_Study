package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;


@WebServlet("/visit/check_pwd.do")
public class VisidCheckPwdAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// TODO Auto-generated method stub
		// /visit/check_pwd.do?idx=33&c_pwd=1234
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		//idx�� �ش�Ǵ� �Խù� ���� ��� 
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		String result ="yes";//
		
		//��й�ȣ üũ
		//System.out.println(vo.getPwd());
		System.out.println(c_pwd);
		
		if(vo.getPwd().equals(c_pwd)==false)result = "no";
		
		
		//��û�� Ajax���� ��� ���� 
		//ȣ���� jsp�� �ִ� ��ġ�� ���� ��ȯ�Ѵ�.
		response.getWriter().print(result);

		
	}
	
}