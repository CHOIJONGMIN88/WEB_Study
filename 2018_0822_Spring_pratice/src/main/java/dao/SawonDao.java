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
		//SqlSessionTemplate객체 내에서 factory.openSession() and sqlSession.close()
		//스프링 객체가 세션을 열고닫는거까지 지원해주므로 쓰지않아도 됨
		
		list = sqlSession.selectList("sawon.sawon_list");
	
		return list;
	}
	
	
	
}
