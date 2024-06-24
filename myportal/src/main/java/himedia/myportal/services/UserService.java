package himedia.myportal.services;

import himedia.myportal.repositories.vo.UserVo;

public interface UserService {
	public UserVo getUser(String email);
	public boolean join(UserVo vo);
	public UserVo getUser(String email, String password);
}
