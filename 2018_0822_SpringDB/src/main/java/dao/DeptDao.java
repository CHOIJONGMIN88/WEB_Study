package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDao {
	
	SqlSession sqlSession;
	
	public DeptDao() {
		// TODO Auto-generated constructor stub
	}

	public DeptDao(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public List<DeptVo> selectList() {
		
		List<DeptVo> list=null;
		//SqlSessionTemplate객체 내에서 factory.openSession() and sqlSession.close()
		//스프링 객체가 세션을 열고닫는거까지 지원해주므로 쓰지않아도 됨
		
		list = sqlSession.selectList("dept.dept_list");
	
		return list;
	}
	
	
	
}
