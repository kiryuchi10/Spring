package himedia.myportal.repositories.dao;

import java.util.List;

import himedia.myportal.repositories.vo.UserVo;


public interface UserDao {
	public List<UserVo> selectAll();
	public UserVo selectUser(String name); // 게시물 작성
	public UserVo selectPassword(String password);
}
