package vo;

import java.sql.Date;

public class VisitVo {

	//DB�ʵ��� ==Vo�Ӽ��� == form parameter��

	int idx;
	String name;
	String content;
	String pwd;
	String ip;
	String regdate;
	Date regdate2;
	
	public VisitVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public VisitVo(String name, String content, String pwd, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}

	//�����Ҷ� ����ϱ� ���� ������
	public VisitVo(int idx, String name, String content, String pwd, String ip) {
		super();
		this.idx = idx;
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}


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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public Date getRegdate2() {
		return regdate2;
	}
	public void setRegdate2(Date regdate2) {
		this.regdate2 = regdate2;
	}
	
	
}
