package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVo;

public class Product_out_DaoImpl implements ProductDao{

	SqlSession sqlSession;
	
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ProductVo> list() {
		// TODO Auto-generated method stub
				List<ProductVo> list=null;
				
				list = sqlSession.selectList("product_out.product_out_list");
				
				return list;
	}

	@Override
	public int insert(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		int res=0;
		
		res = sqlSession.insert("product_out.product_out_insert",vo);
		
		
		return 0;
	}

	@Override
	public int update(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductVo selectOne(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
