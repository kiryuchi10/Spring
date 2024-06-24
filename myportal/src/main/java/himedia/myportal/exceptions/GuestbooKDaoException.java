package himedia.myportal.exceptions;

import himedia.myportal.repositories.vo.GuestbookVo;

public class GuestbooKDaoException extends RuntimeException{
	private GuestbookVo guestbookVo=null;
	
	public GuestbooKDaoException() {
		
	}
	public GuestbooKDaoException(String message) {
		super(message);
	}
	public GuestbooKDaoException(String message, GuestbookVo vo) {
		super(message);
		this.guestbookVo=vo;
	}
	public GuestbookVo getGuestbookVo() {
		return guestbookVo;
	}
	
}
