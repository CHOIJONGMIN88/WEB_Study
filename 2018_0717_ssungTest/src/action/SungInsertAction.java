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
		
		//0.수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.파라메터 수신 
		String name = request.getParameter("name");
		String str_kor = request.getParameter("kor");
		String str_eng = request.getParameter("eng");
		String str_mat = request.getParameter("mat");
		
		//문자열 정수
		int kor = Integer.parseInt(str_kor);
		int eng = Integer.parseInt(str_eng);
		int mat = Integer.parseInt(str_mat);
		
		//SungVo포장 
		
		SungVo vo = new SungVo();
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMat(mat);
		
		
		//DB Insert 
		int res = SungTBDao.getInstance().insert(vo);
		
		System.out.println(res);
		//목록보기 이동 //재요청 해야함
		response.sendRedirect("list.do");
		
		
	}

}
