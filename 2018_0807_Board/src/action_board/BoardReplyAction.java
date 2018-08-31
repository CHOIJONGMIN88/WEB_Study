package action_board;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;



@WebServlet("/board/reply.do")
public class BoardReplyAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//����� ���ر� ��ȣ==idx 
		
		
		
		
		int idx=	  Integer.parseInt(request.getParameter("idx"));
		
		int board_idx=Integer.parseInt(request.getParameter("board_idx"));
		String page=request.getParameter("page");
	
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		
		//���رۿ� �ش�Ǵ� �Խù� ��ü�� ���ɴϴ�.
		
		BoardVo baseVo = BoardDao.getInstance().selectOne(idx);
		
		
		//���رۺ��� step�� ū �Խù��� step�� 1�� ���� 
		//���ر��� ����� ���� +1 ���־� ���� �о�ø��� .
		int res = BoardDao.getInstance().update_step(baseVo);
		
		//��� ������ ����
		//���ο� ������ ���� �����ۿ� �ִ´�.
		BoardVo vo = new BoardVo(id,name,subject,content,pwd,ip);
		
		vo.setRef(baseVo.getRef()); //���ر��� ref�� ���� �״�� �޴´�.
		vo.setStep(baseVo.getStep()+1); //��� step = ���ر� step +1
		vo.setDepth(baseVo.getDepth()+1);//���depth = ���ر� depth +1
		
		//����� DB reply
		
		res=BoardDao.getInstance().reply(vo);		
		
		//�Խñ�idx-->view.jsp(idx)->boardform.jsp-->����ؼ� idxƮ��ŷ���̴�.
		//��� �ۼ� �Ŀ� ���������� ȣ���ߴ� �������� �Խñ��� ��ġ�� idx�� ��ȯ�Ѵ�.
		
		request.setAttribute("page",page);
		request.setAttribute("idx",board_idx);
		
		
		//forward��ų ������
		String forward_page ="list.do";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
