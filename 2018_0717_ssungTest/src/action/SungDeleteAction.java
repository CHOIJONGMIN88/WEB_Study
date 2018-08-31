package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/sung/delete.do")
public class SungDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
	
		String str_idx = request.getParameter("idx");
		
		int str = Integer.parseInt(str_idx);
		
		
		
		int res = SungTBDao.getInstance().delete(str);
		
		response.sendRedirect("list.do");
		
		
	//	System.out.println(str_idx);
		
	
	
	
	}

}
