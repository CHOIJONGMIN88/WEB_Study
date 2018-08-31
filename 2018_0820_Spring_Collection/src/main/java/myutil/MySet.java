package myutil;

import java.util.Set;

public class MySet {
	
//Set의 경우 중복된 값을 가질 수 없다.	
public MySet() {
	
	
	System.out.println("----My-set----");
	
}
	
	
	Set set; //외부에서 injection

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
	
	
	

	
	

}
