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
		
		
		//�԰�/���/��� ��� ��������
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
		//�԰�ó��
		int res=product_in_dao.insert(vo);
		
		ProductVo remain_vo =product_remain_dao.selectOne(vo.getName());
		
		if(remain_vo==null) { //������̺��� ��ǰ�� ��ϵ��� �ʾ����� 
			//�԰����̺� ��ϻ�ǰ�� ������̺����� ���		
			res=product_remain_dao.insert(vo);
		}else {
			
			//����= ��������+�߰��� ����
			int cnt = remain_vo.getCnt() + vo.getCnt();
			remain_vo.setCnt(cnt);
			
			res=product_remain_dao.update(remain_vo);
			
		}
		
		
		
	}

	@Override
	public void insert_out(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
	
		//1.������ 
		int res = product_out_dao.insert(vo);
		
		//2.�����ǰ�� �����Ͽ� �ִ��� �˻� 
		ProductVo remain_vo = product_remain_dao.selectOne(vo.getName());
		
		if(remain_vo ==null) { //�����Ͽ� �����ǰ�� ���°�� 
			//���ܸ� ������ �߻���Ų��.(�����ǰ�� ���µ� ����� �Ǵ°�� �����̱⶧����)
			throw new Exception("remain_not");
			
		}
		
		//3.�������>�������
		if(remain_vo.getCnt()<vo.getCnt()) {
			throw new Exception("remain_lack");
			
		}
		
		//���������� ������� 
		//���� = ������� - ������� 
		
		
		
		
		
	}

	
	
	
	
	
}