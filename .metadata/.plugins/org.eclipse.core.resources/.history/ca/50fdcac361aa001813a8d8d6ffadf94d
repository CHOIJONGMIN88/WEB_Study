package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import vo.PhotoVo;


public class PhotoDao {

	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<PhotoVo> selectList() {
		
		List<PhotoVo> list=null;
		//SqlSessionTemplate객체 내에서 factory.openSession() and sqlSession.close()
		//스프링 객체가 세션을 열고닫는거까지 지원해주므로 쓰지않아도 됨
		
		list = sqlSession.selectList("photo.photo_list");
	
		return list;
	}
	
	
	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		
		//2.작업         요청ID호출 namespace.mapper_id
		res = sqlSession.insert("photo.photo_insert",vo);

		return res;
	}
	
	
	
}
