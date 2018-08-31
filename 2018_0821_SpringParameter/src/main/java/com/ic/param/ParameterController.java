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
		//�ҽ������ϱ� ���ϰ� �ϱ����� ����� ������ �ڿ� ����Ѵ�.
		return MyConstant.ParameterController.VIEW_PATH +"test_modify_form.jsp";
	}

	

	//@ResponseBody<---view�� ���ؼ� ������� �ʰ� ��ٷ� ����Ѵ�.
	
	
	//dispatcher servelet�� request ������ �ִ� parameter���� name ������ �־��ش�.
				 	// �����ļ����� name1=request.getParameter("name")�� �۾��� �ѰͰ� ���� �ǹ��̴�.
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
	//parameter �̸��� personVo�� �Ӽ����� ��ġ�ؾ� �޾� �� �� �ִ�.
	public String insert2(PersonVo vo,HttpServletRequest request) {
		
		System.out.println(request.getRemoteAddr());
		
		System.out.println(vo.getAge());
		System.out.println(vo.getName());
		System.out.println(vo.getTel());
		
		return "complete";
		
	}
	
	
	
}
