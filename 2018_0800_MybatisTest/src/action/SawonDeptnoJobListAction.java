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
		//  deptno_job_list.do?deptno=10&sajob=과장
		
		request.setCharacterEncoding("utf-8");
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String sajob = request.getParameter("sajob");
		
		List<SawonVo> list = null;
		SawonDao dao = SawonDao.getInstance();
		if(deptno==0 && sajob.equals("all")) {//전체보기
			list = dao.selectList();
		}else if(deptno==0) {
			list = dao.selectList(sajob);
		}else if(sajob.equals("all")) {
			list = dao.selectList(deptno);
		}else {
			//2가지 검색조건이 존재하면
			//방법1)SawonVo를 이용한
			/*SawonVo vo = new SawonVo();
			vo.setDeptno(deptno);
			vo.setSajob(sajob);
			list = dao.selectList(vo);*/
			
			//방법2)Map을 이용한
			Map  map = new HashMap();
			map.put("no", deptno);
			map.put("job", sajob);
			list =  dao.selectList(map);
			
			
		}
		
		//검색결과 request binding
		request.setAttribute("list", list);
		

		//forward시킬 페이지
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}