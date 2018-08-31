package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonDeptnoJobListAction
 */
@WebServlet("/sawon/deptno_job_list.do")
public class SawonDeptnoJobListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//  deptno_job_list.do?deptno=10&sajob=����
		
		request.setCharacterEncoding("utf-8");
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String sajob = request.getParameter("sajob");
		
		List<SawonVo> list = null;
		SawonDao dao = SawonDao.getInstance();
		if(deptno==0 && sajob.equals("all")) {//��ü����
			list = dao.selectList();
		}else if(deptno==0) {
			list = dao.selectList(sajob);
		}else if(sajob.equals("all")) {
			list = dao.selectList(deptno);
		}else {
			//2���� �˻������� �����ϸ�
			//���1)SawonVo�� �̿���
			/*SawonVo vo = new SawonVo();
			vo.setDeptno(deptno);
			vo.setSajob(sajob);
			list = dao.selectList(vo);*/
			
			//���2)Map�� �̿���
			Map  map = new HashMap();
			map.put("no", deptno);
			map.put("job", sajob);
			list =  dao.selectList(map);
			
			
		}
		
		//�˻���� request binding
		request.setAttribute("list", list);
		

		//forward��ų ������
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}