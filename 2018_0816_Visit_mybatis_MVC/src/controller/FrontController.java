package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.VisiDeleteAction;
import action.VisitInsertAction;
import action.VisitInsertFormAction;
import action.VisitListAction;
import action.VisitmodifyAction;
import action.VisitmodifyFomAction;





@WebServlet("*.do")
		//모든 확장자가 .do은 호출에 대하여 해당서블릿을 통과시킨다. 

public class FrontController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String uri = request.getRequestURI(); //해당 요청된 URI주소를 가져온다.	
		int index = uri.lastIndexOf("/"); //뒷쪽부터 검색 
		String cmd = uri.substring(index+1).replaceAll(".do","");
		
		String forward_page ="";
	
		
		
		if(cmd.equals("visit_list")) { //목록보기
			
			VisitListAction action = new VisitListAction();
			// FrontController가 ListAction에게 처리지시
			forward_page = action.execute(request, response);
	
		
		}else if(cmd.equals("insert_form")) {	//입력폼띄우기
			
			VisitInsertFormAction action = new VisitInsertFormAction();
			
			forward_page = action.execute(request, response);
	
		}else if(cmd.equals("insert")) {	
			
			VisitInsertAction action = new VisitInsertAction();
			
			forward_page = action.execute(request, response);
			
		
		
		}else if(cmd.equals("delete")) {	//입력폼 띄우기
			
			VisiDeleteAction action = new VisiDeleteAction();
			
			forward_page = action.execute(request, response);
		
		}else if(cmd.equals("modify_form")) {	//입력폼 띄우기
			
			VisitmodifyFomAction action = new VisitmodifyFomAction();
			
			forward_page = action.execute(request, response);
		
		}
		
		else if(cmd.equals("modify")) {	//입력폼 띄우기
			
			VisitmodifyAction action = new VisitmodifyAction();
			
			forward_page = action.execute(request, response);
		
		}
			
		
		
		
		
		
		
		//forward_page가 들어올떄 list.jsp와 redirect:list.do 로 요청될때가 있다.
		//이 경우 상황에 따라서 판단해서 전송한다.
		
	if(forward_page.startsWith("redirect:")) {
		
		
		forward_page = forward_page.replaceAll("redirect:","");
		//리다이렉트로 보낸다.
		response.sendRedirect(forward_page);
		
		
	}else {
		
		//forward시킬 페이지
		
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
			
	}
		
		// TODO Auto-generated method stub
	}
	
}
