package com.in.mvc;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//오토 디택팅을 위해 해당 태그를 달게 되면 자동으로 코드가 생성된다.
@Controller
public class TestController {

	public TestController(){
		
		System.out.println("스타트");
		
		
	}
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		
		String msg = "점심먹고 합시다";
		
		//dispatechrserverlet으로 전달한 뒤에 servlet이 request binding으로 등록한다.
		model.addAttribute("msg",msg);		
		
		return "/WEB-INF/views/test.jsp";

	}

	@RequestMapping("/test2.do")
	public ModelAndView test2() {
		
		ModelAndView mv = new ModelAndView();
		
		String msg = "ModelAndView방식으로 전달된 데이터";
		mv.addObject("msg",msg); //model<=data
		mv.setViewName("/WEB-INF/views/test2.jsp");

		
		return mv;
		
	}



}
