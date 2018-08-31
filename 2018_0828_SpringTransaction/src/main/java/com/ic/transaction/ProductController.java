package com.ic.transaction;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import myconst.MyConstant;
import service.ProductService;
import vo.ProductVo;

@Controller
public class ProductController {

	
	ProductService product_service;
	
	public ProductService getProduct_service() {
		return product_service;
	}


	public void setProduct_service(ProductService product_service) {
		this.product_service = product_service;
	}




	@RequestMapping("/product/list.do")
	public String list(Model model) {
		//�԰�, ���, ������� ��û
		
		Map map = product_service.selectList();
		
		model.addAttribute("map",map);
		
		return MyConstant.ProductController.VIEW_PATH +"product_list.jsp";
		
	}
	
	//��ǰ�԰�
	@RequestMapping("/product/insert_in.do")
	public String insert_in(ProductVo vo) {
		
		
		try {
			product_service.insert_in(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:list.do";
		
	}
	
	@RequestMapping("/product/insert_out.od")
	
	public String insert_out(ProductVo vo,Model model) {
		
		
		try {
			product_service.insert_out(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String error_msg = e.getMessage(); //"remain_not" or "remain_lack"
			model.addAttribute("error",error_msg);
			//Exception�� aspect.xml�ȿ� throwing�� ��ġ�ؾ� �Ѵ�.�װ����� ������
		
		}
		
		return "redirect:list.do";
		
	}
	
	
}
