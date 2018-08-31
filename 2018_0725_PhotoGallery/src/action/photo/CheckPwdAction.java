package action.photo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;



@WebServlet("/photo/pwd.do")
public class CheckPwdAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		
		 
		PhotoVo vo = PhotoDao.getInstance().selectOne(idx);
		
	
		String result ="yes";
		
		System.out.println(vo.getPwd());
		System.out.println(c_pwd);
		
		if(vo.getPwd().equals(c_pwd)==false)result = "no";
		
		
		//호출한 jsp가 있는 위치에 값을 반환한다.
		response.getWriter().print(result);
		
		
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
