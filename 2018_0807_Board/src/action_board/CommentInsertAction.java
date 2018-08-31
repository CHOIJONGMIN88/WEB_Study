package action_board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import vo.CommentVo;

/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/board/comment_insert.do")
public class CommentInsertAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int b_idx=Integer.parseInt(request.getParameter("b_idx"));
		String id= request.getParameter("id");
		String name = request.getParameter("name");
		String content =request.getParameter("content");
		
		String ip = request.getRemoteAddr();
		
		
		//포장 
		CommentVo vo = new CommentVo(id,name,content,ip,b_idx);
		
		
		int res =CommentDao.getInstance().insert(vo);
		
		
		String result="success";
		
		if(res==0)result="fail";
									//자바는 " 를 문자로 인식하지 않으므로 앞에\를 붙여준다.
		String result_json=String.format("{\"result\":\"%s\"}",result);
		response.setContentType("text/html; charset=utf-8;");
		response.getWriter().println(result_json);
		
		
	
		
		
		
		// TODO Auto-generated method stub
	}
	
}
