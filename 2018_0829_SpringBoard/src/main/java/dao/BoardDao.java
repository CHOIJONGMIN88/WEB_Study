package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;



import vo.BoardVo;

public interface BoardDao {

	// �Խ��� ��� ������
	public List<BoardVo> selectList(); 

	public List<BoardVo> selectList(Map map);

	public BoardVo selectOne(int idx);

	public int update_readhit(int idx);
		
	public int Insert(BoardVo vo);

	public int delete(int idx);

	public int update_step(BoardVo baseVo);

	public int reply(BoardVo vo);

	public int selectRowTotal(Map map);
	
	
	public int update(BoardVo vo);
		
	public int selectRowTotalSearch(Map map);



	;

}