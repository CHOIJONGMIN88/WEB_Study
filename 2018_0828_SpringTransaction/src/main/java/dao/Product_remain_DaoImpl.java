package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVo;

public class Product_remain_DaoImpl implements ProductDao{

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
				
				list = sqlSession.selectList("product_remain.product_remain_list");
				
				return list;
	}

	@Override
	public int insert(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
				int res = 0;
				
				res = sqlSession.insert("product_remain.product_remain_insert",vo);
				
				return res;
	}

	@Override
	public int update(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
				int res = 0;
				res = sqlSession.update("product_remain.product_remain_update",vo);
				return res;
	}

	@Override
	public ProductVo selectOne(String name) {
		// TODO Auto-generated method stub
		ProductVo vo =null;
		
		vo = sqlSession.selectOne("product_remain.product_remain_one",name);
		
		return vo;
	}


	
	
}
