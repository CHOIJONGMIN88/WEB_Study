package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class Test2DaoImpl implements Test2Dao {

	SqlSession sqlSession;
	
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
