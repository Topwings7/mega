package com.tj.test06.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.test06.dto.Category;
import com.tj.test06.dto.Clike;
@Repository
public class ClikeDaoImpl implements ClikeDao{
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public List<Category> categoryList() {
		return sessionTemplate.selectList("categoryList");
	}
	@Override
	public List<Clike> myClikeList(String mid) {
		return sessionTemplate.selectList("myClikeList", mid);
	}

	@Override
	public int myClikeInsert(Clike clike) {
		return sessionTemplate.insert("myClikeInsert", clike);
	}

	@Override
	public int myClikeDelete(Clike clike) {
		return sessionTemplate.delete("myClikeDelete", clike);
	}

}
