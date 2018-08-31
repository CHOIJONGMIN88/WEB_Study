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
		//SqlSessionTemplate��ü ������ factory.openSession() and sqlSession.close()
		//������ ��ü�� ������ �����ݴ°ű��� �������ֹǷ� �����ʾƵ� ��
		
		list = sqlSession.selectList("photo.photo_list");
	
		return list;
	}
	
	
	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		
		//2.�۾�         ��ûIDȣ�� namespace.mapper_id
		res = sqlSession.insert("photo.photo_insert",vo);

		return res;
	}
	
	
	
}