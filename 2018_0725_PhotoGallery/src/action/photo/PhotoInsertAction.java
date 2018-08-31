package action.photo;


import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.PhotoVo;


@WebServlet("/photo/insert.do")
public class PhotoInsertAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String webPath ="image/"; //���� ������ �ö� ���
		
		ServletContext application = request.getServletContext();
		//�����=> ������ ���ϱ� 
		String saveDir=application.getRealPath(webPath);//������ġ
		int maxSize =1024*1024*100;
		
		//��ü�� ���� �Ŀ�
		MultipartRequest mr = new MultipartRequest(request,saveDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
		//System.out.println(saveDir);
		String filename="no_file";
		

		// jsp���� name=photo�� ������ �ٿ�ε� �޴´�.
		File f = mr.getFile("photo");
		if(f!=null) { //���ε�� ȭ���� �����ϸ�....
			filename=f.getName();
		}
		//�Ѿ�� �Ķ���� ���� ����
		String title = mr.getParameter("title");
		String pwd = mr.getParameter("pwd");
		String ip = request.getRemoteAddr();

		
		PhotoVo vo = new PhotoVo(title,filename,pwd,ip);
		
		int res = PhotoDao.getInstance().insert(vo);
	
		//����� ���� ���ε��ؼ� �ٽ� ����
		request.setAttribute("title",title);
		request.setAttribute("filename",filename);
		//System.out.println(title);
		//System.out.println(filename);
		//forward��ų ������
		String forward_page ="/photo/list.do";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
