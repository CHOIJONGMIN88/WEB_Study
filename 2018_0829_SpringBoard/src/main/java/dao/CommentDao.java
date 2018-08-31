package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.CommentVo;

public interface CommentDao {

	//single-ton pattern: 1���� ��ü�� �����ؼ� ��������

	public int insert(CommentVo vo);
		
	public List<CommentVo> selectList(int b_idx);

	public int delete(int idx);

	public List<CommentVo> selectList(Map map);

	public int selectRowTotal(int b_idx);
		
	public int selectComentCount(int b_idx);
	

}
