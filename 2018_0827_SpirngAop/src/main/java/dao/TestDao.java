package dao;

import java.util.List;
import java.util.Map;


public interface TestDao {

	List selectList();
	int  insert(Map map);
	int  update(Map map);
	int  delete(int idx);
	
}
