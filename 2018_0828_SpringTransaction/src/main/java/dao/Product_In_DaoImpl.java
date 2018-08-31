package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVo;

public class Product_In_DaoImpl implements ProductDao{

	SqlSession sqlSession;
	
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ProductVo> list() {
	
		List<ProductVo> list=null;
		
		list=sqlSession.selectList("product_in.product_in_list");		
		
		return list;
	}

	@Override
	public int insert(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		int res=0;
		
		res=sqlSession.insert("product_in.product_in_insert",vo);
		
		return res;
	}

	@Override
	public int update(ProductVo vo) throws Exception {
		
		int res=0;
		res=sqlSession.update("product_in.product_in_update",vo);
		return 0;
	}

	@Override
	public ProductVo selectOne(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
