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
	
	
		//�Ʒ� url�� ���ؼ� list()�� ȣ���� ��ü�� dispatcher
	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		List<DeptVo> list = dept_dao.selectList();
		
		//model�� ���ؼ� �߰��ϸ� DispatcherServlet�� �޾Ƽ� 
		//request binding�Ǽ� ������. 
		model.addAttribute("list",list);
	
		return MyConstant.ParameterController.VIEW_PATH+"dept_list.jsp";
	}
		
		
	
}
