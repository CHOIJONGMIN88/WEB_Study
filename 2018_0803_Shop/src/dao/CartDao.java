package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVo;

public class CartDao {
	SqlSessionFactory factory;
	//single-ton pattern: 1���� ��ü�� �����ؼ� ��������
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
	
	//ȸ���� ��ٱ��� ��� ��ȸ 
	public List<CartVo> selectList(int m_idx){
		
	//	System.out.println(m_idx);
	//	System.out.println("������������");
		
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
