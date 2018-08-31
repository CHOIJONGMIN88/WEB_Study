package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVo;

public class CartDao {
	SqlSessionFactory factory;
	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static CartDao single = null;

	public static CartDao getInstance() {
		if (single == null)
			single = new CartDao();
		return single;
	}

	public CartDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();	
	}
	
	//회원별 장바구니 목록 조회 
	public List<CartVo> selectList(int m_idx){
		
	//	System.out.println(m_idx);
	//	System.out.println("들어오는지보자");
		
		List<CartVo> list=null;
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("cart.cart_list",m_idx);
		
		sqlSession.close();
		
		return list;
		
		
	}
	
	public int update(CartVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//                                          true : auto commit
		SqlSession sqlSession  = factory.openSession(true);
		
		res = sqlSession.update("cart.cart_update", vo);
		
		sqlSession.close();
		
		return res;
	}

	public CartVo selectOne(CartVo vo) {
		// TODO Auto-generated method stub
		CartVo result_vo = null;
		SqlSession sqlSession = factory.openSession();
		
		System.out.println(vo.getM_idx());
		result_vo=sqlSession.selectOne("cart.cart_one",vo);
		
		sqlSession.close();
		return result_vo;
	}

	public int insert(CartVo vo) {
		// TODO Auto-generated method stub
		
		int res=0;
		SqlSession sqlSession = factory.openSession();
		
		res=sqlSession.insert("cart.cart_insert",vo);
		
		sqlSession.commit();
		sqlSession.close();		
		return 0;
	}
	
}
