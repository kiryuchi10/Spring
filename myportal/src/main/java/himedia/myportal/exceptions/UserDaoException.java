package himedia.myportal.exceptions;

import himedia.myportal.repositories.vo.UserVo;

public class UserDaoException extends RuntimeException {
	private UserVo userVo=null;
	public UserDaoException() {
		
	}
	
	public UserDaoException(String message,UserVo userVO) {
		super(message);
		this.userVo=userVo;	
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
}
