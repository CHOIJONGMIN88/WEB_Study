package com.ic.param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myconst.MyConstant;
import vo.PersonVo;

@Controller
public class ParameterController {

	@RequestMapping("/test_form.do")
	public String test_form() {
		
		return  MyConstant.ParameterController.VIEW_PATH  +  "test_form.jsp";
	}
	
	@RequestMapping("/test_modify_form.do")
	public String test_modify_form() {
		//소스관리하기 편리하게 하기위해 상수로 지정한 뒤에 사용한다.
		return MyConstant.ParameterController.VIEW_PATH +"test_modify_form.jsp";
	}

	

	//@ResponseBody<---view를 통해서 출력하지 않고 곧바로 출력한다.
	
	
	//dispatcher servelet이 request 영역에 있는 parameter값을 name 변수에 넣어준다.
				 	// 디스패쳐서블릿이 name1=request.getParameter("name")란 작업을 한것과 같은 의미이다.
/*	public String insert(@RequestParam("name") String name1, 
		     			 @RequestParam("age") String age1,
		     		   	@RequestParam("tel") String tel1
		   					) {

return "";

}*/
	@RequestMapping("insert.do")
	@ResponseBody
	public String insert(String name, 
						     int age, 
						     String tel) {
		
			System.out.println(name);
			System.out.println(age);
			System.out.println(tel);
		
		
		return "Complete";
		
	}
	
	@RequestMapping("insert2.do")
	@ResponseBody
	//parameter 이름과 personVo의 속성명이 일치해야 받아 올 수 있다.
	public String insert2(PersonVo vo,HttpServletRequest request) {
		
		System.out.println(request.getRemoteAddr());
		
		System.out.println(vo.getAge());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		
		return "complete";
		
	}
	
	
	
}
