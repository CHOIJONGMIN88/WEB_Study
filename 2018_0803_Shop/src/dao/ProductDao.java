package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVo;

public class ProductDao {

	//Mybatis 객체
	SqlSessionFactory factory;
	
	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static ProductDao single = null;

	public static ProductDao getInstance() {
		if (single == null)
			single = new ProductDao();
		return single;
	}

	public ProductDao() {
		// TODO Auto-generated constructor stub
		
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	
	}
	
	//카테고리별 상품목록 
	
	public List<ProductVo> selectList(String category){
		
		List<ProductVo> list=null;
		
		SqlSession sqlSession = factory.openSession();
		
		list=sqlSession.selectList("product.product_list",category);
		
		sqlSession.close();
		
		return list;
		
	}
	
	
	public int insert(ProductVo vo) {
		int res=0;
		
		SqlSession sqlSession = factory.openSession();
		
		res = sqlSession.insert("product.product_insert",vo);
		
		if(res==1) //insert가 성공했으면
			sqlSession.commit();
		else
			sqlSession.rollback();
		
		sqlSession.close();
		
		return res;
	}
	
	public ProductVo selectOne(int idx) {
		// TODO Auto-generated method stub
		ProductVo  vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("product.product_one",idx);
		
		sqlSession.close();
		
		
		return vo;
	}
	
	
	
}
