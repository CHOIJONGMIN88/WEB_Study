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



public class VisitmodifyFomAction  {
	
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		int idx= Integer.parseInt(request.getParameter("idx"));
		
	
		
		VisitVo vo = VisitDao.getInstance().selectOne(idx);

	
		String cont = vo.getContent().replaceAll("<br>","\n");
		vo.setContent(cont);
		
		request.setAttribute("vo", vo);
		
		//forward시킬 페이지
		
		
		return "visit_modify_form.jsp";
		
	}
	
}
