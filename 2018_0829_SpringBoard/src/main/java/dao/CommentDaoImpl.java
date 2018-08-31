package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.CommentVo;

public class CommentDaoImpl implements CommentDao{

	//single-ton pattern: 1개의 객체만 생성해서 서비스하자

	SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(CommentVo vo) {
		
		int res=0;
		
	
		res=sqlSession.insert("comment.comment_insert",vo);
		
	
		
		return res;
	}

	public List<CommentVo> selectList(int b_idx) {
		
		List<CommentVo> list = null;
		
	
		list = sqlSession.selectList("comment.comment_list",b_idx);
	
		
		// TODO Auto-generated method stub
		return list;
	}

	
	
	
	
	
	
	
	public int delete(int idx) {

		int res=0;
	
		
		res=sqlSession.delete("comment.coment_delete",idx);
		
	
		return res;
	}

	public List<CommentVo> selectList(Map map) {
		
		List<CommentVo> list = null;
		
		
		
		list = sqlSession.selectList("comment.comment_page_list",map);
		
		
		
		// TODO Auto-generated method stub
		return list;
	}

	public int selectRowTotal(int b_idx) {
		
		int count;
		
		
		
		count=sqlSession.selectOne("comment.comment_row_total",b_idx);
		
	
		
		
		// TODO Auto-generated method stub
		return count;
	}

	public int selectComentCount(int b_idx) {
		int count;
		
		
		
		count=sqlSession.selectOne("comment.comment_row_total",b_idx);
		
		
		
		return count;
	
	}

	
	
	
}
