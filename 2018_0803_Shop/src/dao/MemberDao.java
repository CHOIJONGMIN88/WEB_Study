package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.DBService;
import service.MyBatisConnector;
import vo.MemberVo;

public class MemberDao {

	SqlSessionFactory factory;
	
	
	//single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static MemberDao single = null;

	public static MemberDao getInstance() {
		if (single == null)
			single = new MemberDao();
		return single;
	}

	public MemberDao() {
		// TODO Auto-generated constructor stub
		
		factory=MyBatisConnector.getInstance().getSqlSessionFactory();
	
	}
	
	//��ü ȸ�� ��� ��ȸ
	public List<MemberVo> selectList() {

		List<MemberVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list =sqlSession.selectList("member.member_list");
		
		sqlSession.close();

		return list;
	}
	
	
	
	// idx�� �ش�Ǵ� ȸ�������� ȹ��
	public MemberVo selectOne(int idx) {
		
		MemberVo vo = null;
		SqlSession sqlSession = factory.openSession();
		vo =sqlSession.selectOne("member.member_one",idx);
		sqlSession.close();
		return vo;
	}
	
	
	
	// id�� �ش�Ǵ� ȸ�������� ȹ��
	public MemberVo selectOne(String id) {
		MemberVo vo = null;
		SqlSession sqlSession = factory.openSession();
		vo =sqlSession.selectOne("member.member_one_id",id);
		sqlSession.close();
		
		
		return vo;
	}
	
	
	//ȸ�� insert
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		SqlSession sqlSession = factory.openSession();
		res =sqlSession.selectOne("member.member_insert",vo);
		sqlSession.close();

		return res;
	}

	public int delete(int  idx) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		SqlSession sqlSession = factory.openSession();
		res =sqlSession.delete("member.member_delete",idx);
		sqlSession.close();

		return res;
	}

	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		
		SqlSession sqlSession = factory.openSession();
		res =sqlSession.update("member.member_update",vo);
		sqlSession.close();

		
		
		return res;
	} 
	
	
	
	
	
	
	
}
