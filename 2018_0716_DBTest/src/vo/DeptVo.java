package vo;

public class DeptVo {
	
	//Tip: DB속성명과 Vo의 필드명과 웹 상의 form tag의 parameter 이름을 일치시키는게 작업이 훨씬 수월하다. 
	int deptno;
	String dname;
	String loc;
	
	
	
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
	
	
}
