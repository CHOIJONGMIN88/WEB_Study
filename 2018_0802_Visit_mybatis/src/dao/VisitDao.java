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
// : 데이터(DB<->JavaObject) 관리객체
public class VisitDao {
	
	//Mybatis객체
	SqlSessionFactory factory;
	
	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
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
	
	
	//방명록 목록 조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		
		//String sql = "select * from visit order by idx desc";
		//1.Mybatis작업하는 객체정보 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업         요청ID호출 namespace.mapper_id
		list = sqlSession.selectList("visit.visit_list");
		
		//3.반환
		sqlSession.close();

		
		return list;
	}
	
	//방명록 쓰기
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		
		//String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";
		
		//1.Mybatis작업하는 객체정보 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업         요청ID호출 namespace.mapper_id
		res = sqlSession.insert("visit.visit_insert",vo);
		
		//적용여부에 따라 처리
		if(res==1) //insert가 성공했으면
			sqlSession.commit();
		else
			sqlSession.rollback();
		
		//3.반환
		sqlSession.close();
		


		return res;
	}
	
	//방명록 삭제
	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		
		//1.Mybatis작업하는 객체정보 얻어오기
		//                                true : auto commit
		SqlSession sqlSession = factory.openSession(true);
				
		//2.작업         요청ID호출 namespace.mapper_id
		res = sqlSession.delete("visit.visit_delete",idx);
		
		//3.반환
		sqlSession.close();

		
		return res;
	}
	
	// idx에 해당되는 게시물 1건 얻기
	public VisitVo selectOne(int idx) {
		
		VisitVo vo = null;
		//String sql = "select * from visit where idx=?";
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("visit.visit_one", idx);
		
		sqlSession.close();
		return vo;
	}
	
	//전체 게시물수 구하기
	public int selectRowCount() {
		int count = 0;
		
		SqlSession sqlSession = factory.openSession();
		
		count = sqlSession.selectOne("visit.visit_count");
		
		sqlSession.close();
		
		return count;
	}
	
	//방명록 수정하기
	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수

        SqlSession sqlSession = factory.openSession(true);
   		
   		res = sqlSession.update("visit.visit_update", vo);
   		
   		sqlSession.close();
		

		return res;
	}

	
		//2가지 조건 이상을 검색 하는 리스트
	public List<VisitVo> selectList(VisitVo vo) {
		// TODO Auto-generated method stub
		List<VisitVo> list = null;
		
		//1.Mybatis작업하는 객체정보 얻어오기
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업         요청ID호출 namespace.mapper_id
		list = sqlSession.selectList("visit.visit_condition_list",vo);
		
		//3.반환
		sqlSession.close();

		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
}
