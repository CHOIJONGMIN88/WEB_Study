package action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import vo.DeptVo;

/**
 * Servlet implementation class DeptListAction
 */
@WebServlet("/DeptListAction")
public class DeptListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//부서목록 요청
		List<DeptVo> dept_list = DeptDao.getInstance().selectList();
		 
		//2.request binding
		request.setAttribute("dept_list",dept_list);
		
		//3.forward
		request.getRequestDispatcher("dept_list2").forward(request,response);
	}

}
