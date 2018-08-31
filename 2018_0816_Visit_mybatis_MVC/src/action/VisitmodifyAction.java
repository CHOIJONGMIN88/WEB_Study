package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;


public class VisitmodifyAction {
	
	
	
	public String execute(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr(); //¿äÃ»ÀÚ IP
		//String regdate=request.getParameter("regdate");
		
		
	//	content=content.replaceAll("\n","<br>");
		
		VisitVo vo = new VisitVo(idx,name,content,pwd,ip);
		
		//System.out.println(content);
		int res = VisitDao.getInstance().update(vo);
		
		
		return "redirect:visit_list.do";
		
	
	}
	
}
