package vo;

/*
 * 
 * Vo(Value object)
 * ;값(레코드)을 저장관리하는 객체
 * 
 * cf) Table필드명 == Vo 속성명
 * 
 * 
 * 
 */

public class SungVo {
	//테이블의 헤드 이름 과 객체 처리 변수명을 동일하게 해줘야 데이터 처리가 매우 수월함(공식)
	
	int idx;
	String name;
	int kor,eng,mat,tot;
	String avg;
	int rank;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	


}
