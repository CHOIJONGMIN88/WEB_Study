package com.ic.mysqlvisit;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDao;
import myconst.MyConstant;
import vo.VisitVo;

@Controller
public class VisitController {

	VisitDao visit_dao;

	public VisitDao getVisit_dao() {
		return visit_dao;
	}

	public void setVisit_dao(VisitDao visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	//검색포함 목록조회
	@RequestMapping("/visit/list.do")
	public String list(String search,String search_text,Model model) {
		
		// /visit/list.do?search=all&search_text=홍길동
		
		VisitVo vo = new VisitVo();//검색조건을 담을 vo
		if(search!=null && !search.equals("all")) {
			if(search.equals("name_content")) {//이름+내용
				vo.setName(search_text);
				vo.setContent(search_text);
			}else if(search.equals("name")) {//이름
				vo.setName(search_text);
			}else if(search.equals("content")) {//내용
				vo.setContent(search_text);
			}
		}
		
		//방명록 목록 가져오기
		List<VisitVo> list = visit_dao.selectList(vo);
		
		//결과적으로는 request binding...
		// model통해서 데이터를 DispatcherServlet에게 전달
		// => DispatcherServlet이 request로 binding
		model.addAttribute("list", list);
		
		
		return  MyConstant.VisitController.VIEW_PATH + "visit_list.jsp";
	}
	
	//입력폼 띄우기
	@RequestMapping("/visit/insert_form.do")
	public String insert_form() {
		
		return  MyConstant.VisitController.VIEW_PATH + "visit_insert_form.jsp";
	}
	
	//글쓰기
	@RequestMapping("/visit/insert.do")
	public String insert(VisitVo vo,HttpServletRequest request) {
		
		//2.parameter받기 & IP받기 => insert(VisitVo vo)처리
		/*String name 	= request.getParameter("name");
		String content 	= request.getParameter("content");
		String pwd 		= request.getParameter("pwd");*/
		
		// \n -> <br>
		String content = vo.getContent();
		content = content.replaceAll("\n", "<br>");
		vo.setContent(content);
		
		
		//작성자 IP
		String ip 		= request.getRemoteAddr(); //요청자 IP
		vo.setIp(ip);
		
		//4.DB Insert
		 int res = visit_dao.insert(vo);
		
		
		//방명록 목록보기로 이동
		//response.sendRedirect("list.do");
				
		return "redirect:list.do";// DispatcherServlet에게 전달하면
		                          // response.sendRedirect("list.do");
	}
	
	//비밀번호 체크
	@RequestMapping("/visit/check_pwd.do")
	@ResponseBody
	public String check_pwd(int idx,String c_pwd) {
		
	    //  /visit/check_pwd.do?idx=33&c_pwd=1234@
        
		//idx에 해당되는 게시물 정보 얻기
		VisitVo vo  = visit_dao.selectOne(idx);
		
		// 비번일치: yes 불일치: no
		String result = "yes";
		
		//비밀번호 체크
		if(vo.getPwd().equals(c_pwd)==false)
			result = "no";
		
		//요청한 Ajax에게 결과 전송
		//response.getWriter().println(result);
		
		
		return result; // @ResponseBody : 현재 반환되는 값을 바로 응답시켜라
	}
	
	
	@RequestMapping("/visit/test.do")
	public String test(Model model) {
		
		//Model 용도? :
		// 1.DispatcherServlet에게 data를 넘기는 용도
		// 2.활용
		//    1) forward  : request binding
		//    2) redirect : parameter로 사용
		
		model.addAttribute("page", 5);
		model.addAttribute("search", "name");
		model.addAttribute("search_text", "길동");
				
		
		return "redirect:list.do"; // list.do?page=5&search=name&search_text=길동
	}
	
	
	
	//수정폼 띄우기
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(int idx,Model model) {
		
		VisitVo vo = visit_dao.selectOne(idx);
		
		model.addAttribute("vo", vo);
		
		return  MyConstant.VisitController.VIEW_PATH + "visit_modify_form.jsp";
	}
	
	//수정하기
	@RequestMapping("/visit/modify.do")
	public String modify_form(VisitVo vo,HttpServletRequest request) {
		
		
        vo.setContent(vo.getContent().replaceAll("\n", "<br>"));
		
		//작성자 IP
		String ip 		= request.getRemoteAddr(); //요청자 IP
		vo.setIp(ip);
		
		//4.DB update
		int res = visit_dao.update(vo);
		
		return "redirect:list.do";
		
	}
	
	//삭제하기
	@RequestMapping("/visit/delete.do")
	public String delete(int idx) {
		
		int res = visit_dao.delete(idx);
		
		return "redirect:list.do";
	}
	
	
	
	
}
