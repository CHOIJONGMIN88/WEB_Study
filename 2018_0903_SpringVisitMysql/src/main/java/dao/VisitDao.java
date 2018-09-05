package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVo;

// DAO(Data Access Object)
// : 데이터(DB<->JavaObject) 관리객체
public class VisitDao {
	
	
	SqlSession sqlSession;//Spring으로부터 Injection(setter injection)받는다
	                      //Spring에서 생성된 SqlSessionTemplate객체의 인터페이스 
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//방명록 목록 조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		
		//2.작업         요청ID호출 namespace.mapper_id
		list = sqlSession.selectList("visit.visit_list");
		
		return list;
	}
	
	//방명록 쓰기
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		
		//2.작업         요청ID호출 namespace.mapper_id
		res = sqlSession.insert("visit.visit_insert",vo);

		return res;
	}
	
	//방명록 삭제
	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수
		
		//2.작업         요청ID호출 namespace.mapper_id
		res = sqlSession.delete("visit.visit_delete",idx);
		
		return res;
	}
	
	// idx에 해당되는 게시물 1건 얻기
	public VisitVo selectOne(int idx) {
		
		VisitVo vo = null;
		
		vo = sqlSession.selectOne("visit.visit_one", idx);
		
		return vo;
	}
	
	//전체 게시물수 구하기
	public int selectRowCount() {
		int count = 0;
		
		count = sqlSession.selectOne("visit.visit_count");
		
		return count;
	}
	
	//방명록 수정하기
	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//처리된 행수

   		res = sqlSession.update("visit.visit_update", vo);

		return res;
	}

	public List<VisitVo> selectList(VisitVo vo) {
		// TODO Auto-generated method stub
		List<VisitVo> list = null;
		
		//2.작업         요청ID호출 namespace.mapper_id
		list = sqlSession.selectList("visit.visit_condition_list",vo);
		
	
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
}
