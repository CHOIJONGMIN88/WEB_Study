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
		//Map->Json��ü�� ��ȯ 
	//ResponseBody�� �������� json��ȯ��ü�� ��ȯ��Ų��.
	@RequestMapping("/test_map.do")
	@ResponseBody
	public Map test() {
		
		Map map = new HashMap();
		map.put("name","ȫ�浿");
		map.put("age",20);
		map.put("tel","010-111-1234");
		
		
		return map;
	}	
	
	@RequestMapping("/test_object.do")
	@ResponseBody
	public BoardVo test_object() {
		
		BoardVo vo =new BoardVo("hong","ȫ�浿","����","����","1234","127.0.0.1");
		
		return vo;
	}
	
	//List->JSON Array�� ��ȯ�� �ش�
	@RequestMapping("/test_list.do")
	@ResponseBody
	public List test_list(){
	
	List list = new ArrayList();
	list.add("����");
	list.add("��õ");
	list.add("����");
	list.add("��");	
	
	return list;
	}
	//ObjectList	

	@RequestMapping("/test_object_list.do")
	@ResponseBody
	public List test_object_list() {
		
		List list = new ArrayList();
		list.add(new MemberVo("�浿1","gil1","1234","12312","����Ư����","127.0.0.1"));
		list.add(new MemberVo("�浿2","gil2","1234","12312","��õ��","127.0.0.1"));
		list.add(new MemberVo("�浿3","gil3","1234","12312","������","127.0.0.1"));
		list.add(new MemberVo("�浿4","gil4","1234","12312","ȫ��","127.0.0.1"));
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
