package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {

	SqlSessionFactory factory;
	//single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static DeptDao single = null;

	public static DeptDao getInstance() {
		if (single == null)
			single = new DeptDao();
		return single;
	}

	public DeptDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}
	
	/*�μ���� ��ȸ*/
	public List<DeptVo>  selectList(){
		
		List<DeptVo> list = null;
		
		SqlSession sqlSession =  factory.openSession();// DBCP�� Connectionȹ��
		
		list = sqlSession.selectList("dept_list");
				
		sqlSession.close(); // DBCP�� ���� ���� Connection��ȯ
		
		
		return list;
		
	}
	
	
	
	
	
	
	
}
