package vo;

public class CommentVo {

	int idx;
	String id,name,content,ip,regdate;
	int b_idx;
	
	int no;	//게시물 순서 

	public CommentVo() {
		// TODO Auto-generated constructor stub
	}
	

	
	public CommentVo(String id,String name, String content, String ip, int b_idx) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.ip = ip;
		this.b_idx = b_idx;
	}





	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	
	
	
		
}
