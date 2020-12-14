package com.tj.test02.service;

import java.util.List;

import com.tj.test02.dto.Dept;
import com.tj.test02.dto.Emp;

public interface IService {
	List<Dept> deptList();
	List<Emp> empList(String[] deptno);
}
