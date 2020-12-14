package com.tj.test02.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.test02.dao.Dao;
import com.tj.test02.dto.Dept;
import com.tj.test02.dto.Emp;
@Service
public class ServiceImpl implements IService {
	@Autowired
	private Dao dao;
	@Override
	public List<Dept> deptList() {
		return dao.deptList();
	}

	@Override
	public List<Emp> empList(String[] deptno) {
		List<String> deptnoList = new ArrayList<String>();
		for(int i=0 ; i<deptno.length ; i++) {
			deptnoList.add(deptno[i]);
		}
		return dao.empList(deptnoList);
	}

}
