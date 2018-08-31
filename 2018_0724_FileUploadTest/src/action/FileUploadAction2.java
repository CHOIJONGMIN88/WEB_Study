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
@WebServlet("/upload2.do")
public class FileUploadAction2 extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//enctype="multipart/form-data" 
		// 전송된 데이터 수신은 MultipartReauest cos 패키지 내부에있는 객체가 수신한다(com.oreily.servlet.MultipartRequest) 객체
		//String title=reuqest.getParameter("title"); 파일 전송은 request 방식으로  받을수가 없다 .
	
		
		String webPath ="/upload2/"; //웹경로

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
		String title1 = mr.getParameter("title1");	//request가 위임받는 mr이 대신 객체를 처리한다.
		String title2 = mr.getParameter("title2");
		
		
	//	System.out.printf("title=%s title1=%s\n",title,title1);
		//이미 업로드된 파일을 MultipartRequest 객체로 수신 후에 getFile을 통해 다운로드 받는다. 
		String filename1="no_file";
		String filename2="no_file";
		File f1 = mr.getFile("photo1");
		File f2 = mr.getFile("photo2");
		
		if(f1!=null) { //업로드된 화일이 존재하면....
			filename1=f1.getName();
		}
		if(f1!=null) { //업로드된 화일이 존재하면....
			filename2=f2.getName();
		}
		
		//System.out.printf("title:%s \n filename:%s\n : %s\n",title,filename);
		
		request.setAttribute("title1",title1);
		request.setAttribute("filename1",filename1);
		
		request.setAttribute("title2",title2);
		request.setAttribute("filename2",filename2);
		
		
		//forward시킬 페이지
		String forward_page ="upload_result2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	
		
		// TODO Auto-generated method stub
	}
	
}

