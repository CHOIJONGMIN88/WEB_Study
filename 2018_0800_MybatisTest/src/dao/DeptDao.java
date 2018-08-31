package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {

	SqlSessionFactory factory;
	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
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
	
	/*부서목록 조회*/
	public List<DeptVo>  selectList(){
		
		List<DeptVo> list = null;
		
		SqlSession sqlSession =  factory.openSession();// DBCP로 Connection획득
		
		list = sqlSession.selectList("dept_list");
				
		sqlSession.close(); // DBCP로 부터 얻어온 Connection반환
		
		
		return list;
		
	}
	
	
	
	
	
	
	
}
