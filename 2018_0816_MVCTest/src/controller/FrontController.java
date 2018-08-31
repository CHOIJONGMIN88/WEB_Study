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
		//��� Ȯ���ڰ� .do�� ȣ�⿡ ���Ͽ� �ش缭���� �����Ų��. 

public class FrontController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�پ��ϰ� ������ ȣ��� ���ִ�.
		//list.do
		//view.do
		//insert.do

		String uri = request.getRequestURI(); //�ش� ��û�� URI�ּҸ� �����´�.
		System.out.println(uri);
		
		//uri=http://localhost:9090/2018_0816_MVCTest/insert.do
		
	/*	if(uri.contains("list")) {
			
			 �ش����� �� �����ʴ´�.
			 �ڵ尡 ������� ��������
		}else if(uri.contains("view")) {
			
			
		}
		*/
		
		int index = uri.lastIndexOf("/"); //���ʺ��� �˻� 
		String cmd = uri.substring(index+1).replaceAll(".do","");
		
		String forward_page ="";
	
		if(cmd.equals("list")) { //��Ϻ���
			
			ListAction action = new ListAction();
			forward_page = action.execute(request, response);
			
		
		}else if(cmd.equals("view")) {	//�󼼺��� 
			
			String para =request.getParameter("book");
			
			
			ViewAction view_action = new ViewAction();
			
			forward_page = view_action.execute(request, response,para);
			
		
		}else if(cmd.equals("insert_form")) {	//�Է��� ����
		
			InsertFormAction action = new InsertFormAction();
			
			forward_page = action.execute(request, response);
			
		}else if(cmd.equals("insert")) {	//�Է��� ����

			InsertAction action =new InsertAction();
			
			forward_page = action.execute(request, response);
		}
			
		
		//forward_page�� ���Ë� list.jsp�� redirect:list.do �� ��û�ɶ��� �ִ�.
		//�� ��� ��Ȳ�� ���� �Ǵ��ؼ� �����Ѵ�.
		
	if(forward_page.startsWith("redirect:")) {
		
		
		forward_page = forward_page.replaceAll("redirect:","");
		//�����̷�Ʈ�� ������.
		response.sendRedirect(forward_page);
		
		
	}else {
		
		//forward��ų ������
		
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
			
	}
		
		// TODO Auto-generated method stub
	}
	
}
