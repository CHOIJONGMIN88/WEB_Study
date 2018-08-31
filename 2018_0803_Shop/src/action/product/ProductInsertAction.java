package action.product;

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

import dao.ProductDao;
import vo.ProductVo;

/**
 * Servlet implementation class SungListAction
 */
@WebServlet("/shop/insert.do")
public class ProductInsertAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//웹경로=> 절대경로 구하기
		request.setCharacterEncoding("utf-8");		
		//이클립스상의 경로를 가지고 실제 내부의 저장폴더를 구한다.
		String webPath ="/images/"; 
		ServletContext application = request.getServletContext();
		String saveDir=application.getRealPath(webPath);//저장위치
		
		int maxSize =1024*1024*100;
	
		//객체 생성과 동시에 화일 업로드가 완료된다.
		MultipartRequest mr = new MultipartRequest(request,saveDir,maxSize,"utf-8",new DefaultFileRenamePolicy());

		//파일은 mr객체가 위임받아 name명으로 가져온다.
		//form을 post 방식으로 포장했기때문에 request방식으로 받을 수 없고 mr객체를 이용한다.
		
		
		//String photo_s = mr.getParameter("photo_s");	
		//String photo_l = mr.getParameter("photo_l");
	
		String p_image_s="no_file";
		String p_image_l="no_file";
		//파일을 다운로드받는다.
		File f_photo_s = mr.getFile("photo_s");
		
		File f_photo_l = mr.getFile("photo_l");
	
		if(p_image_s!=null) {
			p_image_s=f_photo_s.getName();
		}
	
		if(p_image_l!=null) { 
			p_image_l=f_photo_l.getName();
		}
		
		
		
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int p_saleprice =Integer.parseInt(mr.getParameter("p_saleprice"));	
	
		String category = mr.getParameter("category");
		String p_num = mr.getParameter("p_num");
		String p_name = mr.getParameter("p_name");
		String p_company = mr.getParameter("p_company");	
		String p_content = mr.getParameter("p_content");
	//	String filename_s="no_file";
	//	String filename_l="no_file";
	
		ProductVo vo = new ProductVo();
		int res=0;		
			vo.setP_price(p_price);
			vo.setP_saleprice(p_saleprice);
			vo.setCategory(category);	
			vo.setP_num(p_num);
			vo.setP_name(p_name);
			vo.setP_company(p_company);
			vo.setP_content(p_content);
			vo.setP_image_l(p_image_l);
			vo.setP_image_s(p_image_s);
		
	
		res=ProductDao.getInstance().insert(vo);
		
		
		
		
		//forward시킬 페이지
		String forward_page ="list.do?category="+category;
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}

