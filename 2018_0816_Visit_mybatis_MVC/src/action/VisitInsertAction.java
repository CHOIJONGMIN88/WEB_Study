package action;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;



public class VisitInsertAction {


	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter받기 & IP받기 
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		
		//작성자 IP 
	//	content=content.replaceAll("\n","<br>");
		
		String ip = request.getRemoteAddr(); //요청자 IP
		
		//3.VisitVo로 포장
		VisitVo vo = new VisitVo(name,content,pwd,ip);
		
		//4.DB Insert
		int res = VisitDao.getInstance().insert(vo);

		
		return "redirect:visit_list.do";
		
	}
	
}
