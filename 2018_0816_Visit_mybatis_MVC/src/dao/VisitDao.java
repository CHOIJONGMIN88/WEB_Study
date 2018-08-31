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
import vo.VisitVo;

// DAO(Data Access Object)
// : ������(DB<->JavaObject) ������ü
public class VisitDao {
	
	//Mybatis��ü
	SqlSessionFactory factory;
	
	//single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static VisitDao single = null;

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();
		return single;
	}

	public VisitDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}
	
	
	//���� ��� ��ȸ
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		
		//String sql = "select * from visit order by idx desc";
		//1.Mybatis�۾��ϴ� ��ü���� ������
		SqlSession sqlSession = factory.openSession(true);
		
		//2.�۾�         ��ûIDȣ�� namespace.mapper_id
		list = sqlSession.selectList("visit.visit_list");
		
		//3.��ȯ
		sqlSession.close();

		
		return list;
	}
	
	//���� ����
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		
		//String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";
		
		//1.Mybatis�۾��ϴ� ��ü���� ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾�         ��ûIDȣ�� namespace.mapper_id
		res = sqlSession.insert("visit.visit_insert",vo);
		
		//���뿩�ο� ���� ó��
		if(res==1) //insert�� ����������
			sqlSession.commit();
		else
			sqlSession.rollback();
		
		//3.��ȯ
		sqlSession.close();
		


		return res;
	}
	
	//���� ����
	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		
		//1.Mybatis�۾��ϴ� ��ü���� ������
		//                                true : auto commit
		SqlSession sqlSession = factory.openSession(true);
				
		//2.�۾�         ��ûIDȣ�� namespace.mapper_id
		res = sqlSession.delete("visit.visit_delete",idx);
		
		//3.��ȯ
		sqlSession.close();

		
		return res;
	}
	
	// idx�� �ش�Ǵ� �Խù� 1�� ���
	public VisitVo selectOne(int idx) {
		
		VisitVo vo = null;
		//String sql = "select * from visit where idx=?";
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("visit.visit_one", idx);
		
		sqlSession.close();
		return vo;
	}
	
	//��ü �Խù��� ���ϱ�
	public int selectRowCount() {
		int count = 0;
		
		SqlSession sqlSession = factory.openSession();
		
		count = sqlSession.selectOne("visit.visit_count");
		
		sqlSession.close();
		
		return count;
	}
	
	//���� �����ϱ�
	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���

        SqlSession sqlSession = factory.openSession(true);
   		
   		res = sqlSession.update("visit.visit_update", vo);
   		
   		sqlSession.close();
		

		return res;
	}

	
		//2���� ���� �̻��� �˻� �ϴ� ����Ʈ
	public List<VisitVo> selectList(VisitVo vo) {
		// TODO Auto-generated method stub
		List<VisitVo> list = null;
		
		//1.Mybatis�۾��ϴ� ��ü���� ������
		SqlSession sqlSession = factory.openSession(true);
		
		//2.�۾�         ��ûIDȣ�� namespace.mapper_id
		list = sqlSession.selectList("visit.visit_condition_list",vo);
		
		//3.��ȯ
		sqlSession.close();

		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
}
