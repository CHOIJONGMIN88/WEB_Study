package com.ic.bbs;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.BoardDao;
import dao.CommentDao;
import myconst.MyConst;
import myconst.MyConstant;
import util.Paging;
import vo.BoardVo;
import vo.CommentVo;

@Controller
public class BoardController {

	@Autowired  //�ڵ�����
	BoardDao board_dao;
	@Autowired  //�ڵ�����
	CommentDao comment_dao;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/board/list.do")
	public String list(String search,String search_text,Integer page,Model model) {
		
		
		//String search = request.getParameter("search");
		//String search_text = request.getParameter("search_text");
		//String strPage = request.getParameter("page");
		
		int    nowPage = 1; //���� �������� ������
		
		//���������� page=3 ��������
		//if(strPage!=null && !strPage.isEmpty())
		if(page!=null)
			nowPage = page;
	
		//������ page�� ���� start,end���
		int start = (nowPage-1) *MyConst.Board.BLOCKLIST + 1;
		int end   = start + MyConst.Board.BLOCKLIST - 1;
		
		//mybatis mapper�� �����ϱ� ���ؼ� Map�� ����
		Map  map = new HashMap();
		//       key    value
		map.put("start", start);
		map.put("end"  , end);
		
		if(search!=null && !search.equals("all")) {
			
			if(search.equals("name_subject_content")) {
				map.put("name", search_text);
				map.put("subject", search_text);
				map.put("content", search_text);
			}else if(search.equals("name")) {
				map.put("name", search_text); 
			}else if(search.equals("subject")) {
				map.put("subject", search_text);
			}else if(search.equals("content")) {
				map.put("content", search_text);
			}
			
		}
		

		//�Խ��� ��ϰ�������
		//BoardDao dao = BoardDao.getInstance();
		
		List<BoardVo> list = board_dao.selectList(map);
		
		//���ǿ� �Խù��� �óĿ� ��������(show)����
		session.removeAttribute("show");
		
	
		
		//������ �޴� ����
		int rowTotal = board_dao.selectRowTotal(map);//��ü���ڵ��
					
		//paging���� �˻����� �־ �ۼ��ؾߵ�.
		//paging���� �˻����� �־ �ۼ��ؾߵ�.
				String pageMenu = Paging.getPaging("list.do",
						                            nowPage, 
						                            rowTotal, 
						                            search,
						                            search_text,
						                            MyConst.Board.BLOCKLIST, 
						                            MyConst.Board.BLOCKPAGE
						                            );	
		
		//��������� request binding
		model.addAttribute("list", list);		
		model.addAttribute("pageMenu", pageMenu);
				
		
		return  MyConstant.BoardController.VIEW_PATH +  "board_list.jsp";
	}
	
	@RequestMapping("/board/insert_form.do")
	public String insert_form() {
		return MyConstant.BoardController.VIEW_PATH + "board_write.jsp";
	}

	
	@RequestMapping("/board/insert.do")
	//public String insert(BoardVo vo,HttpServletRequest request){
	public String insert(BoardVo vo,HttpServletRequest request) {
		//vo�� �ڵ����� ����Ǿ �Ѿ�´�. request ��ü�� �Ķ���ͷ� ������ �� �ִ�.
	
		HttpSession	session = request.getSession();
	    session.getAttribute("user");
	    
	    String ip=request.getRemoteAddr();
	  	vo.setIp(ip);

		int res=board_dao.Insert(vo);
		return  "/board/list.do";
	}
	
	@RequestMapping("/board/view.do")
	public String view(Integer idx,HttpServletRequest request,Model model ) {
	
		BoardVo vo=null;

		vo=board_dao.selectOne(idx);
		
		//���Խù��� �ô��� üũ
		HttpSession session = request.getSession();
		if(session.getAttribute("show")==null) {
			int res=board_dao.update_readhit(idx);
			//���ǿ� �ôٴ� ���� ���
			session.setAttribute("show",true);	
		}
		
		// ��ȸ�� ������ ���ε�
		model.addAttribute("vo",vo);
		
		return  MyConstant.BoardController.VIEW_PATH +  "board_view.jsp";
		
	}
	
	@RequestMapping("/board/delete.do")
	public String delete(Integer idx) {
		
		int res=0;
		res=board_dao.delete(idx);	
		return "redirect:list.do";
		
		// TODO Auto-generated method stub

	}
	@RequestMapping("/board/modify_form.do")
	public String modify_form(Integer idx,Model model) {
			
			BoardVo vo = null;
			vo=board_dao.selectOne(idx);
			model.addAttribute("vo",vo);
		
		return MyConstant.BoardController.VIEW_PATH + "board_modify_form.jsp";
		// TODO Auto-generated method stub

	}
	
	@RequestMapping("/board/modify_action.do")
	public String modify_form(Integer idx,Model model,String page,String subject,String name,String content) {

		BoardVo vo = board_dao.selectOne(idx);

		//����� ���� �־��ص� �����ͺ��̽��� ���� ������Ʈ �����ش�.
		vo.setSubject(subject);
		vo.setName(name);
		vo.setContent(content);
		
		 // ���ο�� �޾Ƽ� ����� ���� ������ ���̽��� ���� ������Ʈ �����ش�.
		int res = board_dao.update(vo);
		
		return "redirect:list.do";
	
	}
	
	
	@RequestMapping(value="/board/comment_insert.do",produces="text/html; charset=utf-8")
	@ResponseBody
	public void comment_insert(String b_idx,String id, String name, String content,HttpServletRequest request,
				HttpServletResponse response) throws IOException {

	
		String ip = request.getRemoteAddr();
		System.out.println(id + " " +  name);
		CommentVo vo = new CommentVo();
		vo.setB_idx(Integer.parseInt(b_idx));
		vo.setContent(content);
		vo.setName(name);
		vo.setId(id);
		vo.setIp(ip);
		
		int res =comment_dao.insert(vo);
		
		
		String result="success";
		
		if(res==0)result="fail";
									//�ڹٴ� " �� ���ڷ� �ν����� �����Ƿ� �տ�\�� �ٿ��ش�.
		String result_json=String.format("{\"result\":\"%s\"}",result);
		
		response.getWriter().println(result_json);
		
	
	}
	
	
	@RequestMapping(value="/board/comment_list.do",produces="text/html; charset=utf-8")
	
	public String comment_insert(String b_idx,Model model,HttpServletResponse response) {
	
	 
		List<CommentVo> list = comment_dao.selectList(Integer.parseInt(b_idx));
		
		
		model.addAttribute("list",list);
		
		
		return MyConstant.BoardController.VIEW_PATH +  "comment_list.jsp";
		
		
	}
	
	
	
	
	
}