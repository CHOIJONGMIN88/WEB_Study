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
		
		//삭제할 idx에 해당되는 게시물(PhotoVo) 1건 얻어오기
		PhotoVo vo = PhotoDao.getInstance().selectOne(idx);
		
		//비밀번호 확인(틀린경우)
		if(vo.getPwd().equals(c_pwd)==false) {
			
			String result = "{\"result\":\"no_pwd\"}";
			response.getWriter().println(result);
			return;
		}
		
		//삭제
		int res = PhotoDao.getInstance().delete(idx);//DB정보 삭제
		
		//화일도 삭제
		String web_path = "/image/";
		String path = request.getServletContext().getRealPath(web_path);
		
		//실제 경로 상에 파일을 삭제한다.
		File f = new File(path,vo.getFilename());
		f.delete();
		
		
		
		if(res==0) {//삭제 실패(res=삭제된 행수)
			String result = "{\"result\":\"no\"}";
			response.getWriter().println(result);
			return;
		}
		
		//삭제성공
		String result = "{\"result\":\"yes\"}";
		response.getWriter().println(result);
		

		

	}

}
