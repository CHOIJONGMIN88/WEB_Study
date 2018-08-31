package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import vo.MemberVo;

public interface MemberDao {

	
	
	//��ü ȸ�� ��� ��ȸ
	public List<MemberVo> selectList();

	
	
	// idx�� �ش�Ǵ� ȸ�������� ȹ��
	public MemberVo selectOne(int idx);
		
	
	
	
	// id�� �ش�Ǵ� ȸ�������� ȹ��
	public MemberVo selectOne(String id);
	
	//ȸ�� insert
	public int insert(MemberVo vo);
	
	public int delete(int  idx);
		
	
	public int update(MemberVo vo);
	
	
	
	
	
}
