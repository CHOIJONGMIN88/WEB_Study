package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBService {

	DataSource ds; //오라클 데이터베이스에 연결해주는 자원을 관리해주는 객체(context_xml에 들어있는 name상의 이름을 통해 접근해서 설정내용을 확인한다.)
	
	//Interface 객체 DataSource
	
	//BasicDataSource ds1;
	
	
	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static DBService single = null;

	public static DBService getInstance() {
		if (single == null)
			single = new DBService();
		return single;
	}

	public DBService() {
		// TODO Auto-generated constructor stub
		//JNDI(Java Naming Directory(탐색) Interface)로 등록된 자원정보를 획득
		//context.xml 내의 Resource name="jdbc/oracle_test" 로 접근

		try {
			
			//1.자원을 탐색할 객체생성
			InitialContext ic = new InitialContext();
			//2.자원을 포함하고 있는 Context정보를 획득 
			Context context =(Context)ic.lookup("java:comp/env"); //*암기 java:comp/env이름을 가진 context를 탐색(오브젝트타입 반환)
			//context.xml 파일의 자원 정보를 찾는다.
			ds=(DataSource) context.lookup("jdbc/oracle_test");//context.lookup<--룩업의 이름을 통해 해당 자원을 찾아 object 타입을 반환한다.
			//JNDI 기법
			
			
			
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public Connection getConnection() {
		
		//연결하기 위한 커넥션을 생성
		Connection conn = null;
		//JNDI를 통해서 획득한 DataSource로 부터 컨넥션을 획득  (오라클과 연결해주는 연결 커넥션)
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
