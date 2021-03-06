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

	// DispatcherServlet에서 자동연결
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
	
	//목록보기
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
		
		
		
		
		if(photo.isEmpty()==false) {//업로드 화일이 있는경우
			//업로드된 화일명을 얻어오기
			filename = photo.getOriginalFilename();
			
			
			//저장위치및 화일명 설정
			File f = new File(abs_path,filename);
			//설정경로에 이미 존재하냐?
			if(f.exists()) {
				long tm = System.currentTimeMillis();//현재 시스템 시간
				filename = String.format("%d_%s", tm,filename);
				f = new File(abs_path,filename);
			}
			
			//임시화일=>지정된 위치로 복사
			photo.transferTo(f);
			
		}
		
		//업로드된 화일명을 vo넣어준다
		vo.setFilename(filename);
		
		// model통해서 DisptcherServlet에게 데이터를 넘긴다
		model.addAttribute("vo",vo);//결과적으로 request binding
		

		System.out.println(vo.getFilename());
		System.out.println(vo.getTitle());
		System.out.println(vo.getPwd());
		
		
		vo.setIp(request.getRemoteAddr());
		
		
		
		photo_dao.insert(vo);
		
		
	return    "photo/list.do";
	
	}
	
	
	
	
	
}
