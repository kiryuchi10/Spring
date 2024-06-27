package himedia.myportal.repositories.dao;

import java.util.List;

import himedia.myportal.repositories.vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> selectAll();
	public int insert(BoardVo vo); // 게시물 작성
//	public int delete(BoardVo vo);
	public BoardVo getContent(Long no);
	public int update(BoardVo vo);
//	public BoardVo getContent(BoardVo boardvo);
	int increaseHitCount(Long no);
	public int delete(Long no, Long userNo);
}
