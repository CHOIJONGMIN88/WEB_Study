package advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

public class Advice {
	//spring�� �ڵ������û(autowired�� ���� ȯ�漳���� ���־����)
	//					Advice��ü�� ������ ��ġ���� <context : annotation-confing/>
	@Autowired
	HttpServletRequest request;
	//before�� after���̸� �������ִ� ��ü��. 
	
	public void before(JoinPoint jp){
		Signature s =  jp.getSignature();
	
		long start= System.currentTimeMillis();
		//���۽ð��� ����
		request.setAttribute("start",start);
		System.out.println("----before:" + s);
	}
	
	public void after(JoinPoint jp){
		Signature s =  jp.getSignature();
		
		//request�� ����� start�� ������
		long start = (Long)request.getAttribute("start");
		long end = System.currentTimeMillis();
	
		System.out.println("----after:" + s + "����ð�:"+(start-end) + "ms");
		//System.out.println("----after:" + s.toLongString());
	}
}
