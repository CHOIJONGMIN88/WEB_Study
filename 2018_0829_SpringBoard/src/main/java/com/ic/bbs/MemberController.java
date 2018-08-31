package com.ic.bbs;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;
import myconst.MyConstant;
import vo.MemberVo;

@Controller
public class MemberController {

	MemberDao member_dao;
	@Autowired
	HttpSession session;
	
	public MemberDao getMember_dao() {
		return member_dao;
	}

	public void setMember_dao(MemberDao member_dao) {
		this.member_dao = member_dao;
	}
	
	@RequestMapping("/member/login_form.do")
	public String login_form() {
		
		
		return MyConstant.MemberController.VIEW_PATH + "member_login_form.jsp";
	}
	
	@RequestMapping("/member/login.do")
	public String login(String id,String pwd,String url,Model model) {
		
		
	    MemberVo user = member_dao.selectOne(id);

		if(user==null) {//id�� Ʋ�����
			// Session Tracking : GET���(Query String)�� �̿�
			model.addAttribute("reason","fail_id");
			return "redirect:login_form.do";
		}
		
		//��й�ȣ üũ
		if(user.getPwd().equals(pwd)==false) { //��й�ȣ�� Ʋ�����
			// Session Tracking : GET���(Query String)�� �̿�
		
			model.addAttribute("reason","fail_pwd");
			return "redirect:login_form.do";
		}
		
		//����α��� �Ǿ������ ó��....
		//�α��� �� ȸ�������� ���ǿ� ����
		// ��Scope : pageContext,request,session,application
		//           ���尡���� ������ =>�ڹ��� ��簴ü
		
		session.setAttribute("user", user);
		
	
		//������ ���� �����⶧���� null�� �ƴϰų� url�� ������ üũ�ϴ� ������ �߰����ش�.
		if(url!=null && !url.isEmpty()) {
			//response.sendRedirect(url);
			return "redirect:" + url;
		}else {
		
		//response.sendRedirect("../board/list.do");
		return "redirect:../board/list.do";
		}
		
		
		//return "";
	}
	
	
	
	
	
	
	
}