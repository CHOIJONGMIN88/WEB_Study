package com.ic.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.TestService;

@Controller
public class TestController {
	
	TestService service;
	TestService service2;
	// TestService를 참조하는 타입 변수 service에 TestServiceImpl(TestService를상속받음) 클래스를 생성해서
	//넣어줄수 있다. 그러므로 service.test() 곧 TestServiceImpl.class 내부의 test()가 실행된다.

	public TestService getService2() {
		return service2;
	}

	public void setService2(TestService service2) {
		this.service2 = service2;
	}

	public TestService getService() {
		return service;
	}

	public void setService(TestService service) {
		this.service = service;
	}
	
	@RequestMapping("test.do")
	@ResponseBody
	//retun값이 responsebody에 의해서 view를 거치지 않고 dispatcherServlet이 직접 아래내용에 대해 응답한다.
	public String test() {
		
		//TestService test() call
		service.test();
		
		service.test2();
	
		service2.test();
		service.test2();
		
		
		return "TestService's test() call";
		
	}
	
	

}
