package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductDao;
import vo.ProductVo;

public class ProductServiceImpl implements ProductService {

	ProductDao product_in_dao;
	ProductDao product_out_dao;
	ProductDao product_remain_dao;
	
	
	public ProductDao getProduct_in_dao() {
		return product_in_dao;
	}

	public void setProduct_in_dao(ProductDao product_in_dao) {
		this.product_in_dao = product_in_dao;
	}

	public ProductDao getProduct_out_dao() {
		return product_out_dao;
	}

	public void setProduct_out_dao(ProductDao product_out_dao) {
		this.product_out_dao = product_out_dao;
	}



	public ProductDao getProduct_remain_dao() {
		return product_remain_dao;
	}

	public void setProduct_remain_dao(ProductDao product_remain_dao) {
		this.product_remain_dao = product_remain_dao;
	}

	@Override
	public Map selectList() {
		// TODO Auto-generated method stub
		
		
		//입고/출고/재고 목록 가져오기
		List in_list =product_in_dao.list();
		List out_list =product_out_dao.list();
		List remain_list =product_remain_dao.list();
		
		Map map = new HashMap();
		map.put("in_list",in_list);
		map.put("out_list",out_list);
		map.put("remain_list",remain_list);
		
		
		return map;
	}

	@Override
	public void insert_in(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		//입고처리
		int res=product_in_dao.insert(vo);
		
		ProductVo remain_vo =product_remain_dao.selectOne(vo.getName());
		
		if(remain_vo==null) { //재고테이블에 상품이 등록되지 않았으면 
			//입고테이블 등록상품을 재고테이블에도 등록		
			res=product_remain_dao.insert(vo);
		}else {
			
			//수량= 기존수량+추가된 수량
			int cnt = remain_vo.getCnt() + vo.getCnt();
			remain_vo.setCnt(cnt);
			
			res=product_remain_dao.update(remain_vo);
			
		}
		
		
		
	}

	@Override
	public void insert_out(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
	
		//1.출고등록 
		int res = product_out_dao.insert(vo);
		
		//2.출고상품이 재고목록에 있는지 검사 
		ProductVo remain_vo = product_remain_dao.selectOne(vo.getName());
		
		if(remain_vo ==null) { //출고목록에 출고상품이 없는경우 
			//예외를 강제로 발생시킨다.(출고상품이 없는데 출고가 되는경우 오류이기때문에)
			throw new Exception("remain_not");
			
		}
		
		//3.출고수량>재고수량
		if(remain_vo.getCnt()<vo.getCnt()) {
			throw new Exception("remain_lack");
			
		}
		
		//성장적으로 재고수량 
		//수량 = 재고수량 - 출고수량 
		
		
		
		
		
	}

	
	
	
	
	
}
