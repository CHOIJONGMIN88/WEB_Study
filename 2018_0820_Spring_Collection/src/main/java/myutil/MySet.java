package myutil;

import java.util.Set;

public class MySet {
	
//Set�� ��� �ߺ��� ���� ���� �� ����.	
public MySet() {
	
	
	System.out.println("----My-set----");
	
}
	
	
	Set set; //�ܺο��� injection

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
	
	
	

	
	

}
