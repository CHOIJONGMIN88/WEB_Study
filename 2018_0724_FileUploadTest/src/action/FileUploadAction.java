package action;

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


/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//enctype="multipart/form-data" 
		// ���۵� ������ ������ MultipartReauest cos ��Ű�� ���ο��ִ� ��ü�� �����Ѵ�(com.oreily.servlet.MultipartRequest) ��ü
		//String title=reuqest.getParameter("title"); ���� ������ request �������  �������� ���� .

		String webPath ="/upload/"; //�����

		ServletContext application = request.getServletContext();
		//�����=> ������ ���ϱ� 
		String saveDir=application.getRealPath(webPath);//������ġ
		int maxSize =1024*1024*100;
	
		//��ü ������ ���ÿ� ȭ�� ���ε尡 �Ϸ�ȴ�.
		MultipartRequest mr = new MultipartRequest(request,saveDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
												// ��ûó����ü ���� ��ġ   ���� ũ��    "title" ���ڵ� ,���� ���ϸ� ���ε�� �̸��� �����ؼ� ���ε�
		
		//mr : Ŭ���̾�Ʈ�κ��� ���޵� parameter������ ��� �����Ѵ�.
		//     request�� ��û������ ���ӹ޾Ҵ�.
		
		//String title1 = request.getParameter("title"); //���� �� ����
		String title = mr.getParameter("title");	//request�� ���ӹ޴� mr�� ��� ��ü�� ó���Ѵ�.
		
	//	System.out.printf("title=%s title1=%s\n",title,title1);
		//�̹� ���ε�� ������ MultipartRequest ��ü�� ���� �Ŀ� getFile�� ���� �ٿ�ε� �޴´�. 
		String filename="no_file";
		
		File f = mr.getFile("photo");
		if(f!=null) { //���ε�� ȭ���� �����ϸ�....
			filename=f.getName();
		}
		
		//System.out.printf("title:%s \n filename:%s\n : %s\n",title,filename);
		
		request.setAttribute("title",title);
		request.setAttribute("filename",filename);
		
		//forward��ų ������
		String forward_page ="upload_result.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	
		
		// TODO Auto-generated method stub
	}
	
}

