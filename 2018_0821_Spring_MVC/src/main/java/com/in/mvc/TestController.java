package com.in.mvc;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//���� �������� ���� �ش� �±׸� �ް� �Ǹ� �ڵ����� �ڵ尡 �����ȴ�.
@Controller
public class TestController {

	public TestController(){
		
		System.out.println("��ŸƮ");
		
		
	}
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		
		String msg = "���ɸ԰� �սô�";
		
		//dispatechrserverlet���� ������ �ڿ� servlet�� request binding���� ����Ѵ�.
		model.addAttribute("msg",msg);		
		
		return "/WEB-INF/views/test.jsp";

	}

	@RequestMapping("/test2.do")
	public ModelAndView test2() {
		
		ModelAndView mv = new ModelAndView();
		
		String msg = "ModelAndView������� ���޵� ������";
		mv.addObject("msg",msg); //model<=data
		mv.setViewName("/WEB-INF/views/test2.jsp");

		
		return mv;
		
	}



}
