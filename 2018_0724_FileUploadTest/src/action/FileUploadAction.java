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
		// 전송된 데이터 수신은 MultipartReauest cos 패키지 내부에있는 객체가 수신한다(com.oreily.servlet.MultipartRequest) 객체
		//String title=reuqest.getParameter("title"); 파일 전송은 request 방식으로  받을수가 없다 .

		String webPath ="/upload/"; //웹경로

		ServletContext application = request.getServletContext();
		//웹경로=> 절대경로 구하기 
		String saveDir=application.getRealPath(webPath);//저장위치
		int maxSize =1024*1024*100;
	
		//객체 생성과 동시에 화일 업로드가 완료된다.
		MultipartRequest mr = new MultipartRequest(request,saveDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
												// 요청처리객체 저장 위치   저장 크기    "title" 인코딩 ,동일 파일명 업로드시 이름을 변경해서 업로드
		
		//mr : 클라이언트로부터 전달된 parameter정보를 모두 관리한다.
		//     request의 요청정보를 위임받았다.
		
		//String title1 = request.getParameter("title"); //받을 수 없다
		String title = mr.getParameter("title");	//request가 위임받는 mr이 대신 객체를 처리한다.
		
	//	System.out.printf("title=%s title1=%s\n",title,title1);
		//이미 업로드된 파일을 MultipartRequest 객체로 수신 후에 getFile을 통해 다운로드 받는다. 
		String filename="no_file";
		
		File f = mr.getFile("photo");
		if(f!=null) { //업로드된 화일이 존재하면....
			filename=f.getName();
		}
		
		//System.out.printf("title:%s \n filename:%s\n : %s\n",title,filename);
		
		request.setAttribute("title",title);
		request.setAttribute("filename",filename);
		
		//forward시킬 페이지
		String forward_page ="upload_result.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	
		
		// TODO Auto-generated method stub
	}
	
}

