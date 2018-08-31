package service;

import java.util.Map;

import vo.ProductVo;

public interface ProductService {

	Map selectList();
	
	void insert_in(ProductVo vo) throws Exception;	//입고
	void insert_out(ProductVo vo) throws Exception;	//출고 
	
	
}
