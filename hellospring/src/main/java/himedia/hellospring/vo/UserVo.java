package himedia.hellospring.vo;

import java.util.Date;	//주의

public class UserVo {
	// 기본적으로 vo에는 생성자,getters/setters, toString 구현해야함
	private Long no;
	private String name;
	private String password;
	private String email;
	private String gender;
	private Date createdAt; // date 임포트할때 꼭 java.util.Date로 해줘야함
	
	// 기본생성자 
	public UserVo() {
		
	}
	
	// 전체생성자
	public UserVo(Long no, String name, String password, String email, String gender, Date createdAt) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.createdAt = createdAt;
	}

	// primary key, date 제외하고 데이터만 있는걸로 하나 더 생성자 만들기
	public UserVo(String name, String password, String email, String gender) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
	}

	// getters/setters 전체 다 만들어주기
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	// 내부데이터를 문자형식으로 리턴해주는 검증용 메서드!! toString 꼭 구현! 
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", createdAt=" + createdAt + "]";
	}
	
	
	
}
