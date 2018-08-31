package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/job_list.do")
public class SawonJobListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// sawon/job_list.do?sajob=����
		
		request.setCharacterEncoding("utf-8");
		
		String sajob = request.getParameter("sajob");
				
		
		//������ ������
		List<SawonVo> list = null;
		SawonDao dao = SawonDao.getInstance();
		
		if(sajob.equals("all")) {//��ü�����
			list = dao.selectList();
		}else {
			list = dao.selectList(sajob);
		}
		
		
		//System.out.println(list.size());
		
		//request binding
		request.setAttribute("list", list);
		
		
		//forward��ų ������
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}