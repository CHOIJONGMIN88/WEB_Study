package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CommentVo;

public class CommentDao {

	//single-ton pattern: 1개의 객체만 생성해서 서비스하자

	SqlSessionFactory factory;
	
	static CommentDao single = null;

	public static CommentDao getInstance() {
		if (single == null)
			single = new CommentDao();
		return single;
	}

	public CommentDao() {
		
	factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		// TODO Auto-generated constructor stub
	}
	
	
	public int insert(CommentVo vo) {
		
		int res=0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res=sqlSession.insert("comment.comment_insert",vo);
		
		sqlSession.close();
		
		
		
		
		return res;
	}

	public List<CommentVo> selectList(int b_idx) {
		
		List<CommentVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("comment.comment_list",b_idx);
		
		sqlSession.close();
		
		// TODO Auto-generated method stub
		return list;
	}

	
	
	
	
	
	
	
	public int delete(int idx) {

		int res=0;
		SqlSession sqlSession = factory.openSession(true);
		
		res=sqlSession.delete("comment.coment_delete",idx);
		
		sqlSession.close();
		return res;
	}

	public List<CommentVo> selectList(Map map) {
		
		List<CommentVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("comment.comment_page_list",map);
		
		sqlSession.close();
		
		// TODO Auto-generated method stub
		return list;
	}

	public int selectRowTotal(int b_idx) {
		
		int count;
		
		SqlSession sqlSession = factory.openSession();
		
		count=sqlSession.selectOne("comment.comment_row_total",b_idx);
		
		sqlSession.close();
		
		
		// TODO Auto-generated method stub
		return count;
	}

	public int selectComentCount(int b_idx) {
		int count;
		
		SqlSession sqlSession = factory.openSession();
		
		count=sqlSession.selectOne("comment.comment_row_total",b_idx);
		
		sqlSession.close();
		
		return count;
	
	}

	
	
	
}
