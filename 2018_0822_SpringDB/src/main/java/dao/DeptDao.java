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
		//SqlSessionTemplate��ü ������ factory.openSession() and sqlSession.close()
		//������ ��ü�� ������ ����ݴ°ű��� �������ֹǷ� �����ʾƵ� ��
		
		list = sqlSession.selectList("dept.dept_list");
	
		return list;
	}
	
	
	
}
