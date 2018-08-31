package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import vo.SawonVo;

public class SawonDao {
	
	SqlSession sqlSession;
	
	public SawonDao() {
		// TODO Auto-generated constructor stub
	}

	public SawonDao(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public List<SawonVo> selectList() {
		
		List<SawonVo> list=null;
		//SqlSessionTemplate��ü ������ factory.openSession() and sqlSession.close()
		//������ ��ü�� ������ ����ݴ°ű��� �������ֹǷ� �����ʾƵ� ��
		
		list = sqlSession.selectList("sawon.sawon_list");
	
		return list;
	}
	
	
	
}
