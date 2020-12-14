package com.tj.test04.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.test04.dto.Memo;
@Repository
public class MemoDaoImpl implements MemoDao{
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public int memoInsert(Memo memo) {
		return sessionTemplate.insert("memoInsert", memo);
	}
	@Override
	public List<Memo> memoList(Memo memo) {
		return sessionTemplate.selectList("memoList", memo);
	}

	@Override
	public int getCnt() {
		return sessionTemplate.selectOne("getCnt");
	}

}
