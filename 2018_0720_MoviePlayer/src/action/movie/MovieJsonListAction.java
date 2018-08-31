package action.movie;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieListAction
 */
@WebServlet("/movie/json_list.do")
public class MovieJsonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String web_path = "/mp4/";
		
		//web -> ������ 
		//��App ������ü
		ServletContext application = request.getServletContext();
		String abs_path = application.getRealPath(web_path);
		
		//System.out.println(abs_path);
		File f = new File(abs_path);
		
		//�Ʒ�������(mp4)�� ȭ�ϸ�� ���
		File [] file_array = f.listFiles();

		StringBuffer sb = new StringBuffer("[");
		for(File ff : file_array) {
			
			String filename = ff.getName(); // path
			//System.out.println(filename);
			//filename="blackpink_�ѵζѵ�.mp4"
			String [] im_arr = filename.split("_");
			// im_arr = { "blackpink" , "�ѵζѵ�.mp4"};
			String singer = im_arr[0];
			String title = im_arr[1].replaceAll(".mp4", "");
			String path = String.format("mp4/%s", filename);
			
			sb.append(String.format("{'singer':'%s','title':'%s','path':'%s' },", 
					                          singer,      title,       path
					));
		}
		
		//������ (,) ����
		int last_index = sb.toString().lastIndexOf(',');
		String json_array = sb.toString().substring(0,last_index);//������ , ����
		
		
		json_array = json_array + "]";
		
		
		//�������ڵ� ����
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().println(json_array);
		
		
		
		
	}

}