package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.DepartmentDo;

public interface DepartmentDao {
	List<DepartmentDo> listDepartment();

	DepartmentDo getDepartmentById(long id);

	void addDepartment(String name, String description);

	void updateDepartment(long id, String name, String description);

	void deleteDepartment(long id);
}
