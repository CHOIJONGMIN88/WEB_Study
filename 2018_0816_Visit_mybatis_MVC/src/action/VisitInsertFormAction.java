package action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class VisitInsertFormAction {

	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response){
		
		
		//forward��ų ������
		 return "/visit/visit_insert_form.jsp";
		
	}
	
}

