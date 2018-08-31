package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;



import vo.BoardVo;

public class BoardDaoImpl implements BoardDao {

	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 게시판 목록 얻어오기
	public List<BoardVo> selectList() {

		List<BoardVo> list = null;

		list = sqlSession.selectList("board.board_list");

		return list;

	}

	public List<BoardVo> selectList(Map map) {

		List<BoardVo> list = null;

		list = sqlSession.selectList("board.board_condition_list", map);

		return list;

	}

	public BoardVo selectOne(int idx) {

		BoardVo vo = null;

		vo = sqlSession.selectOne("board.board_view", idx);

		return vo;

	}

	public int update_readhit(int idx) {
		// TODO Auto-generated method stub

		int res = 0;

		res = sqlSession.update("board.board_update_readhit", idx);

		return res;
	}

	public int Insert(BoardVo vo) {

		int res = 0;

		res = sqlSession.update("board.board_insert", vo);

		return res;
	}

	public int delete(int idx) {

		int res = 0;

		res = sqlSession.update("board.board_delete_update", idx);

		return res;
	}

	public int update_step(BoardVo baseVo) {

		int res = 0;

		res = sqlSession.update("board.board_update_step", baseVo);

		return res;

	}

	public int reply(BoardVo vo) {

		int res = 0;

		res = sqlSession.update("board.board_reply", vo);

		return res;
	}

	public int selectRowTotal(Map map) {
		int count = 0;

		count = sqlSession.selectOne("board.board_total_count");

		return count;
	}

	public int update(BoardVo vo) {
		int count = 0;

		count = sqlSession.update("board.board_update", vo);

		return count;
	}

	public int selectRowTotalSearch(Map map) {

		int count = 0;

		count = sqlSession.selectOne("board.board_electRowTotalSearch", map);

		return count;

	}

}
