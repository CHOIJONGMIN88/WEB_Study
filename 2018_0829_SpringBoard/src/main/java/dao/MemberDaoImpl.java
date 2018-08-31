package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import vo.MemberVo;

public class MemberDaoImpl implements MemberDao {

	SqlSession sqlSession;
	
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}



	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}



	//전체 회원 목록 조회
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;
		
		
		list =sqlSession.selectList("member.member_list");
	
		return list;
	}
	
	
	
	// idx에 해당되는 회원정보를 획득
	public MemberVo selectOne(int idx) {
		
		MemberVo vo = null;
		
		vo =sqlSession.selectOne("member.member_one",idx);
		
		return vo;
	}
	
	
	
	// id에 해당되는 회원정보를 획득
	public MemberVo selectOne(String id) {
		MemberVo vo = null;
	
		vo =sqlSession.selectOne("member.member_one_id",id);
		
		
		
		return vo;
	}
	
	
	//회원 insert
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
	
		res =sqlSession.selectOne("member.member_insert",vo);
		

		return res;
	}

	public int delete(int  idx) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		
		res =sqlSession.delete("member.member_delete",idx);
		

		return res;
	}

	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		
		
		res =sqlSession.update("member.member_update",vo);
		

		
		
		return res;
	} 
	
	
	
	
	
	
	
}
