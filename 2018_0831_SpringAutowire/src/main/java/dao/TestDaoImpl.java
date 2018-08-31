package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("test_dao")
public class TestDaoImpl implements TestDao {

	
	@Autowired
	SqlSession sqlSession;
	
	public TestDaoImpl() {
		
	}
	
	
	@Override
	public List selectList() {
		// TODO Auto-generated method stub
		
   List list = sqlSession.selectList("dept.dept_list");
		
		return list;
	}

	
	
}
