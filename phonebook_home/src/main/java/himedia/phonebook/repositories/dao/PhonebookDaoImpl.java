package himedia.phonebook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.phonebook.repositories.vo.PhonebookVo;

@Repository("phonebookDao")
public class PhonebookDaoImpl implements PhonebookDao {
	private final SqlSession sqlSession;

	@Autowired
	public PhonebookDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<PhonebookVo> selectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("phonebook.selectAll");
	}

	@Override
	public PhonebookVo selectOne(Long id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("phonebook.selectOne", id);
	}

	@Override
	public List<PhonebookVo> selectListByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("phonebook.selectListByKeyword", keyword);
	}

	@Override
	public int insert(PhonebookVo phonebookVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("phonebook.insert", phonebookVo);
	}

	@Override
	public int delete(PhonebookVo phonebookVo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("phonebook.delete", phonebookVo);
	}
}
