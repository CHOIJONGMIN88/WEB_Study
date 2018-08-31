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


public class VisiDeleteAction  {

	
	/**
	 * @throws IOException 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		//삭제할 idx값 수신
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int res = VisitDao.getInstance().delete(idx);
		
		
		
		return "visit_list.jsp";
		
		
		
	}
	
}
