package action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAction {

	
public String execute(HttpServletRequest request,HttpServletResponse response,String para) {
		
		
		System.out.println("----insert�ߴٰ� ġ��....----");
	
	
	return "redirect:list.do";
		
	}
	
	
	
	
	
	
}
