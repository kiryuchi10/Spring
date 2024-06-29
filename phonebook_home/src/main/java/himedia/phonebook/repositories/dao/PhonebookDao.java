package himedia.phonebook.repositories.dao;

import java.util.List;

import himedia.phonebook.repositories.vo.PhonebookVo;

public interface PhonebookDao {
	public List<PhonebookVo> selectAll();
	public List<PhonebookVo> selectListByKeyword(String keyword);
	public int insert(PhonebookVo phonebookVo);
	public int delete(PhonebookVo phonebookVo);
	public PhonebookVo selectOne(Long id);
}
