package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;
import vo.SawonYearVo;

public class SawonDao {
	//single-ton : ��ü1���� ���� ����
	static SawonDao single = null;

	//SessionFactory�����ϴ� ��ü
	SqlSessionFactory factory;
	
	public SawonDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}
	
	//������ ��������
	public List<SawonVo>  selectList(){
		
		List<SawonVo> list = null;
		
		//1.Mybatis �۾���ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾����� : Mapper���� id=sawon_list�� ����� ����
		//             �۾������ ArrayList�ڵ� �������ش�
		list = sqlSession.selectList("sawon_list");
		
		//3.�۾���ü ��ȯ��Ų��(���������� connection close)
		sqlSession.close();
		
		
		return list;
		
	}

	public List<SawonVo> selectList(int deptno) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis �۾���ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾����� : Mapper���� id=sawon_deptno_list�� ����� ����
		//             �۾������ ArrayList�ڵ� �������ش�
		//                               ȣ��ID,         �μ�(��) 
		list = sqlSession.selectList("sawon_deptno_list",deptno);
		
		//3.�۾���ü ��ȯ��Ų��(���������� connection close)
		sqlSession.close();
		
		
		return list;
	}

	public List<SawonVo> selectList(String sajob) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis �۾���ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾����� : Mapper���� id=sawon_deptno_list�� ����� ����
		//             �۾������ ArrayList�ڵ� �������ش�
		//                               ȣ��ID,         �μ�(��) 
		list = sqlSession.selectList("sawon_sajob_list",sajob);
		
		//3.�۾���ü ��ȯ��Ų��(���������� connection close)
		sqlSession.close();
		
		
		return list;
	}

	public List<SawonVo> selectList(SawonVo vo) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis �۾���ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾����� : Mapper���� id=sawon_deptno_list�� ����� ����
		//             �۾������ ArrayList�ڵ� �������ش�
		//                               ȣ��ID,         �μ�(��) 
		list = sqlSession.selectList("sawon_deptno_sajob_list",vo);
		
		//3.�۾���ü ��ȯ��Ų��(���������� connection close)
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis �۾���ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾����� : Mapper���� id=sawon_deptno_list�� ����� ����
		//             �۾������ ArrayList�ڵ� �������ش�
		//                               ȣ��ID,         �μ�(��) 
		list = sqlSession.selectList("sawon_deptno_sajob_map_list",map);
		
		//3.�۾���ü ��ȯ��Ų��(���������� connection close)
		sqlSession.close();
		
		return list;
	}

	public List<SawonYearVo> selectYearList() {
		// TODO Auto-generated method stub
		List<SawonYearVo> list = null;
		
		//1.Mybatis �۾���ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.�۾����� : Mapper���� id=sawon_deptno_list�� ����� ����
		//             �۾������ ArrayList�ڵ� �������ش�
		//                               ȣ��ID,         �μ�(��) 
		list = sqlSession.selectList("sawon_year_list");
		
		//3.�۾���ü ��ȯ��Ų��(���������� connection close)
		sqlSession.close();
		
		return list;
	}

	
}
