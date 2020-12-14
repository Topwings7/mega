package com.tj.test06.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.test06.dto.Member;
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public Member login(Member member) {
		return sessionTemplate.selectOne("login", member);
	}

}
