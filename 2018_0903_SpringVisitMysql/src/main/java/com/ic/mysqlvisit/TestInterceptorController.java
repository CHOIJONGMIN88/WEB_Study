package com.ic.mysqlvisit;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestInterceptorController {

	@RequestMapping(value="/adult/list.do")
	@ResponseBody
	public String adult_list() {
		
		return "Adult Page";
	}
	
	@RequestMapping(value="/adult/view.do")
	@ResponseBody
	public String adult_view() {
		
		return "Adult Page";
	}
	
	@RequestMapping(value="/adult/not_login.do")
	@ResponseBody
	public String not_login() {
		
		return "Not Login Page";
	}
}
