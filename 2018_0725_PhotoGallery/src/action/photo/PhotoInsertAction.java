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
		
		
		String webPath ="image/"; //웹상에 사진이 올라갈 경로
		
		ServletContext application = request.getServletContext();
		//웹경로=> 절대경로 구하기 
		String saveDir=application.getRealPath(webPath);//저장위치
		int maxSize =1024*1024*100;
		
		//객체로 수신 후에
		MultipartRequest mr = new MultipartRequest(request,saveDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
		//System.out.println(saveDir);
		String filename="no_file";
		

		// jsp상의 name=photo로 파일을 다운로드 받는다.
		File f = mr.getFile("photo");
		if(f!=null) { //업로드된 화일이 존재하면....
			filename=f.getName();
		}
		//넘어온 파라미터 값을 저장
		String title = mr.getParameter("title");
		String pwd = mr.getParameter("pwd");
		String ip = request.getRemoteAddr();

		
		PhotoVo vo = new PhotoVo(title,filename,pwd,ip);
		
		int res = PhotoDao.getInstance().insert(vo);
	
		//저장된 값을 바인딩해서 다시 전송
		request.setAttribute("title",title);
		request.setAttribute("filename",filename);
		//System.out.println(title);
		//System.out.println(filename);
		//forward시킬 페이지
		String forward_page ="/photo/list.do";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
