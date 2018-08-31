package action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAction {

	
public String execute(HttpServletRequest request,HttpServletResponse response,String para) {
		
		
		System.out.println("----insert했다고 치자....----");
	
	
	return "redirect:list.do";
		
	}
	
	
	
	
	
	
}
