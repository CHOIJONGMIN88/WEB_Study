package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction {
	
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("JSP");
		list.add("Oracle");
		list.add("Spring");
		
		//FrontController�� ������ �� �ִ� ������ �����͸� binding
		request.setAttribute("list", list);
		
		
		return "list.jsp";
		
	}

}
