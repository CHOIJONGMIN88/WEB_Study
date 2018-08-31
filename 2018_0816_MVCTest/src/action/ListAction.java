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
		
		//FrontController와 공유할 수 있는 공간에 데이터를 binding
		request.setAttribute("list", list);
		
		
		return "list.jsp";
		
	}

}
