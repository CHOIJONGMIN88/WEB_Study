package com.ic.autowire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TestService;

@Controller
public class TestController {
	
	@Autowired
	TestService test_service;
	
	public TestController() {
		
		System.out.println("--TestController()--");
	}
	
	@RequestMapping("/list.do")
	public String list(Model model ) {
		
		List list=test_service.selectlist();
		
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/dept_list.jsp";
		
	}
	
	
}
