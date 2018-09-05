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
	
	//�˻����� �����ȸ
	@RequestMapping("/visit/list.do")
	public String list(String search,String search_text,Model model) {
		
		// /visit/list.do?search=all&search_text=ȫ�浿
		
		VisitVo vo = new VisitVo();//�˻������� ���� vo
		if(search!=null && !search.equals("all")) {
			if(search.equals("name_content")) {//�̸�+����
				vo.setName(search_text);
				vo.setContent(search_text);
			}else if(search.equals("name")) {//�̸�
				vo.setName(search_text);
			}else if(search.equals("content")) {//����
				vo.setContent(search_text);
			}
		}
		
		//���� ��� ��������
		List<VisitVo> list = visit_dao.selectList(vo);
		
		//��������δ� request binding...
		// model���ؼ� �����͸� DispatcherServlet���� ����
		// => DispatcherServlet�� request�� binding
		model.addAttribute("list", list);
		
		
		return  MyConstant.VisitController.VIEW_PATH + "visit_list.jsp";
	}
	
	//�Է��� ����
	@RequestMapping("/visit/insert_form.do")
	public String insert_form() {
		
		return  MyConstant.VisitController.VIEW_PATH + "visit_insert_form.jsp";
	}
	
	//�۾���
	@RequestMapping("/visit/insert.do")
	public String insert(VisitVo vo,HttpServletRequest request) {
		
		//2.parameter�ޱ� & IP�ޱ� => insert(VisitVo vo)ó��
		/*String name 	= request.getParameter("name");
		String content 	= request.getParameter("content");
		String pwd 		= request.getParameter("pwd");*/
		
		// \n -> <br>
		String content = vo.getContent();
		content = content.replaceAll("\n", "<br>");
		vo.setContent(content);
		
		
		//�ۼ��� IP
		String ip 		= request.getRemoteAddr(); //��û�� IP
		vo.setIp(ip);
		
		//4.DB Insert
		 int res = visit_dao.insert(vo);
		
		
		//���� ��Ϻ���� �̵�
		//response.sendRedirect("list.do");
				
		return "redirect:list.do";// DispatcherServlet���� �����ϸ�
		                          // response.sendRedirect("list.do");
	}
	
	//��й�ȣ üũ
	@RequestMapping("/visit/check_pwd.do")
	@ResponseBody
	public String check_pwd(int idx,String c_pwd) {
		
	    //  /visit/check_pwd.do?idx=33&c_pwd=1234@
        
		//idx�� �ش�Ǵ� �Խù� ���� ���
		VisitVo vo  = visit_dao.selectOne(idx);
		
		// �����ġ: yes ����ġ: no
		String result = "yes";
		
		//��й�ȣ üũ
		if(vo.getPwd().equals(c_pwd)==false)
			result = "no";
		
		//��û�� Ajax���� ��� ����
		//response.getWriter().println(result);
		
		
		return result; // @ResponseBody : ���� ��ȯ�Ǵ� ���� �ٷ� ������Ѷ�
	}
	
	
	@RequestMapping("/visit/test.do")
	public String test(Model model) {
		
		//Model �뵵? :
		// 1.DispatcherServlet���� data�� �ѱ�� �뵵
		// 2.Ȱ��
		//    1) forward  : request binding
		//    2) redirect : parameter�� ���
		
		model.addAttribute("page", 5);
		model.addAttribute("search", "name");
		model.addAttribute("search_text", "�浿");
				
		
		return "redirect:list.do"; // list.do?page=5&search=name&search_text=�浿
	}
	
	
	
	//������ ����
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(int idx,Model model) {
		
		VisitVo vo = visit_dao.selectOne(idx);
		
		model.addAttribute("vo", vo);
		
		return  MyConstant.VisitController.VIEW_PATH + "visit_modify_form.jsp";
	}
	
	//�����ϱ�
	@RequestMapping("/visit/modify.do")
	public String modify_form(VisitVo vo,HttpServletRequest request) {
		
		
        vo.setContent(vo.getContent().replaceAll("\n", "<br>"));
		
		//�ۼ��� IP
		String ip 		= request.getRemoteAddr(); //��û�� IP
		vo.setIp(ip);
		
		//4.DB update
		int res = visit_dao.update(vo);
		
		return "redirect:list.do";
		
	}
	
	//�����ϱ�
	@RequestMapping("/visit/delete.do")
	public String delete(int idx) {
		
		int res = visit_dao.delete(idx);
		
		return "redirect:list.do";
	}
	
	
	
	
}
