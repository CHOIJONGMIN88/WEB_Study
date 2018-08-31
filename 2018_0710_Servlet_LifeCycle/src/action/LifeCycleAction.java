package action;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleAction
 */
@WebServlet("/lifecycle.do")
public class LifeCycleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleAction() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("--1.LifeCycleAction()--");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("--2.init()--");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("--4.destroy()--");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--3.service()--");
		
		//클라이언트 측에서 요청한 방식을 얻어낸다.
		String method = request.getMethod();
		//System.out.println(method);
		// "GET"나 POST를 반환받아 요청방식에 따라 작업이 분기된다. 최신기술은 인코딩이 같기때문에 분리해서 사용하지 않는다.
		if(method.equals("GET"))
			doGet(request,response);
		else if(method.equals("POST"))
			doPost(request,response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--3-1.doGet()--");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--3-2.doPost()--");
		
	}

}
