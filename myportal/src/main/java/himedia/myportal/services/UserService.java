package himedia.myportal.services;

import himedia.myportal.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	public UserVo getUser(String email);
	public boolean join(UserVo vo);
	public UserVo getUser(String email, String password);
	
	public boolean isAuthenticated(HttpServletRequest request); // 인증 체크 메서드 
}
