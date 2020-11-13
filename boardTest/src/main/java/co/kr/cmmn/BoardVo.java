package co.kr.cmmn;

public class BoardVo {
	private int id;
	private String title;
	private String content;
	private String name;
	private String regDate;
	
	public BoardVo(int id, String title, String content, String name, String regDate) {
		this.id=id;
		this.title=title;
		this.content=content;
		this.name=name;
		this.regDate=regDate;
	}
	public BoardVo() {
		super();
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setContent(String content) {
		this.content=content;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setRegDate(String regDate) {
		this.regDate=regDate;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getName() {
		return name;
	}
	public String getRegDate() {
		return regDate;
	}
}
