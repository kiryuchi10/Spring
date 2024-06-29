package himedia.phonebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.phonebook.repositories.dao.PhonebookDao;
import himedia.phonebook.repositories.vo.PhonebookVo;


@Service("phonebookService")
public class PhonebookServiceImpl implements PhonebookService {
	@Autowired
	private PhonebookDao phonebookDao;
	
	@Override
	public List<PhonebookVo> getList() {
		List<PhonebookVo> list=phonebookDao.selectAll();
		return list;
	}

	@Override
	public List<PhonebookVo> searchListByNameKeyword(String keyword) {
		return phonebookDao.selectListByKeyword(keyword);
	}

	@Override
	public PhonebookVo getOne(Long id) {
		return phonebookDao.selectOne(id);
	}

	@Override
	public boolean addNewPhonebookRow(PhonebookVo phonebookVo) {
		return 1 == phonebookDao.insert(phonebookVo);
	}

	@Override
	public boolean deletePhonebookRow(PhonebookVo phonebookVo) {
		return 1 == phonebookDao.delete(phonebookVo);
	}

	

}
