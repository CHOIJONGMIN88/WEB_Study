package action_board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import vo.BoardVo;


@WebServlet("/board/insert.do")
public class BoardInsertAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int res=0;
		BoardVo vo=new BoardVo();
		
		HttpSession session = request.getSession();
	    session.getAttribute("user");
	    
	    String id=request.getParameter("id");
	    String name=request.getParameter("name");
	    String content=request.getParameter("content");
	    String subject=request.getParameter("subject");
	    String pwd=request.getParameter("pwd");
	    String ip=request.getRemoteAddr();
	    
		vo.setId(id);
		vo.setName(name);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setSubject(subject);
		vo.setIp(ip);
		
		
	//System.out.println(ip);
		
	
		
		
		res=BoardDao.getInstance().Insert(vo);
		
		
	    
	    
	    
		//forward시킬 페이지
		String forward_page ="list.do";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
