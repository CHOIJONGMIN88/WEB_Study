package action.movie;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/movie/upload.do")
public class MovieUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String webPath = "/mp4/";//�����

		ServletContext application = request.getServletContext();
		//�����=>������ ���ϱ�
		String saveDir = application.getRealPath(webPath);
		

		
		int    maxSize = 1024*1024*100;// 100M
		
		
		//��ü������ ���ÿ� ȭ�Ͼ��ε�� �Ϸ�ȴ�
		MultipartRequest mr = new MultipartRequest(
				                          request,  //��ûó����ü
				                          saveDir,  //������ġ
				                          maxSize,  //����ũ��
				                          "utf-8",  //���ڵ�
				                          //����ȭ�ϸ� ���ε�� �̸��� �����ؼ� ���ε�
				                          new DefaultFileRenamePolicy() 
				);
		
         response.sendRedirect("list.do");

	}

}