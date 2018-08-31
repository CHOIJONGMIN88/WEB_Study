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
		String webPath = "/mp4/";//웹경로

		ServletContext application = request.getServletContext();
		//웹경로=>절대경로 구하기
		String saveDir = application.getRealPath(webPath);
		

		
		int    maxSize = 1024*1024*100;// 100M
		
		
		//객체생성과 동시에 화일업로드는 완료된다
		MultipartRequest mr = new MultipartRequest(
				                          request,  //요청처리객체
				                          saveDir,  //저장위치
				                          maxSize,  //저장크기
				                          "utf-8",  //인코딩
				                          //동일화일명 업로드시 이름을 변경해서 업로드
				                          new DefaultFileRenamePolicy() 
				);
		
         response.sendRedirect("list.do");

	}

}