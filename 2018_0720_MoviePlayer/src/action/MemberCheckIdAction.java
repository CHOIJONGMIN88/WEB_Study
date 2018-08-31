package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        //   /member/check_id.do?id=hong
		//수신인코딩설정
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		//id에 해당되는 MemberVo객체 얻어오기
		MemberVo vo = MemberDao.getInstance().selectOne(id);
		
		String result="no";
		
		if(vo==null)//사용가능한 id
			result="yes";
		
		//결과값 :JSON포장  :  [{'result':'yes'}]
		String result_json = String.format("[{'result':'%s'}]", result);
				
		//결과전송
		response.getWriter().println(result_json);  // 
		
		
		
		

	}

}