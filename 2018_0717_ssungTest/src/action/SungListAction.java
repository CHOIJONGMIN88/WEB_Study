package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/list.do")
public class SungListAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//성적목록 가져오기 
		List<SungVo> list =SungTBDao.getInstance().selectList();
		
		System.out.println("여기까진 들어와버리기~");
		
		request.setAttribute("list",list);
		
		//forward시킬 페이지
		String forward_page ="sung/sung_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}

}
