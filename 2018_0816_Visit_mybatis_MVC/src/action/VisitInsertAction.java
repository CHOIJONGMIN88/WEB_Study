package action;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;



public class VisitInsertAction {


	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//1.�������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//2.parameter�ޱ� & IP�ޱ� 
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		
		//�ۼ��� IP 
	//	content=content.replaceAll("\n","<br>");
		
		String ip = request.getRemoteAddr(); //��û�� IP
		
		//3.VisitVo�� ����
		VisitVo vo = new VisitVo(name,content,pwd,ip);
		
		//4.DB Insert
		int res = VisitDao.getInstance().insert(vo);

		
		return "redirect:visit_list.do";
		
	}
	
}
