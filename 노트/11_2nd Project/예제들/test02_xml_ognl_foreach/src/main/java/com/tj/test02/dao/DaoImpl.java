package com.tj.test02.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tj.test02.dto.Dept;
import com.tj.test02.dto.Emp;
@Repository
public class DaoImpl implements Dao{
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public List<Dept> deptList() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("deptList");
	}

	@Override
	public List<Emp> empList(List<String> deptnoList) {
		return sessionTemplate.selectList("empList", deptnoList);
	}

}
