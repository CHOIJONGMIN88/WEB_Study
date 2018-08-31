package service;

import dao.Test2Dao;
import dao.TestDao;

public class TestServiceImpl implements TestService{

	TestDao  dao1;
	Test2Dao dao2;
	
	
	public TestDao getDao1() {
		return dao1;
	}



	public void setDao1(TestDao dao1) {
		this.dao1 = dao1;
	}



	public Test2Dao getDao2() {
		return dao2;
	}



	public void setDao2(Test2Dao dao2) {
		this.dao2 = dao2;
	}



	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		long start = System.currentTimeMillis();
		
		try {
			Thread.sleep(1234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("--메소스내부: testservice test() 호출--");		
		
		long end =System.currentTimeMillis();
		
		System.out.println("test() 수행시간:" + (end-start) + "(ms)");
	}
	



	@Override
	public void test2() {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		
		try {
			Thread.sleep(234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("--메소스내부: 테스트 투  호출--");		
		
		long end =System.currentTimeMillis();
		
		System.out.println("test() 수행시간:" + (end-start) + "(ms)");
		
		
	}

	
}
