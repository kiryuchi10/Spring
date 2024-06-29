package himedia.phonebook.services;

import java.util.List;

import himedia.phonebook.repositories.vo.PhonebookVo;

public interface PhonebookService {

	List<PhonebookVo> getList();
	public List<PhonebookVo> searchListByNameKeyword(String keyword);
	public boolean addNewPhonebookRow(PhonebookVo phonebookVo);
	public boolean deletePhonebookRow(PhonebookVo phonebookVo);
	public PhonebookVo getOne(Long id);
}
