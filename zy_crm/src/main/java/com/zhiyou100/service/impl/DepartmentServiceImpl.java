package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.DepartmentDao;
import com.zhiyou100.dao.impl.DepartmentDaoImpl;
import com.zhiyou100.entity.DepartmentDo;
import com.zhiyou100.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
private DepartmentDao dao =new DepartmentDaoImpl();
	@Override
	public List<DepartmentDo> listDepartment() {
		
		return dao.listDepartment();
		
	}

	@Override
	public DepartmentDo getDepartmentById(long id) {
		
		return dao.getDepartmentById(id);
	}

	@Override
	public void addDepartment(String name, String description) {
		dao.addDepartment(name, description);

	}

	@Override
	public void updateDepartment(long id, String name, String description) {
		dao.updateDepartment(id, name, description);

	}

	@Override
	public void deleteDepartment(long id) {
		dao.deleteDepartment(id);

	}

}
