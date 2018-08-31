package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBService {

	DataSource ds; //����Ŭ �����ͺ��̽��� �������ִ� �ڿ��� �������ִ� ��ü(context_xml�� ����ִ� name���� �̸��� ���� �����ؼ� ���������� Ȯ���Ѵ�.)
	
	//Interface ��ü DataSource
	
	//BasicDataSource ds1;
	
	
	//single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static DBService single = null;

	public static DBService getInstance() {
		if (single == null)
			single = new DBService();
		return single;
	}

	public DBService() {
		// TODO Auto-generated constructor stub
		//JNDI(Java Naming Directory(Ž��) Interface)�� ��ϵ� �ڿ������� ȹ��
		//context.xml ���� Resource name="jdbc/oracle_test" �� ����

		try {
			
			//1.�ڿ��� Ž���� ��ü����
			InitialContext ic = new InitialContext();
			//2.�ڿ��� �����ϰ� �ִ� Context������ ȹ�� 
			Context context =(Context)ic.lookup("java:comp/env"); //*�ϱ� java:comp/env�̸��� ���� context�� Ž��(������ƮŸ�� ��ȯ)
			//context.xml ������ �ڿ� ������ ã�´�.
			ds=(DataSource) context.lookup("jdbc/oracle_test");//context.lookup<--����� �̸��� ���� �ش� �ڿ��� ã�� object Ÿ���� ��ȯ�Ѵ�.
			//JNDI ���
			
			
			
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public Connection getConnection() {
		
		//�����ϱ� ���� Ŀ�ؼ��� ����
		Connection conn = null;
		//JNDI�� ���ؼ� ȹ���� DataSource�� ���� ���ؼ��� ȹ��  (����Ŭ�� �������ִ� ���� Ŀ�ؼ�)
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
