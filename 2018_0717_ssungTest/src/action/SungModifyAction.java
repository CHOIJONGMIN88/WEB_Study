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
 * Servlet implementation class SungModifyAction
 */
@WebServlet("/sung/modify_form.do")
public class SungModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//sung/modify_form.do?idx=12
		
		int idx= Integer.parseInt(request.getParameter("idx"));
		
		//해당 idx에 해당되는 SungVo 구한다.
		SungVo vo = SungTBDao.getInstance().selectOne(idx);
		
		request.setAttribute("vo",vo);
		
		request.getRequestDispatcher("sung_modify_form.jsp").forward(request, response);
		
	
	
	}

}
