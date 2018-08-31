package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import vo.MemberVo;

public interface MemberDao {

	
	
	//전체 회원 목록 조회
	public List<MemberVo> selectList();

	
	
	// idx에 해당되는 회원정보를 획득
	public MemberVo selectOne(int idx);
		
	
	
	
	// id에 해당되는 회원정보를 획득
	public MemberVo selectOne(String id);
	
	//회원 insert
	public int insert(MemberVo vo);
	
	public int delete(int  idx);
		
	
	public int update(MemberVo vo);
	
	
	
	
	
}
