package com.ic.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.TestService;

@Controller
public class TestController {
	
	TestService service;
	TestService service2;
	// TestService�� �����ϴ� Ÿ�� ���� service�� TestServiceImpl(TestService����ӹ���) Ŭ������ �����ؼ�
	//�־��ټ� �ִ�. �׷��Ƿ� service.test() �� TestServiceImpl.class ������ test()�� ����ȴ�.

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
	//retun���� responsebody�� ���ؼ� view�� ��ġ�� �ʰ� dispatcherServlet�� ���� �Ʒ����뿡 ���� �����Ѵ�.
	public String test() {
		
		//TestService test() call
		service.test();
		
		service.test2();
	
		service2.test();
		service.test2();
		
		
		return "TestService's test() call";
		
	}
	
	

}