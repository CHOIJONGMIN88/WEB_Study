package myutil;

import java.util.Map;

public class MyMap {

	Map map; // Spring에서 생성하고 Injection

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	
}
