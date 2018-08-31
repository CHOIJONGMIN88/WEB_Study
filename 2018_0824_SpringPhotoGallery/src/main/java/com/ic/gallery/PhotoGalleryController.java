package com.ic.gallery;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dao.PhotoDao;
import myconst.MyConstant;
import vo.PhotoVo;

@Controller
public class PhotoGalleryController {

	// DispatcherServlet���� �ڵ�����
		@Autowired
		ServletContext application;
		
		@Autowired
		HttpServletRequest request;
		
		@Autowired
		HttpSession  session;
	
	
	PhotoDao  photo_dao;

	public PhotoDao getPhoto_dao() {
		return photo_dao;
	}

	public void setPhoto_dao(PhotoDao photo_dao) {
		this.photo_dao = photo_dao;
	}
	
	//��Ϻ���
	@RequestMapping("/photo/list.do")
	public String list(Model model) {
	
	List<PhotoVo> list = photo_dao.selectList();
	
	model.addAttribute("list",list);
	
	return  MyConstant.PhotoGalleryController.VIEW_PATH +  "photo_list.jsp";
	
	}
	
	@RequestMapping("/photo/insert_form.do")
	public String insert_form(Model model) {
	
	return  MyConstant.PhotoGalleryController.VIEW_PATH +  "photo_insert_form.jsp";
	
	}
	
	@RequestMapping("/photo/insert.do")
	public String insert(PhotoVo vo,Model model,HttpServletRequest request)throws Exception {
	
		
		
		
		String web_path="/resources/upload/";
		String abs_path=application.getRealPath(web_path);
		
		System.out.println(abs_path);
		
		String filename="no_file";
		MultipartFile  photo = vo.getPhoto();
		
		
		
		
		if(photo.isEmpty()==false) {//���ε� ȭ���� �ִ°��
			//���ε�� ȭ�ϸ��� ������
			filename = photo.getOriginalFilename();
			
			
			//������ġ�� ȭ�ϸ� ����
			File f = new File(abs_path,filename);
			//������ο� �̹� �����ϳ�?
			if(f.exists()) {
				long tm = System.currentTimeMillis();//���� �ý��� �ð�
				filename = String.format("%d_%s", tm,filename);
				f = new File(abs_path,filename);
			}
			
			//�ӽ�ȭ��=>������ ��ġ�� ����
			photo.transferTo(f);
			
		}
		
		//���ε�� ȭ�ϸ��� vo�־��ش�
		vo.setFilename(filename);
		
		// model���ؼ� DisptcherServlet���� �����͸� �ѱ��
		model.addAttribute("vo",vo);//��������� request binding
		

		System.out.println(vo.getFilename());
		System.out.println(vo.getTitle());
		System.out.println(vo.getPwd());
		
		
		vo.setIp(request.getRemoteAddr());
		
		
		
		photo_dao.insert(vo);
		
		
	return    "photo/list.do";
	
	}
	
	
	
	
	
}