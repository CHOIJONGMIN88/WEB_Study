package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Sawon_dao;
import vo.Sawon_vo;

/**
 * Servlet implementation class sawon_action
 */
@WebServlet("/sawon_action")
public class sawon_action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	List<Sawon_vo> sawon_list=Sawon_dao.getInstance().selectList();	
	
	request.setAttribute("sawon_list", sawon_list);
	request.getRequestDispatcher("dept_list3").forward(request, response);
	
	
	}

}
