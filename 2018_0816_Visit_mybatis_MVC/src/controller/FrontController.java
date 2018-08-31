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
		//��� Ȯ���ڰ� .do�� ȣ�⿡ ���Ͽ� �ش缭���� �����Ų��. 

public class FrontController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String uri = request.getRequestURI(); //�ش� ��û�� URI�ּҸ� �����´�.	
		int index = uri.lastIndexOf("/"); //���ʺ��� �˻� 
		String cmd = uri.substring(index+1).replaceAll(".do","");
		
		String forward_page ="";
	
		
		
		if(cmd.equals("visit_list")) { //��Ϻ���
			
			VisitListAction action = new VisitListAction();
			// FrontController�� ListAction���� ó������
			forward_page = action.execute(request, response);
	
		
		}else if(cmd.equals("insert_form")) {	//�Է�������
			
			VisitInsertFormAction action = new VisitInsertFormAction();
			
			forward_page = action.execute(request, response);
	
		}else if(cmd.equals("insert")) {	
			
			VisitInsertAction action = new VisitInsertAction();
			
			forward_page = action.execute(request, response);
			
		
		
		}else if(cmd.equals("delete")) {	//�Է��� ����
			
			VisiDeleteAction action = new VisiDeleteAction();
			
			forward_page = action.execute(request, response);
		
		}else if(cmd.equals("modify_form")) {	//�Է��� ����
			
			VisitmodifyFomAction action = new VisitmodifyFomAction();
			
			forward_page = action.execute(request, response);
		
		}
		
		else if(cmd.equals("modify")) {	//�Է��� ����
			
			VisitmodifyAction action = new VisitmodifyAction();
			
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
