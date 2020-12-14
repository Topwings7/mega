package com.tj.test05.dao;

import java.util.List;

import com.tj.test05.dto.B;

public interface BDao {
	public List<B> list(B b);
	public int cnt(B b);
	public int write(B b);
	public B detail(int bno);
	public int update(B b);
	public int delete(int bno);
}
