package vo;

public class PhotoVo {

	int idx;
	String title,filename,pwd,ip,regdate;
	
	
	public PhotoVo() {
		
	}
	
	
	//insert��  idx �� regdate�� ��� data-base���� ó���ȴ�.
	public PhotoVo(String title, String filename, String pwd, String ip) {
		super();
		this.title = title;
		this.filename = filename;
		this.pwd = pwd;
		this.ip = ip;
	}

	//������ ���
	public PhotoVo(int idx, String title, String filename, String pwd, String ip) {
		super();
		this.idx = idx;
		this.title = title;
		this.filename = filename;
		this.pwd = pwd;
		this.ip = ip;
	}




	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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
		
}
