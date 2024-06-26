package himedia.myportal.exceptions;

import himedia.myportal.repositories.vo.BoardVo;

public class BoardDaoException extends RuntimeException {
	private BoardVo BoardVo = null;

	public BoardDaoException() {

	}

	public BoardDaoException(String message) {
		super(message);
	}

	public BoardDaoException(String message, BoardVo vo) {
		super(message);
		this.BoardVo = vo;
	}

	public BoardVo getBoardVo() {
		return BoardVo;
	}

}