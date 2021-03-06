package advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

public class Advice {
	//spring에 자동연결요청(autowired에 대한 환경설정이 되있어야함)
	//					Advice객체가 생성된 위치에서 <context : annotation-confing/>
	@Autowired
	HttpServletRequest request;
	//before와 after사이를 연결해주는 객체다. 
	
	public void before(JoinPoint jp){
		Signature s =  jp.getSignature();
	
		long start= System.currentTimeMillis();
		//시작시간을 구함
		request.setAttribute("start",start);
		System.out.println("----before:" + s);
	}
	
	public void after(JoinPoint jp){
		Signature s =  jp.getSignature();
		
		//request에 저장된 start값 얻어오기
		long start = (Long)request.getAttribute("start");
		long end = System.currentTimeMillis();
	
		System.out.println("----after:" + s + "수행시간:"+(start-end) + "ms");
		//System.out.println("----after:" + s.toLongString());
	}
}
