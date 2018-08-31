package service;

public class Testinterface implements TestService{

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		System.out.println("이것도 같이 상속");
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
		System.out.println("같이 실행 되야 정상");
		
	}

	public void test3() {
		
		System.out.println("해당 메쏘드는 인터페이스에 상속되지 않는 메쏘드이므로 나오지않는다.");
		
	}
	
	
	
}
