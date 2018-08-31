package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.InsertAction;
import action.InsertFormAction;
import action.ListAction;
import action.ViewAction;


@WebServlet("*.do")
		//모든 확장자가 .do은 호출에 대하여 해당서블릿을 통과시킨다. 

public class FrontController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//다양하게 서블릿이 호출될 수있다.
		//list.do
		//view.do
		//insert.do

		String uri = request.getRequestURI(); //해당 요청된 URI주소를 가져온다.
		System.out.println(uri);
		
		//uri=http://localhost:9090/2018_0816_MVCTest/insert.do
		
	/*	if(uri.contains("list")) {
			
			 해당방식은 잘 쓰지않는다.
			 코드가 길어지고 지저분함
		}else if(uri.contains("view")) {
			
			
		}
		*/
		
		int index = uri.lastIndexOf("/"); //뒷쪽부터 검색 
		String cmd = uri.substring(index+1).replaceAll(".do","");
		
		String forward_page ="";
	
		if(cmd.equals("list")) { //목록보기
			
			ListAction action = new ListAction();
			forward_page = action.execute(request, response);
			
		
		}else if(cmd.equals("view")) {	//상세보기 
			
			String para =request.getParameter("book");
			
			
			ViewAction view_action = new ViewAction();
			
			forward_page = view_action.execute(request, response,para);
			
		
		}else if(cmd.equals("insert_form")) {	//입력폼 띄우기
		
			InsertFormAction action = new InsertFormAction();
			
			forward_page = action.execute(request, response);
			
		}else if(cmd.equals("insert")) {	//입력폼 띄우기

			InsertAction action =new InsertAction();
			
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
