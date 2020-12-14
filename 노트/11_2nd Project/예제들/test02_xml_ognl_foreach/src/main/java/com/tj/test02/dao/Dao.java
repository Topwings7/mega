package com.tj.test02.dao;

import java.util.List;
import com.tj.test02.dto.Dept;
import com.tj.test02.dto.Emp;

public interface Dao {
	List<Dept> deptList();
	List<Emp> empList(List<String> deptnoList);
}
