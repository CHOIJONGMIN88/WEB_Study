package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;
import vo.SawonYearVo;

public class SawonDao {
	//single-ton : 객체1개만 생성 서비스
	static SawonDao single = null;

	//SessionFactory생성하는 객체
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
	
	//사원목록 가져오기
	public List<SawonVo>  selectList(){
		
		List<SawonVo> list = null;
		
		//1.Mybatis 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행 : Mapper내에 id=sawon_list인 명령을 수행
		//             작업결과를 ArrayList자동 포장해준다
		list = sqlSession.selectList("sawon_list");
		
		//3.작업객체 반환시킨다(내부적으로 connection close)
		sqlSession.close();
		
		
		return list;
		
	}

	public List<SawonVo> selectList(int deptno) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행 : Mapper내에 id=sawon_deptno_list인 명령을 수행
		//             작업결과를 ArrayList자동 포장해준다
		//                               호출ID,         인수(자) 
		list = sqlSession.selectList("sawon_deptno_list",deptno);
		
		//3.작업객체 반환시킨다(내부적으로 connection close)
		sqlSession.close();
		
		
		return list;
	}

	public List<SawonVo> selectList(String sajob) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행 : Mapper내에 id=sawon_deptno_list인 명령을 수행
		//             작업결과를 ArrayList자동 포장해준다
		//                               호출ID,         인수(자) 
		list = sqlSession.selectList("sawon_sajob_list",sajob);
		
		//3.작업객체 반환시킨다(내부적으로 connection close)
		sqlSession.close();
		
		
		return list;
	}

	public List<SawonVo> selectList(SawonVo vo) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행 : Mapper내에 id=sawon_deptno_list인 명령을 수행
		//             작업결과를 ArrayList자동 포장해준다
		//                               호출ID,         인수(자) 
		list = sqlSession.selectList("sawon_deptno_sajob_list",vo);
		
		//3.작업객체 반환시킨다(내부적으로 connection close)
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행 : Mapper내에 id=sawon_deptno_list인 명령을 수행
		//             작업결과를 ArrayList자동 포장해준다
		//                               호출ID,         인수(자) 
		list = sqlSession.selectList("sawon_deptno_sajob_map_list",map);
		
		//3.작업객체 반환시킨다(내부적으로 connection close)
		sqlSession.close();
		
		return list;
	}

	public List<SawonYearVo> selectYearList() {
		// TODO Auto-generated method stub
		List<SawonYearVo> list = null;
		
		//1.Mybatis 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행 : Mapper내에 id=sawon_deptno_list인 명령을 수행
		//             작업결과를 ArrayList자동 포장해준다
		//                               호출ID,         인수(자) 
		list = sqlSession.selectList("sawon_year_list");
		
		//3.작업객체 반환시킨다(내부적으로 connection close)
		sqlSession.close();
		
		return list;
	}

	
}
