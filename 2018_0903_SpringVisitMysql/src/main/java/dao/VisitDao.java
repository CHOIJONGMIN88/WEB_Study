package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVo;

// DAO(Data Access Object)
// : ������(DB<->JavaObject) ������ü
public class VisitDao {
	
	
	SqlSession sqlSession;//Spring���κ��� Injection(setter injection)�޴´�
	                      //Spring���� ������ SqlSessionTemplate��ü�� �������̽� 
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//���� ��� ��ȸ
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		
		//2.�۾�         ��ûIDȣ�� namespace.mapper_id
		list = sqlSession.selectList("visit.visit_list");
		
		return list;
	}
	
	//���� ����
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		
		//2.�۾�         ��ûIDȣ�� namespace.mapper_id
		res = sqlSession.insert("visit.visit_insert",vo);

		return res;
	}
	
	//���� ����
	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		
		//2.�۾�         ��ûIDȣ�� namespace.mapper_id
		res = sqlSession.delete("visit.visit_delete",idx);
		
		return res;
	}
	
	// idx�� �ش�Ǵ� �Խù� 1�� ���
	public VisitVo selectOne(int idx) {
		
		VisitVo vo = null;
		
		vo = sqlSession.selectOne("visit.visit_one", idx);
		
		return vo;
	}
	
	//��ü �Խù��� ���ϱ�
	public int selectRowCount() {
		int count = 0;
		
		count = sqlSession.selectOne("visit.visit_count");
		
		return count;
	}
	
	//���� �����ϱ�
	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���

   		res = sqlSession.update("visit.visit_update", vo);

		return res;
	}

	public List<VisitVo> selectList(VisitVo vo) {
		// TODO Auto-generated method stub
		List<VisitVo> list = null;
		
		//2.�۾�         ��ûIDȣ�� namespace.mapper_id
		list = sqlSession.selectList("visit.visit_condition_list",vo);
		
	
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
}
