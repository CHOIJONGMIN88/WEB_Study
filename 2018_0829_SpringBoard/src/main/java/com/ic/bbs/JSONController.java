package com.ic.bbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.BoardVo;
import vo.MemberVo;

@Controller
public class JSONController {
		//Map->Json객체로 변환 
	//ResponseBody로 스프링의 json변환객체가 변환시킨다.
	@RequestMapping("/test_map.do")
	@ResponseBody
	public Map test() {
		
		Map map = new HashMap();
		map.put("name","홍길동");
		map.put("age",20);
		map.put("tel","010-111-1234");
		
		
		return map;
	}	
	
	@RequestMapping("/test_object.do")
	@ResponseBody
	public BoardVo test_object() {
		
		BoardVo vo =new BoardVo("hong","홍길동","제목","내용","1234","127.0.0.1");
		
		return vo;
	}
	
	//List->JSON Array로 변환해 준다
	@RequestMapping("/test_list.do")
	@ResponseBody
	public List test_list(){
	
	List list = new ArrayList();
	list.add("서울");
	list.add("인천");
	list.add("대전");
	list.add("꺅");	
	
	return list;
	}
	//ObjectList	

	@RequestMapping("/test_object_list.do")
	@ResponseBody
	public List test_object_list() {
		
		List list = new ArrayList();
		list.add(new MemberVo("길동1","gil1","1234","12312","서울특별씨","127.0.0.1"));
		list.add(new MemberVo("길동2","gil2","1234","12312","인천시","127.0.0.1"));
		list.add(new MemberVo("길동3","gil3","1234","12312","강남시","127.0.0.1"));
		list.add(new MemberVo("길동4","gil4","1234","12312","홍시","127.0.0.1"));
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
