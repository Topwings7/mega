package com.tj.test04.dao;

import java.util.List;

import com.tj.test04.dto.Memo;

public interface MemoDao {
	public int memoInsert(Memo memo);
	public List<Memo> memoList(Memo memo);
	public int getCnt();
}
