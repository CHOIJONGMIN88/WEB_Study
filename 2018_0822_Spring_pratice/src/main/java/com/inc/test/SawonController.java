package com.inc.test;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.SawonDao;
import myconst.MyConstant;
import vo.SawonVo;;

@Controller
public class SawonController {

		SawonDao sawon_dao;
				
		public SawonController() {
			// TODO Auto-generated constructor stub
		}

		public SawonController(SawonDao sawon_dao) {
			super();
			this.sawon_dao = sawon_dao;
			
		}
	
	
		//�Ʒ� url�� ���ؼ� list()�� ȣ���� ��ü�� dispatcher
	@RequestMapping("/sawon/list.do")
	public String list(Model model) {
		
		System.out.println("���� ������ּ���...");
		
	
		List<SawonVo> list = sawon_dao.selectList();
		
		//model�� ���ؼ� �߰��ϸ� DispatcherServlet�� �޾Ƽ� 
		//request binding�Ǽ� ������. 
		model.addAttribute("list",list);
		
		
		
		return MyConstant.SawonController.VIEW_PATH+"sawon_list.jsp";
	}
		
		
	
}
