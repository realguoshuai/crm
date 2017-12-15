package com.zhiyou100.dao.impl;

import java.util.List;

import org.junit.Test;

import com.zhiyou100.entity.RoleDo;
public class RoleDaoImplTest {
RoleDaoImpl dao = new RoleDaoImpl();
	@Test
	public void testListRole() {
		List<RoleDo> listRole = dao.listRole();
		for (RoleDo roleDo : listRole) {
			System.out.println(roleDo);
		}
	}

	@Test
	public void testAddRole() {
		dao.addRole("王五", "教学主任");
	}

	@Test
	public void testUpdateRole() {
		dao.updateRole((long) 3, "赵刘", "招生部主任");
	}

	@Test
	public void testRemoveRole() {
		dao.removeRole(5);
	}

}
