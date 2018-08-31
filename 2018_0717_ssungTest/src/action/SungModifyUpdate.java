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
 * Servlet implementation class SungModifyUpdate
 */
@WebServlet("/sung/modify.do")
public class SungModifyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("utf-8");
	//idx=44&name=%EB%82%91&kor=33&eng=31&mat=22
		
		SungVo vo= new SungVo();
		
		vo.setName(request.getParameter("name"));
		vo.setKor(Integer.parseInt(request.getParameter("kor")));
		vo.setEng(Integer.parseInt(request.getParameter("eng")));
		vo.setMat(Integer.parseInt(request.getParameter("mat")));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		
		int res = SungTBDao.getInstance().update(vo);
	
		response.sendRedirect("list.do");
	
	
	}

}
