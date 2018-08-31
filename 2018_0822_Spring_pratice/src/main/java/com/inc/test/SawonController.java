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
	
	
		//아래 url에 의해서 list()를 호출한 객체는 dispatcher
	@RequestMapping("/sawon/list.do")
	public String list(Model model) {
		
		System.out.println("제발 실행되주세여...");
		
	
		List<SawonVo> list = sawon_dao.selectList();
		
		//model을 통해서 추가하면 DispatcherServlet이 받아서 
		//request binding되서 끝난다. 
		model.addAttribute("list",list);
		
		
		
		return MyConstant.SawonController.VIEW_PATH+"sawon_list.jsp";
	}
		
		
	
}
