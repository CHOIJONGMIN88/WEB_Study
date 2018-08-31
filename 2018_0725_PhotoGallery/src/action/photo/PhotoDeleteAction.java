package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoDeleteAction
 */
@WebServlet("/photo/delete.do")
public class PhotoDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// photo/delete.do?idx=5&c_pwd=1111
		
		request.setCharacterEncoding("utf-8");
				
		int idx = Integer.parseInt(request.getParameter("idx"));
		//  c_pwd="1234.@"
		String c_pwd = request.getParameter("c_pwd");
		
		//������ idx�� �ش�Ǵ� �Խù�(PhotoVo) 1�� ������
		PhotoVo vo = PhotoDao.getInstance().selectOne(idx);
		
		//��й�ȣ Ȯ��(Ʋ�����)
		if(vo.getPwd().equals(c_pwd)==false) {
			
			String result = "{\"result\":\"no_pwd\"}";
			response.getWriter().println(result);
			return;
		}
		
		//����
		int res = PhotoDao.getInstance().delete(idx);//DB���� ����
		
		//ȭ�ϵ� ����
		String web_path = "/image/";
		String path = request.getServletContext().getRealPath(web_path);
		
		//���� ��� �� ������ �����Ѵ�.
		File f = new File(path,vo.getFilename());
		f.delete();
		
		
		
		if(res==0) {//���� ����(res=������ ���)
			String result = "{\"result\":\"no\"}";
			response.getWriter().println(result);
			return;
		}
		
		//��������
		String result = "{\"result\":\"yes\"}";
		response.getWriter().println(result);
		

		

	}

}
