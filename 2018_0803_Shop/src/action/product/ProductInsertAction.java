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
		
		//�����=> ������ ���ϱ�
		request.setCharacterEncoding("utf-8");		
		//��Ŭ�������� ��θ� ������ ���� ������ ���������� ���Ѵ�.
		String webPath ="/images/"; 
		ServletContext application = request.getServletContext();
		String saveDir=application.getRealPath(webPath);//������ġ
		
		int maxSize =1024*1024*100;
	
		//��ü ������ ���ÿ� ȭ�� ���ε尡 �Ϸ�ȴ�.
		MultipartRequest mr = new MultipartRequest(request,saveDir,maxSize,"utf-8",new DefaultFileRenamePolicy());

		//������ mr��ü�� ���ӹ޾� name������ �����´�.
		//form�� post ������� �����߱⶧���� request������� ���� �� ���� mr��ü�� �̿��Ѵ�.
		
		
		//String photo_s = mr.getParameter("photo_s");	
		//String photo_l = mr.getParameter("photo_l");
	
		String p_image_s="no_file";
		String p_image_l="no_file";
		//������ �ٿ�ε�޴´�.
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
		
		
		
		
		//forward��ų ������
		String forward_page ="list.do?category="+category;
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
	}
	
}
