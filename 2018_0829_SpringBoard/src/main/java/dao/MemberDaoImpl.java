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



	//��ü ȸ�� ��� ��ȸ
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;
		
		
		list =sqlSession.selectList("member.member_list");
	
		return list;
	}
	
	
	
	// idx�� �ش�Ǵ� ȸ�������� ȹ��
	public MemberVo selectOne(int idx) {
		
		MemberVo vo = null;
		
		vo =sqlSession.selectOne("member.member_one",idx);
		
		return vo;
	}
	
	
	
	// id�� �ش�Ǵ� ȸ�������� ȹ��
	public MemberVo selectOne(String id) {
		MemberVo vo = null;
	
		vo =sqlSession.selectOne("member.member_one_id",id);
		
		
		
		return vo;
	}
	
	
	//ȸ�� insert
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
	
		res =sqlSession.selectOne("member.member_insert",vo);
		

		return res;
	}

	public int delete(int  idx) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		
		res =sqlSession.delete("member.member_delete",idx);
		

		return res;
	}

	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		
		
		res =sqlSession.update("member.member_update",vo);
		

		
		
		return res;
	} 
	
	
	
	
	
	
	
}