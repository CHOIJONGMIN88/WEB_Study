package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungInsertAction
 */
@WebServlet("/sung/insert.do")
public class SungInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//0.���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//1.�Ķ���� ���� 
		String name = request.getParameter("name");
		String str_kor = request.getParameter("kor");
		String str_eng = request.getParameter("eng");
		String str_mat = request.getParameter("mat");
		
		//���ڿ� ����
		int kor = Integer.parseInt(str_kor);
		int eng = Integer.parseInt(str_eng);
		int mat = Integer.parseInt(str_mat);
		
		//SungVo���� 
		
		SungVo vo = new SungVo();
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMat(mat);
		
		
		//DB Insert 
		int res = SungTBDao.getInstance().insert(vo);
		
		System.out.println(res);
		//��Ϻ��� �̵� //���û �ؾ���
		response.sendRedirect("list.do");
		
		
	}

}
