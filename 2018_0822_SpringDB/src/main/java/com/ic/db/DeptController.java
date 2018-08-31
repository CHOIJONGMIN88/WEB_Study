package com.ic.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDao;
import myconst.MyConstant;
import vo.DeptVo;

@Controller
public class DeptController {

		DeptDao dept_dao;
				
		public DeptController() {
			// TODO Auto-generated constructor stub
		}

		public DeptController(DeptDao dept_dao) {
			super();
			this.dept_dao = dept_dao;
		}
	
	
		//아래 url에 의해서 list()를 호출한 객체는 dispatcher
	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		List<DeptVo> list = dept_dao.selectList();
		
		//model을 통해서 추가하면 DispatcherServlet이 받아서 
		//request binding되서 끝난다. 
		model.addAttribute("list",list);
	
		return MyConstant.ParameterController.VIEW_PATH+"dept_list.jsp";
	}
		
		
	
}
