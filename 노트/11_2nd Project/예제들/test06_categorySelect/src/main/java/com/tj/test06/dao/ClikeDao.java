package com.tj.test06.dao;

import java.util.List;

import com.tj.test06.dto.Category;
import com.tj.test06.dto.Clike;

public interface ClikeDao {
	public List<Category> categoryList();
	public List<Clike> myClikeList(String mid);
	public int myClikeInsert(Clike clike);
	public int myClikeDelete(Clike clike);
}
