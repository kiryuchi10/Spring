package himedia.myportal.repositories.vo;

import java.util.Date;

public class BoardVo {
//	  no number PRIMARY KEY,
//    title varchar2(128) NOT NULL,
//    content varchar2(255) NOT NULL,
//    hit number DEFAULT 0,
//    reg_date date DEFAULT sysdate,
//    user_no number NOT NULL
	private Long no;
	private String title;
	private String content;
	private Long hit;
	private Date regDate;
	private Long userNo;
	private String userName;
	
	
	public BoardVo() {
		super();
	}
	

	public BoardVo(String title, String content, Long userNo) {
		super();
		this.title = title;
		this.content = content;
		this.userNo = userNo;
	}


	public BoardVo(Long no, String title, String content, Long hit, Date regDate, Long userNo, String userName) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regDate = regDate;
		this.userNo = userNo;
		this.userName = userName;
	}


	public Long getNo() {
		return no;
	}


	public void setNo(Long no) {
		this.no = no;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content.replace("\n","<br>");
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Long getHit() {
		return hit;
	}


	public void setHit(Long hit) {
		this.hit = hit;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public Long getUserNo() {
		return userNo;
	}


	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
