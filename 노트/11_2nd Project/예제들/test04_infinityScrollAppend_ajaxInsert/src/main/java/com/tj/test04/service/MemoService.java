package com.tj.test04.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tj.test04.dto.Memo;

public interface MemoService {
	public int memoInsert(Memo memo, Model model, HttpServletRequest request);
	public List<Memo> memoList(String pageNum, Model model);
	public int getCnt();
	public void insert100();
}
