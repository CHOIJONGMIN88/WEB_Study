package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.BoardVo;

public class BoardDao {

	SqlSessionFactory factory;
	
	
	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static BoardDao single = null;

	public static BoardDao getInstance() {
		if (single == null)
			single = new BoardDao();
		return single;
	}

	public BoardDao() {
		factory=MyBatisConnector.getInstance().getSqlSessionFactory();
	
	}
	//게시판 목록 얻어오기
	public List<BoardVo> selectList(){
		
		List<BoardVo> list = null;
		SqlSession sqlSession =factory.openSession();
		
		list = sqlSession.selectList("board.board_list");
		
		sqlSession.close();
		
	
		return list;
		
	}
	
	public List<BoardVo> selectList(Map map){
		
		List<BoardVo> list = null;
		SqlSession sqlSession =factory.openSession();
		
		list = sqlSession.selectList("board.board_condition_list",map);
		                                                                 
		sqlSession.close();
		
	
		return list;
		
		
	}
	public BoardVo selectOne(int idx){
		
		BoardVo vo = null;
		SqlSession sqlSession =factory.openSession();
		
		vo = sqlSession.selectOne("board.board_view",idx);
		
		sqlSession.close();
		
	
		return vo;
		
	}

	public int update_readhit(int idx) {
		// TODO Auto-generated method stub
		
		int res=0;
		SqlSession sqlSession =factory.openSession(true);
		
		res=sqlSession.update("board.board_update_readhit",idx);
		
		sqlSession.close();
		return res;
	}

	public int Insert(BoardVo vo) {
		
		int res=0;
		SqlSession sqlSession =factory.openSession(true);
		res=sqlSession.update("board.board_insert",vo);
		
		sqlSession.close();
		return res;
	}

	public int delete(int idx) {

		int res=0;
		SqlSession sqlSession =factory.openSession(true);
		res=sqlSession.update("board.board_delete_update",idx);
		sqlSession.close();
		
		// TODO Auto-generated method stub
		return res;
	}

	public int update_step(BoardVo baseVo) {
		
		int res=0;
		SqlSession sqlSession =factory.openSession(true);
		
		res=sqlSession.update("board.board_update_step",baseVo);
		
		sqlSession.close();
		return res;

	}

	public int reply(BoardVo vo) {

		int res=0;
		SqlSession sqlSession =factory.openSession(true);
		res=sqlSession.update("board.board_reply",vo);
		
		sqlSession.close();
		return res;
	}

	public int selectRowTotal() {
		int count = 0;
	
		SqlSession sqlSession =factory.openSession(true);
		count=sqlSession.selectOne("board.board_total_count");
		
		sqlSession.close();
		return count;
	}
	
	public int update(BoardVo vo) {
		int count = 0;
	
		SqlSession sqlSession =factory.openSession(true);
		
		count=sqlSession.update("board.board_update",vo);
		
		sqlSession.close();
		return count;
	}

	public int selectRowTotalSearch(Map map) {
		
		int count = 0;
		
		SqlSession sqlSession =factory.openSession();
		
		count=sqlSession.selectOne("board.board_electRowTotalSearch",map);
		
		sqlSession.close();
	
		return count;
		

	
	}
	
	
	
	
}
